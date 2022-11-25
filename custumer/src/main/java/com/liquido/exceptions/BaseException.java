package com.liquido.exceptions;

import com.liquido.enums.ResultCode;
import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final ResultCode resultCode;

    public BaseException(final ResultCode resultCode, final Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public BaseException(final ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BaseException(final Throwable cause) {
        super(cause);
        this.resultCode = ResultCode.INTERNAL_ERROR;
    }

    public BaseException(final String reason, final Throwable e) {
        super(reason, e);
        this.resultCode = ResultCode.INTERNAL_ERROR;
    }

    public BaseException(final ResultCode resultCode, final String reason, final Throwable cause) {
        super(reason, cause);
        this.resultCode = resultCode;
    }

    public BaseException(final ResultCode resultCode, final String reason) {
        super(reason);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return String.format("ResultCode: %s;\n Exception: %s", resultCode, super.toString());
    }
}
