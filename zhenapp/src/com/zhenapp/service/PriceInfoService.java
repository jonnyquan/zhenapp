package com.zhenapp.service;

import com.zhenapp.po.Custom.TPriceInfoCustom;

public interface PriceInfoService {
	/*
	 * 根据代理id修改价格信息
	 */
	public int updatePriceByagentid(TPriceInfoCustom tPriceInfoCustom) throws Exception;
	/*
	 * 根据代理id查询对于代理的价格信息
	 */
	public TPriceInfoCustom findPriceByAgentid(String agentid) throws Exception;
	
	
}
