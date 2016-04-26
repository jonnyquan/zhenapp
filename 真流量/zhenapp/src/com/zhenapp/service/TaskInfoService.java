package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.TTaskInfo;
import com.zhenapp.po.Custom.TTaskInfoCustom;

public interface TaskInfoService {
	/*
	 * 保存任务信息(订单)
	 */
	public int insertTask(TTaskInfo tTaskInfo) throws Exception;
	
	/*
	 * 根据条件分页查询任务订单信息
	 */
	public List<TTaskInfoCustom> findTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	
	/*
	 * 根据条件查询所有任务订单信息
	 */
	public List<TTaskInfoCustom> findAllTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	
	/*
	 * 根据条件查询所有任务订单信息
	 */
	public void deleteTaskBypk(Integer taskpk) throws Exception;
	
	
	
}
