package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings({
        "checkstyle:EmptyLineSeparator",
        "PMD.TooManyFields"
})
public class Bs2BoletoCreateResponse {
    @JsonProperty("id")
    @NonNull
    String ticketId;

    @JsonProperty("sacado")
    Bs2BoletoDrawee drawee;
    public Optional<Bs2BoletoDrawee> getDrawee() {
        return Optional.ofNullable(drawee);
    }

    @JsonProperty("status")
    @NonNull
    Bs2BoletoStatus status;

    @JsonProperty("nossoNumero")
    @NonNull
    String bs2BoletoNumber;

    @JsonProperty("codigoDeBarra")
    @JsonAlias("codigoBarras")
    @NonNull
    String boletoBarcode;

    @JsonProperty("linhaDigitavel")
    @NonNull
    String boletoDigitalLine;

    @JsonProperty("seuNumero")
    @NonNull
    String liquidoBoletoNumber;

    @JsonProperty("clienteId")
    @NonNull
    String clientId;

    @JsonProperty("sacadorAvalista")
    Bs2BoletoDrawerGuarantor drawerGuarantor;
    public Optional<Bs2BoletoDrawerGuarantor> getDrawerGuarantor() {
        return Optional.ofNullable(drawerGuarantor);
    }

    @JsonProperty("vencimento")
    @NonNull
    String dueDate;

    @JsonProperty("valor")
    double amount;

    @JsonProperty("canal")
    String channel;
    public Optional<String> getChannel() {
        return Optional.ofNullable(channel);
    }

    @JsonProperty("multa")
    Bs2BoletoFine fine;
    public Optional<Bs2BoletoFine> getFine() {
        return Optional.ofNullable(fine);
    }

    @JsonProperty("desconto")
    Bs2BoletoDiscount discount;
    public Optional<Bs2BoletoDiscount> getDiscount() {
        return Optional.ofNullable(discount);
    }

    @JsonProperty("mensagem")
    Bs2BoletoMessage message;
    public Optional<Bs2BoletoMessage> getMessage() {
        return Optional.ofNullable(message);
    }

    @JsonProperty("aceite")
    Boolean acceptProtest;
    public Optional<Boolean> getAcceptProtest() {
        return Optional.ofNullable(acceptProtest);
    }

    @JsonProperty("especie")
    String boletoType;
    public Optional<String> getBoletoType() {
        return Optional.ofNullable(boletoType);
    }



}
