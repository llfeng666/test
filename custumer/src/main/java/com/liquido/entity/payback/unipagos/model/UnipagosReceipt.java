package com.liquido.entity.payback.unipagos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UnipagosReceipt {
    String status;
    String id;
    String type;
    @JsonProperty("status_time")
    String statusTime;
    @JsonProperty("create_time")
    String createTime;
    @JsonProperty("currency_code")
    String currencyCode;
    String amount;
    String description;
    UnipagosParticipant from;
    UnipagosParticipant to;
    Concept concept;

    @Value
    @Builder
    @AllArgsConstructor
    public static class Concept {

        List<Charge> charge;
    }

    @Value
    @Builder
    @AllArgsConstructor
    public static class Charge {


        String description;
        String amount;
        String visible;
        List<ReferenceItem> reference;

        @Value
        @Builder
        @AllArgsConstructor
        public static class ReferenceItem {

            String label;
            String value;
        }
    }
}

/*

Example:

    "receipt": {
        "id": "878a535f-2653-433f-ae5f-b4a13785d493",
        "type": "W",
        "create_time": "2021-04-10 20:27:07.250783+00",
        "status": "P",
        "status_time": "2021-04-10 20:27:07.250783+00",
        "currency_code": "MXN",
        "amount": "10.12",
        "description": "Retiro Interbancario SPEI"
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
        }
    }

 */
