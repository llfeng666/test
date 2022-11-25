package com.liquido.entity;


import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Value
@Data
@Builder
public class NanoPayRequest {

    @NotNull(message = "accountId不能为空")
    private String accountId;

    @NotNull(message = "amount不能为空")
    private String amount;



}