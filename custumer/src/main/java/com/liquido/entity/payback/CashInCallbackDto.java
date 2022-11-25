package com.liquido.entity.payback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("PMD.TooManyFields")
public class CashInCallbackDto {
    @Deprecated
    private String idempotencyKey;
    private String transactionIdempotencyKey;
    private String accountIdempotencyKey;
    @Deprecated
    private String merchantId;
    private String accountUuid;
    private String accountId;
    private String phoneNumber;
    private Boolean isChildAccount;
    private String amount;
    private String currency;
    private String cashInTime;
    private int responseCode;
    private String responseErrorMsg;
    private String responseBody;
    @Builder.Default
    private String referenceNumber = "";
    @Builder.Default
    private String trackingId = "";
    @Builder.Default
    private String senderName = "";
    @Builder.Default
    private String senderAccountNumber = "";
}
