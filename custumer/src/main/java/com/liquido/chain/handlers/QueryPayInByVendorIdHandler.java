package com.liquido.chain.handlers;

import java.util.Objects;

import com.liquido.chain.Bs2HanlderChain;
import com.liquido.chain.Bs2ProcessRequest;
import com.liquido.chain.TradeContext;
import com.liquido.chain.handlers.vo.Bs2ProcessData;
import com.liquido.chain.handlers.vo.TradeTypeClassName;
import com.liquido.entity.PayInDukpay;
import com.liquido.enums.models.PaymentStatus;
import com.liquido.service.Bs2QueryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 根据vendorid 查询数据库
 */
@Slf4j
@Component("queryPayInByVendorIdHandler")
public class QueryPayInByVendorIdHandler implements Bs2HanlderChain {

    @Autowired
    private Bs2QueryService bs2QueryService;

    @Override
    public TradeContext process(Chain<Bs2ProcessRequest, TradeContext> chain) {
        TradeContext response = chain.response();
        final Bs2ProcessRequest request = chain.request();
        Bs2ProcessData bs2ProcessData = response.getBs2ProcessData();
        boolean failedFlag = false;
        String errorMsg = "";
        final PayInDukpay payInDukpay =
                bs2QueryService.queryPayInDukpayByVendorId(request.getVendorTransactionId()
                        , request.getCoName());
        if (Objects.isNull(payInDukpay)) {
            failedFlag = true;
            errorMsg = "根据 vendorId 查询无记录";
        }else if(PaymentStatus.SETTLED.name().equals(payInDukpay.getTransferStatus())){
            failedFlag = true;
            errorMsg = "根据 vendorId 查询Payin 已经 settled";
            bs2ProcessData.setIdempotencyKey(payInDukpay.getIdempotencyKey());
        }
        bs2ProcessData.setPayInDukpay(payInDukpay);
        return response.setContext(response,failedFlag,
                TradeTypeClassName.bs2E2eIdQueryHandler.name(),
                errorMsg,
                bs2ProcessData
                );
    }

}
