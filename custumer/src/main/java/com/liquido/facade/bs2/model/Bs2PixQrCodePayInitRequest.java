package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bs2PixQrCodePayInitRequest {

    @JsonProperty("qrCode")
    @NonNull
    String qrCode;
}
