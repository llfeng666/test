package com.liquido.enums.models;

import java.util.HashSet;
import java.util.Set;

public enum PaymentStatus {
    INITIAL_STATUS,
    SETTLED,
    IN_PROGRESS,
    FAILED,
    CHARGED_BACK,
    REFUNDING,
    REFUNDED,
    EXPIRED,
    CANCELLED,
    REFUND,
    REJECTED;

    private static final Set<PaymentStatus> FINAL_STATUSES = new HashSet<>();

    static {
        FINAL_STATUSES.add(SETTLED);
        FINAL_STATUSES.add(FAILED);
        FINAL_STATUSES.add(REJECTED);
        FINAL_STATUSES.add(REFUND);
    }

    public boolean isFinalStatus() {
        return FINAL_STATUSES.contains(this);
    }

    public String getName() {
        return name();
    }

    private static final Set<PaymentStatus> RESOLVED_STATUSES =
            Set.of(
                    SETTLED, FAILED, REFUNDED, CHARGED_BACK, EXPIRED, CANCELLED
            );


    public boolean isResolvedStatus() {
        return RESOLVED_STATUSES.contains(this);
    }
}
