package com.liquido.exceptions;


import com.liquido.enums.ResultCode;

abstract class BaseCheckedException extends Exception {
    private static final long serialVersionUID = 1L;

    private final ResultCode resultCode;

    BaseCheckedException(final ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    BaseCheckedException(final ResultCode resultCode, final String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return String.format("ResultCode: %s;\n Exception: %s", resultCode, super.toString());
    }
}
