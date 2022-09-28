package com.liquido.facade.bs2.model;

import com.liquido.enums.models.PaymentStatus;
import com.liquido.exceptions.InternalServerException;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2RefundStatus {
    IN_PROGRESS("EM_PROCESSAMENTO"),
    REFUNDED("DEVOLVIDO"),
    NOT_PROCESSED("NAO_REALIZADO");

    private final String statusPortuguese;

    Bs2RefundStatus(final String statusPortuguese) {
        this.statusPortuguese = statusPortuguese;
    }

    @JsonValue
    public String getStatusPortuguese() {
        return this.statusPortuguese;
    }

    public PaymentStatus toPaymentStatus() {
        if (this.equals(IN_PROGRESS)) {
            return PaymentStatus.IN_PROGRESS;
        } else if (this.equals(REFUNDED)) {
            return PaymentStatus.SETTLED;
        } else if (this.equals(NOT_PROCESSED)) {
            return PaymentStatus.FAILED;
        } else {
            throw new InternalServerException(
                    String.format("Failed to get PaymentStatus from Bs2RefundStatus: %s", this));
        }
    }

    public static Bs2RefundStatus fromPaymentStatus(final PaymentStatus status) {
        if (status.equals(PaymentStatus.IN_PROGRESS)) {
            return IN_PROGRESS;
        } else if (status.equals(PaymentStatus.SETTLED)) {
            return REFUNDED;
        } else if (status.equals(PaymentStatus.FAILED)) {
          return NOT_PROCESSED;
        } else {
            throw new InternalServerException(
                    String.format("Failed to get Bs2RefundStatus from PaymentStatus: %s", status));
        }
    }
}
