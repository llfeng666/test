package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoFine {
    /**
     * Enter a fixed percentage amount that will be billed after
     * the due date that was defined in the "Expiration" field
     */
    @JsonProperty("valor")
    Double fixedFineInPercentage;
    public Optional<Double> getFixedFineInPercentage() {
        return Optional.ofNullable(fixedFineInPercentage);
    }

    /**
     * Date from which the fine will be charged.
     */
    @JsonProperty("data")
    String paymentDueDate;
    public Optional<String> getPaymentDueDate() {
        return Optional.ofNullable(paymentDueDate);
    }

    /**
     * Interest on the fine (Percentage) from which daily amount
     * (percentage) will be charged in interest if the slip has not
     * been paid by the due date. No accumulation limit. Example: 15.
     */
    @JsonProperty("juros")
    Double interest;
    public Optional<Double> getInterest() {
        return Optional.ofNullable(interest);
    }
}
