package com.liquido.facade.bs2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * Init PIX payment using PIX key
 * https://devs.bs2.com/manual/pix-clientes/#pagamento-iniciar-pagamento-por-chave
 * /pix/direto/forintegration/v1/pagamentos/chave
 */
@Value
@Builder
public class Bs2PixPayInitRequest {
    @JsonProperty("chave")
    @NonNull
    Bs2PixKey key;
}
