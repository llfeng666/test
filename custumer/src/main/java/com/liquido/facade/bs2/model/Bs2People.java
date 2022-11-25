package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2People {
    @JsonProperty("documento")
    @NonNull
    String documentId;       // document


    @JsonProperty("tipoDocumento")
    @NonNull
    String documentType;   // type of document: CPF, CNPJ


    @JsonProperty("nome")
    @NonNull
    String name;            // name


    @JsonProperty("nomeFantasia")
    String lastName;    // family name

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }
}
