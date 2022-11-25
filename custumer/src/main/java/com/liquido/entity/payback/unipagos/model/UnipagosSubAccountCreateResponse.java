package com.liquido.entity.payback.unipagos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UnipagosSubAccountCreateResponse extends UnipagosBaseResponse {
    //if create subaccount error, this response may be null
    Float balance;
    @JsonProperty("clabeAccount")
    String subAccountClabe;
    String currencyCode;
    String limitCode;
    String status;
    String delegationMode;
    String creationTime;
    @JsonProperty("delegateId")
    UnipagosAccountId merchantAccount;
    @JsonProperty("targetAccountId")
    UnipagosAccountId subAccount;
}

/*
{
    "balance":0,
    "clabeAccount":"646180211500802017",
    "currencyCode":"MXN",
    "limitCode":"MX-01",
    "delegateId":{
        "type":"merchant",
        "key":"60774599fc9d3e005b0ee9d3"
    },
    "targetAccountId":{
        "type":"merchant",
        "key":"sba-67ca6621fea142af91bbd7cc"
    },
    "status":"active",
    "delegationMode":"SUB_ACCOUNT",
    "creationTime":"2021-05-27T22:32:54.551Z",
    "_resultCode":"000",
    "_resultType":"SUCCESS",
    "_resultDesc":"Operation successful"
}
 */
