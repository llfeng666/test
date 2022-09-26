package com.example.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.SubAccountPaybackNanopay;
import com.example.entity.SubAccountPaybackNanopayExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_LIQUIDO)
public interface SubAccountPaybackNanopayMapper {
    long countByExample(SubAccountPaybackNanopayExample example);

    int deleteByExample(SubAccountPaybackNanopayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubAccountPaybackNanopay record);

    int insertSelective(SubAccountPaybackNanopay record);

    List<SubAccountPaybackNanopay> selectByExample(SubAccountPaybackNanopayExample example);

    SubAccountPaybackNanopay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubAccountPaybackNanopay record, @Param("example") SubAccountPaybackNanopayExample example);

    int updateByExample(@Param("record") SubAccountPaybackNanopay record, @Param("example") SubAccountPaybackNanopayExample example);

    int updateByPrimaryKeySelective(SubAccountPaybackNanopay record);

    int updateByPrimaryKey(SubAccountPaybackNanopay record);
}