package com.liquido.enums.models;

import java.util.Locale;

import com.google.common.base.Verify;

/**
 * Only records the subset of countries which we support for now
 */
public enum CountryCode {
    US,
    MX,
    BR,
    CL,
    CO;

    CountryCode() {
        Verify.verify(
                Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2).contains(this.name()),
                "Unknown country: %s",
                this.name()
        );
    }
}
