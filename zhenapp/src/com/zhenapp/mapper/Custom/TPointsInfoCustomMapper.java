package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TPointsInfoCustom;

public interface TPointsInfoCustomMapper {
	/*
	 * 查询账户明细信息
	 */
	public List<TPointsInfoCustom> findPointsInfoByPage(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 分页查询账户明细信息总条数
	 */
	public int findPointsCountsByPage(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据角色为代理分页查询账户明细信息
	 */
	public List<TPointsInfoCustom> findPointsInfoByPageandRole(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据角色为代理分页查询账户明细信息总条数
	 */
	public int findPointsCountsByPageandRole(HashMap<String, Object> pagemap) throws Exception;

	
	/*
	 * 插入账户明细信息
	 */
	public int savePoints(TPointsInfoCustom tPointsInfoCustom) throws Exception;
}