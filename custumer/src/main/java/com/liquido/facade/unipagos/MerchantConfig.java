package com.liquido.facade.unipagos;

import java.time.ZoneId;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("PMD.TooManyFields")
public class MerchantConfig {
    private String apiKeyName;
    private String apiKey;
    private String keyStoreType;
    private String keyStorePassword;
    private String keyStoreFileName;
    private String speiDescription;
    private String tableName;   // different apiKey will use different payout table
    private ZoneId clientTimeZoneId;
    private Long maxAmountCents;
    private Long minAmountCents;

    private String merchantCode;
    private String arcusInstrumentId;
    private String arcusAccountId;
    private String arcusAccountNumber;

    @Getter(AccessLevel.NONE)
    String payoutNotifyUrl;

    public Optional<String> getPayoutNotifyUrl() {
        return Optional.ofNullable(payoutNotifyUrl);
    }

    @Getter(AccessLevel.NONE)
    String paybackNotifyUrl;

    public Optional<String> getPaybackNotifyUrl() {
        return Optional.ofNullable(paybackNotifyUrl);
    }

    @Getter(AccessLevel.NONE)
    String clientWebhookSecret;

    public Optional<String> getClientWebhookSecret() {
        return Optional.ofNullable(clientWebhookSecret);
    }

}
