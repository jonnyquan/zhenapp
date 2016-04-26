package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;


public interface TTbaccountInfoCustomMapper {

	/*
	 * 查询所有有效淘宝账号
	 */
	public List<TTbaccountInfoCustom> findTbaccountBypage(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 查询所有有效淘宝账号
	 */
	public List<TTbaccountInfoCustom> findAllTbaccountBypage(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 插入淘宝账号信息
	 */
	public int insertTbaccount(TTbaccountInfoCustom tTbaccountInfoCustom ) throws Exception;
	/*
	 * 根据id删除帐号信息
	 */
	public int deleteTbaccountByid(String tbaccountids) throws Exception;
}