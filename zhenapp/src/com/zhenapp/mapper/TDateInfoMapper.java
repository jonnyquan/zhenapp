package com.zhenapp.mapper;

import com.zhenapp.po.TDateInfo;
import com.zhenapp.po.TDateInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDateInfoMapper {
    int countByExample(TDateInfoExample example);

    int deleteByExample(TDateInfoExample example);

    int deleteByPrimaryKey(Integer datepk);

    int insert(TDateInfo record);

    int insertSelective(TDateInfo record);

    List<TDateInfo> selectByExample(TDateInfoExample example);

    TDateInfo selectByPrimaryKey(Integer datepk);

    int updateByExampleSelective(@Param("record") TDateInfo record, @Param("example") TDateInfoExample example);

    int updateByExample(@Param("record") TDateInfo record, @Param("example") TDateInfoExample example);

    int updateByPrimaryKeySelective(TDateInfo record);

    int updateByPrimaryKey(TDateInfo record);
}