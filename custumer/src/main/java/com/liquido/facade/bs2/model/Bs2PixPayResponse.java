package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Bs2PixPayResponse {

    @NonNull
    String endToEndId;

    @NonNull
    String status;

    @JsonProperty("recebedor")
    Bs2PayerPayee receiver;

    public Optional<Bs2PayerPayee> getReceiver() {
        return Optional.ofNullable(receiver);
    }

    @JsonProperty("cobranca")
    Bs2Charge charger;

    public Optional<Bs2Charge> getCharger() {
        return Optional.ofNullable(charger);
    }

    @JsonProperty("erro")
    Bs2Error error;

    public Optional<Bs2Error> getError() {
        return Optional.ofNullable(error);
    }
}
