package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TRechargeInfoCustom;


public interface TRechargeInfoCustomMapper {
	/*
	 * 根据用户名查询充值记录
	 */
	public List<TRechargeInfoCustom> findRechargeinfoByUser(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据用户名分页查询充值记录
	 */
	public int findTotalRechargeinfoByUserAndpage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据用户名分页查询充值记录
	 */
	public List<TRechargeInfoCustom> findRechargeinfoByUserAndpage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据角色分页查询充值记录
	 */
	public int findTotalRechargeinfoByRoleAndpage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据角色分页查询充值记录
	 */
	public List<TRechargeInfoCustom> findRechargeinfoByRoleAndpage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 插入充值记录
	 */
	public int insertRechargeinfo(TRechargeInfoCustom tRechargeInfoCustom) throws Exception;
	
	/*
	 * 删除充值记录
	 */
	public int deleteRechargeinfoByid(String rechargeids) throws Exception;
	/*
	 * 根据验证码更新充值状态
	 */
	public int updateRechargestate(String verificationcode)throws Exception;
	/*
	 * 根据验证码查询充值信息
	 */
	public TRechargeInfoCustom findRechargeBycode(String verificationcode)throws Exception;
}