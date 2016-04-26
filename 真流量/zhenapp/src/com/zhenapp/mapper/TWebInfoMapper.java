package com.zhenapp.mapper;

import com.zhenapp.po.TWebInfo;
import com.zhenapp.po.TWebInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWebInfoMapper {
    int countByExample(TWebInfoExample example);

    int deleteByExample(TWebInfoExample example);

    int deleteByPrimaryKey(Integer webpk);

    int insert(TWebInfo record);

    int insertSelective(TWebInfo record);

    List<TWebInfo> selectByExample(TWebInfoExample example);

    TWebInfo selectByPrimaryKey(Integer webpk);

    int updateByExampleSelective(@Param("record") TWebInfo record, @Param("example") TWebInfoExample example);

    int updateByExample(@Param("record") TWebInfo record, @Param("example") TWebInfoExample example);

    int updateByPrimaryKeySelective(TWebInfo record);

    int updateByPrimaryKey(TWebInfo record);
}