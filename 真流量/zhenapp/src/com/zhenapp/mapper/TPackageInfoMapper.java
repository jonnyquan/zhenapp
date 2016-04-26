package com.zhenapp.mapper;

import com.zhenapp.po.TPackageInfo;
import com.zhenapp.po.TPackageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPackageInfoMapper {
    int countByExample(TPackageInfoExample example);

    int deleteByExample(TPackageInfoExample example);

    int deleteByPrimaryKey(Integer packagepk);

    int insert(TPackageInfo record);

    int insertSelective(TPackageInfo record);

    List<TPackageInfo> selectByExample(TPackageInfoExample example);

    TPackageInfo selectByPrimaryKey(Integer packagepk);

    int updateByExampleSelective(@Param("record") TPackageInfo record, @Param("example") TPackageInfoExample example);

    int updateByExample(@Param("record") TPackageInfo record, @Param("example") TPackageInfoExample example);

    int updateByPrimaryKeySelective(TPackageInfo record);

    int updateByPrimaryKey(TPackageInfo record);
}