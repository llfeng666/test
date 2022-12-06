package com.liquido.chain;


import com.liquido.chain.handlers.vo.Bs2ProcessData;

import lombok.Data;

@Data
public class TradeContext {

    private boolean failed;

    private String errorMsg;

    private String errorCode;

    private boolean isHandUp;

    private String nodeName;

    private Bs2ProcessData bs2ProcessData;

    private String e2eId;

    public TradeContext success(TradeContext response,String nodeName ){
        response.setFailed(true);
        response.setNodeName(nodeName);
              return response;

    }

    public TradeContext failed(TradeContext response,String nodeName ,String errorMsg){

        response.setFailed(true);
        response.setNodeName(nodeName);
        response.setErrorMsg(errorMsg);
        return  response;
    }


    public TradeContext setContext(TradeContext response,
                               boolean  failedFlag,
                               String nodeName ,String errorMsg,Bs2ProcessData bs2ProcessData){
        response.setFailed(failedFlag);
        response.setNodeName(nodeName);
        response.setErrorMsg(errorMsg);
        response.setBs2ProcessData(bs2ProcessData);
        return  response;
    }

}
