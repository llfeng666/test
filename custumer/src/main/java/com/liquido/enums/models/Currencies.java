package com.liquido.enums.models;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liquido.utils.UtilityClassException;


public final class Currencies {

    public static final Currency USD = Currency.getInstance("USD");
    public static final Currency MXN = Currency.getInstance("MXN");
    public static final Currency BRL = Currency.getInstance("BRL");
    public static final Currency COP = Currency.getInstance("COP");

    private static final Map<String, Currency> SUPPORTED_CURRENCIES =
            Stream.of(USD, MXN, BRL, COP)
                    .map(c -> Map.entry(c.getCurrencyCode(), c))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final Map<Currency, Integer> CURRENCIES_TO_SCALE =
            Map.of(
                    USD, 2,
                    BRL, 2,
                    MXN, 2,
                    COP, 2
            );

    static {
        if (!CURRENCIES_TO_SCALE.keySet().equals(new HashSet<>(SUPPORTED_CURRENCIES.values()))) {
            throw new IllegalStateException(
                    "Currencies class members do not agree on the currencies they support");
        }
    }

    private Currencies() {
        throw new UtilityClassException();
    }

    public static Currency valueOf(final String code) {
        final var sanitized = code.toUpperCase(Locale.ROOT);
        checkSupported(sanitized);
        return SUPPORTED_CURRENCIES.get(sanitized);
    }

    private static void checkSupported(final String currencyCode) {
        if (!SUPPORTED_CURRENCIES.containsKey(currencyCode)) {
            throw new IllegalArgumentException(
                    String.format("Unrecognized currency detected: %s", currencyCode));
        }
    }

    public static boolean isSupported(final String currencyCode) {
        return SUPPORTED_CURRENCIES.containsKey(currencyCode);
    }

    public static BigDecimal currencyValue(final Currency currency, final long amount) {
        checkSupported(currency.getCurrencyCode());
        return BigDecimal.valueOf(amount, CURRENCIES_TO_SCALE.get(currency));
    }

    /**
     * @param rawValue the raw value in double
     * @return the long value in cents. ex: if the value was $12.20, the result would be 1220
     */
    public static long currencyValueInCents(final Currency currency, final double rawValue) {
        return currencyValueInCents(currency, BigDecimal.valueOf(rawValue));
    }

    public static long currencyValueInCents(final Currency currency, final BigDecimal rawValue) {
        checkSupported(currency.getCurrencyCode());
        return rawValue.movePointRight(CURRENCIES_TO_SCALE.get(currency)).longValue();
    }

    /**
     * @return a precise value amount in BigDecimal.
     */
    public static BigDecimal valueToBigDecimal(
            final Currency currency, final double value
    ) {
        checkSupported(currency.getCurrencyCode());
        return BigDecimal.valueOf(value);
    }

    public static String displayCurrency(final Currency currency, final long amount) {
        final BigDecimal currencyValue = currencyValue(currency, amount);
        if (BRL.equals(currency)) {
            final String value = currencyValue.toPlainString().replace(".", ",");
            return currency.getSymbol(Locale.US) + value;
        }
        return currency.getSymbol(Locale.US) + currencyValue.toPlainString();
    }

    public static String displayCurrencyInCents(final Currency currency, final double value) {
        final BigDecimal currencyValue = valueToBigDecimal(currency, value);
        if (BRL.equals(currency)) {
            final String displayValue = currencyValue.toPlainString().replace(".", ",");
            return currency.getSymbol(Locale.US) + displayValue;
        }
        return currency.getSymbol(Locale.US) + currencyValue.toPlainString();
    }
}
