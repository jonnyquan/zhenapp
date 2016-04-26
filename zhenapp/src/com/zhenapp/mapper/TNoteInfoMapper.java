package com.zhenapp.mapper;

import com.zhenapp.po.TNoteInfo;
import com.zhenapp.po.TNoteInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TNoteInfoMapper {
    int countByExample(TNoteInfoExample example);

    int deleteByExample(TNoteInfoExample example);

    int deleteByPrimaryKey(Integer notepk);

    int insert(TNoteInfo record);

    int insertSelective(TNoteInfo record);

    List<TNoteInfo> selectByExampleWithBLOBs(TNoteInfoExample example);

    List<TNoteInfo> selectByExample(TNoteInfoExample example);

    TNoteInfo selectByPrimaryKey(Integer notepk);

    int updateByExampleSelective(@Param("record") TNoteInfo record, @Param("example") TNoteInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TNoteInfo record, @Param("example") TNoteInfoExample example);

    int updateByExample(@Param("record") TNoteInfo record, @Param("example") TNoteInfoExample example);

    int updateByPrimaryKeySelective(TNoteInfo record);

    int updateByPrimaryKeyWithBLOBs(TNoteInfo record);

    int updateByPrimaryKey(TNoteInfo record);
}