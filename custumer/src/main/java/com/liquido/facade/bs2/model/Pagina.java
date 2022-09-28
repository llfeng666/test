package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Pagina {

   private int  qtd;
    private int paginaAtual;
    private int itensPorPagina;
}
