package com.liquido.facade.bs2;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.liquido.exceptions.InternalServerException;
import com.liquido.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.liquido.facade.bs2.model.Bs2AuthRefresherTokenUpdateRequest;
import com.liquido.utils.redis.LqRedisClient;
import com.google.common.base.Verify;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Bs2V2OauthAccessTokenProvider {
    private static final String REDIS_REFRESH_TOKEN_KEY = "REFRESH_TOKEN";
    private static final String REDIS_REFRESH_TOKEN_LOCK_KEY = REDIS_REFRESH_TOKEN_KEY + "_LOCK";
    private static final String REDIS_ACCESS_TOKEN_KEY = "BS2_ACCESS_TOKEN";

    private static final long LOCK_WAIT_TIME_IN_MILLIS = 3000;

    private final Bs2RefreshTokenOauthClient bs2OauthClient;
    private final LqRedisClient redisClient;

    private Optional<String> lastRefreshToken = Optional.empty();

    /**
     * Provides a RESTAPI interface for updating refresh token to use
     */
    String updateRefreshToken(
            final HttpServletRequest request,
            @RequestBody final Bs2AuthRefresherTokenUpdateRequest req
    ) {
        final var token = req.getRefreshToken();
        final var watch = StopWatch.createStarted();
        log.info("Updating refresh token with value: {} and starting a round of auth refresh...",
                token);
        Optional<String> newRefreshToken;
        synchronized (this) {
            newRefreshToken = tryAuthSafe(Optional.of(token));
        }
        Verify.verify(newRefreshToken.isPresent(), "the new refresh token obtained is empty");
        log.info(
                "Refresh with token: {} finished in {}. The new refresh token retrieved is: {}",
                token,
                watch,
                newRefreshToken.get());
        return newRefreshToken.get();
    }

    ResponseEntity<String> getCurrentAccessTokenReq(final HttpServletRequest request) {
        final var accessTokenOpt = getAccessTokenFromRedis();
        if (accessTokenOpt.isEmpty()) {
            return new ResponseEntity<>("Missing access token", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(accessTokenOpt.get(), HttpStatus.OK);
    }

    public String getCurrentAccessToken() {
        return getAccessTokenFromRedis().orElseThrow(
                () -> new InternalServerException("Missing access token for BS2"));
    }

    public String updateRefreshToken(final String refreshToken) {
        return updateRefreshToken(
                null,
                Bs2AuthRefresherTokenUpdateRequest
                        .builder()
                        .refreshToken(refreshToken)
                        .build());
    }

    @Scheduled(
            // Using a hardcoded value of expiration times observed in BS2 real response.
            fixedRate =
                    (Bs2CommonConfigs.BS2_PROD_TOKEN_EXPIRES_IN_SECONDS
                            - Bs2CommonConfigs.TOKEN_EXPIRATION_BUFFER_IN_SECONDS)
                            * DateUtils.MILLIS_PER_SECOND,
            initialDelay = 5 * DateUtils.MILLIS_PER_SECOND
    )
    synchronized Optional<String> scheduledBs2RefreshTokenAuth() {
        return tryAuthSafe(Optional.empty());
    }

    private Optional<String> tryAuthSafe(final Optional<String> tokenToUse) {
        final var refreshTokenBefore = lastRefreshToken;
        try {
            return tryAuthUnsafe(tokenToUse);
        } catch (final Exception e) {
            log.error("Failed to refresh BS2 authentication. Refresh token before: {}."
                            + " Next refresh token stored: {}",
                    refreshTokenBefore,
                    lastRefreshToken,
                    e);
            return Optional.empty();
        }
    }

    private Optional<String> tryAuthUnsafe(final Optional<String> reqToken) {
        final var redisToken = getRefreshTokenFromRedis();
        // Update the last refresh token in case the refresh attempt fails
        lastRefreshToken = redisToken;
        if (reqToken.isEmpty() && redisToken.isEmpty()) {
            log.info("Skipping refresh since no refresh token provided...");
            return Optional.empty();
        }
        final var nextTokenToUse = reqToken.orElseGet(redisToken::get);

        log.info("About to start auth refresh with refresh token: {}", nextTokenToUse);

        final var nextTokenResp = bs2OauthClient.authRequest(nextTokenToUse);
        // Remember it locally first before attempting to store the new token in Redis
        lastRefreshToken = Optional.of(nextTokenResp.getRefreshToken());
        saveRefreshTokenToRedis(nextTokenResp.getRefreshToken());
        final var accessToken = nextTokenResp.getAccessToken();
        saveAccessTokenToRedis(accessToken);
        log.info("Finished auth refresh. Token before: {}, "
                        + "token after: {}. current access token: {}",
                nextTokenToUse,
                lastRefreshToken,
                accessToken);
        redisClient.unlock(REDIS_REFRESH_TOKEN_LOCK_KEY);
        return Optional.of(nextTokenResp.getRefreshToken());
    }

    private Optional<String> getRefreshTokenFromRedis() {
        final var locked =
                redisClient.tryLock(REDIS_REFRESH_TOKEN_LOCK_KEY, LOCK_WAIT_TIME_IN_MILLIS);
        if (!locked) {
            throw new RuntimeException("Failed to acquire Redis lock for refresh token update");
        }
        return redisClient.find(REDIS_REFRESH_TOKEN_KEY, String.class);
    }

    private Optional<String> getAccessTokenFromRedis() {
        return redisClient.find(REDIS_ACCESS_TOKEN_KEY, String.class);
    }

    private void saveRefreshTokenToRedis(final String token) {
        // Setting a really long expiration time because:
        // 1: When BS2 fails with 500, we can try to auth again with the same refresh token
        // 2: For debugging purpose
        redisClient.save(
                REDIS_REFRESH_TOKEN_KEY,
                token,
                Bs2CommonConfigs.BS2_PROD_TOKEN_EXPIRES_IN_SECONDS
                        * DateUtils.MILLIS_PER_SECOND * 5);
    }

    private void saveAccessTokenToRedis(final String token) {
        redisClient.save(
                REDIS_ACCESS_TOKEN_KEY,
                token,
                (Bs2CommonConfigs.BS2_PROD_TOKEN_EXPIRES_IN_SECONDS
                        - Bs2CommonConfigs.TOKEN_EXPIRATION_BUFFER_IN_SECONDS)
                        * DateUtils.MILLIS_PER_SECOND);
    }
}
