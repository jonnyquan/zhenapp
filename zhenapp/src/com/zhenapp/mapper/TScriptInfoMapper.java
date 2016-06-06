package com.zhenapp.mapper;

import com.zhenapp.po.TScriptInfo;
import com.zhenapp.po.TScriptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScriptInfoMapper {
    int countByExample(TScriptInfoExample example);

    int deleteByExample(TScriptInfoExample example);

    int deleteByPrimaryKey(Integer scriptpk);

    int insert(TScriptInfo record);

    int insertSelective(TScriptInfo record);

    List<TScriptInfo> selectByExample(TScriptInfoExample example);

    TScriptInfo selectByPrimaryKey(Integer scriptpk);

    int updateByExampleSelective(@Param("record") TScriptInfo record, @Param("example") TScriptInfoExample example);

    int updateByExample(@Param("record") TScriptInfo record, @Param("example") TScriptInfoExample example);

    int updateByPrimaryKeySelective(TScriptInfo record);

    int updateByPrimaryKey(TScriptInfo record);
}