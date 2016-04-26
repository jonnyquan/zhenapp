package com.zhenapp.mapper;

import com.zhenapp.po.TRoleInfo;
import com.zhenapp.po.TRoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleInfoMapper {
    int countByExample(TRoleInfoExample example);

    int deleteByExample(TRoleInfoExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(TRoleInfo record);

    int insertSelective(TRoleInfo record);

    List<TRoleInfo> selectByExample(TRoleInfoExample example);

    TRoleInfo selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") TRoleInfo record, @Param("example") TRoleInfoExample example);

    int updateByExample(@Param("record") TRoleInfo record, @Param("example") TRoleInfoExample example);

    int updateByPrimaryKeySelective(TRoleInfo record);

    int updateByPrimaryKey(TRoleInfo record);
}