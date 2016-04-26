package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Vo.TRechargeInfoVo;

public interface RechargeInfoService {
	/*
	 * 根据用户名查询充值记录
	 */
	public List<TRechargeInfoCustom> findRechargeinfoByUser(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据用户名分页查询充值记录
	 */
	public List<TRechargeInfoCustom> findRechargeinfoByUserAndpage(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 插入充值记录
	 */
	public int insertRechargeinfo(TRechargeInfoVo tRechargeInfoVo) throws Exception;
	
	/*
	 * 删除充值记录
	 */
	public int deleteRechargeinfoByid(String rechargeids) throws Exception;
}
