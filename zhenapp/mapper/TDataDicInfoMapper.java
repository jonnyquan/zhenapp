package com.zhenapp.mapper;

import com.zhenapp.po.TDataDicInfo;
import com.zhenapp.po.TDataDicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDataDicInfoMapper {
    int countByExample(TDataDicInfoExample example);

    int deleteByExample(TDataDicInfoExample example);

    int deleteByPrimaryKey(Integer dicinfoid);

    int insert(TDataDicInfo record);

    int insertSelective(TDataDicInfo record);

    List<TDataDicInfo> selectByExample(TDataDicInfoExample example);

    TDataDicInfo selectByPrimaryKey(Integer dicinfoid);

    int updateByExampleSelective(@Param("record") TDataDicInfo record, @Param("example") TDataDicInfoExample example);

    int updateByExample(@Param("record") TDataDicInfo record, @Param("example") TDataDicInfoExample example);

    int updateByPrimaryKeySelective(TDataDicInfo record);

    int updateByPrimaryKey(TDataDicInfo record);
}