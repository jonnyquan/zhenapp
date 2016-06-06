package com.zhenapp.mapper;

import com.zhenapp.po.TComboInfo;
import com.zhenapp.po.TComboInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TComboInfoMapper {
    int countByExample(TComboInfoExample example);

    int deleteByExample(TComboInfoExample example);

    int deleteByPrimaryKey(Integer combopk);

    int insert(TComboInfo record);

    int insertSelective(TComboInfo record);

    List<TComboInfo> selectByExample(TComboInfoExample example);

    TComboInfo selectByPrimaryKey(Integer combopk);

    int updateByExampleSelective(@Param("record") TComboInfo record, @Param("example") TComboInfoExample example);

    int updateByExample(@Param("record") TComboInfo record, @Param("example") TComboInfoExample example);

    int updateByPrimaryKeySelective(TComboInfo record);

    int updateByPrimaryKey(TComboInfo record);
}