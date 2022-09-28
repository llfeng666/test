package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2PixPayInCreateQrCodeRequest {
    @JsonProperty("chave")
    @NonNull
    String pixPayInKey;

    @JsonProperty("valor")
    double value;

    @JsonProperty("campoLivre")
    String description;

    @JsonProperty("txId")
    @NonNull
    String txId;
}
