package com.liquido.facade.bs2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Bs2PixPayInCreateDynamicQrCodeResponse extends Bs2PixBasicTransactionResponse {
    @JsonProperty("qrCode")
    @NonNull
    QrCode qrCode;
}
