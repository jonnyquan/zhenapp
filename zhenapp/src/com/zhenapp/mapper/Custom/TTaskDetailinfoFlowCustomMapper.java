package com.zhenapp.mapper.Custom;

import java.util.HashMap;

import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;

public interface TTaskDetailinfoFlowCustomMapper {
	//保存流量任务记录
	public int insertTaskDetailInfoFlow(TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom) throws Exception;
	//根据主键修改流量详情id
	public int updateTaskdetailIdByPk(HashMap<String, Object> hashmap) throws Exception;
	//修改状态为执行终止
	public int updateTaskstate(HashMap<String, Object> hashmap) throws Exception;
	//根据任务id查询出流量详情信息
	public TTaskDetailInfoFlowCustom findTaskdetailInfo(HashMap<String, Object> hashmap) throws Exception;
	//更新流量详情完成数
	public int updatefinishcount(HashMap<String, Object> hashmap) throws Exception;
}