package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoStatusHistory {
    @JsonProperty("Status")
    @NonNull
    Bs2BoletoStatusHistoryStatus status;

    @JsonProperty("Descricao")
    String description;
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @JsonProperty("DataStatus")
    @NonNull
    String statusDate;
}
