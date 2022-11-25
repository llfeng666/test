package com.liquido.facade.bs2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2PixPayInCreateDynamicQrCodeRequest {
    @JsonProperty("txId")
    @NonNull
    String txId;

    @JsonProperty("cobranca")
    @NonNull
    Bs2ChargeInfo charge;
}
