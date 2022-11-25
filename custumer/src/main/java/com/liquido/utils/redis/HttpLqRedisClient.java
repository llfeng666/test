package com.liquido.utils.redis;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Service;

/**
 * https://www.baeldung.com/redis-redisson
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HttpLqRedisClient implements LqRedisClient {
    private final RedisConfig redisConfig;
    private RedissonClient redisClient;

    @PostConstruct
    public void initRedissonClient() {
        final var config = new Config();
        config.useSingleServer().setAddress(redisConfig.getAddress());
        // Will throw an exception if it fails to connect to the Redis server.
        redisClient = Redisson.create(config);
    }

    @PreDestroy
    public void shutdown() {
        if (redisClient != null) {
            try {
                redisClient.shutdown();
            } catch (final Exception e) {
                log.warn("failed to shutdown redis client", e);
            }
        }
    }

    @Override
    public Optional<Long> findLong(final String key) {
        final var rAtomicLong = redisClient.getAtomicLong(toInternalKey(key));
        if (!rAtomicLong.isExists()) {
            return Optional.empty();
        }
        return Optional.of(rAtomicLong.get());
    }

    @Override
    public boolean deleteLong(final String key) {
        return redisClient.getAtomicLong(toInternalKey(key)).delete();
    }

    @Override
    public Optional<Double> findDouble(final String key) {
        final var rAtomicDouble = redisClient.getAtomicDouble(toInternalKey(key));
        if (!rAtomicDouble.isExists()) {
            return Optional.empty();
        }
        return Optional.of(rAtomicDouble.get());
    }

    @Override
    public boolean deleteDouble(final String key) {
        return redisClient.getAtomicDouble(toInternalKey(key)).delete();
    }

    @Override
    public <T> Optional<T> find(final String key, final Class<T> clazz) {
        final var result = redisClient.getBucket(toInternalKey(key));
        if (!result.isExists()) {
            return Optional.empty();
        }
        return Optional.of(clazz.cast(result.get()));
    }

    @Override
    public boolean deleteObject(final String key) {
        return redisClient.getBucket(toInternalKey(key)).delete();
    }

    @Override
    public void save(final String key, final long value) {
        save(key, value, 0L);
    }

    @Override
    public void save(final String key, final long value, final long expirationMs) {
        redisClient.getAtomicLong(toInternalKey(key)).set(value);

        if (expirationMs > 0) {
            redisClient
                    .getAtomicLong(toInternalKey(key))
                    .expire(expirationMs, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void save(final String key, final double value) {
        save(key, value, 0L);
    }

    @Override
    public void save(final String key, final double value, final long expirationMs) {
        redisClient.getAtomicDouble(toInternalKey(key)).set(value);

        if (expirationMs > 0) {
            redisClient
                    .getAtomicDouble(toInternalKey(key))
                    .expire(expirationMs, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void save(final String key, final Object value) {
        save(key, value, 0L);
    }

    @Override
    public void save(final String key, final Object value, final long expirationMs) {
        redisClient.getBucket(toInternalKey(key)).set(value);

        if (expirationMs > 0) {
            redisClient
                    .getBucket(toInternalKey(key))
                    .expire(expirationMs, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public boolean rateLimiterExists(final String rateLimiterKey) {
        return toRateLimiter(rateLimiterKey).isExists();
    }

    @Override
    public boolean deleteRateLimiter(final String rateLimiterKey) {
        return toRateLimiter(rateLimiterKey).delete();
    }

    @Override
    public void initRateLimiter(
            final String rateLimiterKey,
            final long maxAllowedPermits,
            final long rateIntervalInMs
    ) {
        toRateLimiter(rateLimiterKey).setRate(
                RateType.OVERALL,
                maxAllowedPermits,
                rateIntervalInMs,
                RateIntervalUnit.MILLISECONDS);
    }

    @Override
    public boolean tryAcquireRateLimiter(final String rateLimiterKey, final long permits) {
        return toRateLimiter(rateLimiterKey).tryAcquire(permits);
    }

    @Override
    public boolean tryAcquireRateLimiter(
            final String rateLimiterKey,
            final long permits,
            final long timeoutInMs
    ) {
        return toRateLimiter(rateLimiterKey)
                .tryAcquire(permits, timeoutInMs, TimeUnit.MILLISECONDS);
    }

    @Override
    public void acquireRateLimiter(final String rateLimiterKey, final long permits) {
        toRateLimiter(rateLimiterKey).acquire(permits);
    }

    @Override
    public long availablePermits(final String rateLimiterKey) {
        return toRateLimiter(rateLimiterKey).availablePermits();
    }

    @Override
    public boolean tryLock(final String key, final long timeoutInMillis) {
        final var lock = redisClient.getLock(toInternalKey(key));
        try {
            return lock.tryLock(timeoutInMillis, TimeUnit.MILLISECONDS);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Interrupted while trying to acquire Redis lock: {} with timeoutInMillis {}",
                    key,
                    timeoutInMillis,
                    e);
            return false;
        }
    }

    @Override
    public void unlock(final String key) {
        final var lock = redisClient.getLock(toInternalKey(key));
        lock.unlock();
    }

    private RRateLimiter toRateLimiter(final String key) {
        return redisClient.getRateLimiter(toInternalKey(key));
    }

    private String toInternalKey(final String key) {
        return redisConfig.getNamespace() + "_" + key;
    }
}
