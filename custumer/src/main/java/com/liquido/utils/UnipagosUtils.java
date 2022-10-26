package com.liquido.utils;

import java.util.Random;
import java.util.UUID;

import com.liquido.enums.ResultCode;
import com.liquido.enums.models.UnipagosPaymentStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class UnipagosUtils {

    private UnipagosUtils() {
        throw new UtilityClassException();
    }

    // See all result code definition in UnipagosResultCode.java
    public static ResultCode convertVendorResult(final String resultCode, final String message) {
        switch (resultCode) {
            case "000":
                return ResultCode.SUCCESS;
            case "001": // INVALID_PARAM
            case "407": // La cuenta {xxxxxxxxxx} no existe  (account)
                if (message.contains("RECIPIENT BANK")) {
                    // "_message":"THE \"RECIPIENT BANK\" IS CURRENTLY DISABLED AT UNIPAGOS.
                    // BANK ID=<40137>"
                    return ResultCode.BANK_NAME_NOT_FOUND;
                }
                if (message.contains("The CLABE account")) {
                    // "_message":"Reason: An invalid parameter was specified. Detail:
                    // * The CLABE account [recipientClabeNumber=659802019000096492] is not valid
                    return ResultCode.ACCOUNT_INVALID;
                }
                if (message.contains("The amount")) {
                    // "_message":"Reason: An invalid parameter was specified. Detail:  * The amount
                    return ResultCode.EACH_PAYMENT_LIMIT_EXCEEDED;
                }
                if (message.contains("The Name")) {
                    // "_message":"Reason: An invalid parameter was specified. Detail:
                    // * The Name of the account''s owner
                    return ResultCode.BENEFICIARY_NAME_MISMATCH;
                } else {
                    // use ACCOUNT_NOT_FOUND as default
                    return ResultCode.ACCOUNT_NOT_FOUND;
                }
            case "014": // INSUFFICIENT_FUNDS
                return ResultCode.INSUFFICIENT_FUNDS;
            case "102": // RECORD_NOT_FOUND, no trans found in Unipagos,
                // internally we say "transaction is pending for manually review"
                return ResultCode.TRANSACTION_PENDING;
            case "103":
                return ResultCode.TRANSACTION_ALREADY_EXISTS;
            case "400": // STP_SERVICE_NOT_AVAILABLE
            case "401": // STP_INVALID_DETAIL
            case "402": // STP_DUPLICATED_TRACKING_CODE
            case "403": // STP_INVALID_SIGNATURE
            case "404": // STP_INVALID_CERTIFICATE
            case "405": // STP_ERROR_DURING_SEND
            case "406": // STP_PRIVATE_KEY_NOT_FOUND
            case "408": // STP_INVALID_SIGNATURE
            case "414": // STP_INVALID_CHARACTERS
            case "415": // STP_MANDATORY_DATA_MISSING
            case "416": // STP_PAYMENT_NOT_RE
            case "417": // STP_INVALID_PAYMENT_TYPE
            case "420": // STP_UNKNOWN
                return ResultCode.GATEWAY_ERROR;  // this will worth retry
            case "409": // STP_NONEXISTENT_ACCOUNT
            case "410": // STP_ACCOUNT_BLOCKED
            case "411": // STP_ACCOUNT_CANCELED
            case "412": // STP_INVALID_TYPE_ACCOUNT
            case "413": // STP_INVALID_INSTITUTION
                return ResultCode.ACCOUNT_NOT_FOUND;
            default:
                // treat all default as timeout
                return ResultCode.PAYMENT_OPERATION_TIMEOUT;
        }
    }

    // TODO use Enum or utility class
    public static UnipagosPaymentStatus mapUnipagosStatus(final String status) {
        switch (status) {
            case "SETTLED":
                return UnipagosPaymentStatus.SETTLED;
            case "UP_REJECTED":
            case "GW_REJECTED":
            case "REFUNDED":
                return UnipagosPaymentStatus.REJECTED;
            case "RECEIVED":
            case "AUTH_PENDING":
            case "AUTHORIZED":
                return UnipagosPaymentStatus.IN_PROGRESS;
            default:
                log.error("Unknown transaction status from Unipagos, status={}", status);
                return UnipagosPaymentStatus.IN_PROGRESS; // pending is our best option
        }
    }

    // Receipt.status
    //  The "status" of the receipt will initially be in the "P" (pending) state.
    //  When it is sent, the status
    //  will change to either "C" (completed) or "X" (canceled).
    //  SPEI will cancel a transaction if the
    //  destination account does not exist or if the destination bank rejects it for any reason.
    //
    // Note: txStatus can be more precise than the status:
    // {
    //    "_resultType": "SUCCESS",
    //    "_resultCode": "000",
    //    "_resultDesc": "Operation successful",
    //    "_message": "Operation successful",
    //    "creationTime": "2021-05-08 08:03:58 UTC",
    //    "modificationTime": "2021-05-08 08:03:58 UTC",
    //    "status": "AUTHORIZED",
    //    "transactionId": "50b4c85d-02d3-4671-9efa-43d29106b561",
    //    "txStatus": "X",
    //    "txStatusTime": "2021-05-11 09:00:01.610127+00",
    //    "upOperationId": "20210508-030358-077-0263-6014"
    // }
    public static UnipagosPaymentStatus convertReceiptStatus(final String status) {
        switch (status) {
            case "C": // completed
                return UnipagosPaymentStatus.SETTLED;
            case "X": // cancelled
            case "R":
                return UnipagosPaymentStatus.REJECTED;
            case "P":
            default:
                return UnipagosPaymentStatus.IN_PROGRESS;
        }
    }

    public static String generateReferenceNumber(final LqDateUtils lqDateUtils) {
        final long unixTimeStamp = lqDateUtils.now().getEpochSecond();
        final String strUnixTimeStamp = Long.toString(unixTimeStamp);
        final Random random = new Random();
        final int randomValue = 1 + random.nextInt(99);
        final String randomString = String.format("%02d", randomValue);
        return strUnixTimeStamp.substring(strUnixTimeStamp.length() - 5) + randomString;
    }

    public static String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // Unipagos does a MDN mapping on their side,
    // mds 52991225(0)xxx is matched to 52991225(1)xxx, for example:
    //  529912250011
    //  529912251011
    public static boolean checkMdnEquality(final String mdnInLiquido, final String mdnInReceipt) {
        log.info("mdnInLiquido={}, mdnInReceipt={}", mdnInLiquido, mdnInReceipt);

        if (mdnInLiquido.length() != mdnInReceipt.length()) {
            return false;
        }

        if (mdnInLiquido.equals(mdnInReceipt)) {
            return true;
        }

        final int length = mdnInLiquido.length();
        return mdnInLiquido.substring(0, 8).equals(mdnInReceipt.substring(0, 8))
                // check prefix
                && mdnInLiquido.substring(length - 3)
                .equals(mdnInReceipt.substring(length - 3));  // check suffix
    }
}
