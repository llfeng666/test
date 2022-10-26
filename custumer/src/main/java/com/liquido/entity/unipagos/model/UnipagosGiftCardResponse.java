package com.liquido.entity.unipagos.model;


import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UnipagosGiftCardResponse extends UnipagosBaseResponse {
    private static final long serialVersionUID = 1L;
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

    // #activationCode to use on specific digital service
    private String activationCode;

    public Optional<String> getActivationCode() {
        return Optional.ofNullable(activationCode);
    }

    // Account balance
    private String balance;

    public Optional<String> getBalance() {
        return Optional.ofNullable(balance);
    }

    // Specifications on the use of the activation code、
    @JsonProperty("message")
    private String specifications;

    public Optional<String> getSpecifications() {
        return Optional.ofNullable(specifications);
    }

    private UnipagosReceipt receipt;

    public Optional<UnipagosReceipt> getReceipt() {
        return Optional.ofNullable(receipt);
    }
}

/*

 https://unipagos.atlassian.net/wiki/spaces/UDW/pages/2900000769/sales+gift+cards
 /api/v2/sales/gift_cards response:

{
    // The UUID for the monetary transaction generated for this purchase (only if successful)
    "transactionId": "2d08a0c4-990a-4165-95fd-2afa850ea93f",
    // The Unique Unipagos operation Id generated to keep track of the request/response
    "upOperationId": "20181215-181835-024-0066-1010"
    // The final receipt (only if successful)
    "receipt": <receipt object>,
    // #activationCode to use on specific digital service
    "activationCode": , "12345678"
    // Specifications on the use of the activation code
    "message": "use before expiration date xx/xx/xx",
    // The result Code indicates the output of the operation:
    // "000" is considered successful, any other value is considered an error
    "_resultCode": "000",
    "_resultType": "SUCCESS",
    "_resultDesc": "operation successful",
    "_message": "Success"
}
 */
