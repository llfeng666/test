package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoMessage {
    @JsonProperty("linha1")
    String line1;
    public Optional<String> getLine1() {
        return Optional.ofNullable(line1);
    }

    @JsonProperty("linha2")
    String line2;
    public Optional<String> getLine2() {
        return Optional.ofNullable(line2);
    }

    @JsonProperty("linha3")
    String line3;
    public Optional<String> getLine3() {
        return Optional.ofNullable(line3);
    }

    @JsonProperty("linha4")
    String line4;
    public Optional<String> getLine4() {
        return Optional.ofNullable(line4);
    }
}
