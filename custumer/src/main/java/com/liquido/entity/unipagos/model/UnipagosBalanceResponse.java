package com.liquido.entity.unipagos.model;

import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosBalanceResponse extends UnipagosBaseResponse {
    @NonNull
    String balance;
    int reserve;
    @NonNull
    Currency currencyCode;
}
