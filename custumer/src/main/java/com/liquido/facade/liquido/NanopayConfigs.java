package com.liquido.facade.liquido;

import java.util.Map;

import com.liquido.facade.unipagos.MerchantConfig;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "nanopay")
@Configuration
@NonFinal
@Getter
public class NanopayConfigs {

    private Map<String, MerchantConfig> merchantConfigMap;

    public static final String API_KEY = "api_key";
    public static final String CLIENT_ID = "client_id";

    public static final String CLIENT_SECRET = "client_secret";

    public static final String GRANT_TYPE = "grant_type";

    public static final String TRANSACTIONID = "transactionId";

    public static final String OAUTH_URI = "/oauth2/token";

    public static final String PAY_OUT = "/v1/mx/payments/payouts/spei";

    public static final String QUERY_STATUS = "/v1/mx/payments/payouts/key/:idempotencyKey";

    public static final String CREATE_SUBACCOUNT = "/v1/mx/payments/charges/spei/create";

    public static final String GET_SUBINFO = "/v1/mx/payments/charges/spei/{accountUuid}";

    public static final String GET_SUBINFO_PHONE = "/v1/mx/payments/charges/spei/{phoneNumber}";

    public static final String BALANCE = "/v1/mx/payments/charges/spei/{accountUuid}/balance";

    public static final String PAYBACK = "/mx/payments/charges/spei/{sub_account_uuid}/payback";

    public static final String RESEND = String.format("/v1/mx/payments/charges/spei/callback/resend?transactionId={%s}",
    "transactionId");

    @Setter(AccessLevel.PRIVATE)
    @Value("${nanopay.authUrl:#{null}}")
    private String authUrl;

    @Setter(AccessLevel.PRIVATE)
    @Value("${nanopay.baseUrl:#{null}}")
    private String baseUrl;

    @Value("${nanopay.clientId}")
    private String clientId;

    @Value("${nanopay.clientSecret}")
    private String clientSecret;

    @Value("${nanopay.apiKey}")
    private String apiKey;
}
