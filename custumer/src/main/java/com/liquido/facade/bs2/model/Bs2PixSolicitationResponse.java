package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Bs2PixSolicitationResponse {
    @JsonProperty("pagamentoId")
    String paymentId;

    public Optional<String> getPaymentId() {
        return Optional.ofNullable(paymentId);
    }

    @JsonProperty("solicitacaoId")
    @NonNull
    String solicitationId;

    @JsonProperty("endToEndId")
    String endToEndId;

    public Optional<String> getEndToEndId() {
        return Optional.ofNullable(endToEndId);
    }

    @JsonProperty("status")
    String status;

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    @JsonProperty("agencia")
    String agency;

    public Optional<String> getAgency() {
        return Optional.ofNullable(agency);
    }

    @JsonProperty("numero")
    String accountNumber;

    public Optional<String> getAccountNumber() {
        return Optional.ofNullable(accountNumber);
    }

    @JsonProperty("chave")
    Bs2PixKey key;

    public Optional<Bs2PixKey> getKey() {
        return Optional.ofNullable(key);
    }

    @JsonProperty("valor")
    double value;

    @JsonProperty("campoLivre")
    String comments;

    public Optional<String> getComments() {
        return Optional.ofNullable(comments);
    }

    @JsonProperty("rejeitadoDescricao")
    String rejectDescription;

    public Optional<String> getRejectDescription() {
        return Optional.ofNullable(rejectDescription);
    }

    @JsonProperty("erroDescricao")
    String errorDescription;

    public Optional<String> getErrorDescription() {
        return Optional.ofNullable(errorDescription);
    }
}
