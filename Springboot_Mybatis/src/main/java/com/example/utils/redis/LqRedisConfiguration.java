package com.example.utils.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        HttpLqRedisClient.class,
        RedisConfig.class
})
public class LqRedisConfiguration {
}
