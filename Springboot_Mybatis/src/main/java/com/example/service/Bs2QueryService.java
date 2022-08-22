package com.example.service;

import com.example.entity.PayInDukpay;
import com.example.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.example.facade.bs2.model.Bs2GetEidStatusResponse;
import com.example.facade.bs2.model.Bs2TokenOauthResponse;
import com.example.mapper.PayInDukpayMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Bs2QueryService {

    @Autowired
    private  PayInDukpayMapper payInDukpayMapper;

    @Autowired
    Bs2RefreshTokenOauthClient bs2RefreshTokenOauthClient;
    /**
     * 根据eid调 人家接口
     * @param eId
     * @return
     */
    public Bs2GetEidStatusResponse queryBs2Result(String eId){
        Bs2TokenOauthResponse bs2RefreshTokenOauthResponse  = bs2RefreshTokenOauthClient.authReq(eId);

        //根据eid 去调 查询接口
        String accessToken = bs2RefreshTokenOauthResponse.getAccessToken();
        //组装token
        String invalidStr = "Bearer " +accessToken;
        return bs2RefreshTokenOauthClient.getEidStatus(eId,invalidStr);
    }

    public PayInDukpay queryPayInDukpayById(String idempotencyKey) {
        return  payInDukpayMapper.selectByIdKey(idempotencyKey);
    }

    public PayInDukpay queryPayInDukpayByEId(String eId) {
        return  payInDukpayMapper.selectByEId(eId);
    }


}
