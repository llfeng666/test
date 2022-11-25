package com.liquido.enums.models;

import java.util.Optional;

import lombok.Builder;
import lombok.Value;
import org.apache.http.util.TextUtils;

@Value
@Builder
public class BillingInfo {
    Address address;

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    String name;

    public Optional<String> getName() {
        return TextUtils.isBlank(name) ? Optional.empty() : Optional.of(name);
    }

    String email;

    public Optional<String> getEmail() {
        return TextUtils.isBlank(email) ? Optional.empty() : Optional.of(email);
    }

    String phone;

    public Optional<String> getPhone() {
        return TextUtils.isBlank(phone) ? Optional.empty() : Optional.of(phone);
    }
}
