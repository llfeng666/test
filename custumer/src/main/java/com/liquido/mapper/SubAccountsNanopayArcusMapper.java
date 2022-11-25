package com.liquido.mapper;

import java.util.List;

import com.liquido.constant.DBConstants;
import com.liquido.entity.SubAccountsNanopayArcus;
import com.liquido.entity.SubAccountsNanopayArcusExample;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_LIQUIDO)
public interface SubAccountsNanopayArcusMapper {
    long countByExample(SubAccountsNanopayArcusExample example);

    int deleteByExample(SubAccountsNanopayArcusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubAccountsNanopayArcus record);

    int insertSelective(SubAccountsNanopayArcus record);

    List<SubAccountsNanopayArcus> selectByExample(SubAccountsNanopayArcusExample example);

    SubAccountsNanopayArcus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubAccountsNanopayArcus record, @Param("example") SubAccountsNanopayArcusExample example);

    int updateByExample(@Param("record") SubAccountsNanopayArcus record, @Param("example") SubAccountsNanopayArcusExample example);

    int updateByPrimaryKeySelective(SubAccountsNanopayArcus record);

    int updateByPrimaryKey(SubAccountsNanopayArcus record);
}