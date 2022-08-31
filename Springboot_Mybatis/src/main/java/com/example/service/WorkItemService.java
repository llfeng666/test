package com.example.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.example.entity.PayInDukpay;
import com.example.entity.WorkItem;
import com.example.entity.WorkItemResponse;
import com.example.enums.PayInTableNames;
import com.example.mapper.WorkItemMapper;
import com.example.utils.DateUtils;
import jodd.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkItemService {

    @Autowired
    private WorkItemMapper workItemMapper;

    @Autowired
    private Bs2QueryService bs2QueryService;

    public WorkItemResponse queryCallBackInfo(String idempotencyKey, String coName){
        final String tableName = PayInTableNames.findTableName(coName);
        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey,tableName);
        List<WorkItem> workItems = workItemMapper.queryByGroupId(payInDukpay.getInternalTransactionId());
        if(Objects.isNull(workItems)){
            return null;
        }
        final WorkItem workItem = workItems.get(0);
        Date updateTime=new Date(workItem.getUpdateTime().getTime());
        Date createTime=new Date(workItem.getCreateTime().getTime());
        final String updateTimeDate =
                DateUtils.getFormatDate(updateTime, "yyyy-MM-dd HH:mm:ss");

        final String createTimeDate =
                DateUtils.getFormatDate(createTime, "yyyy-MM-dd HH:mm:ss");

        final WorkItemResponse workItemResponse = WorkItemResponse.builder().status(workItem.getStatus())
                .updateTime(updateTimeDate)
                .createTime(createTimeDate)
                .build();
        return workItemResponse;
    }

}
