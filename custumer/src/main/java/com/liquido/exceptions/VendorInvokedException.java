package com.liquido.exceptions;

import com.liquido.enums.ResultCode;

public class VendorInvokedException extends BaseException {
    private static final long serialVersionUID = 1L;

    private String vendorErrorCode;

    private String vendorErrorMsg;

    public VendorInvokedException(final ResultCode resultCode) {
        super(resultCode);
    }

    public VendorInvokedException(final Throwable cause) {
        super(cause);
    }

    public VendorInvokedException(final ResultCode code, final String reason) {
        super(code, reason);
    }

    public VendorInvokedException(final ResultCode code, final Throwable e) {
        super(code, e);
    }

    public VendorInvokedException(
            final ResultCode resultCode,
            final String code,
            final String msg
    ) {
        super(resultCode);
        this.vendorErrorCode = code;
        this.vendorErrorMsg = msg;
    }

    public String getVendorErrorCode() {
        return vendorErrorCode;
    }

    public String getVendorErrorMsg() {
        return vendorErrorMsg;
    }
}
