package com.zhenapp.mapper;

import com.zhenapp.po.TPriceInfo;
import com.zhenapp.po.TPriceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPriceInfoMapper {
    int countByExample(TPriceInfoExample example);

    int deleteByExample(TPriceInfoExample example);

    int deleteByPrimaryKey(Integer pricepk);

    int insert(TPriceInfo record);

    int insertSelective(TPriceInfo record);

    List<TPriceInfo> selectByExample(TPriceInfoExample example);

    TPriceInfo selectByPrimaryKey(Integer pricepk);

    int updateByExampleSelective(@Param("record") TPriceInfo record, @Param("example") TPriceInfoExample example);

    int updateByExample(@Param("record") TPriceInfo record, @Param("example") TPriceInfoExample example);

    int updateByPrimaryKeySelective(TPriceInfo record);

    int updateByPrimaryKey(TPriceInfo record);
}