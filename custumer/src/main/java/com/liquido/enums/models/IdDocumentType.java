package com.liquido.enums.models;

public enum IdDocumentType {
    CPF("cpf"),
    CNPJ("cnpj");

    private String commonName;

    IdDocumentType(final String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
