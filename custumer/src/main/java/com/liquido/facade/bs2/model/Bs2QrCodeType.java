package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Bs2QrCodeType {
    @JsonProperty("Estatico")
    STATIC,

    @JsonProperty("Dinamico")
    DYNAMIC

}
