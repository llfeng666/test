package com.example.entity;


import lombok.NonNull;

public class BsRequest {

    @NonNull
    private String idempotencyKey;

    @NonNull
    private String eid;

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }
}
