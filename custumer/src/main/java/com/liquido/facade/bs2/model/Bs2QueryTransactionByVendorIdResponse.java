package com.liquido.facade.bs2.model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Bs2QueryTransactionByVendorIdResponse {

    @JsonProperty("calendario")
    Bs2CalendarDateTimeInfo calendarInfo;

    @JsonProperty("status")
    Bs2TransactionStatus status;

    @JsonProperty("txId")
    String txId;

    public Optional<String> getTxId() {
        return Optional.ofNullable(txId);
    }

    @JsonProperty("revisao")
    int version;

    @JsonProperty("location")
    String location;

    public Optional<String> getLocation() {
        return Optional.ofNullable(location);
    }


    @JsonProperty("devedor")
    Bs2DebtorInfo debtor;

    public Optional<Bs2DebtorInfo> getDebtor() {
        return Optional.ofNullable(debtor);
    }

    @JsonProperty("valor")
    Valor value;

    public Optional<Valor> getValue() {
        return Optional.ofNullable(value);
    }

    /**
     * Should be the receiver side's PIX key. i.e. Liquido's PIX key
     */
    @JsonProperty("chave")
    String pixKey;

    public Optional<String> getPixKey() {
        return Optional.ofNullable(pixKey);
    }

    @JsonProperty("solicitacaoPagador")
    String payerComment;

    public Optional<String> getPayerComment() {
        return Optional.ofNullable(payerComment);
    }

    @JsonProperty("infoAdicionais")
    String infoAdicionais;

    public Optional<String> getInfoAdicionais() {
        return Optional.ofNullable(infoAdicionais);
    }


    @JsonProperty("pix")
    List<Bs2VendorResponsePix> pix;


}
