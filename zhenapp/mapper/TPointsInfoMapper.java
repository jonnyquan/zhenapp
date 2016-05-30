package com.zhenapp.mapper;

import com.zhenapp.po.TPointsInfo;
import com.zhenapp.po.TPointsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPointsInfoMapper {
    int countByExample(TPointsInfoExample example);

    int deleteByExample(TPointsInfoExample example);

    int deleteByPrimaryKey(Integer pointspk);

    int insert(TPointsInfo record);

    int insertSelective(TPointsInfo record);

    List<TPointsInfo> selectByExample(TPointsInfoExample example);

    TPointsInfo selectByPrimaryKey(Integer pointspk);

    int updateByExampleSelective(@Param("record") TPointsInfo record, @Param("example") TPointsInfoExample example);

    int updateByExample(@Param("record") TPointsInfo record, @Param("example") TPointsInfoExample example);

    int updateByPrimaryKeySelective(TPointsInfo record);

    int updateByPrimaryKey(TPointsInfo record);
}