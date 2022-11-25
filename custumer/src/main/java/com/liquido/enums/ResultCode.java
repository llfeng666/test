package com.liquido.enums;

// For code larger than 505, are internal code
public enum ResultCode {
    INTERNAL_ERROR(500, "Server internal error"),
    SUCCESS(200, ""),
    INVALID_REQUEST(400, "Invalid request"),
    CREDENTIALS_LOCKED(402, "The client account is locked."),
    AUTHENTICATION_FAILED(403, "The client failed to authorize with vendor"),
    NOT_FOUND(404, "The requested resource is not found."),
    BANK_NAME_NOT_FOUND(423, "The target bank name was not found."),
    BANK_CODE_NOT_FOUND(424, "The target bank code was not found."),
    BANK_BRANCH_NOT_FOUND(425, "The target bank branch was not found."),
    BENEFICIARY_DOCUMENT_INVALID(
            426, "The target beneficiary document is invalid, such as wrong CPF."),
    BENEFICIARY_NAME_MISMATCH(
            427, "The target beneficiary name doesn't match the target account holder's name."),
    ACCOUNT_NOT_FOUND(428, "The target account was not found."),
    ACCOUNT_INVALID(429, "The target account is invalid, mostly due to wrong format."),
    ACCOUNT_LOCKED(430, "The target account is locked, couldn't be used now."),
    PIX_KEY_INVALID(431, "The PIX Key provided is invalid."),
    PAYER_DOCUMENT_INVALID(432, "The payer document is invalid."),
    PAYMENT_REQUEST_NOT_FOUND(441, "The transaction Id is invalid."),
    TRANSACTION_ALREADY_EXISTS(442, "The idempotency key provided is used before."),
    TRANSACTION_PENDING(443, "This transaction is pending for manually review."),
    RESOURCE_DUPLICATED(444, "The resource already exists."),
    INVALID_PHONE_NUMBER(445, "The phone number is invalid."),
    INVALID_CARD_NUMBER(446, "The card number is invalid."),
    INVALID_DOCUMENT(447, "The document is invalid."),
    INVALID_USER_ID(448, "The user id is invalid."),
    MISSING_USER_INFO(449, "The user information is missing."),
    INSUFFICIENT_FUNDS(450, "The source account is out of balance."),
    EACH_PAYMENT_LIMIT_EXCEEDED(451, "The payment amount is reached the payment limit."),
    DAILY_PAYMENT_LIMIT_EXCEEDED(
            452, "The total daily payment amount is reached the daily payment limit."),
    MONTHLY_PAYMENT_LIMIT_EXCEEDED(
            453, "The total monthly payment amount is reached the daily payment limit."),
    YEARLY_PAYMENT_LIMIT_EXCEEDED(
            454, "The total yearly payment amount is reached the daily payment limit."),
    AMOUNT_TOO_SMALL(455, "The payment amount is too small to be accepted."),
    AMOUNT_LIMIT_EXCEEDED(456, "The payment amount exceeds payee's transaction limit"),
    GATEWAY_TIMEOUT(460, "The payment gateway connection time out."),
    GATEWAY_ERROR(461, "The payment gateway had a problem."),
    PAYMENT_OPERATION_TIMEOUT(462, "The payment operation had a time out issue."),
    PAYMENT_OPERATION_CANCELLED(463, "The payment transaction was cancelled."),
    PAYMENT_REJECTED_BY_BANK(464, "The payment transaction was rejected by bank."),
    ACCOUNTING_BILL_DAY_INVALID(470, "The date is invalid."),
    ACCOUNTING_BILL_NOT_COME_OUT(
            471, "The bill according to date has not come out, please retry later."),
    BALANCE_UNAVAILABLE(472, "balance is unavailable now, please retry later."),
    INVALID_SKU(480, "The SKU provided is invalid and was not found in the system"),
    INVALID_TOPUP_PHONE_NUMBER(481, "Carrier does not support the phone number"),
    INVALID_UTILITY_REFERENCE_NUMBER(482, "Carrier does not support the reference number"),
    INVALID_AMOUNT(483, "The payment amount does not match the corresponding reference number"),

    INVALID_WHATSAPP_ID(601, "This phone number does not have an associated whatsapp account."),
    USER_OPTED_OUT(602, "This user has opted out of our messaging service."),
    MESSAGE_LIMIT_EXCEEDED(650, "Message limit reached."),
    REQUEST_TOO_FREQUENT(651, "Processing message request with same user, please try later"),

    VENDOR_REJECT_NEED_FAILOVER(1001, "An error happened but can failover"),
    ACCOUNT_TYPE_MISMATCH(1002, "The payment is rejected because account type not correct"),
    VENDOR_OUTAGE(1003, "The vendor is in short outage"),
    RECEIPIENT_PSP_OUTAGE(1004, "The target bank is in outage"),
    RISK_ANALYSIS_FAILED(1005, "The transaction failed risk analysis"),
    GIFT_CARD_OUT_OF_STOCK(1010, "The GiftCard is out of stock at this moment");

    private final int code;
    private final String message;

    ResultCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCode fromCode(final int code) {
        for (final var type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return ResultCode.INTERNAL_ERROR;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
