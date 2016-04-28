package com.zhenapp.service;

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
}
