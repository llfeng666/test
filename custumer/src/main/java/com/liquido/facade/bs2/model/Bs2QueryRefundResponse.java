package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2QueryRefundResponse {

    private String endToEndId;

    private String txid;

    private String valor;

    private String horario;

    @JsonProperty("pagador")
    private Pagador pagador;

    private String infoPagador;

    @JsonProperty("devolucoes")
    private List<Devolucoes> devolucoes;

}
