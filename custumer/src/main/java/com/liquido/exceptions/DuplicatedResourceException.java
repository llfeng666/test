package com.liquido.exceptions;

import com.liquido.enums.ResultCode;

/**
 * This is intended for scenarios that a resource already exists.
 * e.g. phone, email, document, user, transaction, etc
 *
 * Suggested reason phrase:
 * 1. User already exists.
 * 2. Duplicated transaction found.
 *
 */
public class DuplicatedResourceException extends BaseException {
    private static final long serialVersionUID = 1L;

    public DuplicatedResourceException() {
        super(ResultCode.RESOURCE_DUPLICATED);
    }

    public DuplicatedResourceException(final String reason) {
        super(ResultCode.RESOURCE_DUPLICATED, reason);
    }

    public DuplicatedResourceException(final ResultCode resultCode, final String reason) {
        super(resultCode, reason);
    }

    public DuplicatedResourceException(final ResultCode resultCode,
                                       final String reason,
                                       final Throwable e) {
        super(resultCode, reason, e);
    }
}
