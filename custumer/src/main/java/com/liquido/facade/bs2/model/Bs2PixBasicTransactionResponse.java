package com.liquido.facade.bs2.model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bs2PixBasicTransactionResponse {
    @JsonProperty("calendario")
    @Getter(AccessLevel.NONE)
    Bs2CalendarDateTimeInfo calendarInfo;

    public Optional<Bs2CalendarDateTimeInfo> getCalendarInfo() {
        return Optional.ofNullable(calendarInfo);
    }

    @JsonProperty("status")
    @NonNull
    Bs2TransactionStatus status;

    @JsonProperty("txId")
    @Getter(AccessLevel.NONE)
    String txId;

    public Optional<String> getTxId() {
        return Optional.ofNullable(txId);
    }

    @JsonProperty("revisao")
    int version;

    @JsonProperty("location")
    @Getter(AccessLevel.NONE)
    String location;

    public Optional<String> getLocation() {
        return Optional.ofNullable(location);
    }

    @JsonProperty("devedor")
    @Getter(AccessLevel.NONE)
    Bs2DebtorInfo debtor;

    public Optional<Bs2DebtorInfo> getDebtor() {
        return Optional.ofNullable(debtor);
    }

    @JsonProperty("valor")
    @Getter(AccessLevel.NONE)
    Bs2TransactionValue value;

    public Optional<Bs2TransactionValue> getValue() {
        return Optional.ofNullable(value);
    }

    /**
     * Should be the receiver side's PIX key. i.e. Liquido's PIX key
     */
    @JsonProperty("chave")
    @Getter(AccessLevel.NONE)
    String pixKey;

    public Optional<String> getPixKey() {
        return Optional.ofNullable(pixKey);
    }

    @JsonProperty("solicitacaoPagador")
    @Getter(AccessLevel.NONE)
    String payerComment;

    public Optional<String> getPayerComment() {
        return Optional.ofNullable(payerComment);
    }

    @JsonProperty("infoAdicionais")
    @Getter(AccessLevel.NONE)
    List<AdditionalInfoItem> additionalInfo;

    public List<AdditionalInfoItem> getAdditionalInfo() {
        if (additionalInfo == null) {
            return List.of();
        }
        return additionalInfo;
    }

    @Value
    @Builder
    @AllArgsConstructor
    public static class AdditionalInfoItem {
        @JsonProperty("nome")
        @Getter(AccessLevel.NONE)
        String name;

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        @JsonProperty("valor")
        @Getter(AccessLevel.NONE)
        String value;

        public Optional<String> getValue() {
            return Optional.ofNullable(value);
        }
    }
}
