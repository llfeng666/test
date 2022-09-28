package com.liquido.facade.bs2;

import com.liquido.enums.Vendor;
import com.liquido.exceptions.VendorApiRequestException;

public class Bs2RequestException extends VendorApiRequestException {
    private static final long serialVersionUID = 1L;

    public Bs2RequestException(final Throwable e) {
        super(Vendor.BS2, e);
    }

    public Bs2RequestException(final String reason) {
        super(Vendor.BS2, reason);
    }

    public Bs2RequestException(final String reason, final Throwable e) {
        super(Vendor.BS2, reason, e);
    }
}
