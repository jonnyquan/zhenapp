package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTaskInfoCustom;


public interface TTaskInfoCustomMapper {

	/*
	 * 查询任务信息(订单)
	 */
	public List<TTaskInfoCustom> findTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据条件查询所有任务订单信息
	 */
	public List<TTaskInfoCustom> findAllTaskBypage(HashMap<String,Object> hashmap) throws Exception;
}