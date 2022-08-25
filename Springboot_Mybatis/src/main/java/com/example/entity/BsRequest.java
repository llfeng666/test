package com.example.entity;


import lombok.NonNull;

public class BsRequest {

    @NonNull
    private String idempotencyKey;

    @NonNull
    private String e2eId;

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getE2eId() {
        return e2eId;
    }

    public void setE2eId(String e2eId) {
        this.e2eId = e2eId;
    }
}
