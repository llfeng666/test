package com.liquido.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkItemResponse {
    private String status;

    private String createTime;

    private String updateTime;

    private String workGroupId;

    private String errorMsg;
}
