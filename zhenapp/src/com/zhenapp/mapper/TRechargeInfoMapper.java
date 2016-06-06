package com.zhenapp.mapper;

import com.zhenapp.po.TRechargeInfo;
import com.zhenapp.po.TRechargeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRechargeInfoMapper {
    int countByExample(TRechargeInfoExample example);

    int deleteByExample(TRechargeInfoExample example);

    int deleteByPrimaryKey(Integer rechargepk);

    int insert(TRechargeInfo record);

    int insertSelective(TRechargeInfo record);

    List<TRechargeInfo> selectByExample(TRechargeInfoExample example);

    TRechargeInfo selectByPrimaryKey(Integer rechargepk);

    int updateByExampleSelective(@Param("record") TRechargeInfo record, @Param("example") TRechargeInfoExample example);

    int updateByExample(@Param("record") TRechargeInfo record, @Param("example") TRechargeInfoExample example);

    int updateByPrimaryKeySelective(TRechargeInfo record);

    int updateByPrimaryKey(TRechargeInfo record);
}