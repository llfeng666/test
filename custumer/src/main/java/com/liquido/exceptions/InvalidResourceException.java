package com.liquido.exceptions;

import com.liquido.enums.ResultCode;

/**
 * This is intended for invalid format exception.
 * e.g. phone, email, document, name, etc
 *
 * Suggested reason phrase:
 * 1. Invalid Phone Number.
 * 2. Phone number is invalid.
 *
 */
public class InvalidResourceException extends BaseException {
    private static final long serialVersionUID = 1L;

    //    public InvalidResourceException(final ResultCode resultCode, final String resource) {
    //        super(resultCode, String.format("Invalid %s.", resource));
    //    }

    public InvalidResourceException(final ResultCode resultCode, final String reason) {
        super(resultCode, reason);
    }

    public InvalidResourceException(final ResultCode resultCode,
                                    final String reason,
                                    final Throwable e) {
        super(resultCode, reason, e);
    }
}
