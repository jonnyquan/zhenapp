package com.zhenapp.mapper;

import com.zhenapp.po.TChangeInfo;
import com.zhenapp.po.TChangeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChangeInfoMapper {
    int countByExample(TChangeInfoExample example);

    int deleteByExample(TChangeInfoExample example);

    int insert(TChangeInfo record);

    int insertSelective(TChangeInfo record);

    List<TChangeInfo> selectByExample(TChangeInfoExample example);

    int updateByExampleSelective(@Param("record") TChangeInfo record, @Param("example") TChangeInfoExample example);

    int updateByExample(@Param("record") TChangeInfo record, @Param("example") TChangeInfoExample example);
}