package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Bs2TransactionStatus {
    ACTIVE("ATIVA"),
    COMPLETED("CONCLUIDA"),
    REMOVED_BY_RECEIVING_USER("REMOVIDA_PELO_USUARIO_RECEBEDOR"),
    REMOVED_BY_PSP("REMOVIDA_PELO_PSP");

    private final String portugueseName;

    Bs2TransactionStatus(final String portugueseName) {
        this.portugueseName = portugueseName;
    }

    @JsonValue
    public String getPortugueseName() {
        return portugueseName;
    }
}
