package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2PixPayWithKeyResponse {

    @JsonProperty("identificador")
    @NonNull
    String idempotencyKey;

    @JsonProperty("solicitacaoId")
    @NonNull
    String solicitationId;

    @JsonProperty("chave")
    @NonNull
    Bs2PixKey key;

    @JsonProperty("valor")
    double value;

    @JsonProperty("errors")
    String error;

    public Optional<String> getError() {
        return Optional.ofNullable(error);
    }


}
