package com.liquido.utils.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "redis")
@Configuration
@Data
@Slf4j
public class RedisConfig {
    private String address;
    private String namespace;
}
