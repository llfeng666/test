package com.example.facade.bs2.model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2Pix {
    @JsonProperty("status")
    @Getter(AccessLevel.NONE)
    String status;

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    @JsonProperty("endToEndId")
    @Getter(AccessLevel.NONE)
    String endToEndId;

    public Optional<String> getEndToEndId() {
        return Optional.ofNullable(endToEndId);
    }

    @JsonProperty("txId")
    @Getter(AccessLevel.NONE)
    String txId;

    public Optional<String> getTxId() {
        return Optional.ofNullable(txId);
    }

    @JsonProperty("valor")
    double value;

    @JsonProperty("horario")
    @Getter(AccessLevel.NONE)
    String settledTime;

    public Optional<String> getSettledTime() {
        return Optional.ofNullable(settledTime);
    }

    @JsonProperty("pagador")
    @Getter(AccessLevel.NONE)
    PixPayer payer;

    public Optional<PixPayer> getPayer() {
        return Optional.ofNullable(payer);
    }

    @JsonProperty("infoPagador")
    @Getter(AccessLevel.NONE)
    String payerComment;

    public Optional<String> getPayerComment() {
        return Optional.ofNullable(payerComment);
    }

    @JsonProperty("devolucoes")
    @Getter(AccessLevel.NONE)
    List<Bs2PixPayInRefundResponse> refundInfo;

    public List<Bs2PixPayInRefundResponse> getRefundInfo() {
        if (refundInfo == null) {
            return List.of();
        }
        return refundInfo;
    }

    @Value
    @Builder
    @AllArgsConstructor
    public static class PixPayer {
        @JsonProperty("cpf")
        @Getter(AccessLevel.NONE)
        String cpf;

        public Optional<String> getCpf() {
            return Optional.ofNullable(cpf);
        }

        @JsonProperty("cnpj")
        @Getter(AccessLevel.NONE)
        String cnpj;

        public Optional<String> getCnpj() {
            return Optional.ofNullable(cnpj);
        }

        @JsonProperty("nome")
        @Getter(AccessLevel.NONE)
        String name;

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }
    }
}
