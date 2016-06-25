package com.zhenapp.service;

import java.util.HashMap;

import com.zhenapp.po.Custom.TChangeInfoCustom;


public interface ChangeInfoService {
	/*
	 * 查询是否点击一键换号
	 */
	public TChangeInfoCustom findChangeinfo(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 根据手机号修改是否一键换号
	 */
	public int updatestate(HashMap<String, Object> hashmap) throws Exception;
}
