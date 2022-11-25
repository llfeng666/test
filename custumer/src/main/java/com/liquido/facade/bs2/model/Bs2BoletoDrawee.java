package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoDrawee {
    @JsonProperty("email")
    String email;
    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    @JsonProperty("telefone")
    String phoneNumber;
    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }


    @JsonProperty("documento")
    String document;
    public Optional<String> getDocument() {
        return Optional.ofNullable(document);
    }

    @JsonProperty("nome")
    String name;
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @JsonProperty("endereco")
    Bs2BoletoAddress address;
    public Optional<Bs2BoletoAddress> getAddress() {
        return Optional.ofNullable(address);
    }
}
