package com.liquido.facade.bs2.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Preconditions;

public final class QrCode implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String code;

    private QrCode(final String code) {
        Preconditions.checkArgument(code != null, "null QR code");
        this.code = code;
    }

    @JsonCreator
    public static QrCode valueOf(final String str) {
        return new QrCode(str);
    }

    @Override
    @JsonValue
    public String toString() {
        return code;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof QrCode)) {
            return false;
        }
        final QrCode other = (QrCode) obj;
        return Objects.equals(code, other.code);
    }

    public String getTextCode() {
        return code;
    }
}
