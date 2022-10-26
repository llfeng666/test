package com.liquido.entity.unipagos.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class UnipagosPayoutRequest {
    @NonNull
    String externalId;
    @NonNull
    String referenceNumber;
    String recipientName;
    @NonNull
    String recipientClabeNumber;
    String recipientEmail;
    String recipientRfc;
    @NonNull
    String recipientBankId;
    String description;
    @NonNull
    String amount;
}
