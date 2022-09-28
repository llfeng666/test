package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoWallet {
    @JsonProperty("descricao")
    String description;
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @JsonProperty("codigo")
    int walletCode;
}
