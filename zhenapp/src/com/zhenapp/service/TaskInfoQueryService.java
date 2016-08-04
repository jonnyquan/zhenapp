package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTaskInfoQueryCustom;


public interface TaskInfoQueryService {
	/**
	 * 将订单信息表中的订单信息插入到查询表中
	 */
	public int saveTaskInfo(TTaskInfoQueryCustom tTaskInfoQueryCustom) throws Exception;
	
	/**
	 * 查询订单信息表中在查询表中没有的数据
	 */
	public List<TTaskInfoQueryCustom> findTaskInfo(HashMap<String, Object> hashmap) throws Exception;
	
	/**
	 * 根据条件查询订单信息表的数据
	 */
	public List<TTaskInfoQueryCustom> findTaskInfoByMap(HashMap<String, Object> hashmap) throws Exception;
	public int findTotalTaskInfoByMap(HashMap<String, Object> hashmap) throws Exception;
	/**
	 * 更新完成数失败数和状态
	 */
	public int updateTaskInfo(HashMap<String, Object> hashmap) throws Exception;
	/**
	 * 更新订单状态
	 */
	public int updateTaskInfoState(HashMap<String, Object> hashmap) throws Exception;
}
