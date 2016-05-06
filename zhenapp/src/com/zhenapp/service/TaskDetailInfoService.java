package com.zhenapp.service;

import java.util.HashMap;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;

public interface TaskDetailInfoService {
	/*
	 * 插入对于手机做任务的详细信息
	 */
	public int insertDetailinfo(TTaskDetailInfoCustom tTaskDetailInfoCustom) throws Exception;
	/*
	 * 根据手机id获取符合规则的任务详情
	 */
	public TTaskDetailInfoCustom requesttaskByphoneid(String phoneid) throws Exception;
	/*
	 * 根据任务详情id修改该任务详情状态
	 */
	public int updateTaskDetailstate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据任务id修改该任务详情状态为执行终止
	 */
	public int updateterminationstate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 查询执行终止的任务消耗的积分数
	 */
	public int findPointsByteterminationstate(String taskid) throws Exception;
	/*
	 * 查询属于该手机并且详细任务状态为执行中（20）
	 */
	public TTaskDetailInfoCustom findTaskDetailByPidAndState(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据手机编号和详细任务状态修改反馈结果
	 */
	public int updateTaskDetailByPidAndState(HashMap<String, Object> hashmap) throws Exception;
}
