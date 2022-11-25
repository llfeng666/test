package com.liquido.utils;

import java.time.Duration;

import com.fasterxml.jackson.databind.json.JsonMapper;
import io.netty.handler.ssl.SslContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Component
public class LqWebClientBuilder {
    private static final int DEFAULT_CONNECTION_MAX_IDLE_SECONDS = 30;

    private final JsonMapper jsonMapper;

    @Autowired
    public LqWebClientBuilder(final JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public WebClient.Builder createWebClient(
            final String connectionProviderName,
            final int connectionTimeout
    ) {
        final HttpClient httpClient =
                HttpClient.create(
                        ConnectionProvider.builder(connectionProviderName)
                                .maxIdleTime(Duration.ofSeconds(connectionTimeout))
                                .build());

        final ClientHttpConnector clientHttpConnector = new ReactorClientHttpConnector(httpClient);
        return WebClient
                .builder()
                .exchangeStrategies(setExchangeStrategies())
                .clientConnector(clientHttpConnector);
    }

    public WebClient.Builder createWebClient(
            final String connectionProviderName,
            final int connectionTimeout,
            final SslContext sslContext
    ) {
        final HttpClient httpClient =
                HttpClient.create(
                        ConnectionProvider.builder(connectionProviderName)
                                .maxIdleTime(Duration.ofSeconds(connectionTimeout))
                                .build())
                        .secure(sslContextSpec -> sslContextSpec.sslContext(sslContext));

        final ClientHttpConnector clientHttpConnector = new ReactorClientHttpConnector(httpClient);
        return WebClient
                .builder()
                .exchangeStrategies(setExchangeStrategies())
                .clientConnector(clientHttpConnector);
    }

    public WebClient.Builder createWebClient(final String connectionProviderName) {
        return createWebClient(
                connectionProviderName,
                DEFAULT_CONNECTION_MAX_IDLE_SECONDS
        );
    }

    public WebClient.Builder createWebClient(
            final String connectionProviderName,
            final MediaType paramMediaType
    ) {
        final var client = createWebClient(
                connectionProviderName,
                DEFAULT_CONNECTION_MAX_IDLE_SECONDS
        );
        client.defaultHeader(HttpHeaders.CONTENT_TYPE, paramMediaType.toString());
        return client;
    }

    public WebClient.Builder createWebClient(
            final String connectionProviderName,
            final SslContext sslContext
    ) {
        return createWebClient(
                connectionProviderName,
                DEFAULT_CONNECTION_MAX_IDLE_SECONDS,
                sslContext
        );
    }

    //that the max size does not affect the actual buffer size allocated
    public ExchangeStrategies setExchangeStrategies() {

        return ExchangeStrategies.builder()
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer.defaultCodecs()
                            .jackson2JsonEncoder(new Jackson2JsonEncoder(jsonMapper));
                    clientCodecConfigurer.defaultCodecs()
                            .jackson2JsonDecoder(new Jackson2JsonDecoder(jsonMapper));
                    clientCodecConfigurer.defaultCodecs()
                            .maxInMemorySize(512 * 1024);
                })
                .build();
    }
}
