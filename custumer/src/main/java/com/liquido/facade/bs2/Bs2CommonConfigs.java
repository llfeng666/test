package com.liquido.facade.bs2;

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

@ConfigurationProperties(prefix = "bs2")
@Configuration
@NonFinal
@Getter
public class Bs2CommonConfigs {
    // The param names are not used literally in URLs
    public static final String E2E_ID_PARAM_NAME = "e2eId";
    public static final String EXTERNAL_ID_PARAM_NAME = "externalId";
    public static final String TX_ID_PARAM_NAME = "txId";
    public static final String BS2_BOLETO_NUMBER_PARAM_NAME = "bs2BoletoNumber";
    public static final String QRCODE_ID_PARAM_NAME = "qrCodeId";

    public static final String OAUTH_SCOPE_PARAM_KEY = "scope";
    public static final String OAUTH_GRANT_TYPE_PARAM_KEY = "grant_type";
    public static final String OAUTH_REFRESH_TOKEN_PARAM_KEY = "refresh_token";

    public static final String OAUTH_URI = "/auth/oauth/v2/token";
    public static final String BALANCE_QUERY_URI =
            "/pj/apibanking/forintegration/v1/contascorrentes/saldo";
    public static final String PIX_PAY_INIT_URI = "/pix/direto/forintegration/v1/pagamentos/chave";
    public static final String PIX_QRCODE_PAY_INIT_URI =
            "/pix/direto/forintegration/v1/pagamentos/qrcodes";
    public static final String PIX_TED_PAY_INIT_URI =
            "/pix/direto/forintegration/v1/pagamentos/manual";
    public static final String PIX_PAY_CONFIRM_URI =
            "/pix/direto/forintegration/v1/pagamentos/{pagamentoId}/confirmacao";
    public static final String PIX_ASNYC_PAY_URI =
            "/pix/direto/forintegration/v1/pagamentos/chave/solicitacoes";
    public static final String PIX_PAY_QUERY_URI =
            "/pix/direto/forintegration/v1/pagamentos/{pagamentoId}";
    public static final String PIX_PAY_QUERY_SOLICITATION_URI =
            "/pix/direto/forintegration/v1/pagamentos/chave/solicitacoes/{solicitationId}";

    public static final String PIX_PAY_QUERY_STATUS_URL = "pix/direto/forintegration/v1/recebimentos/{eId}/recebimento";
    public static final String PIX_PAY_IN_STATIC_QR_CODE_CREATE_URI =
            "/pix/direto/forintegration/v1/qrcodes/estatico";
    public static final String PIX_PAY_IN_DYNAMIC_QR_CODE_CREATE_URI =
            "/pix/direto/forintegration/v1/qrcodes/dinamico";
    public static final String PIX_PAY_IN_REFUND_URI =
            String.format(
                    "/pix/direto/forintegration/v1/pix/{%s}/devolucao/{%s}", E2E_ID_PARAM_NAME,
                    EXTERNAL_ID_PARAM_NAME
            );


    public static final String QUERY_REFUND =   "/pix/direto/forintegration/v1/pix/{eId}";


    public static final String PIX_PAY_IN_QUERY_BILLING_BY_TX_ID_URI =
            String.format("/pix/direto/forintegration/v1/cob/{%s}", TX_ID_PARAM_NAME);

    public static final String PAY_IN_BOLETO_CREATE_TICKET_URI =
            "/pj/forintegration/cobranca/v2/boletos/simplificado";
    public static final String PAY_IN_BOLETO_QUERY_TICKET_URI =
            String.format("/pj/forintegration/cobranca/v1/boletos/{%s}",
                    BS2_BOLETO_NUMBER_PARAM_NAME);
    public static final String PAY_IN_BOLETO_CANCEL_TICKET_URI =
            String.format("/pj/forintegration/cobranca/v1/boletos/{%s}/solicitacoes/cancelamentos",
                    BS2_BOLETO_NUMBER_PARAM_NAME);

    public static final String PIX_QRCODE_CANCEL_URI =
            String.format("/pix/direto/forintegration/v1/qrcodes/{%s}", QRCODE_ID_PARAM_NAME);

    public static final String PIX_QRCODE_QUERY_URI = "/pix/direto/forintegration/v1/qrcodes";


    // Observed value from real response. Declared here to facilitate cache configuration and
    // testings
    public static final long BS2_STAGING_TOKEN_EXPIRES_IN_SECONDS = 420;
    public static final long BS2_PROD_TOKEN_EXPIRES_IN_SECONDS = 300;
    // Leave 30 seconds of buffer
    public static final int TOKEN_EXPIRATION_BUFFER_IN_SECONDS = 30;
    // bs2 dynamic QR code txId length must be between 26 and 35
    public static final int BS2_DYNAMIC_QR_CODE_TX_ID_LENGTH = 26;
    public static final int BS2_BOLETO_LIQUIDO_NUMBER_LENGTH = 15;
    // bs2 dynamic QR code expiration seconds must be between 3600(1 hour) and 604800(1 week)
    public static final int BS2_DYNAMIC_QR_CODE_MIN_EXPIRATION_SECONDS = 3600;
    public static final int BS2_DYNAMIC_QR_CODE_MAX_EXPIRATION_SECONDS = 604800;


    public enum Bs2GrantType {
        CLIENT_CREDENTIALS("client_credentials"),
        REFRESH_TOKEN("refresh_token");

        private static final Map<String, Bs2GrantType> ALL_VALUES_TO_ENUMS =
                Arrays
                        .stream(Bs2GrantType.values())
                        .map(e -> Map.entry(e.grantValue, e))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        private final String grantValue;

        Bs2GrantType(final String grantValue) {
            this.grantValue = grantValue;
        }

        public String grantValue() {
            return grantValue;
        }

        public static boolean isAllowed(final String grantValue) {
            return ALL_VALUES_TO_ENUMS.containsKey(grantValue);
        }

        public static Bs2GrantType fromGrantValue(final String grantValue) {
            if (!ALL_VALUES_TO_ENUMS.containsKey(grantValue)) {
                throw new IllegalArgumentException(
                        String.format("Unrecognized grantValue: %s", grantValue));
            }
            return ALL_VALUES_TO_ENUMS.get(grantValue);
        }
    }

    private int testServerPort = -1;

    @PostConstruct
    void verifyAndInitIfNecessary() {
        Verify.verify(
                Bs2GrantType.isAllowed(getGrantType()), "Unrecognized grant_type: %s",
                getGrantType()
        );
        if (TextUtils.isBlank(baseUrl)) {
            testServerPort = SocketUtils.findAvailableTcpPort();
            setBaseUrl(String.format("http://localhost:%s", String.valueOf(testServerPort)));
        }
    }

    public int getTestServerPort() {
        return testServerPort;
    }

    @Setter(AccessLevel.PRIVATE)
    @Value("${bs2.baseUrl:#{null}}")
    private String baseUrl;

    @Value("${bs2.oauth.apiKey}")
    private String apiKey;

    @Value("${bs2.oauth.secret}")
    private String secret;

    @Value("${bs2.oauth.grantType}")
    private String grantType;

    @Value("${bs2.oauth.scope}")
    private String scope;

    @Value("${bs2.payIn.pixKey:#{null}}")
    private String pixPayInKey;
}
