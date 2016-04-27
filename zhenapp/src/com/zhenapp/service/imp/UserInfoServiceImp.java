package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.TUserInfoMapper;
import com.zhenapp.mapper.Custom.TUserInfoCustomMapper;
import com.zhenapp.po.TUserInfo;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.UserInfoService;
@Service
public class UserInfoServiceImp implements UserInfoService {
	@Autowired
	private TUserInfoMapper tUserInfoMapper;
	@Autowired
	private TUserInfoCustomMapper tUserInfoCustomMapper;

	/*
	 * 保存用户信息 -----注册使用
	 */
	@Override
	public int saveUser(TUserInfo tUserInfo) throws Exception {
		return tUserInfoMapper.insert(tUserInfo);
	}

	/*
	 * 根据用户名查询用户信息 -----供登录及根据用户名查询用户信息使用
	 */
	public List<TUserInfoCustom> findUserBynick(String usernick) {
		return tUserInfoCustomMapper.findUserBynick(usernick);
	}

	/*
	 * 查询所有用户信息
	 */
	public List<TUserInfoCustom> findAllUser() throws Exception {
		return tUserInfoCustomMapper.findAllUser();
	}

	/*
	 * 根据用户名密码查询积分点数
	 */
	public String findpointsByUserid(TUserinfoVo tUserinfoVo) throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.findpointsByUserid(tUserinfoVo);
	}

	@Override
	public TUserInfoCustom findPasswordByemail(TUserinfoVo tUserinfoVo)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.findPasswordByemail(tUserinfoVo);
	}

	@Override
	public int updateUserinfo(TUserinfoVo tUserinfoVo)
			throws Exception {
		// TODO Auto-generated method stub
		return tUserInfoCustomMapper.updateUserinfo(tUserinfoVo);
	}
}
