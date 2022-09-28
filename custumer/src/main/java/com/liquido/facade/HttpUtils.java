package com.liquido.facade;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


import com.liquido.enums.ResultCode;
import com.liquido.exceptions.InternalServerException;
import com.liquido.exceptions.VendorInvokedException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import okio.Buffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public final class HttpUtils {
    public static final String AUTH_PROTOCOL_SCHEME_BASIC = "Basic";
    public static final String AUTH_PROTOCOL_SCHEME_BEARER = "Bearer";
    public static final String X_API_KEY = "x-api-key";

    private final JsonUtils jsonUtils;
    private final XmlUtils xmlUtils;

    @Autowired
    HttpUtils(
            final JsonUtils jsonUtils,
            final XmlUtils xmlUtils
    ) {
        this.jsonUtils = jsonUtils;
        this.xmlUtils = xmlUtils;
    }

    public static String formatBearerAuthToken(final String token) {
        return AUTH_PROTOCOL_SCHEME_BEARER + " " + token;
    }


    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static Map<String, String> parseUrlEncodedBody(final Buffer buf, final long bodyLen) {
        if (buf.size() != bodyLen) {
            throw new IllegalArgumentException(
                    String.format(
                            "Body len: %d does not match with the length of the buffer: %d",
                            bodyLen,
                            buf.size()
                    ));
        }
        return Arrays
                // Should split first before decoding
                .stream(buf.readUtf8().split("&"))
                .map(arg -> {
                    final var keyAndValue =
                            Arrays
                                    .stream(arg.split("="))
                                    .map(s -> URLDecoder.decode(s, StandardCharsets.UTF_8))
                                    .collect(Collectors.toList());
                    if (keyAndValue.size() != 2) {
                        throw new IllegalArgumentException(
                                String.format("Detected invalid URL encoded body param: %s", arg));
                    }
                    return Map.entry(keyAndValue.get(0), keyAndValue.get(1));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static String generateBasicAuth(final String apiKey, final String apiSecret) {
        return HttpHeaders.encodeBasicAuth(apiKey, apiSecret, null);
    }

    public <T> T retrieveResp(final WebClient.RequestHeadersSpec<?> spec, final Class<T> clazz) {
        final var respStr = getResponseBody(spec);
        try {
            return jsonUtils.decode(respStr, clazz);
        } catch (final Exception e) {
            throw new InternalServerException(
                    String.format("Error parsing the response string: %s", respStr), e);
        }
    }


    public boolean retrieveRespCode(final WebClient.RequestHeadersSpec<?> spec) {
        return getResponseFlag(spec);
    }

    public <T> T retrieveXmlResp(final WebClient.RequestHeadersSpec<?> spec, final Class<T> clazz) {
        final var respStr = getResponseBody(spec);
        try {
            return xmlUtils.decode(respStr, clazz);
        } catch (final Exception e) {
            throw new InternalServerException(
                    String.format("Error parsing the response string: %s", respStr), e);
        }
    }

    public <T> T retrieveResp(
            final WebClient.RequestHeadersSpec<?> spec,
            final TypeReference<T> type
    ) {
        final var respStr = getResponseBody(spec);
        try {
            return jsonUtils.decode(respStr, type);
        } catch (final Exception e) {
            throw new InternalServerException(
                    String.format("Error parsing the response string: %s", respStr), e);
        }
    }

    /**
     * This should be used only if the response expected is a pure string without a JSON structure.
     */
    public String retrieveRespStr(final WebClient.RequestHeadersSpec<?> spec) {
        return getResponseBody(spec);
    }

    public void sendAndValidateHttpStatus(final WebClient.RequestHeadersSpec<?> spec) {
        getResponseBody(spec);
    }

    private String getResponseBody(final WebClient.RequestHeadersSpec<?> spec) {
        return spec
                .exchangeToMono(clientResponse -> {
                    final var bodyStrMono = clientResponse.bodyToMono(String.class);
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return bodyStrMono;
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return bodyStrMono.flatMap(errorBody -> Mono.error(
                                new InternalServerException(String.format(
                                        "Response failed with 4xx: %s, and message is: %s",
                                        clientResponse.statusCode(), errorBody
                                )))
                        );
                    } else if (clientResponse.statusCode().is5xxServerError()) {
                        return bodyStrMono.flatMap(errorBody -> {
                            final var message = String.format(
                                    "Response failed with 5XX: %s, and message is: %s. "
                                    + "Throwing VendorInvokedException",
                                    clientResponse.statusCode(),
                                    errorBody
                            );
                            return Mono.error(new VendorInvokedException(
                                    ResultCode.GATEWAY_ERROR,
                                    message
                            ));
                        });
                    } else {
                        return bodyStrMono.flatMap(errorBody -> {
                            log.error(
                                    "Response received unsupported HttpStatus code: {}, "
                                    + "and message is: {}",
                                    clientResponse.statusCode(),
                                    errorBody
                            );
                            return clientResponse.createException().flatMap(Mono::error);
                        });
                    }
                })
                .block();
    }



    public boolean getResponseFlag(final WebClient.RequestHeadersSpec<?> spec) {

         spec.exchangeToMono(clientResponse -> {
                    Mono<String> bodyStrMono = clientResponse.bodyToMono(String.class);
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        atomicBoolean.set(true);
                        return bodyStrMono;
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        atomicBoolean.set(false);
                        return bodyStrMono.flatMap(errorBody -> Mono.error(
                                new InternalServerException(String.format(
                                        "Response failed with 4xx: %s, and message is: %s",
                                        clientResponse.statusCode(), errorBody
                                )))
                        );
                    } else if (clientResponse.statusCode().is5xxServerError()) {
                        atomicBoolean.set(false);
                        return bodyStrMono.flatMap(errorBody -> {
                            final var message = String.format(
                                    "Response failed with 5XX: %s, and message is: %s. "
                                            + "Throwing VendorInvokedException",
                                    clientResponse.statusCode(),
                                    errorBody
                            );
                            return Mono.error(new VendorInvokedException(
                                    ResultCode.GATEWAY_ERROR,
                                    message
                            ));
                        });
                    } else {
                        atomicBoolean.set(false);
                        return bodyStrMono.flatMap(errorBody -> {
                            log.error(
                                    "Response received unsupported HttpStatus code: {}, "
                                            + "and message is: {}",
                                    clientResponse.statusCode(),
                                    errorBody
                            );
                            return clientResponse.createException().flatMap(Mono::error);
                        });
                    }
                })
                .block();
         return atomicBoolean.get();
    }
}
