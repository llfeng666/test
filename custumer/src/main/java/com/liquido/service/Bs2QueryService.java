package com.liquido.service;

import com.liquido.entity.CoQueryRequest;
import com.liquido.entity.PayInDukpay;
import com.liquido.entity.Proof;
import com.liquido.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.liquido.facade.bs2.model.Bs2GetEidStatusResponse;
import com.liquido.facade.bs2.model.Bs2TokenOauthResponse;
import com.liquido.mapper.PayInDukpayMapper;
import com.liquido.mapper.PayOutDukpayMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Bs2QueryService {

    @Autowired
    private  PayInDukpayMapper payInDukpayMapper;

    @Autowired
    private PayOutDukpayMapper payOutDukpayMapper;

    @Autowired
    Bs2RefreshTokenOauthClient bs2RefreshTokenOauthClient;


    public Proof getPloofInfo(String idempotencyKey,String eId,String tableName){
        return  payOutDukpayMapper.queryPayOutInfo(CoQueryRequest.builder()
                        .idempotencyKey(idempotencyKey)
                        .eId(eId)
                        .tableName(tableName)
                .build());
    }



    public String getAccessToken(String eId){
        //根据eid 去调 查询接口
        Bs2TokenOauthResponse bs2RefreshTokenOauthResponse  = bs2RefreshTokenOauthClient.authReq(eId);
        return bs2RefreshTokenOauthResponse.getAccessToken();
    }

    /**
     * 根据eid调 人家接口
     * @param eId
     * @return
     */
    public Bs2GetEidStatusResponse queryBs2Result(String eId,String accessToken){
        //组装token
        String invalidStr = "Bearer " +accessToken;
        return bs2RefreshTokenOauthClient.getEidStatus(eId,invalidStr);
    }

    public PayInDukpay queryPayInDukpayById(String idempotencyKey,String tableName) {

        return  payInDukpayMapper.selectByIdKey(CoQueryRequest.builder().idempotencyKey(idempotencyKey).tableName(tableName).build());
    }

    public PayInDukpay queryPayInDukpayByEId(String eId,String tableName) {
        return  payInDukpayMapper.selectByEId(CoQueryRequest.builder().eId(eId).tableName(tableName).build());
    }

    public PayInDukpay queryPayInDukpayByVendorId(String vendorId,String tableName) {
        return  payInDukpayMapper.selectByVendorId(CoQueryRequest.builder().tableName(tableName).vendorId(vendorId).build());
    }


}
