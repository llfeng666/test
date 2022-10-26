package com.liquido.service.impl;

import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;
import com.liquido.service.VendorService;

public class AcursServiceImpl implements VendorService {
    @Override
    public BasicResultVO handle(NanoPayRequest nanoPayRequest) {
        return null;
    }

    @Override
    public Vendor vendorName() {
        return Vendor.ARCUS;
    }
}
