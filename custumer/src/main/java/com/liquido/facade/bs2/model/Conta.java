package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Conta {

    private String banco;
    private String bancoNome;
    private String agencia;
    private String numero;
    private String tipo;
}
