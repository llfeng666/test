package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoFinalBeneficiary {
    @JsonProperty("razaoSocial")
    String socialName;
    public Optional<String> getSocialName() {
        return Optional.ofNullable(socialName);
    }

    @JsonProperty("nomeFantasia")
    String tradeName;
    public Optional<String> getTradeName() {
        return Optional.ofNullable(tradeName);
    }

    @JsonProperty("documento")
    String document;
    public Optional<String> getDocument() {
        return Optional.ofNullable(document);
    }
}
