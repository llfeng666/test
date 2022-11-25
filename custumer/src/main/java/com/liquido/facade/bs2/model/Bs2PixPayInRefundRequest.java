package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2PixPayInRefundRequest {
    // Refund amount. The total refund amount should not exceed the amount in the original
    // transaction
    @JsonProperty("valor")
    double amount;

    public static Bs2PixPayInRefundRequest of(final double amount) {
        return Bs2PixPayInRefundRequest.builder().amount(amount).build();
    }
}
