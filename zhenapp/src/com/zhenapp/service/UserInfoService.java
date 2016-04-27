package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.TUserInfo;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;

public interface UserInfoService {
	
	/*
	 * 根据用户名查询用户信息
	 */
	public List<TUserInfoCustom> findUserBynick(String usernick) throws Exception;
	
	/*
	 * 分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPage(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 保存用户信息
	 */
	public int saveUser(TUserInfo tUserInfo) throws Exception;
	
	/*
	 * 根据用户信息查询积分
	 */
	public String findpointsByUserid(TUserinfoVo tUserinfoVo) throws Exception;
	
	/*
	 * 根据用户名和注册邮箱找回密码
	 */
	public TUserInfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 修改用户信息
	 */
	public int updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception;
}
