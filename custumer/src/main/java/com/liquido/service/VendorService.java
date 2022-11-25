package com.liquido.service;

import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;

public interface VendorService {

    BasicResultVO handle(NanoPayRequest nanoPayRequest);

    Vendor vendorName();

}
