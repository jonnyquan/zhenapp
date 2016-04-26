package com.zhenapp.mapper.Custom;

import java.util.List;

import com.zhenapp.po.PageInfo;
import com.zhenapp.po.Custom.TelectricityCustom;

public interface TElectricityInfoCustomMapper {
	/*
	 * 查询前10条电商信息  用于侧边栏展示 按时间倒序排列
	 */
	public List<TelectricityCustom> findElectrity_10() throws Exception;
	
	/*
	 * 查询全部电商信息  用于电商信息页面展示
	 */
	public List<TelectricityCustom> findAllElectrity() throws Exception;
	
	
	/*
	 * 根据主键查询电商详情
	 */
	public TelectricityCustom findElectrityBypk(String electricitypk) throws Exception;
	
	/*
	 * 分页查询电商信息
	 */
	public List<TelectricityCustom> findElectrityBypage(PageInfo pageinfo) throws Exception;
}
