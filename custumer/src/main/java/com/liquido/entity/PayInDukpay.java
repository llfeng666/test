package com.liquido.entity;

import java.util.Date;


public class PayInDukpay {

    private int id;

    private String endToEndId;

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    private String idempotencyKey;

    private String merchantName;

    private  String referenceId;

    private  String internalTransactionId;

    private String vendorTransactionId;

    private  String transferStatus;

    private String transactionType;

    private Date scheduledTime;

    private Date submitTime;

    private Date finalStatusTime;

    private int amount;

    private  String currency;

    private  String country;

    private  String paymentMethod;

    private  String paymentFlow;

    //json
    private String paymentInfo;

    //json
    private  String payer;

    private  String payerComment;

    private  String payeeComment;

    private String vendorStatusCode;

    private String vendorStatusMessage;

    private String transferStatusCode;

    private String transferErrorMsg;

    private String response;

    private  int version;

    private Date createTime;

    private  Date updateTime;

    private  String clientZoneId;

    private String rawClientRequest;

    private  String vendorName;

    private int flags;

    private  String settleVendor;

    private  String vendorTransferDetails;

    private  String callbackUrl;

    private Date settledTime;

    private int refundedAmount;

    //json
    private String riskData;

    //json
    private String orderInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getInternalTransactionId() {
        return internalTransactionId;
    }

    public void setInternalTransactionId(String internalTransactionId) {
        this.internalTransactionId = internalTransactionId;
    }

    public String getVendorTransactionId() {
        return vendorTransactionId;
    }

    public void setVendorTransactionId(String vendorTransactionId) {
        this.vendorTransactionId = vendorTransactionId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getFinalStatusTime() {
        return finalStatusTime;
    }

    public void setFinalStatusTime(Date finalStatusTime) {
        this.finalStatusTime = finalStatusTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentFlow() {
        return paymentFlow;
    }

    public void setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayerComment() {
        return payerComment;
    }

    public void setPayerComment(String payerComment) {
        this.payerComment = payerComment;
    }

    public String getPayeeComment() {
        return payeeComment;
    }

    public void setPayeeComment(String payeeComment) {
        this.payeeComment = payeeComment;
    }

    public String getVendorStatusCode() {
        return vendorStatusCode;
    }

    public void setVendorStatusCode(String vendorStatusCode) {
        this.vendorStatusCode = vendorStatusCode;
    }

    public String getVendorStatusMessage() {
        return vendorStatusMessage;
    }

    public void setVendorStatusMessage(String vendorStatusMessage) {
        this.vendorStatusMessage = vendorStatusMessage;
    }

    public String getTransferStatusCode() {
        return transferStatusCode;
    }

    public void setTransferStatusCode(String transferStatusCode) {
        this.transferStatusCode = transferStatusCode;
    }

    public String getTransferErrorMsg() {
        return transferErrorMsg;
    }

    public void setTransferErrorMsg(String transferErrorMsg) {
        this.transferErrorMsg = transferErrorMsg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public String getClientZoneId() {
        return clientZoneId;
    }

    public void setClientZoneId(String clientZoneId) {
        this.clientZoneId = clientZoneId;
    }

    public String getRawClientRequest() {
        return rawClientRequest;
    }

    public void setRawClientRequest(String rawClientRequest) {
        this.rawClientRequest = rawClientRequest;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getSettleVendor() {
        return settleVendor;
    }

    public void setSettleVendor(String settleVendor) {
        this.settleVendor = settleVendor;
    }

    public String getVendorTransferDetails() {
        return vendorTransferDetails;
    }

    public void setVendorTransferDetails(String vendorTransferDetails) {
        this.vendorTransferDetails = vendorTransferDetails;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Date getSettledTime() {
        return settledTime;
    }

    public void setSettledTime(Date settledTime) {
        this.settledTime = settledTime;
    }

    public int getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(int refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public String getRiskData() {
        return riskData;
    }

    public void setRiskData(String riskData) {
        this.riskData = riskData;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
