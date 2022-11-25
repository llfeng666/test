package com.liquido.exceptions;


import com.liquido.enums.ResultCode;

public class ClientRequestException extends BaseCheckedException {
    private static final long serialVersionUID = 1L;

    private final String details;

    public ClientRequestException(final String details) {
        super(ResultCode.INVALID_REQUEST, details);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return String.format(
                "ClientRequestException with details: %s. Parent exception is: %s",
                getDetails(),
                super.toString()
        );
    }
}
