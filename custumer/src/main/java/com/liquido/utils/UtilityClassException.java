package com.liquido.utils;

/*
 * Vendored version of
 * https://github.com/jdbi/jdbi/blob/master/core/src/main/java/org/jdbi/v3/core/internal/UtilityClassException.java
 * Copyright (c), Data Geekery GmbH, contact@datageekery.com
 */
public class UtilityClassException extends UnsupportedOperationException {
    private static final long serialVersionUID = 1L;

    public UtilityClassException() {
        super("utility class");
    }
}
