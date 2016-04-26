package com.zhenapp.mapper;

import com.zhenapp.po.TUserDetailinfo;
import com.zhenapp.po.TUserDetailinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserDetailinfoMapper {
    int countByExample(TUserDetailinfoExample example);

    int deleteByExample(TUserDetailinfoExample example);

    int deleteByPrimaryKey(Integer detailpk);

    int insert(TUserDetailinfo record);

    int insertSelective(TUserDetailinfo record);

    List<TUserDetailinfo> selectByExample(TUserDetailinfoExample example);

    TUserDetailinfo selectByPrimaryKey(Integer detailpk);

    int updateByExampleSelective(@Param("record") TUserDetailinfo record, @Param("example") TUserDetailinfoExample example);

    int updateByExample(@Param("record") TUserDetailinfo record, @Param("example") TUserDetailinfoExample example);

    int updateByPrimaryKeySelective(TUserDetailinfo record);

    int updateByPrimaryKey(TUserDetailinfo record);
}