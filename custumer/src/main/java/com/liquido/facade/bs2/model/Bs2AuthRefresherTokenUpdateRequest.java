package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2AuthRefresherTokenUpdateRequest {
    @NonNull
    String refreshToken;
}
