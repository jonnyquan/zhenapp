package com.zhenapp.mapper;

import com.zhenapp.po.TTaskDetailinfoTemp;
import com.zhenapp.po.TTaskDetailinfoTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskDetailinfoTempMapper {
    int countByExample(TTaskDetailinfoTempExample example);

    int deleteByExample(TTaskDetailinfoTempExample example);

    int deleteByPrimaryKey(Integer taskdetailpk);

    int insert(TTaskDetailinfoTemp record);

    int insertSelective(TTaskDetailinfoTemp record);

    List<TTaskDetailinfoTemp> selectByExample(TTaskDetailinfoTempExample example);

    TTaskDetailinfoTemp selectByPrimaryKey(Integer taskdetailpk);

    int updateByExampleSelective(@Param("record") TTaskDetailinfoTemp record, @Param("example") TTaskDetailinfoTempExample example);

    int updateByExample(@Param("record") TTaskDetailinfoTemp record, @Param("example") TTaskDetailinfoTempExample example);

    int updateByPrimaryKeySelective(TTaskDetailinfoTemp record);

    int updateByPrimaryKey(TTaskDetailinfoTemp record);
}