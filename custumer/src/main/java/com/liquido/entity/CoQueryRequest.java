package com.liquido.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CoQueryRequest {

    private String idempotencyKey;


    private String eId;

    private String  tableName;


    private String  vendorId;



}
