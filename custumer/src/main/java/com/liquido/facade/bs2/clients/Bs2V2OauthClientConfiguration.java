package com.liquido.facade.bs2.clients;

import com.liquido.facade.bs2.Bs2CommonConfigs;
import com.liquido.facade.bs2.Bs2V2OauthAccessTokenProvider;
import com.liquido.facade.bs2.LiquidoCommonConfigs;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        Bs2RefreshTokenOauthClient.class,
        Bs2CommonConfigs.class,
        LiquidoCommonConfigs.class,
        Bs2V2OauthAccessTokenProvider.class,
})
@Configuration
public class Bs2V2OauthClientConfiguration {
}
