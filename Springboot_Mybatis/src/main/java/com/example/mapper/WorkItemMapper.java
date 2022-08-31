package com.example.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.WorkItem;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_VIRGO)
public interface WorkItemMapper {

    List<WorkItem> queryByGroupId(String groupId);
}
