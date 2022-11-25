package com.liquido.converters;

import java.util.Optional;

import com.liquido.enums.Vendor;

public class EnumConvert {
    private static final String  UNIPAGOS = "64";

    private static final String  ARCUS = "70";


    public static Optional<Vendor> convertToVendor(final String type){
        if(UNIPAGOS.equals(type)){
            return Optional.of(Vendor.UNIPAGOS);
        }else  if(ARCUS.equals(type)){
            return Optional.of(Vendor.ARCUS);
        }
          return Optional.empty();
    }

}
