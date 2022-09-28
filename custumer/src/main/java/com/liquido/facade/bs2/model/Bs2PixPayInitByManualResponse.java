package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * BS2 PIX payment required two steps: first init the payment either by PIX key
 * or manually input the bank info, then
 * confirm with the payment id returned by the fist step.
 * <p>
 * The following two endpoints return same response:
 * /pix/direto/forintegration/v1/pagamentos/chave
 * /pix/direto/forintegration/v1/pagamentos/manual
 */
@Value
@Builder
public class Bs2PixPayInitByManualResponse {
    @JsonProperty("pagamentoId")
    @NonNull
    String paymentId;         // payment id

    @NonNull
    String endToEndId;          // end to end id, transaction id

    @JsonProperty("recebedor")
    Bs2PayerPayee receiver;    // receiver

    public Optional<Bs2PayerPayee> getReceiver() {
        return Optional.ofNullable(receiver);
    }

    @JsonProperty("pagador")
    Bs2PayerPayee payer;      // payer

    public Optional<Bs2PayerPayee> getPayer() {
        return Optional.ofNullable(payer);
    }
}

/*
{
    "pagamentoId": "b88d23bb-8636-4a5d-b28c-179adbba8e6a",
    "endToEndId": "E710278662021100122300143121791P",
    "recebedor": {
        "ispb": "71027866",
        "conta": {
            "banco": "218",
            "bancoNome": "BCO BS2 S.A.",
            "agencia": "0001",
            "numero": "3141004",
            "tipo": "ContaPagamento"
        },
        "pessoa": {
            "documento": "28906563000162",
            "tipoDocumento": "CNPJ",
            "nome": "PSITTOPIX3",
            "nomeFantasia": null
        }
    },
    "pagador": {
        "ispb": "71027866",
        "conta": {
            "banco": "218",
            "bancoNome": "BCO BS2 S.A.",
            "agencia": "0001",
            "numero": "8354294",
            "tipo": "ContaCorrente"
        },
        "pessoa": {
            "documento": "43215655000190",
            "tipoDocumento": "CNPJ",
            "nome": "Liquido BRL",
            "nomeFantasia": null
        }
    }
}
 */
