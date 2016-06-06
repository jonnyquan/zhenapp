package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class DeleteUserAdminController {
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 * 删除用户信息  ------系统管理员
	 */
	@RequestMapping(value="/deleteUserByUserpkAndAdmin")
	public @ResponseBody ModelMap deleteUserByUserpkAdmin(HttpSession session,String userpk) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("userpk", userpk);
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		hashmap.put("updatetime", sdf.format(new Date()));
		//根据要删除的用户主键及登录人的代理id修改需要删除的用户的状态为30
		userInfoService.updateUserState(hashmap);
		map.put("ec", 0);
		return map;
	}
}
