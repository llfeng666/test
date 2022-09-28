package com.liquido.facade.bs2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Devolucoes {

   private String  id;
      private String rtrId;
    private String  valor;
    private Horario  horario;
    private String status;
    private String motivo;
}
