package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoDrawerGuarantor {

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
