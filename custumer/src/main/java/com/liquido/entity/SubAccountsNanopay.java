package com.liquido.entity;

import java.util.Date;

public class SubAccountsNanopay {
    private Long id;

    private String parentId;

    private String friendlyName;

    private String legalName;

    private String externalBankAccount;

    private String subAccountUuid;

    private String extraData;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private String accountId;

    private String userId;

    private String idempotencyKey;

    private String mdn;

    private Boolean isPrefab;

    private String parentClabeId;

    private String phoneNumber;

    private String isOpen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getSubAccountUuid() {
        return subAccountUuid;
    }

    public void setSubAccountUuid(String subAccountUuid) {
        this.subAccountUuid = subAccountUuid;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    public Boolean getIsPrefab() {
        return isPrefab;
    }

    public void setIsPrefab(Boolean isPrefab) {
        this.isPrefab = isPrefab;
    }

    public String getParentClabeId() {
        return parentClabeId;
    }

    public void setParentClabeId(String parentClabeId) {
        this.parentClabeId = parentClabeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", friendlyName=").append(friendlyName);
        sb.append(", legalName=").append(legalName);
        sb.append(", externalBankAccount=").append(externalBankAccount);
        sb.append(", subAccountUuid=").append(subAccountUuid);
        sb.append(", extraData=").append(extraData);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", accountId=").append(accountId);
        sb.append(", userId=").append(userId);
        sb.append(", idempotencyKey=").append(idempotencyKey);
        sb.append(", mdn=").append(mdn);
        sb.append(", isPrefab=").append(isPrefab);
        sb.append(", parentClabeId=").append(parentClabeId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", isOpen=").append(isOpen);
        sb.append("]");
        return sb.toString();
    }
}