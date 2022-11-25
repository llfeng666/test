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
public class Bs2BoletoDiscount {
    /**
     * Percentage value diluted among the total days available for discount
     */
    @JsonProperty("percentual")
    Double discountPercentage;
    public Optional<Double> getDiscountPercentage() {
        return Optional.ofNullable(discountPercentage);
    }

    /**
     * Fixed amount that will be discounted in case of payment within the discount deadline
     */
    @JsonProperty("valorFixo")
    Double fixedDiscountAmount;
    public Optional<Double> getFixedDiscountAmount() {
        return Optional.ofNullable(fixedDiscountAmount);
    }

    /**
     * Discounted amount per day, within the discount deadline
     */
    @JsonProperty("valorDiario")
    Double discountPerDay;
    public Optional<Double> getDiscountPerDay() {
        return Optional.ofNullable(discountPerDay);
    }

    /**
     * Deadline for discount, cannot be after than the due date.
     * Format: 2019-08-24T14:15:22Z
     */
    @JsonProperty("limite")
    String discountDeadline;
    public Optional<String> getDiscountDeadline() {
        return Optional.ofNullable(discountDeadline);
    }
}
