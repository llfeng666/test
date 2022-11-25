package com.liquido.facade.liquido;


import java.util.Map;

import com.liquido.facade.unipagos.MerchantConfig;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "unipagos")
@Configuration
@Getter
@Setter
@VisibleForTesting
public class LiquidoYamlConfig {

    private Map<String, MerchantConfig> merchantConfigMap;

    @Setter(AccessLevel.PRIVATE)
    @Value("${unipagos.baseUrl:#{null}}")
    private String baseUrl;

}
