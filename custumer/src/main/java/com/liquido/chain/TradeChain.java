package com.liquido.chain;


public interface TradeChain <T,R>{


    R process(Chain<T, R> chain);


    interface Chain<T,R>{
        T request();

        R response();

        R process(T request, R response);
    }

}
