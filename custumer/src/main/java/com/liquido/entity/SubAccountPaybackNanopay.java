package com.liquido.entity;

import java.util.Date;

public class SubAccountPaybackNanopay {
    private Long id;

    private String userId;

    private String parentAccountUuid;

    private String parentAccountId;

    private String subAccountId;

    private String subAccountUuid;

    private String friendlyName;

    private String legalName;

    private String externalBankAccount;

    private String requestId;

    private String externalId;

    private String transactionId;

    private String referenceNumber;

    private String status;

    private String amount;

    private String currency;

    private String description;

    private Long submitUnixTime;

    private String submitTime;

    private String finalStatusTime;

    private Long finalStatusUnixTime;

    private String vendorErrorCode;

    private String vendorErrorMessage;

    private String response;

    private String notifyClientStatus;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private Integer flags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentAccountUuid() {
        return parentAccountUuid;
    }

    public void setParentAccountUuid(String parentAccountUuid) {
        this.parentAccountUuid = parentAccountUuid;
    }

    public String getParentAccountId() {
        return parentAccountId;
    }

    public void setParentAccountId(String parentAccountId) {
        this.parentAccountId = parentAccountId;
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getSubAccountUuid() {
        return subAccountUuid;
    }

    public void setSubAccountUuid(String subAccountUuid) {
        this.subAccountUuid = subAccountUuid;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getExternalBankAccount() {
        return externalBankAccount;
    }

    public void setExternalBankAccount(String externalBankAccount) {
        this.externalBankAccount = externalBankAccount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSubmitUnixTime() {
        return submitUnixTime;
    }

    public void setSubmitUnixTime(Long submitUnixTime) {
        this.submitUnixTime = submitUnixTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getFinalStatusTime() {
        return finalStatusTime;
    }

    public void setFinalStatusTime(String finalStatusTime) {
        this.finalStatusTime = finalStatusTime;
    }

    public Long getFinalStatusUnixTime() {
        return finalStatusUnixTime;
    }

    public void setFinalStatusUnixTime(Long finalStatusUnixTime) {
        this.finalStatusUnixTime = finalStatusUnixTime;
    }

    public String getVendorErrorCode() {
        return vendorErrorCode;
    }

    public void setVendorErrorCode(String vendorErrorCode) {
        this.vendorErrorCode = vendorErrorCode;
    }

    public String getVendorErrorMessage() {
        return vendorErrorMessage;
    }

    public void setVendorErrorMessage(String vendorErrorMessage) {
        this.vendorErrorMessage = vendorErrorMessage;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNotifyClientStatus() {
        return notifyClientStatus;
    }

    public void setNotifyClientStatus(String notifyClientStatus) {
        this.notifyClientStatus = notifyClientStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", parentAccountUuid=").append(parentAccountUuid);
        sb.append(", parentAccountId=").append(parentAccountId);
        sb.append(", subAccountId=").append(subAccountId);
        sb.append(", subAccountUuid=").append(subAccountUuid);
        sb.append(", friendlyName=").append(friendlyName);
        sb.append(", legalName=").append(legalName);
        sb.append(", externalBankAccount=").append(externalBankAccount);
        sb.append(", requestId=").append(requestId);
        sb.append(", externalId=").append(externalId);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", referenceNumber=").append(referenceNumber);
        sb.append(", status=").append(status);
        sb.append(", amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", description=").append(description);
        sb.append(", submitUnixTime=").append(submitUnixTime);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", finalStatusTime=").append(finalStatusTime);
        sb.append(", finalStatusUnixTime=").append(finalStatusUnixTime);
        sb.append(", vendorErrorCode=").append(vendorErrorCode);
        sb.append(", vendorErrorMessage=").append(vendorErrorMessage);
        sb.append(", response=").append(response);
        sb.append(", notifyClientStatus=").append(notifyClientStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", flags=").append(flags);
        sb.append("]");
        return sb.toString();
    }
}