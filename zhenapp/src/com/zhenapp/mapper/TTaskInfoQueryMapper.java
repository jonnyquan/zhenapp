package com.zhenapp.mapper;

import com.zhenapp.po.TTaskInfoQuery;
import com.zhenapp.po.TTaskInfoQueryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskInfoQueryMapper {
    int countByExample(TTaskInfoQueryExample example);

    int deleteByExample(TTaskInfoQueryExample example);

    int deleteByPrimaryKey(Integer querypk);

    int insert(TTaskInfoQuery record);

    int insertSelective(TTaskInfoQuery record);

    List<TTaskInfoQuery> selectByExample(TTaskInfoQueryExample example);

    TTaskInfoQuery selectByPrimaryKey(Integer querypk);

    int updateByExampleSelective(@Param("record") TTaskInfoQuery record, @Param("example") TTaskInfoQueryExample example);

    int updateByExample(@Param("record") TTaskInfoQuery record, @Param("example") TTaskInfoQueryExample example);

    int updateByPrimaryKeySelective(TTaskInfoQuery record);

    int updateByPrimaryKey(TTaskInfoQuery record);
}