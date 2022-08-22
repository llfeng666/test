package com.example.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.PayInDukpay;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_VIRGO)
public interface PayInDukpayMapper {

    PayInDukpay selectByIdKey(String idempotencyKey);


    PayInDukpay selectByEId(String eId);

}
