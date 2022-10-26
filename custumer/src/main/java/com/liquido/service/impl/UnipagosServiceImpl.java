package com.liquido.service.impl;

import java.util.List;

import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.SubAccountPaybackNanopay;
import com.liquido.entity.SubAccountPaybackNanopayExample;
import com.liquido.entity.SubAccountsNanopay;
import com.liquido.entity.SubAccountsNanopayExample;
import com.liquido.entity.unipagos.model.UnipagosAccountBalanceResponse;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;
import com.liquido.exceptions.InternalServerException;
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

//    @Autowired
//    private LqDateUtils lqDateUtils;

    @Autowired
    private SubAccountsNanopayMapper subAccountsNanopayMapper;

    @Autowired
    private SubAccountPaybackNanopayMapper subAccountPaybackNanopayMapper;


    private static final String SUCCESS = "SUCCESS";

    private static final String ZERO = "0.00";



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
        SubAccountPaybackNanopayExample subAccountPaybackNanopayExample =
                new SubAccountPaybackNanopayExample();
        SubAccountPaybackNanopayExample.Criteria subCriteria =
                subAccountPaybackNanopayExample.createCriteria();
        subCriteria.andSubAccountUuidEqualTo(subAccountUuid);
        subCriteria.andAmountEqualTo(nanoPayRequest.getAmount());
        List<SubAccountPaybackNanopay> subAccountPaybackNanopays =
                subAccountPaybackNanopayMapper.selectByExample(subAccountPaybackNanopayExample);

        final String apiKey = "";
        //查询 liquido 接口 payback
        UnipagosAccountBalanceResponse unipagosAccountBalanceResponse =
                null;

        final String balance = String.valueOf(unipagosAccountBalanceResponse.getBalance());
        if (balance.equals(ZERO)) {

        }else if (nanoPayRequest.getAmount().equals(balance)){
            //todo 查询liquido接口 payback

        }else{

        }


        if (CollectionUtil.isEmpty(subAccountPaybackNanopays)) {
            //执行 5


        }else{
            //存在payback记录但状态不为settled查询vendor订单状态
            SubAccountPaybackNanopay subAccountPaybackNanopay =
                    subAccountPaybackNanopays.stream().findFirst()
                            .orElseThrow(() -> new InternalServerException(""));
            String payBackStatus = subAccountPaybackNanopay.getStatus();
            if ("SETTLED".equals(payBackStatus)) {
                return new BasicResultVO().success("已经是settled ");
            }

            final String submitTime = subAccountPaybackNanopay.getSubmitTime();
//
//            final String dateInPayCashFormat = lqDateUtils.getDateInPayCashFormat(
//                    lqDateUtils.parseMexicoFormattedTime(submitTime), lqDateUtils.MEXICO_TIME);

            // todo Unipagos 接口
//            UnipagosTransferQueryResponse response =
//                    unipagosClient.queryTransfer(dateInPayCashFormat,
//                            subAccountPaybackNanopay.getExternalId(),
//                            subAccountPaybackNanopay.getSubAccountId());
//            if (SUCCESS.equals(response.getResultType())) {
//                final UnipagosPaymentStatus status = UnipagosUtils.mapUnipagosStatus(
//                        response.getStatus().orElse("RECEIVED"));
//                UnipagosPaymentStatus txStatus = UnipagosPaymentStatus.INITIAL_STATUS;
//                if (!status.isFinalStatus()
//                        || status == UnipagosPaymentStatus.SETTLED) {
//                    txStatus = UnipagosUtils.convertReceiptStatus(
//                            response.getTxStatus().orElse("P"));
//                }
//                final Set<UnipagosPaymentStatus> isSettledStatus = Set.of(UnipagosPaymentStatus.SETTLED);
//                if (isSettledStatus.contains(status) || isSettledStatus.contains(txStatus)) {
//                //更新数据库
//
//                //通知商户
//
//                }
//            }

        }
        return null;
    }

    @Override
    public Vendor vendorName() {
        return Vendor.UNIPAGOS;
    }
}
