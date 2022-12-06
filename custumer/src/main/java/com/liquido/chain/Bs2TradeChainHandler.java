package com.liquido.chain;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bs2TradeChainHandler implements TradeChain.Chain<Bs2ProcessRequest,TradeContext>{
    private final int index;

    private final Bs2ProcessRequest request;

    private TradeContext response;

    private List<Bs2HanlderChain> handlers;

    public Bs2TradeChainHandler(List<Bs2HanlderChain> handlers,int index,Bs2ProcessRequest request,TradeContext response) {
        this.handlers=handlers;
        this.index = index;
        this.request=request;
        this.response= response;
    }

    @Override
    public Bs2ProcessRequest request() {
        return request;
    }

    @Override
    public TradeContext response() {
        return response;
    }

    @Override
    public TradeContext process(Bs2ProcessRequest request, TradeContext response) {
        if(index>=handlers.size()){
            return response;
        }
        TradeChain.Chain<Bs2ProcessRequest,TradeContext> next = new Bs2TradeChainHandler(handlers,index+1,request,response);
        Bs2HanlderChain handle = handlers.get(index);
        log.info("当前处理类：{}"+handle.getClass().getName(),index);
        if(response.isHandUp()){
            return response;
        }
        if(response.isFailed()){
            return response;
        }
        response =  handle.process(next);

        log.info("当前handle处理response{}", JSONObject.toJSON(response));

        return response;
    }


}
