package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Bs2PixQrCodeQueryResponse {
    @JsonProperty("items")
    List<Bs2PixQrCodeInfo> pixQrCodeInfos;

    public List<Bs2PixQrCodeInfo> getPixQrCodeInfos() {
        if (pixQrCodeInfos == null) {
            return List.of();
        }
        return pixQrCodeInfos;
    }

    // This field is not in use
    @JsonProperty("pagina")
    JsonNode pageInfo;
}
