package com.zhenapp.mapper;

import com.zhenapp.po.TGuideInfo;
import com.zhenapp.po.TGuideInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGuideInfoMapper {
    int countByExample(TGuideInfoExample example);

    int deleteByExample(TGuideInfoExample example);

    int deleteByPrimaryKey(Integer guidepk);

    int insert(TGuideInfo record);

    int insertSelective(TGuideInfo record);

    List<TGuideInfo> selectByExampleWithBLOBs(TGuideInfoExample example);

    List<TGuideInfo> selectByExample(TGuideInfoExample example);

    TGuideInfo selectByPrimaryKey(Integer guidepk);

    int updateByExampleSelective(@Param("record") TGuideInfo record, @Param("example") TGuideInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TGuideInfo record, @Param("example") TGuideInfoExample example);

    int updateByExample(@Param("record") TGuideInfo record, @Param("example") TGuideInfoExample example);

    int updateByPrimaryKeySelective(TGuideInfo record);

    int updateByPrimaryKeyWithBLOBs(TGuideInfo record);

    int updateByPrimaryKey(TGuideInfo record);
}