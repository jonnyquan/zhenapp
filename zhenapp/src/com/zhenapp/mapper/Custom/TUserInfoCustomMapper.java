package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;

public interface TUserInfoCustomMapper {
    
	/*
	 * 根据用户名查询用户信息
	 */
	List<TUserInfoCustom> findUserBynick(String usernick);

	/*
	 * 分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPage(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 根据用户名密码查询积分点数
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
	/*
	 * 根据用户主键删除用户信息
	 */
	public int deleteUserinfoBypk(String userpk) throws Exception;
}