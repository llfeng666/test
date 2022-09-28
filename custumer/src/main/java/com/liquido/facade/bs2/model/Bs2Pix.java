package com.liquido.facade.bs2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Bs2Pix {


    private String status;



    private  String endToEndId;


    private String txId;


    private double valor;

    private String horario;


    private PixPayer payer;


    private String payerComment;

    private List<Devolucoes>devolucoes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public PixPayer getPayer() {
        return payer;
    }

    public void setPayer(PixPayer payer) {
        this.payer = payer;
    }

    public String getPayerComment() {
        return payerComment;
    }

    public void setPayerComment(String payerComment) {
        this.payerComment = payerComment;
    }

    public List<Devolucoes> getDevolucoes() {
        return devolucoes;
    }

    public void setDevolucoes(List<Devolucoes> devolucoes) {
        this.devolucoes = devolucoes;
    }

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
