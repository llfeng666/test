package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bs2PixPayInCreateQrCodeResponse {
    @JsonProperty("txId")
    @NonNull
    String txId;

    @JsonProperty("qrCode")
    @NonNull
    QrCode qrCode;

    // In BS2 vendor's raw format. Should use LqDateUtils to parse
    @JsonProperty("dataCriacao")
    @NonNull
    String createdAt;
}
