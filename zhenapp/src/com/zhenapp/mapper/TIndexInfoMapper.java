package com.zhenapp.mapper;

import com.zhenapp.po.TIndexInfo;
import com.zhenapp.po.TIndexInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TIndexInfoMapper {
    int countByExample(TIndexInfoExample example);

    int deleteByExample(TIndexInfoExample example);

    int deleteByPrimaryKey(Integer indexpk);

    int insert(TIndexInfo record);

    int insertSelective(TIndexInfo record);

    List<TIndexInfo> selectByExampleWithBLOBs(TIndexInfoExample example);

    List<TIndexInfo> selectByExample(TIndexInfoExample example);

    TIndexInfo selectByPrimaryKey(Integer indexpk);

    int updateByExampleSelective(@Param("record") TIndexInfo record, @Param("example") TIndexInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TIndexInfo record, @Param("example") TIndexInfoExample example);

    int updateByExample(@Param("record") TIndexInfo record, @Param("example") TIndexInfoExample example);

    int updateByPrimaryKeySelective(TIndexInfo record);

    int updateByPrimaryKeyWithBLOBs(TIndexInfo record);

    int updateByPrimaryKey(TIndexInfo record);
}