package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TPriceInfoCustom;

public interface PriceInfoService {
	/*
	 * 根据价格类型代码查询价格信息
	 */
	public TPriceInfoCustom findPriceBycode(String pricecode) throws Exception;
	
	/*
	 * 根据价格类型代码查询价格信息
	 */
	public List<TPriceInfoCustom> findAllPrice() throws Exception;
	/*
	 * 根据价格类型代码修改价格信息
	 */
	public int updatePriceBycode(HashMap<String,Object> hashmap) throws Exception;
}
