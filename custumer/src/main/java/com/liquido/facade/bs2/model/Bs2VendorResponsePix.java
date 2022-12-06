package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bs2VendorResponsePix {

    @JsonProperty("status")
    private String status;


    @JsonProperty("endToEndId")
    private  String endToEndId;

    @JsonProperty("txId")
    private String txId;

    @JsonProperty("valor")
    private double valor;


    @JsonProperty("horario")
    private String horario;


    @JsonProperty("pagador")
    private PixPayer pagador;

    @JsonProperty("infoPagador")
    private String infoPagador;

    @JsonProperty("devolucoes")
    private List<Devolucoes>devolucoes;


    @Builder
    public static class PixPayer {
        @JsonProperty("cpf")
        String cpf;


        @JsonProperty("cnpj")
        String cnpj;


        @JsonProperty("nome")
        String name;

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
