package com.zhenapp.service;

import com.zhenapp.po.Custom.TFilepathInfoCustom;

public interface FilepathInfoService {
	/*
	 * 根据id查询路径信息
	 */
	public TFilepathInfoCustom findFilepathByid(String filepathid) throws Exception;
	
}
