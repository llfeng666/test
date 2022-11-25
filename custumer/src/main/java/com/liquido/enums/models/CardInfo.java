package com.liquido.enums.models;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CardInfo {
    @NonNull
    String cardNumber;

    @NonNull
    String cardHolderName;

    int expirationMonth;

    /**
     * Last 4 digits
     */
    int expirationYear;

    @NonNull
    String cvc;
}
