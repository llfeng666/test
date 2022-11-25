package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2DebtorInfo {
    @JsonProperty("cnpj")
    @Getter(AccessLevel.NONE)
    String cnpj;

    public Optional<String> getCnpj() {
        return Optional.ofNullable(cnpj);
    }

    @JsonProperty("cpf")
    @Getter(AccessLevel.NONE)
    String cpf;

    public Optional<String> getCpf() {
        return Optional.ofNullable(cpf);
    }

    @JsonProperty("nome")
    @Getter(AccessLevel.NONE)
    String name;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
