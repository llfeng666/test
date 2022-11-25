package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2RefreshTokenOauthResponse {
    @JsonProperty("access_token")
    @NonNull
    String accessToken;

    @JsonProperty("token_type")
    @NonNull
    String tokenType;

    @JsonProperty("expires_in")
    @NonNull
    Long expiresIn;

    @JsonProperty("scope")
    @NonNull
    String scope;

    @JsonProperty("refresh_token")
    @NonNull
    String refreshToken;
}
