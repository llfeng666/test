package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Pessoa {

   private String   documento;
    private String  tipoDocumento;
    private String  nome;
    private String  nomeFantasia;
    private String  conta;
}
