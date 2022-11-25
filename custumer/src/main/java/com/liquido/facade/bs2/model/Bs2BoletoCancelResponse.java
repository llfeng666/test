package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2BoletoCancelResponse {
    @JsonProperty("solicitacaoId")
    @NonNull
    String requestId;

    @JsonProperty("nossoNumero")
    @NonNull
    String bs2BoletoNumber;

    @JsonProperty("status")
    @NonNull
    Bs2BoletoCancelStatus status;

    @JsonProperty("justificativa")
    String justification;

    public Optional<String> getJustification() {
        return Optional.ofNullable(justification);
    }
}
