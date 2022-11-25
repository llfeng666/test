package com.liquido.enums.models;

import java.util.Optional;

import lombok.Builder;
import lombok.Value;
import org.apache.http.util.TextUtils;

@Value
@Builder
public class Address {
    String street;

    public Optional<String> getStreet() {
        return TextUtils.isBlank(street) ? Optional.empty() : Optional.of(street);
    }

    String number;

    public Optional<String> getNumber() {
        return TextUtils.isBlank(number) ? Optional.empty() : Optional.of(number);
    }

    /**
     * Unit, Apt., etc.
     */
    String complement;

    public Optional<String> getComplement() {
        return TextUtils.isBlank(complement) ? Optional.empty() : Optional.of(complement);
    }

    String district;

    public Optional<String> getDistrict() {
        return TextUtils.isBlank(district) ? Optional.empty() : Optional.of(district);
    }

    String city;

    public Optional<String> getCity() {
        return TextUtils.isBlank(city) ? Optional.empty() : Optional.of(city);
    }

    String state;

    public Optional<String> getState() {
        return TextUtils.isBlank(state) ? Optional.empty() : Optional.of(state);
    }

    String zipCode;

    public Optional<String> getZipCode() {
        return TextUtils.isBlank(zipCode) ? Optional.empty() : Optional.of(zipCode);
    }

    CountryCode country;

    public Optional<CountryCode> getCountry() {
        return Optional.ofNullable(country);
    }
}
