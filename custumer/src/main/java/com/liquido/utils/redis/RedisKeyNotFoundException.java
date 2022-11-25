package com.liquido.utils.redis;

public class RedisKeyNotFoundException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public RedisKeyNotFoundException(final String key) {
        super("Redis key not found: " + key);
    }
}
