package com.liquido.entity.payback.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * {
 * "_resultType": "SUCCESS",
 * "_resultCode": "000",
 * "_resultDesc": "",
 * "_message": null,
 * "balance": 20000.7,
 * "currencyCode": "MXN"
 * }
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
public class UnipagosAccountBalanceResponse extends UnipagosBaseResponse {

    @NonNull
    private Float balance;
    @NonNull
    private String currencyCode;
}
