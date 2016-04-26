package com.zhenapp.mapper.Custom;

import java.util.List;

import com.zhenapp.po.Custom.TUserinfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;

public interface TUserInfoCustomMapper {
    
	/*
	 * 根据用户名查询用户信息
	 */
	List<TUserinfoCustom> findUserBynick(String usernick);

    /*
     * 查询所有用户信息
     */
	public List<TUserinfoCustom> findAllUser() throws Exception;
	
	/*
	 * 根据用户名密码查询积分点数
	 */
	public String findpointsByUserid(TUserinfoVo tUserinfoVo) throws Exception;
	
	/*
	 * 根据用户名和注册邮箱找回密码
	 */
	public TUserinfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 修改用户信息
	 */
	public int updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception;
}