package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Bs2PixPayConfirmRequest {

    @JsonProperty("recebedor")
    @JsonAlias("receiver")
    Bs2PayerPayee receiver;        // receiver, got via the PIX payment initiation endpoint

    public Optional<Bs2PayerPayee> getReceiver() {
        return Optional.ofNullable(receiver);
    }

    @JsonProperty("valor")
    @JsonAlias("value")
    double value;

    @JsonProperty("campoLivre")
    @JsonAlias("freeField")
    String freeField;              // free field

    public Optional<String> getFreeField() {
        return Optional.ofNullable(freeField);
    }

    @JsonProperty("efetuarEm")
    @JsonAlias("effectOn")
    String effectOn;               // effect on ?

    public Optional<String> getEffectOn() {
        return Optional.ofNullable(effectOn);
    }
}

/*

https://devs.bs2.com/manual/pix-clientes/'?json#pagamento-confirmar

{
    "recebedor": {
        "ispb": "string",
        "conta": {
            "agencia": "string",
            "numero": "string",
            "tipo": "ContaCorrente" // enum: "ContaCorrente",
             "ContaSalario", "Poupanca", "ContaPagamento"
        },
        "pessoa": {
            "documento": "string",
            "tipoDocumento": "CPF", // enum: "CPF", "CNPJ"
            "nome": "string",
            "nomeFantasia": "string"
        }
    },
    "valor": 0,
    "campoLivre": "string",
    "efetuarEm": "2021-8-2T22:50:57.650Z"
}
 */
