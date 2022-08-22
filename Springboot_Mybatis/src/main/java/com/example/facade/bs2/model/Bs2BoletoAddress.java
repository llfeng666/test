package com.example.facade.bs2.model;

import java.util.Optional;


import com.example.enums.models.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoAddress {
    @JsonProperty("cep")
    String zipCode;
    public Optional<String> getZipCode() {
        return Optional.ofNullable(zipCode);
    }

    @JsonProperty("estado")
    String state;
    public Optional<String> getState() {
        return Optional.ofNullable(state);
    }

    @JsonProperty("cidade")
    String city;
    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    @JsonProperty("bairro")
    String district;
    public Optional<String> getDistrict() {
        return Optional.ofNullable(district);
    }

    @JsonProperty("logradouro")
    String street;
    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    @JsonProperty("numero")
    String number;
    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }

    @JsonProperty("complemento")
    String complement;
    public Optional<String> getComplement() {
        return Optional.ofNullable(complement);
    }

    public static Bs2BoletoAddress fromAddress(final Address
                                                       address) {
        final var builder = Bs2BoletoAddress.builder();
        address.getComplement().ifPresent(builder::complement);
        address.getNumber().ifPresent(builder::number);
        address.getStreet().ifPresent(builder::street);
        address.getDistrict().ifPresent(builder::district);
        address.getCity().ifPresent(builder::city);
        address.getState().ifPresent(builder::state);
        address.getZipCode().ifPresent(builder::zipCode);
        return builder.build();
    }
}
