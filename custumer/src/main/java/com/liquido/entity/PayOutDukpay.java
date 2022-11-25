package com.liquido.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PayOutDukpay {

        private int    id;
        private String    idempotencyKey;
        private String    originalIdemKey;
        private String    transactionId;
        private String    status;
        private String    amount;
        private String    foreignAmount;
        private String    exchangeRate;
        private String    transactionFee;
        private String    balance;
        private String    currency;
        private String    submitTime;
        private Timestamp    createTime;
        private Timestamp updateTime;
        private String    paymentType;
        private String    payerComment;
        private String    payeeComment;
        private String    country;
        private String    userId;
        private String    bankName;
        private String    bankCode;
        private String    bankId;
        private String    branchId;
        private String    targetAccountId;
        private String    pixKey;
        private String    pixKeyType;
        private String    targetName;
        private String    targetLastName;
        private String    targetEmail;
        private String    targetDocumentId;
        private String    targetDocumentType;
        private String    targetBirthDate;
        private String    targetPhone;
        private String    scheduleDate;
        private int    submitUnixTime;
        private String    finalStatusTime;
        private int    finalStatusUnixTime;
        private String    vendorCreateTime;
        private String    vendorErrorCode;
        private String    vendorErrorMessage;
        private int    transferStatusCode;
        private String    transferErrorMsg;
        private int    flags;
        private String    response;
        private String    reserve;
        private int    version;
        private int    needRetry;
        private String    rawClientRequest;
        private String    vendorName;
        private String    targetBankAccountType;
        private String    settleVendor;
        private String    pixEndToEndId;
        private String    rejectedByVendors;
        private int    retryCount;
        private String    fullNameFromPixKey;
        private String    docIdFromPixKey;
        private Long    amountInCents;
        private String    paymentInfo;
        private String    paymentAmount;





}
