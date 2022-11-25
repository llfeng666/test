package com.liquido.facade.bs2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2TransactionValue {
    /**
     * Explanation from doc
     * Value of qrcode to be paid.
     */
    @JsonProperty("original")
    double originalValue;

    /**
     * Explanation from doc
     * This is a field that determines whether the final amount of the cpf
     * can be changed by the payer. In the absence of this field, it is assumed
     * that the value of the billing cpf cannot be changed, that is, the value
     * 0 is assumed. If the field is present and with a value of 1, then it is
     * determined that the final amount of the billing can have its value
     * changed by the payer.
     * NOTE: Not use yet
     */
    @JsonProperty("modalidadeAlteracao")
    int modalityChange;

    /**
     * Explanation from doc
     * Amount of collection interest
     * NOTE: Not use yet
     */
    @JsonProperty("juros")
    int fee;

    /**
     * Explanation from doc
     * Amount of the collection fine
     * NOTE: Not use yet
     */
    @JsonProperty("multa")
    int fine;

    /**
     * Explanation from doc
     * Billing discount amount
     * NOTE: Not use yet
     */
    @JsonProperty("desconto")
    int discount;

    /**
     * Explanation from doc
     * Final billing amount
     * NOTE: Not use yet
     */
    @JsonProperty("final")
    int finalValue;
}
