package com.liquido.exceptions;

import com.liquido.enums.ResultCode;

public class InternalServerException extends BaseException {
    private static final long serialVersionUID = 1L;

    public InternalServerException(final Throwable cause) {
        super(ResultCode.INTERNAL_ERROR, cause);
    }

    public InternalServerException(final String reason) {
        super(ResultCode.INTERNAL_ERROR, reason);
    }

    public InternalServerException(final String reason, final Throwable cause) {
        super(ResultCode.INTERNAL_ERROR, reason, cause);
    }
}
