package com.liquido.mapper;

import java.util.List;

import com.liquido.constant.DBConstants;
import com.liquido.entity.WorkItem;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_VIRGO)
public interface WorkItemMapper {

    List<WorkItem> queryByGroupId(String groupId);
}
