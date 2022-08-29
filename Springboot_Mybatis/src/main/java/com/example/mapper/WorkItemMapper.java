package com.example.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.WorkItem;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_VIRGO)
public interface WorkItemMapper {

    WorkItem queryByGroupId(String groupId);
}
