package com.liquido.facade.bs2.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class Bs2BoletoDto extends Bs2BoletoCreateResponse {
    /**
     * Amount paid for the ticket. Example: 995.55 This amount is filled in when
     * the payment slip is paid in the banking network. If the ticket is
     * paid in BS2 itself, this amount will only be filled in together with the
     * ValorLiquidado field.
     */
    @JsonProperty("valorPago")
    double amountPaid;

    /**
     * Settled value of the ticket. Example: 995.55 Unlike the amount paid, the amount
     * settled is the exact amount that enters the account, and occurs on D+1.
     */
    @JsonProperty("valorLiquidado")
    double amountSettled;

    @JsonProperty("carteira")
    Bs2BoletoWallet wallet;
    public Optional<Bs2BoletoWallet> getWallet() {
        return Optional.ofNullable(wallet);
    }

    @JsonProperty("movimento")
    String movementDate;
    public Optional<String> getMovementDate() {
        return Optional.ofNullable(movementDate);
    }

    /**
     * Ticket issuance date
     */
    @JsonProperty("emissao")
    String issueDate;
    public Optional<String> getIssueDate() {
        return Optional.ofNullable(issueDate);
    }

    /**
     * Date of notification of payment of the ticket
     */
    @JsonProperty("notificacaoPagamento")
    String paymentNotificationDate;
    public Optional<String> getPaymentNotificationDate() {
        return Optional.ofNullable(paymentNotificationDate);
    }

    @JsonProperty("pagamento")
    String paymentDate;
    public Optional<String> getPaymentDate() {
        return Optional.ofNullable(paymentDate);
    }

    @JsonProperty("cancelamento")
    String cancelDate;
    public Optional<String> getCancelDate() {
        return Optional.ofNullable(cancelDate);
    }

    @JsonProperty("registrado")
    boolean isRegisteredWithCip;

    /**
     * A BS2 enum. Currently unused. Should change to an enum class once the field is looked at
     */
    @JsonProperty("naturezaDaOperacaoDePagamento")
    int natureOfPayment;

    @JsonProperty("bancoPagamento")
    int paymentBankCode;

    @JsonProperty("agenciaPagamento")
    int paymentAgencyCode;

    @JsonProperty("canalPagamento")
    int paymentChannelCode;

    @JsonProperty("dataLimitePagamento")
    String paymentDeadline;
    public Optional<String> getPaymentDeadline() {
        return Optional.ofNullable(paymentDeadline);
    }
}
