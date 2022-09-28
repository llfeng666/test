package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2ChargeInfo {
    @JsonProperty("calendario")
    @NonNull
    Bs2CalendarDateTimeInfo calendarInfo;

    @JsonProperty("devedor")
    @NonNull
    Bs2DebtorInfo debtor;

    @JsonProperty("valor")
    @NonNull
    Bs2TransactionValue value;

    /**
     * Should be the receiver side's PIX key. i.e. Liquido's PIX key
     */
    @JsonProperty("chave")
    @NonNull
    String pixKey;

    @JsonProperty("solicitacaoPagador")
    String payerComment;

    @JsonProperty("informacoesAdicionais")
    List<AdditionalInfoItem> additionalInfo;

    @Value
    @Builder
    public static class AdditionalInfoItem {
        @JsonProperty("nome")
        String name;

        @JsonProperty("valor")
        String value;
    }
}
