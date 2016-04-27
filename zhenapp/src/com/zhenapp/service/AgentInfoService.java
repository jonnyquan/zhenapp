package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TAgentInfoCustom;

public interface AgentInfoService {
	/*
	 * 分页查询代理信息
	 */
	public List<TAgentInfoCustom> findAgentBypage(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 分页查询代理信息
	 */
	public List<TAgentInfoCustom> findAllAgentBypage(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 根据主键删除代理信息
	 */
	public int deleteAgentBypk(String pks) throws Exception;
}
