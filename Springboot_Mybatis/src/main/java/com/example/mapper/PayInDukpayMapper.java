package com.example.mapper;

import com.example.entity.PayInDukpay;
import org.springframework.stereotype.Repository;

@Repository
public interface PayInDukpayMapper {

    PayInDukpay selectByIdKey(String idempotencyKey);


    PayInDukpay selectByEId(String eId);

}
