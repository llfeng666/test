package com.liquido.facade.bs2.model;


import com.liquido.enums.models.PaymentStatus;
import com.liquido.exceptions.InternalServerException;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2BoletoWebhookStatus {
    IN_PROGRESS(1),
    OVERDUE(2),
    CANCELLED(3),
    SETTLED(4);

    private final int statusVal;

    Bs2BoletoWebhookStatus(final int statusVal) {
        this.statusVal = statusVal;
    }

    @JsonValue
    public int getStatusVal() {
        return this.statusVal;
    }

    public PaymentStatus toPaymentStatus() {
        switch (this) {
            case IN_PROGRESS:
                return PaymentStatus.IN_PROGRESS;
            case OVERDUE:
                return PaymentStatus.EXPIRED;
            case CANCELLED:
                return PaymentStatus.CANCELLED;
            case SETTLED:
                return PaymentStatus.SETTLED;
            default:
                throw new InternalServerException(
                        String.format(
                                "Failed to get PaymentStatus from Bs2BoletoWebhookStatus: %s",
                                this));
        }
    }

    public static Bs2BoletoWebhookStatus fromPaymentStatus(final PaymentStatus status) {
        switch (status) {
            case IN_PROGRESS:
                return Bs2BoletoWebhookStatus.IN_PROGRESS;
            case EXPIRED:
                return Bs2BoletoWebhookStatus.OVERDUE;
            case CANCELLED:
                return Bs2BoletoWebhookStatus.CANCELLED;
            case SETTLED:
                return Bs2BoletoWebhookStatus.SETTLED;
            default:
                throw new InternalServerException(
                        String.format(
                                "Failed to get Bs2BoletoWebhookStatus from PaymentStatus: %s",
                                status));
        }
    }
}
