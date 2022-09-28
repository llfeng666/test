package com.liquido.facade.bs2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Bs2AccountType {
    CHECKING("ContaCorrente"),
    SALARY("ContaSalario"),
    SAVINGS("Poupanca"),
    PAYMENT_INSTITUTION("ContaPagamento");

    private final String type;

    Bs2AccountType(final String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    private static final Map<String, Bs2AccountType> BY_NAME =
            Arrays.stream(Bs2AccountType.values()).collect(
                    Collectors.toMap(Bs2AccountType::getType, Function.identity()));

    public static Bs2AccountType toAccountType(final String type) {
        if (!BY_NAME.containsKey(type)) {
            throw new IllegalArgumentException(
                    "Unexpected AccountType by vendor response: " + type);
        }

        return BY_NAME.get(type);
    }
}
