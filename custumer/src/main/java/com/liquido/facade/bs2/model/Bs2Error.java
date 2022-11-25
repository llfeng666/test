package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Bs2Error {
    @JsonProperty("erroCodigo")
    String errorCode;

    public Optional<String> getErrorCode() {
        return Optional.ofNullable(errorCode);
    }

    @JsonProperty("erroDescricao")
    String errorMessage;

    public Optional<String> getErrorMessage() {
        return Optional.ofNullable(errorMessage);
    }

}
