package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;

public interface TaskDetailInfoService {
	
	public TTaskDetailInfoCustom requesttaskAuto(HashMap<String, Object> hashmap) throws Exception;
	//根据条件查询详情任务信息
	public List<TTaskDetailInfoCustom> findTaskDetail(HashMap<String, Object> hashmap) throws Exception;
	//查询执行过的id和关键词的详情任务
	public List<TTaskDetailInfoCustom> findexitid(HashMap<String, Object> hashmap) throws Exception;
	//查询出终止任务个数
	public int findcountEndstate(String taskid) throws Exception;
	//根据日期按手机分组统计完成的收藏数和加购数
	public List<TTaskDetailInfoCustom> findtaskdatacount(HashMap<String, Object> hashmap) throws Exception;
	//根据日期按手机分组统计完成的收藏数和加购数
	public TTaskDetailInfoCustom findtaskdatasum(HashMap<String, Object> hashmap) throws Exception;
	
	//根据id更新反馈给手机的字符串
	public int updateTaskDetailresultByid(HashMap<String, Object> hashmap) throws Exception;
	//修改任务详情信息
	public int updateTaskDetail(HashMap<String, Object> hashmap) throws Exception;
	//根据id和状态查询加购的记录数
	public int findshoppingcount(HashMap<String, Object> hashmap) throws Exception;
	//根据id和状态查询收藏的记录数
	public int findcollectioncount(HashMap<String, Object> hashmap) throws Exception;
	//根据任务id和状态查询记录数
	public int findCounts(HashMap<String, Object> hashmap) throws Exception;
	//查询卡机任务（手机获取5分钟后没有反馈的任务信息）
	public List<TTaskDetailInfoCustom> findTaskDetailByProblemAndPage(HashMap<String, Object> hashmap) throws Exception;
	//查询卡机任务（手机获取5分钟后没有反馈的任务信息）的总条数
	public int findTotalTaskDetailByProblemAndPage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据主键查询任务详情信息
	 */
	public TTaskDetailInfoCustom findTaskDetailBypk(String taskdetailpk) throws Exception;
	/*
	 * 根据条件查询任务详情
	 */
	public List<TTaskDetailInfoCustom> findTaskDetailByPage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据条件查询任务详情总数
	 */
	public int findTaskDetailTotalByPage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 插入对于手机做任务的详细信息
	 */
	public int insertDetailinfo(TTaskDetailInfoCustom tTaskDetailInfoCustom) throws Exception;
	/*
	 * 根据手机id获取符合规则的任务详情
	 */
	public TTaskDetailInfoCustom requesttaskByphoneid(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据手机id获取符合规则的任务详情
	 */
	public TTaskDetailInfoCustom requesttaskByphoneid_temp(HashMap<String, Object> hashmap) throws Exception;
	
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
	/*
	 * 根据任务id和新的任务详情状态修改该任务id所属任务的旧任务详情状态
	 */
	public int updateTaskDetailstateByTaskidAndoldstate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 查询只有流量访问的详细任务
	 */
	public List<TTaskDetailInfoCustom> findTaskDetailByflow() throws Exception;
	/*
	 * 查询某个宝贝id 做收藏或加购  或者收藏和加购的数目
	 */
	public int findTaskDetailByIdAndtask(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据任务状态及任务id查询任务条数
	 */
	public int findTaskDetailInfoByIdAndTaskstate(HashMap<String, Object> hashmap) throws Exception;
	//根据任务id和详情任务状态删除详情任务信息
	public int deleteTaskBystate(HashMap<String, Object> hashmap) throws Exception;
	
}
