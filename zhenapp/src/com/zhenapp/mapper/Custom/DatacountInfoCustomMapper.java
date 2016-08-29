package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.DatacountInfoCustom;
import com.zhenapp.po.Custom.TDatacountInfoCustom;



public interface DatacountInfoCustomMapper {
	/*
	 * 按照日期分组查询 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public List<DatacountInfoCustom> findDataBydate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 按照日期统计 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public DatacountInfoCustom findSUMDataBydate(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 按照日期分组查询 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public List<TDatacountInfoCustom> findDatacountBydate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 按照日期统计 流量数 收藏数 购物车数 购买积分 消耗积分和后台操作积分数
	 */
	public TDatacountInfoCustom findSUMDatacountBydate(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据日前统计到数据信息表中
	 */
	public int saveDatacount(HashMap<String, Object> hashmap)throws Exception;
}