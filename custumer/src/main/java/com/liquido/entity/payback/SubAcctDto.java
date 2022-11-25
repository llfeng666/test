package com.liquido.entity.payback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("PMD.TooManyFields")
public class SubAcctDto {
    private String accountUuid;
    private String accountId;
    private String parentAccountUuid;
    private String parentAccountId;
    private String friendlyName;
    private String legalName;
    private String externalBankAccount;
    private String extraData;
    private String idempotencyKey;
    private String userId;
    private String balance;
    private String currency;
    private String mdn;
    private String phoneNumber;
    private int isPrefab;
    private String isOpen;
    private String response;
    private String request;
}
