package com.example.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Horario {

    private String solicitacao;
    private String liquidacao;
}
