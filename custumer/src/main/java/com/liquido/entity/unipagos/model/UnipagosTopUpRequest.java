package com.liquido.entity.unipagos.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UnipagosTopUpRequest {
    @NonNull
    String externalId;
    @NonNull
    String sku;
    @NonNull
    String amount;
    @NonNull
    String targetPhoneNumber;
}

/*
 * {
 *   "sku": "ATT010",
 *   "externalId": "2006",
 *   "amount": "10.00",
 *   "targetPhoneNumber": "5584707262"
 * }
 */

