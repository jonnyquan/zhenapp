package com.zhenapp.service;

import com.zhenapp.po.Custom.TWebInfoCustom;

public interface WebInfoService {
	/*
	 * 根据访问域名查询域名信息
	 */
	public TWebInfoCustom findWebBywebwww(String webwww) throws Exception;
	
	/*
	 * 根据访问域名修改web信息
	 */
	public int updateWebBywebwww(TWebInfoCustom tWebInfoCustom) throws Exception;
}
