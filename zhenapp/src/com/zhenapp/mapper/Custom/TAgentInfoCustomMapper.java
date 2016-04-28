package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TAgentInfoCustom;


public interface TAgentInfoCustomMapper {
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
	public int deleteAgentByid(String ids) throws Exception;
	/*
	 * 根据用户id查询代理信息
	 */
	public TAgentInfoCustom findAgentByuserid(String userid) throws Exception;
	/*
	 * 根据代理id查询代理信息
	 */
	public TAgentInfoCustom findAgentByAgentid(String agentid) throws Exception;
}