package com.liquido.mapper;

import com.liquido.constant.DBConstants;
import com.liquido.entity.CoQueryRequest;
import com.liquido.entity.Proof;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_LIQUIDO_TRANSFER)
public interface PayOutDukpayMapper {

    Proof queryPayOutInfo( CoQueryRequest coQueryRequest);
}
