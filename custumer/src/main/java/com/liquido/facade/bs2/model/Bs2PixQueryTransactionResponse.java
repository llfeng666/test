package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Bs2PixQueryTransactionResponse extends Bs2PixBasicTransactionResponse {
    @JsonProperty("pix")
    @Getter(AccessLevel.NONE)
    List<Bs2Pix> pix;

    public List<Bs2Pix> getPix() {
        if (pix == null) {
            return List.of();
        }
        return pix;
    }
}
