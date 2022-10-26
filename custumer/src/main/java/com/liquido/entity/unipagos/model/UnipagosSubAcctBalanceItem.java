package com.liquido.entity.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UnipagosSubAcctBalanceItem {
    @NonNull
    String balance;
    @NonNull
    String clabeAccount;
    @NonNull
    String currencyCode;
    @NonNull
    String countryCode;
    FormalName formalName;
    String limitCode;
    String status;
    @NonNull
    UnipagosParticipant targetAccountId;
    String creationTime;

    @Data
    public static class FormalName {
        private String given;
        private String paternal;
    }
}

/*
    {
      "balance": "0.00",
      "clabeAccount": "646180112056075374",
      "currencyCode": "MXN",
      "countryCode": "MX",
      "formalName": {
        "given": "Jaime Hernandez",
        "paternal": "Jaime Hernandez"
      },
      "limitCode": "MX-01",
      "status": "active",
      "targetAccountId": {
        "type": "merchant",
        "key": "sba-607742e38196a27f34ee6b73"
      },
      "creationTime": "2021-05-25T22:35:23.055Z"
    }
 */
