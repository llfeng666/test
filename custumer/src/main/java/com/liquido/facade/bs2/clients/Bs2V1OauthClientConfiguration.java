package com.liquido.facade.bs2.clients;

import com.liquido.facade.bs2.Bs2CommonConfigs;
import com.liquido.facade.bs2.LiquidoCommonConfigs;
import com.liquido.facade.liquido.NanopayConfigs;

import org.springframework.context.annotation.Import;

@Import({
        NanopayConfigs.class,
        Bs2CommonConfigs.class,
        LiquidoCommonConfigs.class
})
public class Bs2V1OauthClientConfiguration {
}
