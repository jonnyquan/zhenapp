package com.zhenapp.mapper;

import com.zhenapp.po.TTbaccountInfoTemp;
import com.zhenapp.po.TTbaccountInfoTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTbaccountInfoTempMapper {
    int countByExample(TTbaccountInfoTempExample example);

    int deleteByExample(TTbaccountInfoTempExample example);

    int deleteByPrimaryKey(Integer tbaccountpk);

    int insert(TTbaccountInfoTemp record);

    int insertSelective(TTbaccountInfoTemp record);

    List<TTbaccountInfoTemp> selectByExample(TTbaccountInfoTempExample example);

    TTbaccountInfoTemp selectByPrimaryKey(Integer tbaccountpk);

    int updateByExampleSelective(@Param("record") TTbaccountInfoTemp record, @Param("example") TTbaccountInfoTempExample example);

    int updateByExample(@Param("record") TTbaccountInfoTemp record, @Param("example") TTbaccountInfoTempExample example);

    int updateByPrimaryKeySelective(TTbaccountInfoTemp record);

    int updateByPrimaryKey(TTbaccountInfoTemp record);
}