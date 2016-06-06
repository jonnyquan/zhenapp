package com.zhenapp.mapper.Custom;

import java.util.HashMap;

import com.zhenapp.po.Custom.TIndexInfoCustom;


public interface TIndexInfoCustomMapper {
	//查询首页信息
	public TIndexInfoCustom findIndex(HashMap<String, Object> hashmap) throws Exception;
	
	//插入首页信息
	public int insertIndex(TIndexInfoCustom tIndexInfoCustom) throws Exception;
	
	//修改首页信息
	public int updateIndex(HashMap<String, Object> hashmap) throws Exception;
	
	//修改首页信息
	public int deleteIndex(HashMap<String, Object> hashmap) throws Exception;
}