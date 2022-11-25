package com.liquido.mapper;

import java.util.List;

import com.liquido.entity.SubAccountPaybackNanopayArcus;
import com.liquido.entity.SubAccountPaybackNanopayArcusExample;

import org.apache.ibatis.annotations.Param;

public interface SubAccountPaybackNanopayArcusMapper {
    long countByExample(SubAccountPaybackNanopayArcusExample example);

    int deleteByExample(SubAccountPaybackNanopayArcusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubAccountPaybackNanopayArcus record);

    int insertSelective(SubAccountPaybackNanopayArcus record);

    List<SubAccountPaybackNanopayArcus> selectByExampleWithBLOBs(SubAccountPaybackNanopayArcusExample example);

    List<SubAccountPaybackNanopayArcus> selectByExample(SubAccountPaybackNanopayArcusExample example);

    SubAccountPaybackNanopayArcus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubAccountPaybackNanopayArcus record, @Param("example") SubAccountPaybackNanopayArcusExample example);

    int updateByExampleWithBLOBs(@Param("record") SubAccountPaybackNanopayArcus record, @Param("example") SubAccountPaybackNanopayArcusExample example);

    int updateByExample(@Param("record") SubAccountPaybackNanopayArcus record, @Param("example") SubAccountPaybackNanopayArcusExample example);

    int updateByPrimaryKeySelective(SubAccountPaybackNanopayArcus record);

    int updateByPrimaryKeyWithBLOBs(SubAccountPaybackNanopayArcus record);

    int updateByPrimaryKey(SubAccountPaybackNanopayArcus record);
}