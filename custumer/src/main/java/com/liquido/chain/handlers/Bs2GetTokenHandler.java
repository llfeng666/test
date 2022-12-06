package com.liquido.chain.handlers;

import com.liquido.chain.Bs2HanlderChain;
import com.liquido.chain.Bs2ProcessRequest;
import com.liquido.chain.TradeContext;
import com.liquido.chain.handlers.vo.Bs2ProcessData;
import com.liquido.chain.handlers.vo.TradeTypeClassName;
import com.liquido.service.Bs2QueryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 考虑加缓存
 */
@Slf4j
@Component("bs2GetTokenHandler")
public class Bs2GetTokenHandler implements Bs2HanlderChain {

    @Autowired
    private Bs2QueryService bs2QueryService;

    @Override
    public TradeContext process(Chain<Bs2ProcessRequest, TradeContext> chain) {
        TradeContext response = chain.response();
        Bs2ProcessData bs2ProcessData = response.getBs2ProcessData();
        boolean failedFlag = false;
        String errorMsg = "";
        try {
            String accessToken = bs2QueryService.getToken(TradeTypeClassName.BS2TOKEN);
            bs2ProcessData.setToken( accessToken);
        } catch (Exception e) {
            errorMsg = e.getMessage();
            failedFlag = true;
        }

        return response.setContext(response,failedFlag,
                TradeTypeClassName.bs2TokenHandler.name(),
                errorMsg,
                bs2ProcessData
                );
    }

}
