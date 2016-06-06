package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class UpdateUserController {
	@Autowired
	private UserInfoService userInfoService;

	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 * 用于用户修改基本信息
	 */
	@RequestMapping(value="/updateUser")
	public @ResponseBody ModelAndView updateUser(HttpSession session,TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv =new ModelAndView();
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		userInfoService.updateUser(tUserInfoCustom);
		mv.setViewName("responsepersonal");
		return mv;
	}
}
