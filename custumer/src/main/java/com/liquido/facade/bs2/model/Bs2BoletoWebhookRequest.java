package com.liquido.facade.bs2.model;


import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoWebhookRequest {
    @JsonProperty("Id")
    @NonNull
    String notificationId;

    @JsonProperty("Conta")
    String account;
    public Optional<String> getAccount() {
        return Optional.ofNullable(account);
    }

    @JsonProperty("DataNotificacao")
    String webhookNotificationDate;
    public Optional<String> getWebhookNotificationDate() {
        return Optional.ofNullable(webhookNotificationDate);
    }

    @JsonProperty("NossoNumeroBoleto")
    @NonNull
    String bs2BoletoNumber;

    @JsonProperty("SeuNumeroBoleto")
    @NonNull
    String liquidoBoletoNumber;

    @JsonProperty("Valor")
    double amount;

    @JsonProperty("ValorLiquidado")
    double amountSettled;

    @JsonProperty("SituacaoDescricao")
    String statusDescription;
    public Optional<String> getSituationDescription() {
        return Optional.ofNullable(statusDescription);
    }

    @JsonProperty("Situacao")
    @NonNull
    Bs2BoletoWebhookStatus ticketStatus;

    @JsonProperty("StatusBoleto")
    List<Bs2BoletoStatusHistory> statusHistory;
    public List<Bs2BoletoStatusHistory> getStatusHistory() {
        return statusHistory == null ? List.of() : statusHistory;
    }
}
