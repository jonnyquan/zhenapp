package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TPhoneInfoCustom;

public interface PhoneInfoService {
	/*
	 * 查询当前执行任务的手机中任务状态未完成
	 * 并且手机状态正常
	 * 并且当天没有执行该宝贝id的
	 * 手机编号
	 */
	public TPhoneInfoCustom findTPhoneByTask(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 查询当前执行任务的手机中任务状态未完成
	 * 并且手机状态正常
	 * 并且当天没有执行该宝贝id的
	 * 手机编号
	 */
	public List<TPhoneInfoCustom> findAllPhoneBykeynum(String keynum) throws Exception;
	/* 
	 * 根据宝贝id 查询当前还能做该宝贝流量的数目
	 */
	public int findPhonecountBykeynum(String keynum) throws Exception;
	
	/*
	 * 查询出指定数目条数的手机信息
	 */
	public List<TPhoneInfoCustom> findAllPhoneBycount(int count) throws Exception;
	
	
	/*
	 * 查询手机待完成的任务情况
	 */
	public List<TPhoneInfoCustom> findPhoneAndTask(HashMap<String, Object> hashmap) throws Exception;
	
}
