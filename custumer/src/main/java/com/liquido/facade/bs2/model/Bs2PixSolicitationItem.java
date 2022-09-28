package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2PixSolicitationItem {

    @JsonProperty("identificador")
    @NonNull
    String idempotencyKey;

    @JsonProperty("chave")
    @NonNull
    Bs2PixKey key;

    @JsonProperty("valor")
    double value;
}
