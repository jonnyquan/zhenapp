package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TUsertestInfoCustom;

public interface UsertestInfoService {
	//添加测试账号信息
	public int insertUsertest(TUsertestInfoCustom tUsertestInfoCustom) throws Exception;
	
	//删除测试账号信息
	public int deleteUsertest(HashMap<String, Object> hashmap) throws Exception;
	
	//查询测试账号信息
	public List<TUsertestInfoCustom> findUserTest(HashMap<String, Object> hashmap) throws Exception;
	//查询测试账号信息总数
	public int findTotalUsertest(HashMap<String, Object> hashmap) throws Exception;
}
