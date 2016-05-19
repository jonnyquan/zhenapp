package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TUserInfoCustomMapper;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.UserInfoService;
@Service
public class UserInfoServiceImp implements UserInfoService {
	@Autowired
	private TUserInfoCustomMapper tUserInfoCustomMapper;
	/*
	 * 保存用户信息 -----注册使用
	 */
	public int saveUser(TUserInfoCustom tUserInfoCustom) throws Exception {
		return tUserInfoCustomMapper.saveUser(tUserInfoCustom);
	}
	/*
	 * 根据用户名查询用户信息 -----供登录及根据用户名查询用户信息使用
	 */
	public List<TUserInfoCustom> findUserBynick(String usernick) {
		return tUserInfoCustomMapper.findUserBynick(usernick);
	}
	/*
	 * 根据用户名密码查询积分点数
	 */
	public String findpointsByUsernickAndPwd(TUserInfoCustom tUserInfoCustom) throws Exception {
		return tUserInfoCustomMapper.findpointsByUsernickAndPwd(tUserInfoCustom);
	}
	@Override
	public TUserInfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo)
			throws Exception {
		return tUserInfoCustomMapper.findPasswordByemail(tUserinfoVo);
	}
	@Override
	public int updateUserinfo(TUserinfoVo tUserinfoVo)
			throws Exception {
		return tUserInfoCustomMapper.updateUserinfo(tUserinfoVo);
	}
	@Override
	public List<TUserInfoCustom> findUserByPage(HashMap<String, Object> pagemap) throws Exception {
		return tUserInfoCustomMapper.findUserByPage(pagemap);
	}
	@Override
	public int deleteUserinfoBypk(String userpk) throws Exception {
		return tUserInfoCustomMapper.deleteUserinfoBypk(userpk);
	}
	@Override
	public TUserInfoCustom findUserByuserid(String userid) throws Exception {
		return tUserInfoCustomMapper.findUserByuserid(userid);
	}
	@Override
	public int updateUserinfoPointByUserid(TUserInfoCustom tUserInfoCustom) throws Exception {
		return tUserInfoCustomMapper.updateUserinfoPointByUserid(tUserInfoCustom);
	}
	@Override
	public int updaterole(String userpk) throws Exception {
		return tUserInfoCustomMapper.updaterole(userpk);
	}
	@Override
	public TUserInfoCustom findUserByuserpk(String userpk) throws Exception {
		return tUserInfoCustomMapper.findUserByuserpk(userpk);
	}
	@Override
	public int findTotalUserByPage(HashMap<String, Object> pagemap)
			throws Exception {
		return tUserInfoCustomMapper.findTotalUserByPage(pagemap);
	}
	@Override
	public List<TUserInfoCustom> findUserByPageandRole(
			HashMap<String, Object> pagemap) throws Exception {
		return tUserInfoCustomMapper.findUserByPageandRole(pagemap);
	}
	@Override
	public int findTotalUserByPageandRole(HashMap<String, Object> pagemap)
			throws Exception {
		return tUserInfoCustomMapper.findTotalUserByPageandRole(pagemap);
	}
	@Override
	public int checkEmailUnique(String regemail) throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.checkEmailUnique(regemail);
	}
	@Override
	public int checkMobileUnique(String userphone) throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.checkMobileUnique(userphone);
	}
	@Override
	public int updateUser(TUserInfoCustom tUserInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.updateUser(tUserInfoCustom);
	}
	@Override
	public int updateUserpwdByuserid(TUserInfoCustom tUserInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.updateUserpwdByuserid(tUserInfoCustom);
	}
	@Override
	public int deleteUserByUserpkAndRole(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.deleteUserByUserpkAndRole(hashmap);
	}
	@Override
	public int deleteUserByUserpkAndAdmin(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.deleteUserByUserpkAndAdmin(hashmap);
	}
	@Override
	public int updateroleAndagent(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.updateroleAndagent(hashmap);
	}
}
