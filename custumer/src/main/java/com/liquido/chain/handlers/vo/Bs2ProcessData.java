package com.liquido.chain.handlers.vo;

import com.liquido.entity.PayInDukpay;
import com.liquido.facade.bs2.model.Bs2GetEidStatusResponse;
import com.liquido.facade.bs2.model.Bs2QueryTransactionByVendorIdResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bs2ProcessData {

    private String token;

    private String idempotencyKey;

    private Bs2GetEidStatusResponse bs2GetEidStatusResponse;

    private Bs2QueryTransactionByVendorIdResponse bs2QueryTransactionByVendorIdResponse;

    private PayInDukpay payInDukpay;

}
