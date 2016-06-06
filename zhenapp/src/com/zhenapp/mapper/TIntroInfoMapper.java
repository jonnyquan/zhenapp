package com.zhenapp.mapper;

import com.zhenapp.po.TIntroInfo;
import com.zhenapp.po.TIntroInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TIntroInfoMapper {
    int countByExample(TIntroInfoExample example);

    int deleteByExample(TIntroInfoExample example);

    int deleteByPrimaryKey(Integer intropk);

    int insert(TIntroInfo record);

    int insertSelective(TIntroInfo record);

    List<TIntroInfo> selectByExampleWithBLOBs(TIntroInfoExample example);

    List<TIntroInfo> selectByExample(TIntroInfoExample example);

    TIntroInfo selectByPrimaryKey(Integer intropk);

    int updateByExampleSelective(@Param("record") TIntroInfo record, @Param("example") TIntroInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TIntroInfo record, @Param("example") TIntroInfoExample example);

    int updateByExample(@Param("record") TIntroInfo record, @Param("example") TIntroInfoExample example);

    int updateByPrimaryKeySelective(TIntroInfo record);

    int updateByPrimaryKeyWithBLOBs(TIntroInfo record);

    int updateByPrimaryKey(TIntroInfo record);
}