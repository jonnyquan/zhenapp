package com.zhenapp.mapper;

import com.zhenapp.po.TUsertestInfo;
import com.zhenapp.po.TUsertestInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUsertestInfoMapper {
    int countByExample(TUsertestInfoExample example);

    int deleteByExample(TUsertestInfoExample example);

    int insert(TUsertestInfo record);

    int insertSelective(TUsertestInfo record);

    List<TUsertestInfo> selectByExample(TUsertestInfoExample example);

    int updateByExampleSelective(@Param("record") TUsertestInfo record, @Param("example") TUsertestInfoExample example);

    int updateByExample(@Param("record") TUsertestInfo record, @Param("example") TUsertestInfoExample example);
}