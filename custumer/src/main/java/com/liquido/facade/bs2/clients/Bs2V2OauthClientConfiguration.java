package com.liquido.facade.bs2.clients;

import com.liquido.facade.bs2.Bs2CommonConfigs;
import com.liquido.facade.bs2.Bs2V2OauthAccessTokenProvider;
import com.liquido.facade.bs2.LiquidoCommonConfigs;
import com.liquido.facade.liquido.LiquidoClient;
import com.liquido.facade.liquido.LiquidoYamlConfig;
import com.liquido.facade.unipagos.UnipagosClient;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        LiquidoYamlConfig.class,
        UnipagosClient.class,
        Bs2RefreshTokenOauthClient.class,
        Bs2CommonConfigs.class,
        LiquidoCommonConfigs.class,
        LiquidoClient.class,
        UnipagosClient.class,
        Bs2V2OauthAccessTokenProvider.class,
})
@Configuration
public class Bs2V2OauthClientConfiguration {

}
