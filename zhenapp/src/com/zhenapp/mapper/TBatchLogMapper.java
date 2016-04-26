package com.zhenapp.mapper;

import com.zhenapp.po.TBatchLog;
import com.zhenapp.po.TBatchLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBatchLogMapper {
    int countByExample(TBatchLogExample example);

    int deleteByExample(TBatchLogExample example);

    int deleteByPrimaryKey(Integer batchlogpk);

    int insert(TBatchLog record);

    int insertSelective(TBatchLog record);

    List<TBatchLog> selectByExample(TBatchLogExample example);

    TBatchLog selectByPrimaryKey(Integer batchlogpk);

    int updateByExampleSelective(@Param("record") TBatchLog record, @Param("example") TBatchLogExample example);

    int updateByExample(@Param("record") TBatchLog record, @Param("example") TBatchLogExample example);

    int updateByPrimaryKeySelective(TBatchLog record);

    int updateByPrimaryKey(TBatchLog record);
}