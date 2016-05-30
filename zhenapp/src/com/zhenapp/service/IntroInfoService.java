package com.zhenapp.service;

import java.util.HashMap;

import com.zhenapp.po.Custom.TIntroInfoCustom;

public interface IntroInfoService {
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
