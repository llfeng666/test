package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2BoletoStatusHistoryStatus {
    BOLETO_REGISTERED(1, "Boleto Registered with the responsible body - CIP"),
    PAYMENT_IDENTIFIED(2, "Identified payment of the slip in the banking network (*)"),
    BOLETO_SETTLED(3, "Boleto settled/cleared - credit made to the CC (*)"),
    BOLETO_CANCELLED(4, "Ticket canceled/downloaded (no financial transactions)");
    /**
     * (*) It is important to note that the process in which the payment and receipt of the
     * amount with BS2 is effectively identified is in "Event 3 - Boleto settled/cleared -
     * credit made at CC". The process between the payment of the slip in the banking network
     * (event 2) and the effective clearing of the slip, there may be problems that prevent the
     * receipt of the slip value from BS2, where BS2 often has no power to act.
     */

    private final int statusVal;
    private final String description;

    Bs2BoletoStatusHistoryStatus(final int statusVal, final String description) {
        this.statusVal = statusVal;
        this.description = description;
    }

    @JsonValue
    public int getStatusVal() {
        return this.statusVal;
    }

    public String getDescription() {
        return this.description;
    }
}
