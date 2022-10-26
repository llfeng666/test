package com.liquido.enums;

public enum Vendor {
    BS2,
    BEXS,
    TUNA,
    BANKLY,
    PAYCASH,
    ARCUS,
    BANCOLOMBIA,
    BANORTE,
    // The following vendors are not used in production
    AME,
    PAYPAL,
    MERCADO_PAGO,
    PIC_PAY,
    // The following vendors are not used in production
    GESTOPAGO,
    HOLACASH,
    DLOCAL,
    OPENPAY,
    // This is a mock vendor to be configured (in the merchant service)
    // for clients who want to start testing our service in staging
    // before they get access to production
    MOCK_VENDOR,
    UNIPAGOS
}
