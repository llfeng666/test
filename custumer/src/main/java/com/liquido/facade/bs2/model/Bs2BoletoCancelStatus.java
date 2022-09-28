package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2BoletoCancelStatus {
    WAITING(1),
    FAILED(2),
    PASSED(3);

    private final int statusVal;

    Bs2BoletoCancelStatus(final int statusVal) {
        this.statusVal = statusVal;
    }

    @JsonValue
    public int getStatusVal() {
        return this.statusVal;
    }
}
