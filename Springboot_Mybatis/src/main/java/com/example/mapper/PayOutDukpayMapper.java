package com.example.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.CoQueryRequest;
import com.example.entity.PayOutDukpay;
import com.example.entity.Proof;
import com.example.entity.WorkItem;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_LIQUIDO_TRANSFER)
public interface PayOutDukpayMapper {

    Proof queryPayOutInfo( CoQueryRequest coQueryRequest);
}
