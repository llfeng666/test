package com.liquido.entity.unipagos;

import javax.annotation.PostConstruct;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

@ConfigurationProperties(prefix = "unipagos")
@Configuration
@NonFinal
@Getter
public class UnipagosCommonConfigs {
    // The param names are not actually used in URLs
    public static final String TX_ID_PARAM_NAME = "txId";

    public static final String DATE_PARAM_NAME = "date";

    public static final String EXTERNAL_ID_PARAM_NAME = "xid";

    public static final String SUB_ACCOUNT_MERCHANT_ID_PARAM_NAME = "subAccountUuid";

    // spei payout document
    // https://unipagos.atlassian.net/wiki/spaces/UDW/pages/2642542593/spei+cash+out
    public static final String SPEI_PAY_OUT_OR_QUERY_URI = "/api/v2/spei/cash_out";

    public static final String QUERY_ACCOUNT_BALANCE_URI = "/api/v2/accounts/balance";

    // Unipagos Doc: https://unipagos.atlassian.net/wiki/spaces/UDWpages/163119105/transfers
    public static final String TRANSFER_PREFAB_SUB_ACCOUNT_TO_PARENT_URI =
            "/upams/api/v2/transfers";

    public static final String TRANSFER_PREFAB_SUB_ACCOUNT_QUERY_URI =
            String.format("/upams/api/v2/transfers?xid={%s}&date={%s}",
                    EXTERNAL_ID_PARAM_NAME,
                    DATE_PARAM_NAME);
    public static final String TRANSFER_TO_PARENT_WITH_MERCHANT_ID_URI =
            String.format("/api/v2/users/merchant/{%s}/transfers",
                    SUB_ACCOUNT_MERCHANT_ID_PARAM_NAME);

    //Unipagos Doc:https://unipagos.atlassian.net/wiki/spaces/UDW/pages/2705686529/accounts+balance
    public static final String CREATE_MERCHANT_SUB_ACCOUNT_URI = "/api/v2/merchants/sub-accounts";

    public static final String DEFAULT_KEYSTORE_TYPE = "JKS";

    public static final String ORIGINAL_KEYSTORE_PASSWORD = "135790";

    public static final String ORIGINAL_KEYSTORE_FILE_NAME = "subacct-jks/%s.jks";
    public static final String SPEI_PAY_OUT_QUERY_URI_WITH_TX_ID =
            String.format("/api/v2/spei/cash_out/{%s}", TX_ID_PARAM_NAME);

    //https://unipagos.atlassian.net/wiki/spaces/UDW/pages/2727477257/merchants%2Bsub-accounts
    public static final String SUB_ACCOUNT_QUERY_URI_WITH_SUB_ACCOUNT_MERCHANT_ID =
            String.format("/api/v2/merchants/sub-accounts/{%s}",
                    SUB_ACCOUNT_MERCHANT_ID_PARAM_NAME);
    public static final String TOP_UP_URI = "/api/v2/sales/topups";

    public static final String TOP_UP_QUERY_URI =
            String.format("/api/v2/sales/topups?xid={%s}&date={%s}", EXTERNAL_ID_PARAM_NAME,
                    DATE_PARAM_NAME);
    public static final String GIFT_CARD_URI = "/api/v2/sales/gift_cards";

    public static final String GIFT_CARD_QUERY_URI = "/api/v2/sales/digital_services";

    public static final String GIFT_CARD_QUERY_URI_WITH_XID =
            String.format("/api/v2/sales/digital_services?xid={%s}&date={%s}",
                    EXTERNAL_ID_PARAM_NAME,
                    DATE_PARAM_NAME);
    public static final String QUERY_SUB_ACCOUNT_BALANCE =
            String.format("/api/v2/accounts/merchant/{%s}/balance",
                    SUB_ACCOUNT_MERCHANT_ID_PARAM_NAME);

    // Liquido client (Kwai) timeout value is 8s, we set Unipagos side timeout as 6s.
    public static final long UNIPAGOS_SPEI_POST_TIMEOUT_SECONDS = 6;

    public static final long UNIPAGOS_NETWORK_TIMEOUT_SECONDS = 15;

    private int testServerPort = -1;

    @PostConstruct
    void verifyAndInitIfNecessary() {
        testServerPort = SocketUtils.findAvailableTcpPort();
        if (TextUtils.isBlank(baseUrl)) {
            setBaseUrl(String.format("http://localhost:%s", String.valueOf(testServerPort)));
        }
        if (TextUtils.isBlank(mobileBaseUrl)) {
            setMobileBaseUrl(String.format("http://localhost:%s", String.valueOf(testServerPort)));
        }
    }

    public int getTestServerPort() {
        return testServerPort;
    }

    @Setter(AccessLevel.PRIVATE)
    @Value("${unipagos.baseUrl:#{null}}")
    private String baseUrl;

    @Setter(AccessLevel.PRIVATE)
    @Value("${unipagos.mobileBaseUrl:#{null}}")
    private String mobileBaseUrl;
}
