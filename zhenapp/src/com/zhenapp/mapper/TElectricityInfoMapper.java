package com.zhenapp.mapper;

import com.zhenapp.po.TElectricityInfo;
import com.zhenapp.po.TElectricityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TElectricityInfoMapper {
    int countByExample(TElectricityInfoExample example);

    int deleteByExample(TElectricityInfoExample example);

    int deleteByPrimaryKey(Integer electricitypk);

    int insert(TElectricityInfo record);

    int insertSelective(TElectricityInfo record);

    List<TElectricityInfo> selectByExampleWithBLOBs(TElectricityInfoExample example);

    List<TElectricityInfo> selectByExample(TElectricityInfoExample example);

    TElectricityInfo selectByPrimaryKey(Integer electricitypk);

    int updateByExampleSelective(@Param("record") TElectricityInfo record, @Param("example") TElectricityInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TElectricityInfo record, @Param("example") TElectricityInfoExample example);

    int updateByExample(@Param("record") TElectricityInfo record, @Param("example") TElectricityInfoExample example);

    int updateByPrimaryKeySelective(TElectricityInfo record);

    int updateByPrimaryKeyWithBLOBs(TElectricityInfo record);

    int updateByPrimaryKey(TElectricityInfo record);
}