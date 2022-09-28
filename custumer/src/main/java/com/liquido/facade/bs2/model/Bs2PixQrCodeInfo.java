package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.apache.http.util.TextUtils;

@EqualsAndHashCode(callSuper = true)
@Value
@AllArgsConstructor
public class Bs2PixQrCodeInfo extends Bs2PixPayInCreateQrCodeResponse {
    @JsonProperty("qrCodeId")
    int qrCodeId;

    @JsonProperty("tipo")
    @NonNull
    Bs2QrCodeType qrCodeType;

    @JsonProperty("dataValidade")
    @NonNull
    String expiresAt;

    @JsonProperty("valor")
    double value;

    @JsonProperty("status")
    @NonNull
    Bs2TransactionStatus status;

    @JsonProperty("link")
    String link;

    public Optional<String> getLink() {
        return TextUtils.isBlank(link) ? Optional.empty() : Optional.of(link);
    }

    @JsonProperty("campoLivre")
    String freeField;

    public Optional<String> getFreeField() {
        return TextUtils.isBlank(freeField) ? Optional.empty() : Optional.of(freeField);
    }

    @JsonProperty("valorRecebimento")
    double amountReceived;

    @JsonProperty("quantidadePagamento")
    int paymentQuantity;

    // This field is not in use
    @JsonProperty("chave")
    JsonNode key;

    // This field is not in use
    @JsonProperty("recebedor")
    JsonNode receiver;
}
