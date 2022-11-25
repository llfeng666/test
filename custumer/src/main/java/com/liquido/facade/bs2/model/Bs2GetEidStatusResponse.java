package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2GetEidStatusResponse {
    @JsonProperty("endToEndId")
    private String endToEndId;

    @JsonProperty("recebimentoId")
    private int recebimentoId;

    @JsonProperty("txId")
    private String txId;

    @JsonProperty("data")
    private String data;

    @JsonProperty("valor")
    private double valor;

    @JsonProperty("status")
    private String status;

    @JsonProperty("chaveDict")
    private  String chaveDict;

    @JsonProperty("campoLivre")
    private String campoLivre;

    @JsonProperty("situacao")
    private  String situacao;

    @JsonProperty("devolucoes")
    private List<Devolucoes> devolucoes;

    @JsonProperty("pagador")
    private Pagador pagador;

    @JsonProperty("recebedor")
    private Recebedor recebedor;

    @JsonProperty("pagina")
    private Pagina pagina;



}
