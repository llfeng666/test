package com.example.facade.bs2.clients;

import java.util.List;
import java.util.Map;

import com.example.facade.HttpUtils;
import com.example.facade.bs2.Bs2CommonConfigs;
import com.example.facade.bs2.Bs2RequestException;
import com.example.facade.bs2.LiquidoCommonConfigs;
import com.example.facade.bs2.model.Bs2GetEidStatusResponse;
import com.example.facade.bs2.model.Bs2Pix;
import com.example.facade.bs2.model.Bs2RefreshTokenOauthResponse;
import com.example.facade.bs2.model.Bs2TokenOauthResponse;
import com.example.utils.LqWebClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class Bs2RefreshTokenOauthClient {
    private static final String OAUTH_REFRESH_TOKEN_PARAM_KEY = "refresh_token";

    private final Bs2CommonConfigs bs2Configs;

    private final LiquidoCommonConfigs liquidoCommonConfigs;
    private final WebClient oauthWebClient;
    private final HttpUtils httpUtils;

    private final WebClient liquidoWebClient;

    private final WebClient apiClient;

    @Autowired
    Bs2RefreshTokenOauthClient(
            final Bs2CommonConfigs bs2Configs,
            final LiquidoCommonConfigs liquidoCommonConfigs,
            final HttpUtils httpUtils,
            final LqWebClientBuilder lqWebClientBuilder
    ) {
        this.liquidoCommonConfigs = liquidoCommonConfigs;
        this.bs2Configs = bs2Configs;
        this.httpUtils = httpUtils;
        this.liquidoWebClient = createLiquidoWebClient(lqWebClientBuilder);
        this.oauthWebClient = createOauthWebClient(lqWebClientBuilder);
       this.apiClient = getApiClient(lqWebClientBuilder);
    }

    private WebClient createOauthWebClient(final LqWebClientBuilder lqWebClientBuilder) {
        return lqWebClientBuilder
                .createWebClient(
                        "bs_refresh_token_auth",
                        MediaType.APPLICATION_FORM_URLENCODED
                )
                .baseUrl(bs2Configs.getBaseUrl())
                .filter(ExchangeFilterFunctions.basicAuthentication(
                        bs2Configs.getApiKey(),
                        bs2Configs.getSecret()
                ))
                .build();
    }

    private WebClient getApiClient(final LqWebClientBuilder lqWebClientBuilder) {
        return lqWebClientBuilder
                .createWebClient("bs2_api_client")
                .baseUrl(bs2Configs.getBaseUrl())
                .build();
    }


    private WebClient createLiquidoWebClient(final LqWebClientBuilder lqWebClientBuilder) {
        return lqWebClientBuilder
                .createWebClient(
                        "bs_refresh_token_auth"
                )
                .baseUrl(liquidoCommonConfigs.getBaseUrl())
                .build();
    }


    private MultiValueMap<String, String> getOauthParam(final String refreshToken) {
        return new LinkedMultiValueMap<>(
                Map.of(
                        Bs2CommonConfigs.OAUTH_SCOPE_PARAM_KEY, List.of(bs2Configs.getScope()),
                        Bs2CommonConfigs.OAUTH_GRANT_TYPE_PARAM_KEY, List.of(Bs2CommonConfigs.Bs2GrantType.CLIENT_CREDENTIALS.grantValue()),
                        OAUTH_REFRESH_TOKEN_PARAM_KEY, List.of(refreshToken)
                ));
    }

    public Bs2TokenOauthResponse authReq(final String refreshToken) {
        try {
            MultiValueMap<String, String> oauthParam = getOauthParam(refreshToken);
            log.info("oauthParam -> {}",oauthParam);
            final var req =
                    oauthWebClient
                            .post()
                            .uri(Bs2CommonConfigs.OAUTH_URI)
                            .bodyValue(oauthParam);
            return httpUtils.retrieveResp(req, Bs2TokenOauthResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to authRequest with param: %s", getOauthParam(refreshToken)),
                    e
            );
        }
    }

    public boolean webhookPix(Bs2Pix bs2Pix){
        try {
            final var request = liquidoWebClient
                    .post()
                    .uri(LiquidoCommonConfigs.WEBHOOK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(bs2Pix);
            return httpUtils.retrieveRespCode(request);
        } catch (Exception e) {
            log.info("Failed to search Bs2 by eid :%s" );
             return false;
        }
    }


    public Bs2GetEidStatusResponse getEidStatus(String eId,String token){
        try {
            String url = Bs2CommonConfigs.PIX_PAY_QUERY_STATUS_URL.replace("{eId}", eId);
            final var request = apiClient
                    .get()
                    .uri(uriBuilder ->
                            uriBuilder.path(url)
                                    .build()).headers((httpHeaders -> httpHeaders.setAll(getDefaultHeaders(token))));
            return httpUtils.retrieveResp(request, Bs2GetEidStatusResponse.class);
        } catch (Exception e) {
            throw new Bs2RequestException(
                    String.format("Failed to search Bs2 by eid :%s",eId ), e);
        }
    }

    private Map<String, String> getDefaultHeaders(String token) {
        return Map.of(
                HttpHeaders.AUTHORIZATION,
                token
        );
    }




    public Bs2RefreshTokenOauthResponse authRequest(final String refreshToken) {
        try {
            MultiValueMap<String, String> oauthParam = getOauthParam(refreshToken);
            log.info("oauthParam -> {}",oauthParam);
            final var req =
                    oauthWebClient
                            .post()
                            .uri(Bs2CommonConfigs.OAUTH_URI)
                            .bodyValue(oauthParam);
            return httpUtils.retrieveResp(req, Bs2RefreshTokenOauthResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to authRequest with param: %s", getOauthParam(refreshToken)),
                    e
            );
        }
    }
}