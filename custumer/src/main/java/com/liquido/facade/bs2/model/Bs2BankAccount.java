package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;


@Value
@Builder
public class Bs2BankAccount {
    @JsonProperty("banco")
    String bankCode;       // bank

    public Optional<String> getBankCode() {
        return Optional.ofNullable(bankCode);
    }


    @JsonProperty("bancoNome")
    String bankName;   // bank name

    public Optional<String> getBankName() {
        return Optional.ofNullable(bankName);
    }

    @JsonProperty("agencia")
    String agency;     // agency, bank branch

    public Optional<String> getAgency() {
        return Optional.ofNullable(agency);
    }

    @JsonProperty("numero")
    String accountNumber;      // name

    public Optional<String> getAccountNumber() {
        return Optional.ofNullable(accountNumber);
    }


    @JsonProperty("tipo")
    @NonNull
    String accountType;
    // type, enum ContaCorrente, ContaSalario, Poupanca, ContaPagamento

}
