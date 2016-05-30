package com.zhenapp.mapper;

import com.zhenapp.po.TAgentInfo;
import com.zhenapp.po.TAgentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAgentInfoMapper {
    int countByExample(TAgentInfoExample example);

    int deleteByExample(TAgentInfoExample example);

    int deleteByPrimaryKey(Integer agentpk);

    int insert(TAgentInfo record);

    int insertSelective(TAgentInfo record);

    List<TAgentInfo> selectByExample(TAgentInfoExample example);

    TAgentInfo selectByPrimaryKey(Integer agentpk);

    int updateByExampleSelective(@Param("record") TAgentInfo record, @Param("example") TAgentInfoExample example);

    int updateByExample(@Param("record") TAgentInfo record, @Param("example") TAgentInfoExample example);

    int updateByPrimaryKeySelective(TAgentInfo record);

    int updateByPrimaryKey(TAgentInfo record);
}