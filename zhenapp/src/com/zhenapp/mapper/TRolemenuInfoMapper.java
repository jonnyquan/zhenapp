package com.zhenapp.mapper;

import com.zhenapp.po.TRolemenuInfo;
import com.zhenapp.po.TRolemenuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRolemenuInfoMapper {
    int countByExample(TRolemenuInfoExample example);

    int deleteByExample(TRolemenuInfoExample example);

    int deleteByPrimaryKey(Integer rolemenupk);

    int insert(TRolemenuInfo record);

    int insertSelective(TRolemenuInfo record);

    List<TRolemenuInfo> selectByExample(TRolemenuInfoExample example);

    TRolemenuInfo selectByPrimaryKey(Integer rolemenupk);

    int updateByExampleSelective(@Param("record") TRolemenuInfo record, @Param("example") TRolemenuInfoExample example);

    int updateByExample(@Param("record") TRolemenuInfo record, @Param("example") TRolemenuInfoExample example);

    int updateByPrimaryKeySelective(TRolemenuInfo record);

    int updateByPrimaryKey(TRolemenuInfo record);
}