package com.liquido.entity.payback;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("PMD.TooManyFields")
public class SubAcctPaybackDto {
    private String userId;
    private String subAccountId;
    private String subAccountUuid;
    private String parentAccountId;
    private String parentAccountUuid;
    private String externalBankAccount;
    private String friendlyName;
    private String legalName;
    private String amount;
    private String currency;

    private String externalId;
    private String requestId;
    private String description;
    private String submitTime;
    private long submitUnixTime;
    private String status;          // convert from receipt.status, 'C', or 'X' or 'P'
    private String finalStatusTime;
    private long finalStatusUnixTime;
    private String transactionId;   // upOperationId'
    private String vendorErrorCode;
    private String vendorErrorMessage;
    private String response;        // raw vendor response
    private String notifyClientStatus;

    // not in DB
    @Builder.Default
    private String accountIdType = "CLABE";     // 'clabe' or 'mdn'

    @Builder.Default
    private boolean force = false;
    private String mdn;
    private int isPrefab;
    private PaymentInfo paymentInfo;
}
