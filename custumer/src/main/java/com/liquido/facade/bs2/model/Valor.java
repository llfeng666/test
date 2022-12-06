package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Valor {
    @JsonProperty("original")
    double originalValue;

    @JsonProperty("modalidadeAlteracao")
    int modalityChange;


}
