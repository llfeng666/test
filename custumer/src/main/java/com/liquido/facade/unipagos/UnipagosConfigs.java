package com.liquido.facade.unipagos;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.liquido.facade.liquido.LiquidoYamlConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Component
@Import({
        LiquidoYamlConfig.class
})
public class UnipagosConfigs {

    private final LiquidoYamlConfig config;

    private final Map<String, MerchantConfig> apiKey2Config;

    public static final String TRANSFER_PREFAB_SUB_ACCOUNT_TO_PARENT_URI =
            "/upams/api/v2/transfers";

    public static final String EXTERNAL_ID_PARAM_NAME = "xid";

    public static final String DATE_PARAM_NAME = "date";

    public static final long UNIPAGOS_NETWORK_TIMEOUT_SECONDS = 15;

    private final Map<String, WebClient> apiKey2WebClient = new ConcurrentHashMap<>();



    @Autowired
    public UnipagosConfigs(final LiquidoYamlConfig config) {
        this.config = config;

        apiKey2Config =
                config
                        .getMerchantConfigMap()
                        .values()
                        .stream()
                        .map(c -> Map.entry(c.getApiKey(), c))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    public MerchantConfig getMerchantConfig(final String apiKey) {
        if (!apiKey2Config.containsKey(apiKey)) {
            log.error("No PayoutConfig for api key {}", apiKey);
            throw new InvalidParameterException();
        }

        return apiKey2Config.get(apiKey);
    }


    public LiquidoYamlConfig getConfig(){
            return config;
    }

}
