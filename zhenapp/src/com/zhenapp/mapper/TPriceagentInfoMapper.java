package com.zhenapp.mapper;

import com.zhenapp.po.TPriceagentInfo;
import com.zhenapp.po.TPriceagentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPriceagentInfoMapper {
    int countByExample(TPriceagentInfoExample example);

    int deleteByExample(TPriceagentInfoExample example);

    int deleteByPrimaryKey(Integer pricepk);

    int insert(TPriceagentInfo record);

    int insertSelective(TPriceagentInfo record);

    List<TPriceagentInfo> selectByExample(TPriceagentInfoExample example);

    TPriceagentInfo selectByPrimaryKey(Integer pricepk);

    int updateByExampleSelective(@Param("record") TPriceagentInfo record, @Param("example") TPriceagentInfoExample example);

    int updateByExample(@Param("record") TPriceagentInfo record, @Param("example") TPriceagentInfoExample example);

    int updateByPrimaryKeySelective(TPriceagentInfo record);

    int updateByPrimaryKey(TPriceagentInfo record);
}