package com.liquido.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.SubAccountPaybackNanopay;
import com.liquido.entity.SubAccountPaybackNanopayExample;
import com.liquido.entity.SubAccountsNanopay;
import com.liquido.entity.SubAccountsNanopayExample;
import com.liquido.entity.payback.CashInCallbackDto;
import com.liquido.entity.payback.LiquidoOauthResponse;
import com.liquido.entity.payback.SubAcctDto;
import com.liquido.entity.payback.SubAcctPaybackDto;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;
import com.liquido.enums.models.UnipagosPaymentStatus;
import com.liquido.facade.liquido.LiquidoClient;
import com.liquido.mapper.SubAccountPaybackNanopayMapper;
import com.liquido.mapper.SubAccountsNanopayMapper;
import com.liquido.service.VendorService;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1.查询sub_accounts_nanopay
 * 2.查询sub_account_payback_nanopay
 */
@Service
@Slf4j
public class UnipagosServiceImpl  implements VendorService {

    @Autowired
    private SubAccountsNanopayMapper subAccountsNanopayMapper;

    @Autowired
    private SubAccountPaybackNanopayMapper subAccountPaybackNanopayMapper;

    @Autowired
    private LiquidoClient liquidoClient;

    private static final String SUCCESS = "SUCCESS";


    @Override
    public BasicResultVO handle(NanoPayRequest nanoPayRequest) {

        SubAccountsNanopayExample subAccountsExample = new SubAccountsNanopayExample();
        SubAccountsNanopayExample.Criteria criteria = subAccountsExample.createCriteria();
        criteria.andAccountIdEqualTo(nanoPayRequest.getAccountId());
        List<SubAccountsNanopay> subAccountsNanopays =
                subAccountsNanopayMapper.selectByExample(subAccountsExample);
        if (CollectionUtil.isEmpty(subAccountsNanopays)) {
            log.info("sub_accounts_nanopay 记录为空 直接登记 表格");
            return new BasicResultVO().fail("sub_accounts_nanopay 记录为空 直接登记 表格 ");
        }

        String subAccountUuid =
                subAccountsNanopays.stream().findFirst().orElseThrow().getSubAccountUuid();

        LiquidoOauthResponse liquidoOauthResponse = liquidoClient.authToken();
        String accessToken = "Bearer "+liquidoOauthResponse.getAccessToken();
        //查询 liquido 接口 balance
        SubAcctDto subAcctDto = liquidoClient.balance(subAccountUuid ,accessToken);
        final BigDecimal balance = new BigDecimal(subAcctDto.getBalance());
        if (balance.compareTo(BigDecimal.ZERO)>0) {
            //查询liquido接口 payback
            SubAcctPaybackDto subAcctPaybackDto = liquidoClient.payback(accessToken
                    ,subAccountUuid);
        }else {
            return new BasicResultVO().fail("payback 金额小于等于 记录为空 直接登记 表格 ");
        }

        //todo 是否要限制条件查询
        SubAccountPaybackNanopayExample subAccountPaybackNanopayExample =
                new SubAccountPaybackNanopayExample();
        SubAccountPaybackNanopayExample.Criteria subCriteria =
                subAccountPaybackNanopayExample.createCriteria();
        subCriteria.andSubAccountUuidEqualTo(subAccountUuid);
        subCriteria.andAmountEqualTo(nanoPayRequest.getAmount());
        List<SubAccountPaybackNanopay> subAccountPaybackNanopays =
                subAccountPaybackNanopayMapper.selectByExample(subAccountPaybackNanopayExample);

        if (CollectionUtil.isEmpty(subAccountPaybackNanopays)) {
            return new BasicResultVO().fail("payback  记录为空 直接登记 表格 ");
        }
        //todo 处理哪一笔payback 记录
        SubAccountPaybackNanopay subAccountPaybackNanopay =
                subAccountPaybackNanopays.stream().findFirst().get();
        //判断payback状态
        String status = subAccountPaybackNanopay.getStatus();
        if (UnipagosPaymentStatus.SETTLED.name().equals(status)) {
            return new BasicResultVO().success("已经settled ");
        }

        //todo 调unipagos 接口去查询


        //todo 组装需要更新的参数
        int count = subAccountPaybackNanopayMapper.updateByPrimaryKeySelective(subAccountPaybackNanopay);
        log.info("更新的笔数:{}", count);
        //查询unipagos
        CashInCallbackDto cashInCallbackDto =
                liquidoClient.notifyMerchant(accessToken, subAccountPaybackNanopay.getTransactionId());

        return new BasicResultVO().success("交易处理成功 ");
    }

    @Override
    public Vendor vendorName() {
        return Vendor.UNIPAGOS;
    }
}
