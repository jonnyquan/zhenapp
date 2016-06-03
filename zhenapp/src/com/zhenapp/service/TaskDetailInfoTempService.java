package com.zhenapp.service;

import java.util.HashMap;

import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;


public interface TaskDetailInfoTempService {
	//保存详情任务临时信息
	public int insertDetailinfo(TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom) throws Exception;
	//根据手机号查询详情任务临时信息
	public TTaskDetailinfoTempCustom findTTaskDetailinfoTempByphoneid(HashMap<String, Object> hashmap) throws Exception;
	//根据条件删除详情任务的临时信息
	public int deletetaskDetailInfoTemp(HashMap<String, Object> hashmap) throws Exception;
	//根据条件修改详情任务临时信息的状态
	public int updatestate(HashMap<String, Object> hashmap) throws Exception;
}
