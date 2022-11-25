package com.liquido.entity.payback;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInfo {
    long amount;

    String referenceNumber;

    public Optional<String> getReferenceNumber() {
        return Optional.ofNullable(referenceNumber);
    }

    String trackingId;

    public Optional<String> getTrackingId() {
        return Optional.ofNullable(trackingId);
    }

    String senderName;

    public Optional<String> getSenderName() {
        return Optional.ofNullable(senderName);
    }

    String senderAccountNumber;

    public Optional<String> getSenderAccountNumber() {
        return Optional.ofNullable(senderAccountNumber);
    }
}
