package com.liquido.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnipagosRequest {

    private String accountId;


    private String amount;



}