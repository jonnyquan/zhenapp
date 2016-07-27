package com.zhenapp.mapper.Custom;

import com.zhenapp.po.TRankipInfo;
import com.zhenapp.po.TRankipInfoExample;
import com.zhenapp.po.Custom.TRankipInfoCustom;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRankipInfoCustomMapper {
	public TRankipInfoCustom findRankip() throws Exception;
}