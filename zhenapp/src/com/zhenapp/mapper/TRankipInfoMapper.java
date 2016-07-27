package com.zhenapp.mapper;

import com.zhenapp.po.TRankipInfo;
import com.zhenapp.po.TRankipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRankipInfoMapper {
    int countByExample(TRankipInfoExample example);

    int deleteByExample(TRankipInfoExample example);

    int insert(TRankipInfo record);

    int insertSelective(TRankipInfo record);

    List<TRankipInfo> selectByExample(TRankipInfoExample example);

    int updateByExampleSelective(@Param("record") TRankipInfo record, @Param("example") TRankipInfoExample example);

    int updateByExample(@Param("record") TRankipInfo record, @Param("example") TRankipInfoExample example);
}