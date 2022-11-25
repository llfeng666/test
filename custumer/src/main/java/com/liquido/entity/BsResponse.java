package com.liquido.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BsResponse {

    private String errorCode;

    private String errorMsg;

    private String status;

    private String eId;

}
