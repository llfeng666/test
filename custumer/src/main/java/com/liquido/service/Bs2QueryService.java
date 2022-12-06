package com.liquido.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.liquido.chain.handlers.vo.TradeTypeClassName;
import com.liquido.entity.CoQueryRequest;
import com.liquido.entity.PayInDukpay;
import com.liquido.entity.Proof;
import com.liquido.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.liquido.facade.bs2.model.Bs2GetEidStatusResponse;
import com.liquido.facade.bs2.model.Bs2QueryTransactionByVendorIdResponse;
import com.liquido.facade.bs2.model.Bs2TokenOauthResponse;
import com.liquido.mapper.PayInDukpayMapper;
import com.liquido.mapper.PayOutDukpayMapper;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
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



    public static Cache<String, String> tokenCache =
            CacheBuilder.newBuilder().maximumSize(5)
                    .expireAfterAccess(300, TimeUnit.SECONDS)
                    .concurrencyLevel(10)
                    .initialCapacity(2048)
                    .build();


    public String getToken(String token) {
        try {
            return tokenCache.get(token, () -> TradeTypeClassName.BEARER +getAccessToken());
        } catch (ExecutionException e) {
            log.error("缓存获取token失败");
        }

        return  "Bearer " + getAccessToken();
    }


    public Proof getPloofInfo(String idempotencyKey,String eId,String tableName){
        return  payOutDukpayMapper.queryPayOutInfo(CoQueryRequest.builder()
                        .idempotencyKey(idempotencyKey)
                        .eId(eId)
                        .tableName(tableName)
                .build());
    }



    public String getAccessToken(){
        //根据eid 去调 查询接口
        Bs2TokenOauthResponse bs2RefreshTokenOauthResponse  = bs2RefreshTokenOauthClient.authReq("");
        return bs2RefreshTokenOauthResponse.getAccessToken();
    }

    /**
     * 根据eid调 人家接口
     * @param eId
     * @return
     */
    public Bs2GetEidStatusResponse queryBs2Result(String eId){
        String accessToken = getToken(TradeTypeClassName.BS2TOKEN);
        return bs2RefreshTokenOauthClient.getEidStatus(eId,accessToken);
    }

    public Bs2QueryTransactionByVendorIdResponse queryTransactionResponseByVendorId(String vendorId){
        String  accessToken = getToken(TradeTypeClassName.BS2TOKEN);
        return bs2RefreshTokenOauthClient.queryBs2ByVendorId(vendorId,accessToken);
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
