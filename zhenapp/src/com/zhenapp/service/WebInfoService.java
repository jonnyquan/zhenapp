package com.zhenapp.service;

import com.zhenapp.po.Custom.TWebInfoCustom;

public interface WebInfoService {
	/*
	 * 根据访问域名修改web信息
	 */
	public int updateWebByAgentid(TWebInfoCustom tWebInfoCustom) throws Exception;
	
	/*
	 * 根据代理id查询文本信息
	 */
	public TWebInfoCustom findWebByAgentid(String agentid) throws Exception;
	/*
	 * 保存代理web信息
	 */
	public int saveWebInfo(TWebInfoCustom tWebInfoCustom) throws Exception;
}
