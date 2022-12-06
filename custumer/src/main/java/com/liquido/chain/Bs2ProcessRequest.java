package com.liquido.chain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
public class Bs2ProcessRequest {

    private  String idempotencyKey;

    private String vendorTransactionId;

    private String  e2eId;

    private String coName;

}
