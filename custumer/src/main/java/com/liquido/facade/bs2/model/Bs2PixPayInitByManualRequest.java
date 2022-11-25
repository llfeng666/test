package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

/**
 * Init TED via PIX payment
 * https://devs.bs2.com/manual/pix-clientes/#pagamento-iniciar-pagamento-por-manual
 * /pix/direto/forintegration/v1/pagamentos/manual
 */
@Value
@Builder
public class Bs2PixPayInitByManualRequest {
    @JsonProperty("recebedor")
    Bs2PayerPayee receiver;
}

/*
{
    "recebedor": {
        "ispb": "04184779",
        "conta": {
            "agencia": "5885",
            "numero": "00026182",
            "tipo": "Poupanca" // enum: "ContaCorrente",
            "ContaSalario", "Poupanca", "ContaPagamento"
        },
        "pessoa": {
            "documento": "42162599449",
            "tipoDocumento": "CPF",
            "nome": "Paulo Graciano da silva",
            "nomeFantasia": "Graciano"
        }
    }
}
 */
