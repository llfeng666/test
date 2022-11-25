package com.liquido.exceptions;

import com.liquido.enums.ResultCode;

public class MerchantWebhookException extends BaseException {
    private static final long serialVersionUID = 1L;

    public MerchantWebhookException(final String reason, final Throwable e) {
        super(ResultCode.GATEWAY_ERROR, "Merchant webhook connection threw exception", e);
    }
}
