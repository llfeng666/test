package com.liquido.facade.unipagos;

import java.io.IOException;
import java.security.KeyStore;
import java.time.Duration;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import com.liquido.entity.payback.UnipagosTransferQueryResponse;
import com.liquido.enums.ResultCode;
import com.liquido.exceptions.VendorInvokedException;
import com.liquido.facade.HttpUtils;
import com.liquido.utils.LqWebClientBuilder;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClientRequest;

@Component
@Slf4j
public class UnipagosClient {
    private static final String OAUTH_REFRESH_TOKEN_PARAM_KEY = "refresh_token";

    private final UnipagosConfigs unipagosConfigs;

    private final HttpUtils httpUtils;
    @Autowired(required = true)
    private final LqWebClientBuilder lqWebClientBuilder;


    @Autowired
    UnipagosClient(
            final UnipagosConfigs unipagosConfigs,
            final HttpUtils httpUtils,
            final LqWebClientBuilder lqWebClientBuilder
    ) {
        this.unipagosConfigs = unipagosConfigs;
        this.httpUtils = httpUtils;
        this.lqWebClientBuilder=lqWebClientBuilder;
    }




    public UnipagosTransferQueryResponse queryTransfer(final String date, final String xid,
                                                       final String apiKey) {
        final WebClient webClient = createWebClient(apiKey,unipagosConfigs.getConfig().getBaseUrl());

        try {
            final var httpReq = webClient
                    .get()
                    .uri(uriBuilder ->
                            uriBuilder.path(unipagosConfigs
                                            .TRANSFER_PREFAB_SUB_ACCOUNT_TO_PARENT_URI)
                                    .queryParam(unipagosConfigs.EXTERNAL_ID_PARAM_NAME,
                                            xid)
                                    .queryParam(unipagosConfigs.DATE_PARAM_NAME,
                                            date)
                                    .build())
                    .httpRequest(httpRequest ->
                            getHttpClientRequest(httpRequest,
                                    unipagosConfigs
                                            .UNIPAGOS_NETWORK_TIMEOUT_SECONDS)
                    );
            return httpUtils.retrieveResp(httpReq, UnipagosTransferQueryResponse.class);
        } catch (Exception e) {
            log.error("Exception on Unipagos query transfer", e);
            throw new VendorInvokedException(ResultCode.GATEWAY_ERROR, e);
        }

    }

    public void getHttpClientRequest (ClientHttpRequest httpRequest, long connectionTimeout) {
        final HttpClientRequest reactorRequest = httpRequest.getNativeRequest();
        reactorRequest.responseTimeout(Duration.ofSeconds(connectionTimeout));
    }

    private WebClient createWebClient(final String apiKey, final String baseUrl) {
        log.info("Creating WebClient for apiKey={}", apiKey);
        final MerchantConfig merchantConfig = unipagosConfigs.getMerchantConfig(apiKey);
        return lqWebClientBuilder.createWebClient("unipagos_api_webclient"
                        + merchantConfig.getTableName(), getSslContext(merchantConfig))
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public SslContext getSslContext(final MerchantConfig config) {
        return getSslContext(
                config.getKeyStoreType(),
                config.getKeyStorePassword(),
                config.getKeyStoreFileName());
    }

    private SslContext getSslContext(
            final String keystoreType,
            final String keystorePassword,
            final String keystoreFileName
    ) {
        try {
            final KeyStore keyStore = KeyStore.getInstance(keystoreType);
            final char[] passwordArray = keystorePassword.toCharArray();
            final ResourceLoader resourceLoader = new FileSystemResourceLoader();

            try (var inputStream = resourceLoader.getClassLoader()
                    .getResourceAsStream(keystoreFileName)) {
                keyStore.load(inputStream, passwordArray);

                final KeyManagerFactory keyManagerFactory =
                        KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, keystorePassword.toCharArray());
                final KeyManager keyManager = keyManagerFactory.getKeyManagers()[0];

                return SslContextBuilder.forClient()
                        .keyManager(keyManager)
                        .build();
            } catch (final IOException e) {
                log.error("error opening keystore file", e);
                throw new VendorInvokedException(e);
            }
        } catch (Exception e) {
            log.error("getSslContext exception", e);
            throw new VendorInvokedException(e);
        }
    }

    }
