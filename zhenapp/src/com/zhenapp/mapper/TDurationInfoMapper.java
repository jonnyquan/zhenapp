package com.zhenapp.mapper;

import com.zhenapp.po.TDurationInfo;
import com.zhenapp.po.TDurationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDurationInfoMapper {
    int countByExample(TDurationInfoExample example);

    int deleteByExample(TDurationInfoExample example);

    int deleteByPrimaryKey(Integer durationpk);

    int insert(TDurationInfo record);

    int insertSelective(TDurationInfo record);

    List<TDurationInfo> selectByExample(TDurationInfoExample example);

    TDurationInfo selectByPrimaryKey(Integer durationpk);

    int updateByExampleSelective(@Param("record") TDurationInfo record, @Param("example") TDurationInfoExample example);

    int updateByExample(@Param("record") TDurationInfo record, @Param("example") TDurationInfoExample example);

    int updateByPrimaryKeySelective(TDurationInfo record);

    int updateByPrimaryKey(TDurationInfo record);
}