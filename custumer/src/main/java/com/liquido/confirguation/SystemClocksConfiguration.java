package com.liquido.confirguation;

import java.time.Clock;

import com.google.common.base.Ticker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemClocksConfiguration {
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
