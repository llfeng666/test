package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Bs2PixPayWithKeyRequest {

    @JsonProperty("solicitacoes")
    List<Bs2PixSolicitationItem> items;

    public List<Bs2PixSolicitationItem> getItems() {
        if (items == null) {
            return List.of();
        }
        return items;
    }

}
