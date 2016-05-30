package com.zhenapp.mapper;

import com.zhenapp.po.TSysconfInfo;
import com.zhenapp.po.TSysconfInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysconfInfoMapper {
    int countByExample(TSysconfInfoExample example);

    int deleteByExample(TSysconfInfoExample example);

    int deleteByPrimaryKey(Integer sysconfpk);

    int insert(TSysconfInfo record);

    int insertSelective(TSysconfInfo record);

    List<TSysconfInfo> selectByExample(TSysconfInfoExample example);

    TSysconfInfo selectByPrimaryKey(Integer sysconfpk);

    int updateByExampleSelective(@Param("record") TSysconfInfo record, @Param("example") TSysconfInfoExample example);

    int updateByExample(@Param("record") TSysconfInfo record, @Param("example") TSysconfInfoExample example);

    int updateByPrimaryKeySelective(TSysconfInfo record);

    int updateByPrimaryKey(TSysconfInfo record);
}