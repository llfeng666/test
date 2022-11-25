package com.liquido.enums.models;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * This is for merchant request and response.
 *
 * Please refrain from using this for internal data transfer. Use <code>PhoneNumber</code> instead.
 */
@Builder
@Value
public class PhoneInfo {
    int countryCallingCode;

    @NonNull
    String phoneNumber;

    @Override
    public String toString() {
        return String.format("+%s%s", countryCallingCode, phoneNumber);
    }
}
