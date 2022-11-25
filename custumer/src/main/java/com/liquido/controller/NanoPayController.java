package com.liquido.controller;

import com.liquido.converters.EnumConvert;
import com.liquido.entity.NanoPayRequest;
import com.liquido.entity.vo.BasicResultVO;
import com.liquido.enums.Vendor;
import com.liquido.exceptions.InternalServerException;
import com.liquido.factory.VendorFactory;
import com.liquido.service.VendorService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payin")
public class NanoPayController {

    @Autowired
    private VendorFactory vendorFactory;

    @PostMapping("/nanoPay")
    public BasicResultVO nanoPay(@RequestBody NanoPayRequest request)
            throws Exception {
        String topTwo = request.getAccountId().substring(0, 2);
        Vendor vendor = EnumConvert.convertToVendor(topTwo)
                .orElseThrow(() -> new InternalServerException("输入的账号 处理不了"));
        VendorService vendorService = vendorFactory.getVendorService(vendor);
        return vendorService.handle(request);
    }




}
