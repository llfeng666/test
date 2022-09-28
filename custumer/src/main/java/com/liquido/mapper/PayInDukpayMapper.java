package com.liquido.mapper;

import com.liquido.constant.DBConstants;
import com.liquido.entity.CoQueryRequest;
import com.liquido.entity.PayInDukpay;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_VIRGO)
public interface PayInDukpayMapper {

    PayInDukpay selectByIdKey(CoQueryRequest coQueryRequest);


    PayInDukpay selectByEId(CoQueryRequest coQueryRequest);

    PayInDukpay selectByVendorId(CoQueryRequest coQueryRequest);
}
