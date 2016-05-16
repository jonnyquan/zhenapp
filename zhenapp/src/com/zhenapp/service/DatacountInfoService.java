package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.DatacountInfoCustom;

public interface DatacountInfoService {
	/*
	 * 按照日期分组查询 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public List<DatacountInfoCustom> findDataBydate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 按照日期统计 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public DatacountInfoCustom findSUMDataBydate(HashMap<String, Object> hashmap) throws Exception;

}
