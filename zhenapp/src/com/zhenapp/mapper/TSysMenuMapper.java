package com.zhenapp.mapper;

import com.zhenapp.po.TSysMenu;
import com.zhenapp.po.TSysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysMenuMapper {
    int countByExample(TSysMenuExample example);

    int deleteByExample(TSysMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSysMenu record);

    int insertSelective(TSysMenu record);

    List<TSysMenu> selectByExample(TSysMenuExample example);

    TSysMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSysMenu record, @Param("example") TSysMenuExample example);

    int updateByExample(@Param("record") TSysMenu record, @Param("example") TSysMenuExample example);

    int updateByPrimaryKeySelective(TSysMenu record);

    int updateByPrimaryKey(TSysMenu record);
}