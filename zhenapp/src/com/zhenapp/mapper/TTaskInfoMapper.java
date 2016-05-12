package com.zhenapp.mapper;

import com.zhenapp.po.TTaskInfo;
import com.zhenapp.po.TTaskInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskInfoMapper {
    int countByExample(TTaskInfoExample example);

    int deleteByExample(TTaskInfoExample example);

    int deleteByPrimaryKey(Integer taskpk);

    int insert(TTaskInfo record);

    int insertSelective(TTaskInfo record);

    List<TTaskInfo> selectByExample(TTaskInfoExample example);

    TTaskInfo selectByPrimaryKey(Integer taskpk);

    int updateByExampleSelective(@Param("record") TTaskInfo record, @Param("example") TTaskInfoExample example);

    int updateByExample(@Param("record") TTaskInfo record, @Param("example") TTaskInfoExample example);

    int updateByPrimaryKeySelective(TTaskInfo record);

    int updateByPrimaryKey(TTaskInfo record);
}