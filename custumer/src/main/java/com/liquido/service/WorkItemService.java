package com.liquido.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;


import cn.hutool.core.collection.CollUtil;
import com.liquido.entity.PayInDukpay;
import com.liquido.entity.WorkItem;
import com.liquido.entity.WorkItemResponse;
import com.liquido.enums.PayInTableNames;
import com.liquido.mapper.WorkItemMapper;
import com.liquido.utils.DateUtils;
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
        if(Objects.isNull(payInDukpay)){
            log.error("幂等键 {} 在payin 查询不到记录",idempotencyKey);
            return WorkItemResponse.builder().errorMsg("幂等键在payin 查询不到记录").build();
        }
        if(!"SETTLED".equals(payInDukpay.getTransferStatus())){
            log.error("该订单状态:{}",payInDukpay.getTransferStatus());
            return WorkItemResponse.builder().errorMsg("该订单状态:"+payInDukpay.getTransferStatus()).build();
        }

        List<WorkItem> workItems = workItemMapper.queryByGroupId(payInDukpay.getInternalTransactionId());
        if(CollUtil.isEmpty(workItems)){
            log.error("无回调记录:");
            return WorkItemResponse.builder().errorMsg("无回调记录").build();
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
