package com.liquido.utils.redis;

import java.util.Optional;

public interface LqRedisClient {
    default long getLong(final String key) {
        final var result = findLong(key);
        if (!result.isPresent()) {
            throw new RedisKeyNotFoundException(key);
        }
        return result.get();
    }

    Optional<Long> findLong(final String key);

    boolean deleteLong(final String key);

    default double getDouble(final String key) {
        final var result = findDouble(key);
        if (!result.isPresent()) {
            throw new RedisKeyNotFoundException(key);
        }
        return result.get();
    }

    Optional<Double> findDouble(final String key);

    boolean deleteDouble(final String key);

    default <T> T get(final String key, final Class<T> clazz) {
        final var result = find(key, clazz);
        if (!result.isPresent()) {
            throw new RedisKeyNotFoundException(key);
        }
        return result.get();
    }

    <T> Optional<T> find(final String key, final Class<T> clazz);

    boolean deleteObject(String key);

    void save(String key, long value);

    void save(String key, long value, long expirationMs);

    void save(String key, double value);

    void save(String key, double value, long expirationMs);

    void save(String key, Object value);

    void save(String key, Object value, long expirationMs);

    /**
     * True if rate limiter under this key has been initialized before.
     */
    boolean rateLimiterExists(String rateLimiterKey);

    /**
     * True if rate limiter exists and successfully deleted
     */
    boolean deleteRateLimiter(String rateLimiterKey);

    /**
     * RateLimiters
     */
    void initRateLimiter(String rateLimiterKey, long maxAllowedPermits, long rateIntervalInMs);

    /**
     * @return True if the rate limiter permits are available and acquired. Returns false
     *         immediately if the number of permits requested is not available.
     */
    boolean tryAcquireRateLimiter(String rateLimiterKey, long permits);

    boolean tryAcquireRateLimiter(String rateLimiterKey, long permits, long timeoutInMs);

    void acquireRateLimiter(String rateLimiterKey, long permits);

    long availablePermits(String rateLimiterKey);

    /**
     * Simple locking interface. Will update this once we merge PR 164
     * @return
     */
    boolean tryLock(String key, long timeoutInMillis);

    void unlock(String key);
}
