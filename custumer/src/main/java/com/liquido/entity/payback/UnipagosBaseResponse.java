package com.liquido.entity.payback;




import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UnipagosBaseResponse  {

    @JsonProperty("_resultType")
    @NonNull
    String resultType;

    @JsonProperty("_resultCode")
    @NonNull
    String resultCode;

    @JsonProperty("_resultDesc")
    @NonNull
    String resultDesc;

    @JsonProperty("_message")
    String message;
}

/*
Example:

{
    "_resultType": "SUCCESS",
    "_resultCode": "000",
    "_resultDesc": "Operation successful",
    "_message": "Operation successful",
    "creation_time": "2021-04-10 20:27:07 UTC",
    "status": "AUTHORIZED",
    "transactionId": "878a535f-2653-433f-ae5f-b4a13785d493",
    "upOperationId": "20210410-152707-250-0108-1325"
}

 */
