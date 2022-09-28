package com.liquido.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BsRequest {

    private String idempotencyKey;


    private String e2eId;

    private String coName;


}