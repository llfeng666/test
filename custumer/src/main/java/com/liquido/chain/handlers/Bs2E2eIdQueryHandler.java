package com.liquido.chain.handlers;

import com.liquido.chain.Bs2HanlderChain;
import com.liquido.chain.Bs2ProcessRequest;
import com.liquido.chain.TradeContext;
import com.liquido.chain.handlers.vo.Bs2ProcessData;
import com.liquido.chain.handlers.vo.TradeTypeClassName;
import com.liquido.facade.bs2.model.Bs2GetEidStatusResponse;
import com.liquido.service.Bs2QueryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 根据e2eId 查证bs2
 */
@Slf4j
@Component("bs2E2eIdQueryHandler")
public class Bs2E2eIdQueryHandler implements Bs2HanlderChain {

    @Autowired
    private Bs2QueryService bs2QueryService;

    @Override
    public TradeContext process(Chain<Bs2ProcessRequest, TradeContext> chain) {
        TradeContext response = chain.response();
        final Bs2ProcessRequest request = chain.request();
        Bs2ProcessData bs2ProcessData = response.getBs2ProcessData();
        boolean failedFlag = false;
        String errorMsg = "";
        try {
            final Bs2GetEidStatusResponse bs2GetEidStatusResponse =
                    bs2QueryService.queryBs2Result(request.getE2eId());
            bs2ProcessData.setBs2GetEidStatusResponse(bs2GetEidStatusResponse);
        } catch (Exception e) {
            errorMsg = e.getMessage();
            failedFlag = true;
        }

        return response.setContext(response,failedFlag,
                TradeTypeClassName.bs2E2eIdQueryHandler.name(),
                errorMsg,
                bs2ProcessData
                );
    }

}
