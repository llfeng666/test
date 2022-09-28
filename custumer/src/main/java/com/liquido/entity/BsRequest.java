package com.liquido.entity;


import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BsRequest {

    private String idempotencyKey;

    @NotNull(message = "e2eId不能为空")
    private String e2eId;

    @NotNull(message = "商户名称不能为空")
    private String coName;


}