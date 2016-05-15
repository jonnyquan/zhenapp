package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTaskInfoCustom;

public interface TaskInfoService {
	/*
	 * 保存任务信息(订单)
	 */
	public int insertTaskInfo(TTaskInfoCustom TTaskInfoCustom) throws Exception;
	/*
	 * 根据条件分页查询任务订单信息
	 */
	public List<TTaskInfoCustom> findTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据条件分页查询任务订单信息角色为代理
	 */
	public List<TTaskInfoCustom> findTaskBypageAndrole(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据角色为代理查询任务订单信息总数
	 */
	public int findTotalTaskBypageAndrole(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据条件查询所有任务订单信息
	 */
	public List<TTaskInfoCustom> findAllTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据条件查询所有任务订单信息
	 */
	public int findTotalTaskBypage(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据多个任务主键删除任务信息格式为 "1,2,3,4"
	 * 
	 */
	public void deleteTaskBypk(String taskpk) throws Exception;
	/*
	 * 查询待分配的任务  任务状态为 待分配
	 */
	public List<TTaskInfoCustom> findTaskallocation(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 查询该宝贝id是否是第一次发布任务
	 */
	public List<TTaskInfoCustom> findIsFirst(String taskkeynum) throws Exception;
	/*
	 * 根据任务id修改任务状态
	 */
	public int updateTaskstate(HashMap<String,Object> hashmap) throws Exception;
	/*
	 * 根据taskid查询任务信息
	 */
	public TTaskInfoCustom findTaskInfoByTaskid(String taskid) throws Exception;
	/*
	 * 根据状态查询任务信息
	 */
	public List<TTaskInfoCustom> findTaskInfoByTaskstate(HashMap<String,Object> hashmap) throws Exception;
}
