package com.liquido.facade.liquido;

import java.util.List;
import java.util.Map;

import com.liquido.entity.payback.CashInCallbackDto;
import com.liquido.entity.payback.LiquidoOauthResponse;
import com.liquido.entity.payback.SubAcctDto;
import com.liquido.entity.payback.SubAcctPaybackDto;
import com.liquido.facade.HttpUtils;
import com.liquido.facade.bs2.Bs2RequestException;
import com.liquido.utils.LqWebClientBuilder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class LiquidoClient {
    private static final String OAUTH_REFRESH_TOKEN_PARAM_KEY = "refresh_token";

    private final NanopayConfigs nanopayConfigs;
    
    private final WebClient oauthWebClient;

    private final HttpUtils httpUtils;

    private final WebClient liquidoWebClient;

    @Autowired
    LiquidoClient(
            final NanopayConfigs nanopayConfigs,
            final HttpUtils httpUtils,
            final LqWebClientBuilder lqWebClientBuilder
    ) {
        this.nanopayConfigs = nanopayConfigs;
        this.httpUtils = httpUtils;
        this.liquidoWebClient = createLiquidoWebClient(lqWebClientBuilder);
        this.oauthWebClient = createOauthWebClient(lqWebClientBuilder);
    }




    private WebClient createOauthWebClient(final LqWebClientBuilder lqWebClientBuilder) {
        return lqWebClientBuilder
                .createWebClient(
                        "token_auth",
                        MediaType.APPLICATION_FORM_URLENCODED
                )
                .baseUrl(nanopayConfigs.getAuthUrl())
                .build();
    }


    private MultiValueMap<String, String> getOauthParam() {
        return new LinkedMultiValueMap<>(
                Map.of(
                        NanopayConfigs.CLIENT_ID, List.of(nanopayConfigs.getClientId()),
                        NanopayConfigs.CLIENT_SECRET, List.of(nanopayConfigs.getClientSecret()),
                        OAUTH_REFRESH_TOKEN_PARAM_KEY, List.of("client_credentials")
                ));
    }

    public LiquidoOauthResponse authToken() {
        try {
            MultiValueMap<String, String> oauthParam = getOauthParam();
            log.info("authToken -> {}", oauthParam);
            final var req =
                    oauthWebClient
                            .post()
                            .uri(NanopayConfigs.OAUTH_URI)
                            .bodyValue(oauthParam);
            return httpUtils.retrieveResp(req, LiquidoOauthResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to authRequest with param: %s"),
                    e
            );
        }
    }


    private WebClient createLiquidoWebClient(final LqWebClientBuilder lqWebClientBuilder) {
        return lqWebClientBuilder
                .createWebClient(
                        "liquidoClient"
                )
                .baseUrl(nanopayConfigs.getBaseUrl())
                .build();
    }

    private Map<String, String> getDefaultHeaders(String token) {
        return Map.of(
                HttpHeaders.AUTHORIZATION, token,
                NanopayConfigs.API_KEY, nanopayConfigs.getApiKey()
        );
    }


    public SubAcctDto balance(final String accountUuid, final String token) {
        try {
            String url = NanopayConfigs.BALANCE.replace("{accountUuid}", accountUuid);
            log.info("请求的url地址： ",url);
            final var request = liquidoWebClient
                    .get()
                    .uri(uriBuilder ->
                            uriBuilder.path(url)
                                    .build())
                    .headers((httpHeaders -> httpHeaders.setAll(getDefaultHeaders(token))));
            return httpUtils.retrieveResp(request, SubAcctDto.class);
        } catch (Exception e) {
            log.info("Failed to balance :%s, accountUuid, ",accountUuid,e);
            throw new Bs2RequestException(
                    String.format("Failed to balance :%s", accountUuid), e);
        }
    }

    public SubAcctPaybackDto payback(final String token, final String subAccountUuid) {
        try {
            String url = NanopayConfigs.PAYBACK.replace("{sub_account_uuid}}", subAccountUuid);
            log.info("请求的url地址： ",url);
            final var req =
                    liquidoWebClient
                            .post()
                            .uri(url)
                            .headers((httpHeaders -> httpHeaders.setAll(getDefaultHeaders(token))));
            return httpUtils.retrieveResp(req, SubAcctPaybackDto.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to payback with subAccountUuid: %s", subAccountUuid),
                    e
            );
        }
    }

    public CashInCallbackDto notifyMerchant(final String token, final String transactionId) {
        try {
            final var httpReq =
                    liquidoWebClient
                            .put()
                            .uri(uriBuilder ->
                                    uriBuilder.path(NanopayConfigs.RESEND)
                                            .build(Map.of(
                                                    NanopayConfigs.TRANSACTIONID, transactionId
                                                    )))
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getDefaultHeaders(token)));
            return httpUtils.retrieveResp(httpReq, CashInCallbackDto.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to notifyMerchant with subAccountUuid: %s", transactionId),
                    e
            );
        }
    }

}
