package com.liquido.enums.models;

import java.util.HashSet;
import java.util.Set;

public enum UnipagosPaymentStatus {
    INITIAL_STATUS("INITIAL_STATUS"),
    SETTLED("SETTLED"),
    IN_PROGRESS("IN_PROGRESS"),
    FAILED("FAILED"),
    REFUND("REFUND"),
    REJECTED("REJECTED");

    private String name;

    UnipagosPaymentStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Set<UnipagosPaymentStatus> FINAL_STATUSES = new HashSet<>();

    static {
        FINAL_STATUSES.add(SETTLED);
        FINAL_STATUSES.add(FAILED);
        FINAL_STATUSES.add(REJECTED);
        FINAL_STATUSES.add(REFUND);
    }

    public boolean isFinalStatus() {
        return FINAL_STATUSES.contains(this);
    }
}
