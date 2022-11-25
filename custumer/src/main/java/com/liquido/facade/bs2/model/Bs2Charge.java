package com.liquido.facade.bs2.model;

import java.util.Optional;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Bs2Charge {
    String id;

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    // TODO  Ignored other fields since they are unused for now
}
