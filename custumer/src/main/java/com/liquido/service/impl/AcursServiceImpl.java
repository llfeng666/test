package com.liquido.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.SubAccountPaybackNanopayArcus;
import com.liquido.entity.SubAccountPaybackNanopayArcusExample;
import com.liquido.entity.SubAccountsNanopayArcus;
import com.liquido.entity.SubAccountsNanopayArcusExample;
import com.liquido.entity.payback.CashInCallbackDto;
import com.liquido.entity.payback.LiquidoOauthResponse;
import com.liquido.entity.payback.SubAcctDto;
import com.liquido.entity.payback.SubAcctPaybackDto;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;
import com.liquido.facade.liquido.LiquidoClient;
import com.liquido.mapper.SubAccountPaybackNanopayArcusMapper;
import com.liquido.mapper.SubAccountsNanopayArcusMapper;
import com.liquido.service.VendorService;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class AcursServiceImpl implements VendorService {

    @Autowired
    private SubAccountsNanopayArcusMapper subAccountsNanopayArcusMapper;

    @Autowired
    private SubAccountPaybackNanopayArcusMapper subAccountPaybackNanopayArcusMapper;

    @Autowired
    private LiquidoClient liquidoClient;

    @Override
    public BasicResultVO handle(NanoPayRequest nanoPayRequest) {
        final SubAccountsNanopayArcusExample subAccountsExample = new SubAccountsNanopayArcusExample();
        final SubAccountsNanopayArcusExample.Criteria criteria = subAccountsExample.createCriteria();
        criteria.andAccountIdEqualTo(nanoPayRequest.getAccountId());
        final List<SubAccountsNanopayArcus> subAccountsNanopayArcuses =
                subAccountsNanopayArcusMapper.selectByExample(subAccountsExample);
        if (CollectionUtil.isEmpty(subAccountsNanopayArcuses)) {
            log.info("sub_accounts_nanopay 记录为空 直接登记 表格");
            return new BasicResultVO().fail("sub_accounts_nanopay 记录为空 直接登记 表格 ");
        }
        final SubAccountsNanopayArcus subAccountsNanopayArcus =
                subAccountsNanopayArcuses.stream().findFirst().get();
        final String subAccountUuid = subAccountsNanopayArcus.getSubAccountUuid();
        log.info("subAccountUuid: {}", subAccountUuid);

        //不存在payback记录  直接查询子账户余额
        LiquidoOauthResponse liquidoOauthResponse = liquidoClient.authToken();
        String accessToken = "Bearer "+liquidoOauthResponse.getAccessToken();
        SubAcctDto subAcctDto =
                liquidoClient.balance(subAccountUuid, accessToken);
        BigDecimal balance = new BigDecimal(subAcctDto.getBalance());
        if (balance.compareTo(BigDecimal.ZERO)>0) {
            //todo 账户余额不为0且不存在相同金额的init状态的payback记录
            SubAcctPaybackDto payback = liquidoClient.payback(accessToken, subAccountUuid);
        }else{
            log.info("账户金额为0 直接登记 表格");
            return new BasicResultVO().fail("账户金额为0 直接登记 表格 ");
        }
        //todo 限制条件查询
        SubAccountPaybackNanopayArcusExample subAccountPaybackNanopayArcusExample =
                new SubAccountPaybackNanopayArcusExample();
        SubAccountPaybackNanopayArcusExample.Criteria subAccountPaybackNanopayArcusExampleCriteria =
                subAccountPaybackNanopayArcusExample.createCriteria();
        subAccountPaybackNanopayArcusExampleCriteria.andSubAccountUuidEqualTo(subAccountUuid);
        List<SubAccountPaybackNanopayArcus> subAccountPaybackNanopayArcuses =
                subAccountPaybackNanopayArcusMapper.selectByExample(
                        subAccountPaybackNanopayArcusExample);
        SubAccountPaybackNanopayArcus subAccountPaybackNanopayArcus =
                subAccountPaybackNanopayArcuses.stream().findFirst().get();
        //todo 查询 Arcus 状态



        //todo  update db
        int count  = subAccountPaybackNanopayArcusMapper.updateByPrimaryKeySelective(
                subAccountPaybackNanopayArcus);
        log.info("更新的笔数:{}", count);
        //查询unipagos
        CashInCallbackDto cashInCallbackDto =
                liquidoClient.notifyMerchant(accessToken, subAccountPaybackNanopayArcus.getTransactionId());

        return new BasicResultVO().success("交易处理成功 ");
    }

    @Override
    public Vendor vendorName() {
        return Vendor.ARCUS;
    }
}
