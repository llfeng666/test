package com.liquido.entity.vo;


public class BsRequestForm {

    private String idempotencykey;

    private String e2eId;

    private String coName;

    public String getE2eId() {
        return e2eId;
    }

    public void setE2eId(String e2eId) {
        this.e2eId = e2eId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getIdempotencykey() {
        return idempotencykey;
    }

    public void setIdempotencykey(String idempotencykey) {
        this.idempotencykey = idempotencykey;
    }

}