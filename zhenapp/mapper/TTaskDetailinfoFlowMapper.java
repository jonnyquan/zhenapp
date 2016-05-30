package com.zhenapp.mapper;

import com.zhenapp.po.TTaskDetailinfoFlow;
import com.zhenapp.po.TTaskDetailinfoFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskDetailinfoFlowMapper {
    int countByExample(TTaskDetailinfoFlowExample example);

    int deleteByExample(TTaskDetailinfoFlowExample example);

    int deleteByPrimaryKey(Integer taskdetailpk);

    int insert(TTaskDetailinfoFlow record);

    int insertSelective(TTaskDetailinfoFlow record);

    List<TTaskDetailinfoFlow> selectByExample(TTaskDetailinfoFlowExample example);

    TTaskDetailinfoFlow selectByPrimaryKey(Integer taskdetailpk);

    int updateByExampleSelective(@Param("record") TTaskDetailinfoFlow record, @Param("example") TTaskDetailinfoFlowExample example);

    int updateByExample(@Param("record") TTaskDetailinfoFlow record, @Param("example") TTaskDetailinfoFlowExample example);

    int updateByPrimaryKeySelective(TTaskDetailinfoFlow record);

    int updateByPrimaryKey(TTaskDetailinfoFlow record);
}