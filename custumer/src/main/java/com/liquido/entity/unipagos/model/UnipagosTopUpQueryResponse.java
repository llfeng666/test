package com.liquido.entity.unipagos.model;


import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@AllArgsConstructor
public class UnipagosTopUpQueryResponse extends UnipagosBaseResponse {
    private static final long serialVersionUID = 1L;

    // The current status of the sale:
    // RECEIVED, AUTH_PENDING, AUTHORIZED， UP_REJECTED，GW_REJECTED， SETTLED
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

    public Optional<String> getOperationId() {
        return Optional.ofNullable(upOperationId);
    }

    // The timestamp when the record was received.
    private String creationTime;

    public Optional<String> getCreationTime() {
        return Optional.ofNullable(creationTime);
    }
}

/*
https://pay.unipagos.com/api/v2/sales/topups?xid=1234&date=2019-02-19

response:

{
    // The UUID for the monetary transaction generated for this purchase (only if successful)
    "transactionId": "2d08a0c4-990a-4165-95fd-2afa850ea93f",
    // The Unique Unipagos operation Id generated to keep track of the request/response
    "upOperationId": "20181215-181835-024-0066-1010"
    // The current status of the sale: SETTLED, AUTH_PENDING, RECEIVED, etc (see table below).
    "status": "SETTLED",
    // The timestamp when the record was received.
    "creation_time": "2019-02-19 14:02:22.548734-00",
    // The result Code indicates the output of the operation:
    // "000" is considered successful, any other value is condered an error
    "_resultCode": "000",
    "_resultType": "SUCCESS",
    "_resultDesc": "operation successful",
    "_message": "Success"
}

error response:

{
    "_resultType": "INVALID_PARAM",
    "_resultCode": "001",
    "_resultDesc": " * must match \"([0-9]+)\"   "
        +   "* The \"External ID\" is required, and must be NOT Empty.",
    "_message": "Reason: An invalid parameter was specified. Detail:  "
        +   "* must match \"([0-9]+)\"   * The \"External ID\" is required, and must be NOT Empty."
}

 */
