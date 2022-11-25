package com.liquido.facade.bs2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "liquido")
@Configuration
@NonFinal
@Getter
public class LiquidoCommonConfigs {

    public static final String WEBHOOK = "/v1/webhook/payments/charges/bs2/pix";


    @Setter(AccessLevel.PRIVATE)
    @Value("${liquido.baseUrl:#{null}}")
    private String baseUrl;


}
