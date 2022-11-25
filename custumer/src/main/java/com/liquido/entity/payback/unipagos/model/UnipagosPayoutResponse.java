package com.liquido.entity.payback.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString
@AllArgsConstructor
public class UnipagosPayoutResponse extends UnipagosBaseResponse {

    //if when we payout error, this object may be null

    // balance of the payer account (Liquido M account)
    String balance;
    // used in SPEI, https://www.banxico.org.mx/cep
    String trackingCode;
    // used in STP
    String transactionId;
    // used in Unipagos
    String upOperationId;
    UnipagosReceipt receipt;
    String rawResponseBody;
}

/*

/api/v2/spei/cash_out/ response:

{
    "_resultType": "SUCCESS",
    "_resultCode": "000",
    "_resultDesc": "Operation successful",
    "_message": "Operation successful",
    "balance": "71.86",
    "trackingCode": "UNIPAGOS000000102488",
    "transactionId": "878a535f-2653-433f-ae5f-b4a13785d493",
    "upOperationId": "20210410-152707-250-0108-1325",
    "receipt": {
        "id": "878a535f-2653-433f-ae5f-b4a13785d493",
        "type": "W",
        "create_time": "2021-04-10 20:27:07.250783+00",
        "status": "P",
        "status_time": "2021-04-10 20:27:07.250783+00",
        "currency_code": "MXN",
        "from": {
            "type": "mdn",
            "key": "525536314917"
        },
        "to": {
            "type": "cash",
            "key": "MXN"
        },
        "concept": {
            "charge": [
                {
                    "description": "Retiro Interbancario SPEI",
                    "amount": "0.12",
                    "visible": "A",
                    "reference": [
                        {
                            "label": "claveRastreo",
                            "value": "UNIPAGOS000000102488"
                        }
                    ]
                },
                {
                    "description": "Comisión IVA Incluido",
                    "amount": "10.00",
                    "visible": "A"
                }
            ]
        },
        "amount": "10.12",
        "description": "Retiro Interbancario SPEI"
    }
}
 */
