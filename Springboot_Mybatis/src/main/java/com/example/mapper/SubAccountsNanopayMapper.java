package com.example.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.constant.DBConstants;
import com.example.entity.SubAccountsNanopay;
import com.example.entity.SubAccountsNanopayExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_LIQUIDO)
public interface SubAccountsNanopayMapper {
    long countByExample(SubAccountsNanopayExample example);

    int deleteByExample(SubAccountsNanopayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubAccountsNanopay record);

    int insertSelective(SubAccountsNanopay record);

    List<SubAccountsNanopay> selectByExample(SubAccountsNanopayExample example);

    SubAccountsNanopay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubAccountsNanopay record, @Param("example") SubAccountsNanopayExample example);

    int updateByExample(@Param("record") SubAccountsNanopay record, @Param("example") SubAccountsNanopayExample example);

    int updateByPrimaryKeySelective(SubAccountsNanopay record);

    int updateByPrimaryKey(SubAccountsNanopay record);
}