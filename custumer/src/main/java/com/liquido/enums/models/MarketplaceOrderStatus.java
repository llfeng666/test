package com.liquido.enums.models;

import java.util.HashSet;
import java.util.Set;

public enum MarketplaceOrderStatus {
    CREATED("CREATED"),
    PAID("PAID"),
    IN_PROGRESS("IN_PROGRESS"),
    SETTLED("SETTLED"),
    FAILED("FAILED"),
    REFUNDED("REFUNDED");

    private String name;

    MarketplaceOrderStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Set<MarketplaceOrderStatus> FINAL_STATUSES = new HashSet<>();

    static {
        FINAL_STATUSES.add(SETTLED);
        FINAL_STATUSES.add(FAILED);
        FINAL_STATUSES.add(REFUNDED);
    }

    public boolean isFinalStatus() {
        return FINAL_STATUSES.contains(this);
    }
}
