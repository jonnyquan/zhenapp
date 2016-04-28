package com.zhenapp.mapper;

import com.zhenapp.po.TFilepathInfo;
import com.zhenapp.po.TFilepathInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFilepathInfoMapper {
    int countByExample(TFilepathInfoExample example);

    int deleteByExample(TFilepathInfoExample example);

    int deleteByPrimaryKey(Integer filepathpk);

    int insert(TFilepathInfo record);

    int insertSelective(TFilepathInfo record);

    List<TFilepathInfo> selectByExample(TFilepathInfoExample example);

    TFilepathInfo selectByPrimaryKey(Integer filepathpk);

    int updateByExampleSelective(@Param("record") TFilepathInfo record, @Param("example") TFilepathInfoExample example);

    int updateByExample(@Param("record") TFilepathInfo record, @Param("example") TFilepathInfoExample example);

    int updateByPrimaryKeySelective(TFilepathInfo record);

    int updateByPrimaryKey(TFilepathInfo record);
}