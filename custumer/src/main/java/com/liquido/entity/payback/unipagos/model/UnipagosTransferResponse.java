package com.liquido.entity.payback.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosTransferResponse extends UnipagosBaseResponse {

    @NonNull
    private String upOperationId;
    @NonNull
    private UnipagosReceipt receipt;
    private String rawResponseBody;
}

/*
{
    "receipt": {                                       // The receipt generated for the operation
        "id": "50462496-708f-413a-84f3-a1edc876483b",
        "type": "T",
        "create_time": "2014-06-30 10:24:53.527884-05",
        "status": "C",
        "status_time": "2014-06-30 10:24:53.527884-05",
        "description": "test transfer #1",
        "amount": "20.00",
        "currency_code": "MXN",
        "from": {
            "type": "mdn",
            "key": "525512257935"
        },
        "to": {
            "type": "mdn",
            "key": "525566952123"
        }
    },
    "upOperationId": "20190716-215909-620-0570-0536",   // Unipagos identifier for the operation
    "_resultCode": "000",
    "_resultType": "SUCCESS",
    "_resultDesc": "operation successful",
    "_message": "Success"
}
 */
