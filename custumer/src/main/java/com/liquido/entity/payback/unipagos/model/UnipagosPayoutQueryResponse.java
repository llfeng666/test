package com.liquido.entity.payback.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString
public class UnipagosPayoutQueryResponse extends UnipagosBaseResponse {

    //if transaction is not find , this response may be null

    //todo: add enum for unipagos status and txStatus
    String status;          // 'AUTHORIZED', 'SETTLED', 'REFUNDED', 'GW_REJECTED'...
    String transactionId;   // used in STP
    String upOperationId;   // used in Unipagos
    String creationTime;    // the time Unipagos created the transfer transaction
    String modificationTime; // the time Unipagos received STP notification
    String txStatus;        // 'C' = Completed, 'X' = Cancelled, 'P' = Pending
    String txStatusTime;
    // the time Unipagos updated txStatus. It may several minutes after
    // the modificationTime. On receiving a STP notification, Unipagos update the
    // modificationTime then asynchronously update txStatus/txStatusTime based on a queue.
    String rawResponseBody;
}

/*
"/api/v2/spei/cash_out/:id"  response:

{
    "_resultType": "SUCCESS",
    "_resultCode": "000",
    "_resultDesc": "Operation successful",
    "_message": "Operation successful",
    "status": "SETTLED",
    "creationTime":     "2021-04-16 19:20:29 UTC",
    "modificationTime": "2021-04-16 19:20:56 UTC",
    "txStatusTime":     "2021-04-16 19:23:08.004761+00",
    "txStatus": "C",
    "transactionId": "002ced03-9056-4124-a3fb-f15417df09f2",
    "upOperationId": "20210416-142029-990-0619-6872"
}
 */
