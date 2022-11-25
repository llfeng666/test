package com.liquido.entity.payback;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosTransferQueryResponse extends UnipagosBaseResponse {
    String status;

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    String transactionId;

    public Optional<String> getTransaction() {

        return Optional.ofNullable(transactionId);
    }

    String upOperationId;

    public Optional<String> getOperationId() {
        return Optional.ofNullable(upOperationId);
    }

    String creationTime;

    public Optional<String> getCreatedTime() {
        return Optional.ofNullable(creationTime);
    }

    String modificationTime;

    public Optional<String> getModifiedTime() {
        return Optional.ofNullable(modificationTime);
    }

    String txStatus;

    public Optional<String> getTxStatus() {
        return Optional.ofNullable(txStatus);
    }

    String txStatusTime;

    public Optional<String> getTxStatusTime() {
        return Optional.ofNullable(txStatusTime);
    }
}
