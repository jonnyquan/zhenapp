package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;


public interface TTbaccountInfoCustomMapper {
	//将状为nochange的账号信息状态修改为未测试 60 
	public int updateTbaccountstate() throws Exception;
	//修改所有账号的手机标记
	public int updateTbaccountTag(HashMap<String, Object> hashmap) throws Exception;
	//根据手机号获取一个带有标记的淘宝账号
	public List<TTbaccountInfoCustom> findTbaccountByPhoneidandtag(HashMap<String, Object> hashmap) throws Exception;
	//查询大号库的淘宝账号
	public List<TTbaccountInfoCustom> findTbaccountByphoneidisnull() throws Exception;
	/*
	 * 查询所有有效淘宝账号
	 */
	public List<TTbaccountInfoCustom> findTbaccountBypage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 分页查询所有有效淘宝账号
	 */
	public int findTotalTbaccountBypage(HashMap<String, Object> hashmap) throws Exception;
	
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
	/*
	 * 根据手机号查询有效的淘宝账号信息
	 */
	public List<TTbaccountInfoCustom> findTbaccountByPhoneid(String tbaccountphoneid) throws Exception;
	/*
	 * 根据淘宝账号id查询账号信息
	 */
	public List<TTbaccountInfoCustom> findTbaccountByAccountname(String tbaccountphoneid) throws Exception;
	/*
	 * 根据id修改淘宝账号信息
	 */
	public int updateTbaccountByid(TTbaccountInfoCustom tTbaccountInfoCustom ) throws Exception;
	/*
	 * 按条件删除淘宝账号信息
	 */
	public int deleteAccount(HashMap<String, Object> pagemap) throws Exception;
}