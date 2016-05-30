package com.zhenapp.mapper;

import com.zhenapp.po.TTbaccountInfo;
import com.zhenapp.po.TTbaccountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTbaccountInfoMapper {
    int countByExample(TTbaccountInfoExample example);

    int deleteByExample(TTbaccountInfoExample example);

    int deleteByPrimaryKey(Integer tbaccountpk);

    int insert(TTbaccountInfo record);

    int insertSelective(TTbaccountInfo record);

    List<TTbaccountInfo> selectByExample(TTbaccountInfoExample example);

    TTbaccountInfo selectByPrimaryKey(Integer tbaccountpk);

    int updateByExampleSelective(@Param("record") TTbaccountInfo record, @Param("example") TTbaccountInfoExample example);

    int updateByExample(@Param("record") TTbaccountInfo record, @Param("example") TTbaccountInfoExample example);

    int updateByPrimaryKeySelective(TTbaccountInfo record);

    int updateByPrimaryKey(TTbaccountInfo record);
}