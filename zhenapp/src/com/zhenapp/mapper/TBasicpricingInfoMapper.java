package com.zhenapp.mapper;

import com.zhenapp.po.TBasicpricingInfo;
import com.zhenapp.po.TBasicpricingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBasicpricingInfoMapper {
    int countByExample(TBasicpricingInfoExample example);

    int deleteByExample(TBasicpricingInfoExample example);

    int deleteByPrimaryKey(Integer basicpricingpk);

    int insert(TBasicpricingInfo record);

    int insertSelective(TBasicpricingInfo record);

    List<TBasicpricingInfo> selectByExample(TBasicpricingInfoExample example);

    TBasicpricingInfo selectByPrimaryKey(Integer basicpricingpk);

    int updateByExampleSelective(@Param("record") TBasicpricingInfo record, @Param("example") TBasicpricingInfoExample example);

    int updateByExample(@Param("record") TBasicpricingInfo record, @Param("example") TBasicpricingInfoExample example);

    int updateByPrimaryKeySelective(TBasicpricingInfo record);

    int updateByPrimaryKey(TBasicpricingInfo record);
}