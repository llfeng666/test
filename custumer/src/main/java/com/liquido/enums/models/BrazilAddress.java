package com.liquido.enums.models;

import java.util.Optional;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class BrazilAddress {
    String zipCode;
    public Optional<String> getZipCode() {
        return Optional.ofNullable(zipCode);
    }

    String state;
    public Optional<String> getState() {
        return Optional.ofNullable(state);
    }

    String city;
    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    String district;
    public Optional<String> getDistrict() {
        return Optional.ofNullable(district);
    }

    String street;
    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    String number;
    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }

    /**
     * Unit, Apt., etc.
     */
    String complement;
    public Optional<String> getComplement() {
        return Optional.ofNullable(complement);
    }
}
