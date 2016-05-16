package com.zhenapp.service;

import java.util.List;

import com.zhenapp.po.Custom.TTbaccountInfoTempCustom;

public interface TbaccountInfoTempService {
	/*
	 * 删除所有信息
	 */
	public int deleteAll() throws Exception;
	/*
	 * 保存淘宝账号文件信息
	 */
	public int insertTbaccount(TTbaccountInfoTempCustom tTbaccountInfoTempCustom) throws Exception;
	
	/*
	 * 查询所有临时表中的信息
	 */
	public List<TTbaccountInfoTempCustom> findAllTTbaccountInfoTemp() throws Exception;
} 
