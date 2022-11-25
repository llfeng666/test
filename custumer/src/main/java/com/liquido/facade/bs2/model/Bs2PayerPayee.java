package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bs2PayerPayee {
    String ispb;

    public Optional<String> getIspb() {
        return Optional.ofNullable(ispb);
    }

    @JsonProperty("conta")
    Bs2BankAccount bankAccount;

    public Optional<Bs2BankAccount> getBankAccount() {
        return Optional.ofNullable(bankAccount);
    }

    @JsonProperty("pessoa")
    Bs2People people;

    public Optional<Bs2People> getPeople() {
        return Optional.ofNullable(people);
    }
}

/*
{
    "ispb": "71027866",
    "conta": {
        "banco": "218",
        "bancoNome": "BCO BS2 S.A.",
        "agencia": "0001",
        "numero": "8354294",
        "tipo": "ContaCorrente" // enum: "ContaCorrente",
        "ContaSalario", "Poupanca", "ContaPagamento"
    },
    "pessoa": {
        "documento": "43215655000190",
        "tipoDocumento": "CNPJ",
        "nome": "Liquido BRL",
        "nomeFantasia": null
    }
}
 */
