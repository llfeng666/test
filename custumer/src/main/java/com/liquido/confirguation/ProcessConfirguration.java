package com.liquido.confirguation;


import java.util.List;

import com.liquido.chain.Bs2HanlderChain;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessConfirguration {
    @Autowired
    @Qualifier("bs2GetTokenHandler")
    private Bs2HanlderChain bs2GetTokenHandler;

    @Autowired
    @Qualifier("bs2VendorIdQueryHandler")
    private Bs2HanlderChain bs2VendorIdQueryHandler;

    @Autowired
    @Qualifier("bs2E2eIdQueryHandler")
    private Bs2HanlderChain bs2E2eIdQueryHandler;

    @Bean(name="bs2HandlerList")
    public List<Bs2HanlderChain> bs2HanlderChains(){
        return Lists.newArrayList(bs2VendorIdQueryHandler);
    }


}
