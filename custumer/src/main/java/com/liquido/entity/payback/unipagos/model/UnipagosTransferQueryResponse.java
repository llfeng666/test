package com.liquido.entity.payback.unipagos.model;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@AllArgsConstructor
public class UnipagosTransferQueryResponse extends UnipagosBaseResponse {
    String status;
    String transactionId;
    String upOperationId;
    String creationTime;
    String modificationTime;
    String txStatus;
    String txStatusTime;

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<String> getTransaction() {

        return Optional.ofNullable(transactionId);
    }

    public Optional<String> getOperationId() {
        return Optional.ofNullable(upOperationId);
    }

    public Optional<String> getCreatedTime() {
        return Optional.ofNullable(creationTime);
    }

    public Optional<String> getModifiedTime() {
        return Optional.ofNullable(modificationTime);
    }

    public Optional<String> getTxStatus() {
        return Optional.ofNullable(txStatus);
    }

    public Optional<String> getTxStatusTime() {
        return Optional.ofNullable(txStatusTime);
    }
}


