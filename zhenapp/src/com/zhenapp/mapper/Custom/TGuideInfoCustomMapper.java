package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TGuideInfoCustom;

public interface TGuideInfoCustomMapper {
	/*
	 * 查询前10条新手指引信息  用于侧边栏展示 按时间倒序排列
	 */
	public List<TGuideInfoCustom> findGuide_10() throws Exception;
	
	/*
	 * 查询全部新手指引信息  用于新手指引信息页面展示
	 */
	public List<TGuideInfoCustom> findAllGuide() throws Exception;
	
	/*
	 * 根据新手指引信息主键查询新手指引信息
	 */
	public TGuideInfoCustom findElectrityBypk(String guidepk) throws Exception;
	/*
	 * 分页查询新手指引信息
	 */
	public List<TGuideInfoCustom> findGuideBypage(HashMap<String,Object> pagemap) throws Exception;
}
