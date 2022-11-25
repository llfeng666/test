package com.liquido.entity.payback.unipagos.model;


import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosTopUpResponse extends UnipagosBaseResponse {
    private static final long serialVersionUID = 1L;
    // The account's balance after the transaction is processed
    private String balance;

    public Optional<String> getBalance() {
        return Optional.ofNullable(balance);
    }

    // used in Unipagos's vendor system
    private String transactionId;

    public Optional<String> getTransactionId() {
        return Optional.ofNullable(transactionId);
    }

    // used in Unipagos
    private String upOperationId;

    public Optional<String> getUpOperationId() {
        return Optional.ofNullable(upOperationId);
    }

    private UnipagosReceipt receipt;

    public Optional<UnipagosReceipt> getReceipt() {
        return Optional.ofNullable(receipt);
    }
}

/*

/api/v2/spei/cash_out/ response:

{
    // The account's balance after the transaction is processed
    "balance": "8946.56",
    // The UUID for the monetary transaction generated for this purchase (only if successful)
    "transactionId": "2d08a0c4-990a-4165-95fd-2afa850ea93f",
    // The Unique Unipagos operation Id generated to keep track of the request/response
    "upOperationId": "20181215-181835-024-0066-1010"
    // The final receipt (only if successful)
    "receipt": <receipt object>,
    // The result Code indicates the output of the operation:
    //"000" is considered successful, any other value is considered an error
    "_resultCode": "000",
    "_resultType": "SUCCESS",
    "_resultDesc": "operation successful",
    "_message": "Success"
}

{
  "_resultType": "SUCCESS",
  "_resultCode": "000",
  "_resultDesc": "Operation successful",
  "_message": "Operation successful",
  "balance": "1010.68",
  "receipt": {
    "id": "ffb69d19-0c53-4031-b044-b185f0bbd90a",
    "type": "T",
    "create_time": "2021-06-21 17:22:16.620406+00",
    "status": "C",
    "status_time": "2021-06-21 17:22:16.620406+00",
    "currency_code": "MXN",
    "from": {
      "type": "merchant",
      "key": "6041878d4ff2fdea6a242daa"
    },
    "to": {
      "type": "clabe",
      "key": "646180112053250273"
    },
    "concept": {
      "charge": [
        {
          "description": "AT&T Tiempo Aire 020",
          "amount": "20.00",
          "visible": "A",
          "reference": [
            {
              "label": "acct",
              "value": "5584707262"
            },
            {
              "label": "exid",
              "value": "0003"
            },
            {
              "label": "AUTORIZACION",
              "value": "50104987356"
            }
          ]
        },
        {
          "description": "Menos 4.75% Comisión",
          "amount": "-0.95",
          "visible": "F",
          "tax": [
            {
              "name": "IVA",
              "amount": "2.76"
            }
          ]
        }
      ]
    },
    "amount": "19.05",
    "description": "AT&T Tiempo Aire 020"
  },
  "transactionId": "ffb69d19-0c53-4031-b044-b185f0bbd90a",
  "upOperationId": "20210621-122215-540-0380-3131"
}
 */
