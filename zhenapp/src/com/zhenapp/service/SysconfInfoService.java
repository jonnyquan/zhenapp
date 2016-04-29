package com.zhenapp.service;

import com.zhenapp.po.Custom.TSysconfInfoCustom;

public interface SysconfInfoService {
	/*
	 * 查询系统配置信息
	 */
	public TSysconfInfoCustom findSysconf() throws Exception;
	/*
	 * 修改系统配置
	 */
	public int updateSysinfo(TSysconfInfoCustom tSysconfInfoCustom) throws Exception;
	/*
	 * 单独查询系统配置项中是否禁止发布任务
	 */
	public String findSysdesable() throws Exception;
}
