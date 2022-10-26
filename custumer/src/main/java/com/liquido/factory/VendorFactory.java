package com.liquido.factory;

import java.util.List;
import java.util.stream.Collectors;

import com.liquido.enums.Vendor;
import com.liquido.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendorFactory {

    @Autowired
    private List<VendorService> vendorServices;

    public VendorService getVendorService(final Vendor vendor) {
        return vendorServices.stream()
                .collect(Collectors.toMap(VendorService::vendorName,
                        payProcessor -> payProcessor)).get(vendor);
    }


}
