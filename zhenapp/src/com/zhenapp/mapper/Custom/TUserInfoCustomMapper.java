package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;

public interface TUserInfoCustomMapper {
	/*
	 * 根据用户id修改用户密码
	 */
	public int updateUserpwdByuserid(TUserInfoCustom tUserInfoCustom) throws Exception;
	/*
	 * 个人信息的更新
	 */
	public int updateUser(TUserInfoCustom tUserInfoCustom) throws Exception;
	/*
	 * 根据手机号是否存在此手机信息
	 */
	public int checkMobileUnique(String userphone) throws Exception;
	
	/*
	 * 根据查询是否存在此邮件账号信息
	 */
	public int checkEmailUnique(String regemail) throws Exception;
	/*
	 * 保存用户信息
	 */
	public int saveUser(TUserInfoCustom tUserInfoCustom) throws Exception;
	/*
	 * 根据用户名查询用户信息
	 */
	public TUserInfoCustom findUserByuserid(String userid) throws Exception;
	/*
	 * 根据用户名查询用户信息
	 */
	public List<TUserInfoCustom> findUserBynick(String usernick);

	/*
	 * 分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPage(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 分页查询出用户总数量
	 */
	public int findTotalUserByPage(HashMap<String, Object> pagemap) throws Exception;
	
	/*
	 * 根据角色为代理  分页查询出用户
	 */
	public List<TUserInfoCustom> findUserByPageandRole(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据角色为代理  分页查询出用户总数量
	 */
	public int findTotalUserByPageandRole(HashMap<String, Object> pagemap) throws Exception;
	
	
	/*
	 * 根据用户名密码查询积分点数
	 */
	public String findpointsByUsernickAndPwd(TUserInfoCustom tUserInfoCustom) throws Exception;
	
	/*
	 * 根据用户名和注册邮箱找回密码
	 */
	public TUserInfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 修改用户信息
	 */
	public int updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception;
	/*
	 * 根据userid修改用户积分
	 */
	public int updateUserinfoPointByUserid(TUserInfoCustom tUserInfoCustom) throws Exception;
	/*
	 * 根据用户主键删除用户信息
	 */
	public int deleteUserinfoBypk(String userpk) throws Exception;
	/*
	 * 根据用户主键修改角色为代理用户
	 */
	public int updaterole(String userpk) throws Exception;
	/*
	 * 根据用户主键查询用户信息
	 */
	public TUserInfoCustom findUserByuserpk(String userpk) throws Exception;
	/*
	 * 根据用户主键及所属代理id删除用户信息
	 */
	public int deleteUserByUserpkAndRole(HashMap<String,Object> hashmap) throws Exception;
}