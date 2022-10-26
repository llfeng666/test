package com.liquido.entity.unipagos.model;


import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosGiftCardQueryResponse extends UnipagosBaseResponse {
    private static final long serialVersionUID = 1L;

    // The current status of the sale: RECEIVED, AUTH_PENDING,
    // AUTHORIZED， UP_REJECTED，GW_REJECTED， SETTLED
    private String status;

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    // The UUID for the monetary transaction generated for this purchase (only if successful)
    private String transactionId;

    public Optional<String> getTransactionId() {
        return Optional.ofNullable(transactionId);
    }

    // The Unique Unipagos operation Id generated to keep track of the request/response
    private String upOperationId;

    public Optional<String> getUpOperationId() {
        return Optional.ofNullable(upOperationId);
    }

    // The timestamp when the record was received.
    private String creationTime;

    public Optional<String> getCreationTime() {
        return Optional.ofNullable(creationTime);
    }

    // The timestamp when the record was received.
    private String modificationTime;

    public Optional<String> getModificationTime() {
        return Optional.ofNullable(modificationTime);
    }

    // The current status of the transaction: (P)ending, (C)ompleted,
    // (X)anceled, (D)isputed, (R)efunded, (V)oided.
    private String txStatus;

    public Optional<String> getTxStatus() {
        return Optional.ofNullable(txStatus);
    }

    // The timestamp when the transaction status was updated.
    private String txStatusTime;

    public Optional<String> getTxStatusTime() {
        return Optional.ofNullable(txStatusTime);
    }
}

/*
GET https://pay.unipagos.com/api/v2/sales/digital_services?xid=1234&date=2019-02-19

response:

{
   "_resultType": "SUCCESS",
   // The result Code indicates the output of the operation:
   //"000" is considered successful, any other value is condered an error
   "_resultCode": "000",
   "_resultDesc": "Operation successful",
   "_message": "Operation successful",
   // The timestamp when the record was received.
   "creationTime": "2021-06-21 20:40:27 UTC",
   // The timestamp when the record was updated.
   "modificationTime": "2021-06-21 20:40:28 UTC",
    // The current status of the sale: SETTLED, AUTH_PENDING, RECEIVED, etc (see table below).
   "status": "AUTHORIZED",
   // The UUID for the monetary transaction generated for this purchase (only if successful)
   "transactionId": "7d5dd096-b14c-416e-b4b0-05f325b2fd7d",
   // The current status of the transaction: (P)ending, (C)ompleted,
   // (X)anceled, (D)isputed, (R)efunded, (V)oided.
   "txStatus": "C",
   // The timestamp when the transaction status was updated.
   "txStatusTime": "2021-06-21 20:40:28.494946+00",
   // The Unique Unipagos operation Id generated to keep track of the request/response
   "upOperationId": "20210621-154027-204-0890-3167"
}

error response:

{
    "_resultType": "INVALID_PARAM",
    "_resultCode": "001",
    "_resultDesc": " * must match \"([0-9]+)\"   * The \"External ID\" "
           + "is required, and must be NOT Empty.",
    "_message": "Reason: An invalid parameter was specified. Detail:  "
           + "* must match \"([0-9]+)\"   * The \"External ID\" is required, and must be NOT Empty."
}

 */

