package com.liquido.facade.bs2.model;

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
public class Bs2PixPayInRefundResponse {
    @JsonProperty("id")
    @Getter(AccessLevel.NONE)
    // Should be our idempotencyKey
    String refundId;

    public Optional<String> getRefundId() {
        return Optional.ofNullable(refundId);
    }

    @JsonProperty("rtrId")
    @Getter(AccessLevel.NONE)
    String returnIdentificationId;

    public Optional<String> getReturnIdentificationId() {
        return Optional.ofNullable(returnIdentificationId);
    }

    @JsonProperty("valor")
    double amount;

    @JsonProperty("horario")
    @Getter(AccessLevel.NONE)
    RefundTimeInfo refundTimeInfo;

    public Optional<RefundTimeInfo> getRefundTimeInfo() {
        return Optional.ofNullable(refundTimeInfo);
    }

    @JsonProperty("status")
    Bs2RefundStatus status;

    @Value
    @Builder
    @AllArgsConstructor
    public static class RefundTimeInfo {
        @JsonProperty("solicitacao")
        @Getter(AccessLevel.NONE)
        String requestedTime;

        public Optional<String> getRequestedTime() {
            return Optional.ofNullable(requestedTime);
        }

        @JsonProperty("liquidacao")
        @Getter(AccessLevel.NONE)
        String settledTime;

        public Optional<String> getSettledTime() {
            return Optional.ofNullable(settledTime);
        }
    }
}
