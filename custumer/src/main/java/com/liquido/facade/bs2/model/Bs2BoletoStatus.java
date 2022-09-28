package com.liquido.facade.bs2.model;

import com.liquido.enums.models.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2BoletoStatus {
    OPEN(1),
    EXPIRED(2),
    CANCELLED(3),
    PAID(4);

    private final int statusVal;

    Bs2BoletoStatus(final int statusVal) {
        this.statusVal = statusVal;
    }

    @JsonValue
    public int getStatusVal() {
        return this.statusVal;
    }

    public PaymentStatus toPaymentStatus() {
        switch (this) {
            case OPEN:
                return PaymentStatus.IN_PROGRESS;
            case EXPIRED:
                return PaymentStatus.EXPIRED;
            case CANCELLED:
                return PaymentStatus.CANCELLED;
            case PAID:
                return PaymentStatus.SETTLED;
            default:
                throw new IllegalArgumentException(
                        String.format("Unsupported Boleto status: %s", this));
        }
    }

    public static Bs2BoletoStatus fromPaymentStatus(final PaymentStatus s) {
        switch (s) {
            case IN_PROGRESS:
                return OPEN;
            case FAILED:
            case EXPIRED:
                return EXPIRED;
            case CANCELLED:
                return CANCELLED;
            case SETTLED:
                return PAID;
            default:
                throw new IllegalArgumentException(
                        String.format("Unrecognized payment status: %s", s));
        }
    }
}
