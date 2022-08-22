package com.example.facade.bs2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import com.google.common.base.Verify;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

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
