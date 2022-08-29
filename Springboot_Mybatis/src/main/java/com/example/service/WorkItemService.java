package com.example.service;

import java.util.Date;

import com.example.entity.PayInDukpay;
import com.example.entity.WorkItem;
import com.example.entity.WorkItemResponse;
import com.example.enums.TableNames;
import com.example.mapper.WorkItemMapper;
import com.example.utils.DateUtils;
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
        final String tableName = TableNames.findTableName(coName);
        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey,tableName);
        WorkItem workItem = workItemMapper.queryByGroupId(payInDukpay.getInternalTransactionId());

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
