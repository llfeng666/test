package com.liquido.chain.handlers.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeTypeClassName {

    bs2TokenHandler,
    bs2E2eIdQueryHandler
    ;

    public final static String BS2TOKEN = "bs2_token";

    public final static String BEARER = "Bearer ";
}



