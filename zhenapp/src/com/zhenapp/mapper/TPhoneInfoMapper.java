package com.zhenapp.mapper;

import com.zhenapp.po.TPhoneInfo;
import com.zhenapp.po.TPhoneInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPhoneInfoMapper {
    int countByExample(TPhoneInfoExample example);

    int deleteByExample(TPhoneInfoExample example);

    int deleteByPrimaryKey(Integer phonepk);

    int insert(TPhoneInfo record);

    int insertSelective(TPhoneInfo record);

    List<TPhoneInfo> selectByExample(TPhoneInfoExample example);

    TPhoneInfo selectByPrimaryKey(Integer phonepk);

    int updateByExampleSelective(@Param("record") TPhoneInfo record, @Param("example") TPhoneInfoExample example);

    int updateByExample(@Param("record") TPhoneInfo record, @Param("example") TPhoneInfoExample example);

    int updateByPrimaryKeySelective(TPhoneInfo record);

    int updateByPrimaryKey(TPhoneInfo record);
}