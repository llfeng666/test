package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2CalendarDateTimeInfo {
    // EX: billing expiration date
    @JsonProperty("expiracao")
    int expirationDate;

    @JsonProperty("criacao")
    String creationDate;

    public Optional<String> getCreationDate() {
        return Optional.ofNullable(creationDate);
    }
}
