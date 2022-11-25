package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2BalanceQueryResponse {
    @JsonProperty("valor")
    double balanceValue;

    @JsonProperty("valorBloqueado")
    double blockedValue;
}
