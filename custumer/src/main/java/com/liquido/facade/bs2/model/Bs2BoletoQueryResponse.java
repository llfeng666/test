package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoQueryResponse {
    @JsonProperty("item")
    Bs2BoletoDto boleto;
    public Optional<Bs2BoletoDto> getBoleto() {
        return Optional.ofNullable(boleto);
    }
}
