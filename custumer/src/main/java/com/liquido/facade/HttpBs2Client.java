package com.liquido.facade;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.liquido.facade.bs2.Bs2CommonConfigs;
import com.liquido.facade.bs2.Bs2RequestException;
import com.liquido.facade.bs2.Bs2V2OauthAccessTokenProvider;
import com.liquido.facade.bs2.model.Bs2BoletoCancelResponse;
import com.liquido.facade.bs2.model.Bs2BoletoCreateRequest;
import com.liquido.facade.bs2.model.Bs2BoletoCreateResponse;
import com.liquido.facade.bs2.model.Bs2BoletoQueryResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateDynamicQrCodeRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateDynamicQrCodeResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateQrCodeRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateQrCodeResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInRefundRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInRefundResponse;
import com.liquido.facade.bs2.model.Bs2PixQrCodeQueryResponse;
import com.liquido.facade.bs2.model.Bs2PixQueryTransactionResponse;
import com.liquido.utils.LqWebClientBuilder;
import com.liquido.utils.Unchecked;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class HttpBs2Client implements Bs2Client {

    private static final String ACCESS_TOKEN_CACHE_KEY = "BS2_ACCESS_TOKEN";

    private final Bs2V2OauthAccessTokenProvider bs2V2tokenProvider;
    private final LoadingCache<String, String> accessTokenCache;
    private final WebClient apiClient;
    private final HttpUtils httpUtils;

    @Autowired
    HttpBs2Client(
            final Bs2Configs bs2Configs,
            final Bs2V2OauthAccessTokenProvider bs2V2tokenProvider,
            final Ticker ticker,
            final HttpUtils httpUtils,
            final LqWebClientBuilder lqWebClientBuilder
    ) {
        this.bs2V2tokenProvider = bs2V2tokenProvider;
        this.accessTokenCache = initTokenCache(ticker);
        this.httpUtils = httpUtils;
        this.apiClient =
                lqWebClientBuilder
                        .createWebClient("bs2_api_client")
                        .baseUrl(bs2Configs.getConfigs().getBaseUrl())
                        .build();
    }

    private LoadingCache<String, String> initTokenCache(final Ticker ticker) {
        final CacheLoader<String, String> loader = new CacheLoader<>() {
            @Override
            public String load(final String key) {
                if (ACCESS_TOKEN_CACHE_KEY.equals(key)) {
                    return renewAccessToken();
                } else {
                    log.warn("Invalid cache key detected: {}. Returning an empty value", key);
                    return "";
                }
            }
        };

        return CacheBuilder
                .newBuilder()
                .expireAfterWrite(
                        Bs2CommonConfigs.BS2_PROD_TOKEN_EXPIRES_IN_SECONDS
                                - Bs2CommonConfigs.TOKEN_EXPIRATION_BUFFER_IN_SECONDS,
                        TimeUnit.SECONDS
                )
                .ticker(ticker)
                .build(loader);
    }

    private String renewAccessToken() {
//        final var resp = bs2OauthClient.authRequest();
//        if (!HttpUtils.AUTH_PROTOCOL_SCHEME_BEARER.equals(resp.getTokenType())) {
//            throw new UnsupportedOperationException(
//                    "Unsupported HTTP authorization scheme detected: " + resp.getTokenType());
//        }
//        return HttpUtils.formatBearerAuthToken(resp.getAccessToken());
        return "";
    }

    @VisibleForTesting
    String getAccessTokenFromCache() {
        return Unchecked.supplier(() -> accessTokenCache.get(ACCESS_TOKEN_CACHE_KEY)).get();
    }

    @Override
    public Bs2PixPayInCreateQrCodeResponse pixPayInCreateStaticQrCode(
            final Bs2PixPayInCreateQrCodeRequest req
    ) {
        try {
            final var httpReq =
                    apiClient
                            .post()
                            .uri(Bs2CommonConfigs.PIX_PAY_IN_STATIC_QR_CODE_CREATE_URI)
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()))
                            .bodyValue(req);
            return httpUtils.retrieveResp(httpReq, Bs2PixPayInCreateQrCodeResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to create PIX pay-in static QR code with request: %s",
                            req
                    ), e);
        }
    }

    @Override
    public Bs2PixPayInCreateDynamicQrCodeResponse pixPayInCreateDynamicQrCode(
            final Bs2PixPayInCreateDynamicQrCodeRequest req
    ) {
        try {
            final var httpReq =
                    apiClient.post().uri(Bs2CommonConfigs.PIX_PAY_IN_DYNAMIC_QR_CODE_CREATE_URI)
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()))
                            .bodyValue(req);
            return httpUtils.retrieveResp(httpReq, Bs2PixPayInCreateDynamicQrCodeResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to create PIX pay-in dynamic QR code with request: %s",
                            req
                    ), e);
        }
    }

    @Override
    public Bs2PixPayInRefundResponse pixRequestRefund(
            final String originalPaymentE2eId,
            final String refundTxIdToUse,
            final Bs2PixPayInRefundRequest req
    ) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.E2E_ID_PARAM_NAME, originalPaymentE2eId,
                        Bs2CommonConfigs.EXTERNAL_ID_PARAM_NAME, refundTxIdToUse
                );
        try {
            final var httpReq =
                    apiClient
                            .put()
                            .uri(uriBuilder ->
                                    uriBuilder.path(Bs2CommonConfigs.PIX_PAY_IN_REFUND_URI)
                                            .build(uriPathParams))
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()))
                            .bodyValue(req);
            return httpUtils.retrieveResp(httpReq, Bs2PixPayInRefundResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(String.format(
                    "Failed to request refund with original payment ID: %s, refund ID: %s, "
                            + "and req: %s",
                    originalPaymentE2eId,
                    refundTxIdToUse,
                    req
            ), e);
        }
    }

    @Override
    public Bs2PixPayInRefundResponse pixQueryRefund(
            final String originalPaymentE2eId,
            final String refundTxId
    ) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.E2E_ID_PARAM_NAME, originalPaymentE2eId,
                        Bs2CommonConfigs.EXTERNAL_ID_PARAM_NAME, refundTxId
                );
        try {
            final var httpReq =
                    apiClient
                            .get()
                            .uri(uriBuilder ->
                                    uriBuilder.path(Bs2CommonConfigs.PIX_PAY_IN_REFUND_URI)
                                            .build(uriPathParams))
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()));
            return httpUtils.retrieveResp(httpReq, Bs2PixPayInRefundResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(String.format(
                    "Failed to query refund with original payment ID: %s, refund ID: %s",
                    originalPaymentE2eId,
                    refundTxId
            ), e);
        }
    }

    @Override
    public Bs2PixQueryTransactionResponse pixQueryTransaction(
            final String txId
    ) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.TX_ID_PARAM_NAME, txId
                );
        try {
            final var httpReq =
                    apiClient
                            .get()
                            .uri(uriBuilder ->
                                    uriBuilder
                                            .path(
                                                    Bs2CommonConfigs
                                                            .PIX_PAY_IN_QUERY_BILLING_BY_TX_ID_URI
                                            )
                                            .build(uriPathParams))
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()));
            return httpUtils.retrieveResp(httpReq, Bs2PixQueryTransactionResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format("Failed to query transaction with tx ID: %s", txId), e);
        }
    }

    @Override
    public Bs2PixQrCodeQueryResponse pixQueryQrCode(final String txId) {
        try {
            final var httpReq =
                    apiClient.get()
                            .uri(uriBuilder -> uriBuilder.path(
                                    Bs2CommonConfigs.PIX_QRCODE_QUERY_URI
                            ).queryParam(Bs2CommonConfigs.TX_ID_PARAM_NAME, txId).build())
                            .headers(httpHeaders -> httpHeaders.setAll(getV1DefaultHeaders()));
            return httpUtils.retrieveResp(httpReq, Bs2PixQrCodeQueryResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format("Failed to query qr code with tx ID: %s", txId), e);
        }
    }

    @Override
    public void pixCancelQrCode(final int qrCodeId) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.QRCODE_ID_PARAM_NAME, qrCodeId
                );
        try {
            final var httpReq =
                    apiClient.delete()
                            .uri(uriBuilder ->
                                    uriBuilder.path(Bs2CommonConfigs.PIX_QRCODE_CANCEL_URI)
                                            .build(uriPathParams))
                            .headers(httpHeaders ->
                                    httpHeaders
                                            .setAll(getV1DefaultHeaders()));
            httpUtils.sendAndValidateHttpStatus(httpReq);
        } catch (final Exception e) {
            throw new Bs2RequestException(String.format(
                    "Failed to cancel qr code with id: %s",
                    qrCodeId
            ), e);
        }
    }

    @Override
    public Bs2BoletoCreateResponse boletoCreate(
            final Bs2BoletoCreateRequest req
    ) {
        try {
            final var httpReq =
                    apiClient
                            .post()
                            .uri(Bs2CommonConfigs.PAY_IN_BOLETO_CREATE_TICKET_URI)
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getV2DefaultHeaders()))
                            .bodyValue(req);
            return httpUtils.retrieveResp(httpReq, Bs2BoletoCreateResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(
                    String.format(
                            "Failed to create Boleto pay-in request: %s",
                            req
                    ), e);
        }
    }

    @Override
    public Bs2BoletoQueryResponse boletoQueryTransaction(
            final String bs2BoletoNumber
    ) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.BS2_BOLETO_NUMBER_PARAM_NAME, bs2BoletoNumber
                );
        try {
            final var httpReq =
                    apiClient
                            .get()
                            .uri(uriBuilder ->
                                    uriBuilder
                                            .path(Bs2CommonConfigs.PAY_IN_BOLETO_QUERY_TICKET_URI)
                                            .build(uriPathParams))
                            .headers(httpHeaders -> httpHeaders.setAll(getV2DefaultHeaders()));
            return httpUtils.retrieveResp(httpReq, Bs2BoletoQueryResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(String.format(
                    "Failed to query Boleto transaction with BS2 Boleto number: %s",
                    bs2BoletoNumber
            ), e);
        }
    }

    @Override
    public Bs2BoletoCancelResponse boletoCancel(final String bs2BoletoNumber) {
        final var uriPathParams =
                Map.of(
                        Bs2CommonConfigs.BS2_BOLETO_NUMBER_PARAM_NAME, bs2BoletoNumber
                );
        try {
            final var httpReq =
                    apiClient.post()
                            .uri(uriBuilder -> uriBuilder
                                    .path(Bs2CommonConfigs.PAY_IN_BOLETO_CANCEL_TICKET_URI)
                                    .build(uriPathParams))
                            .contentType(MediaType.APPLICATION_JSON)
                            .headers(httpHeaders -> httpHeaders.setAll(getV2DefaultHeaders()));
            return httpUtils.retrieveResp(httpReq, Bs2BoletoCancelResponse.class);
        } catch (final Exception e) {
            throw new Bs2RequestException(String.format(
                    "Failed to cancel Boleto pay-in request with BS2 Boleto number: %s",
                    bs2BoletoNumber
            ), e);
        }
    }

    private Map<String, String> getV1DefaultHeaders() {
        return Map.of(HttpHeaders.AUTHORIZATION, getAccessTokenFromCache());
    }

    private Map<String, String> getV2DefaultHeaders() {
        return Map.of(
                HttpHeaders.AUTHORIZATION,
                HttpUtils.formatBearerAuthToken(bs2V2tokenProvider.getCurrentAccessToken())
        );
    }
}
