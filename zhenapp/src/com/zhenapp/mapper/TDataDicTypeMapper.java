package com.zhenapp.mapper;

import com.zhenapp.po.TDataDicType;
import com.zhenapp.po.TDataDicTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDataDicTypeMapper {
    int countByExample(TDataDicTypeExample example);

    int deleteByExample(TDataDicTypeExample example);

    int deleteByPrimaryKey(Integer dictypeid);

    int insert(TDataDicType record);

    int insertSelective(TDataDicType record);

    List<TDataDicType> selectByExample(TDataDicTypeExample example);

    TDataDicType selectByPrimaryKey(Integer dictypeid);

    int updateByExampleSelective(@Param("record") TDataDicType record, @Param("example") TDataDicTypeExample example);

    int updateByExample(@Param("record") TDataDicType record, @Param("example") TDataDicTypeExample example);

    int updateByPrimaryKeySelective(TDataDicType record);

    int updateByPrimaryKey(TDataDicType record);
}