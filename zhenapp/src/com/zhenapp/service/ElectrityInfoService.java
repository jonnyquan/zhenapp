package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.TElectricityInfo;
import com.zhenapp.po.Custom.TelectricityCustom;

public interface ElectrityInfoService {
	
	/*
	 * 保存电商信息
	 */
	public int insertElectrity(TElectricityInfo electricityInfo) throws Exception;
	
	/*
	 * 查询前10条电商信息  用于侧边栏展示 按时间倒序排列
	 */
	public List<TelectricityCustom> findElectrity_10(HashMap<String,Object> pagemap) throws Exception;
	/*
	 * 查询全部电商信息  用于电商信息页面展示
	 */
	public List<TelectricityCustom> findAllElectrity(HashMap<String,Object> pagemap) throws Exception;
	
	/*
	 * 根据电商信息主键查询电商信息
	 */
	public TelectricityCustom findElectrityBypk(String electricitypk) throws Exception;
	
	/*
	 * 分页查询电商信息
	 */
	public List<TelectricityCustom> findElectrityBypage(HashMap<String,Object> pagemap) throws Exception;
	/*
	 * 根据id修改电商信息
	 */
	public int updateElectrityById(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据id删除电商信息
	 */
	public int deleteById(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 保存电商信息
	 */
	public int saveElectrity(TelectricityCustom telectricityCustom)throws Exception; 
}
