package com.liquido.entity.payback.unipagos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class UnipagosSpeiInMsgBody extends UnipagosBaseResponse {

    @JsonProperty("accountXRef")
    @NonNull
    UnipagosAccountId subAccount;
    double amount;
    double balance;
    @JsonProperty("beneficiaryClabe")
    @NonNull
    String merchantClabe;
    @JsonProperty("delegateXref")
    @NonNull
    UnipagosAccountId merchantAccount;
    @NonNull
    String stpId;
    @NonNull
    String trackingCode;
    @NonNull
    String txCreationTime;
    @NonNull
    String txId;
    @NonNull
    String txStatus;
    @JsonProperty("speiReferenceNumber")
    @NonNull
    String referenceNumber;
    @JsonProperty("speiSenderName")
    @NonNull
    String senderName;
    @JsonProperty("speiSenderClabe")
    @NonNull
    String senderAccountNumber;
}

/*
{
   "_resultType":"SUCCESS",
   "_resultCode":"000",
   "_resultDesc":"Operation successful",
   "_message":"Inbound SPEI received to CLABE: 646180112053225965",
   "accountXRef":{
      "type":"merchant",
      "key":"sba-448e3225dc2e4d14ab051008"
   },
   "amount":100,
   "balance":100.00,
   "beneficiaryClabe":"646180112053225965",
   "delegateXref":{
      "type":"merchant",
      "key":"6041878d4ff2fdea6a242daa"
   },
   "speiOperationDate":"20200127",  // Date format YYYYMMDD
   "speiPaymentConcept":"PRUEBA1",
   "speiReferenceNumber":"1234567",
   "speiSenderClabe":"846180000400000001",
   "speiSenderInstitutionId":"846",
   "speiSenderName":"Juan Perez",
   "stpId":"845",
   "trackingCode":"031405",
   "txCreationTime":"2021-07-21 20:00:35.914784+00",
   "txId":"c75dcf02-13a2-45f5-ad33-422c842ea93b",
   "txStatus":"C"
}
*/
