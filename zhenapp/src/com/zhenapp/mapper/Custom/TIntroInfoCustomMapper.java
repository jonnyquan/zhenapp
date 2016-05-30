package com.zhenapp.mapper.Custom;

import java.util.HashMap;

import com.zhenapp.po.Custom.TIntroInfoCustom;


public interface TIntroInfoCustomMapper {
	/*
	 *查询服务介绍信息
	 */
	public TIntroInfoCustom findIntroinfo(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 修改服务介绍信息
	 */
	public int updateIntroById(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 保存服务介绍信息
	 */
	public int insertIntro(TIntroInfoCustom tIntroInfoCustom) throws Exception;
}