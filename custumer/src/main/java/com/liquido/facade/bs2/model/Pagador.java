package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Pagador {

    private String ispb;

    private Conta conta;

    private Pessoa pessoa;




}
