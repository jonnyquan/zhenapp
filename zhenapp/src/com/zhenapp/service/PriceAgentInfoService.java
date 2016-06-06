package com.zhenapp.service;

import com.zhenapp.po.Custom.TPriceAgentInfoCustom;


public interface PriceAgentInfoService {
	//插入管理员对代理的单价信息
	public int insertPriceAgent(TPriceAgentInfoCustom tPriceagentInfoCustom) throws Exception;
	
	//根据代理id查询管理员对代理的单价信息
	public TPriceAgentInfoCustom findPriceByAgentid(String agentid) throws Exception;
	
	//修改管理员对代理的单价信息
	public int updatePrice(TPriceAgentInfoCustom tPriceagentInfoCustom) throws Exception;
}
