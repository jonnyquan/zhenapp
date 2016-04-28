package com.zhenapp.mapper.Custom;

import com.zhenapp.po.Custom.TFilepathInfoCustom;


public interface TFilepathInfoCustomMapper {
	/*
	 * 根据id查询路径信息
	 */
	public TFilepathInfoCustom findFilepathByid(String filepathid) throws Exception;
}