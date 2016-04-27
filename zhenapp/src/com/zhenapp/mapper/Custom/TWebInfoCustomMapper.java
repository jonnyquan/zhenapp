package com.zhenapp.mapper.Custom;

import com.zhenapp.po.Custom.TWebInfoCustom;

public interface TWebInfoCustomMapper {
	/*
	 * 根据访问域名查询域名信息
	 */
	public TWebInfoCustom findWebBywebwww(String webwww) throws Exception;
    
    /*
	 * 根据访问域名修改web信息
	 */
	public int updateWebByAgentid(TWebInfoCustom tWebInfoCustom) throws Exception;
	/*
	 * 根据代理id查询文本信息
	 */
	public TWebInfoCustom findWebByAgentid(String agentid) throws Exception;
}