package com.liquido.enums.models;

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
    CANCELLED;

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
