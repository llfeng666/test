package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoCreateRequest {
    @JsonProperty("seuNumero")
    @NonNull
    String liquidoBoletoNumber;

    /**
     * Owner of the product and/or service offered.
     * UNUSED currently
     */
    @JsonProperty("beneficiarioFinal")
    Bs2BoletoFinalBeneficiary finalBeneficiary;
    public Optional<Bs2BoletoFinalBeneficiary> getFinalBeneficiary() {
        return Optional.ofNullable(finalBeneficiary);
    }

    @JsonProperty("cliente")
    @NonNull
    Bs2BoletoClientInfo clientInfo;

    /**
     * UNUSED currently
     */
    @JsonProperty("sacadorAvalista")
    Bs2BoletoDrawerGuarantor drawerGuarantor;
    public Optional<Bs2BoletoDrawerGuarantor> getDrawerGuarantor() {
        return Optional.ofNullable(drawerGuarantor);
    }

    /**
     * EX: 2019-08-24T14:15:22Z
     */
    @JsonProperty("vencimento")
    @NonNull
    String dueDate;

    @JsonProperty("valor")
    double amount;

    /**
     * If the ticket has a final beneficiary, inform this field.
     * UNUSED currently
     */
    @JsonProperty("canal")
    String channel;
    public Optional<String> getChannel() {
        return Optional.ofNullable(channel);
    }

    /**
     * UNUSED currently
     */
    @JsonProperty("multa")
    Bs2BoletoFine fine;
    public Optional<Bs2BoletoFine> getFine() {
        return Optional.ofNullable(fine);
    }

    /**
     * UNUSED currently
     */
    @JsonProperty("desconto")
    Bs2BoletoDiscount discount;
    public Optional<Bs2BoletoDiscount> getDiscount() {
        return Optional.ofNullable(discount);
    }

    /**
     * UNUSED currently
     */
    @JsonProperty("mensagem")
    Bs2BoletoMessage message;
    public Optional<Bs2BoletoMessage> getMessage() {
        return Optional.ofNullable(message);
    }

    /**
     * Field for defining the acceptance of the ticket for cases of protest of the title
     * UNUSED currently
     */
    @JsonProperty("aceite")
    Boolean acceptProtest;
    public Optional<Boolean> getAcceptProtest() {
        return Optional.ofNullable(acceptProtest);
    }

    /**
     * Type of Boleto
     * UNUSED currently
     */
    @JsonProperty("especie")
    String boletoType;
    public Optional<String> getBoletoType() {
        return Optional.ofNullable(boletoType);
    }

    /**
     * Javascript datetime format: 2019-08-24T14:15:22Z
     */
    @JsonProperty("dataLimitePagamento")
    @NonNull
    String paymentDeadline;
}
