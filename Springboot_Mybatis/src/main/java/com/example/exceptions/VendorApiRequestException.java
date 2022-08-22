package com.example.exceptions;

import com.example.enums.ResultCode;
import com.example.enums.Vendor;

public abstract class VendorApiRequestException extends BaseException {
    private static final long serialVersionUID = 1L;

    private Vendor vendor;

    public VendorApiRequestException(final Throwable e) {
        super(e);
    }

    public VendorApiRequestException(final String reason) {
        super(ResultCode.INTERNAL_ERROR, reason);
    }

    public VendorApiRequestException(final String reason, final Throwable e) {
        super(reason, e);
    }

    public VendorApiRequestException(final Vendor vendor, final Throwable e) {
        super(e);
        this.vendor = vendor;
    }

    public VendorApiRequestException(final Vendor vendor, final String reason) {
        super(ResultCode.INTERNAL_ERROR, reason);
        this.vendor = vendor;
    }

    public VendorApiRequestException(final Vendor vendor, final String reason, final Throwable e) {
        super(reason, e);
        this.vendor = vendor;
    }

    public Vendor getVendor() {
        return vendor;
    }
}
