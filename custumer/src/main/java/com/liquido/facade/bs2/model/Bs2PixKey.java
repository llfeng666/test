package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2PixKey {
    @JsonProperty("valor")
    @NonNull
    String value;       // value

    @JsonProperty("tipo")
    @NonNull
    String type;        // type CPF, CNPJ
}
