package com.liquido.entity.payback.unipagos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosSubAcctBalanceResp extends UnipagosBaseResponse {
    @NonNull
    private UnipagosParticipant delegateId;
    @NonNull
    private List<UnipagosSubAcctBalanceItem> subAccounts;
}

/*
{
  "delegateId": {
    "type": "merchant",
    "key": "6041878d4ff2fdea6a242daa"
  },
  "subAccounts": [
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
  ],
  "_resultCode": "000",
  "_resultType": "SUCCESS",
  "_resultDesc": "Operation successful"
}
 */
