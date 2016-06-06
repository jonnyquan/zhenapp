package com.zhenapp.mapper;

import com.zhenapp.po.TTaskDetailinfo;
import com.zhenapp.po.TTaskDetailinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskDetailinfoMapper {
    int countByExample(TTaskDetailinfoExample example);

    int deleteByExample(TTaskDetailinfoExample example);

    int deleteByPrimaryKey(Integer taskdetailpk);

    int insert(TTaskDetailinfo record);

    int insertSelective(TTaskDetailinfo record);

    List<TTaskDetailinfo> selectByExample(TTaskDetailinfoExample example);

    TTaskDetailinfo selectByPrimaryKey(Integer taskdetailpk);

    int updateByExampleSelective(@Param("record") TTaskDetailinfo record, @Param("example") TTaskDetailinfoExample example);

    int updateByExample(@Param("record") TTaskDetailinfo record, @Param("example") TTaskDetailinfoExample example);

    int updateByPrimaryKeySelective(TTaskDetailinfo record);

    int updateByPrimaryKey(TTaskDetailinfo record);
}