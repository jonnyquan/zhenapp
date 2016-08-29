package com.zhenapp.mapper;

import com.zhenapp.po.TDatacountInfo;
import com.zhenapp.po.TDatacountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDatacountInfoMapper {
    int countByExample(TDatacountInfoExample example);

    int deleteByExample(TDatacountInfoExample example);

    int deleteByPrimaryKey(Integer datacountpk);

    int insert(TDatacountInfo record);

    int insertSelective(TDatacountInfo record);

    List<TDatacountInfo> selectByExample(TDatacountInfoExample example);

    TDatacountInfo selectByPrimaryKey(Integer datacountpk);

    int updateByExampleSelective(@Param("record") TDatacountInfo record, @Param("example") TDatacountInfoExample example);

    int updateByExample(@Param("record") TDatacountInfo record, @Param("example") TDatacountInfoExample example);

    int updateByPrimaryKeySelective(TDatacountInfo record);

    int updateByPrimaryKey(TDatacountInfo record);
}