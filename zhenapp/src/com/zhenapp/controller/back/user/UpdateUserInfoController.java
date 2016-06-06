package com.zhenapp.controller.back.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class UpdateUserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 用于用户修改基本信息
	 */
	@RequestMapping(value="/updateUserinfo")
	public @ResponseBody ModelAndView updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception{
		ModelAndView mv =new ModelAndView();
		userInfoService.updateUserinfo(tUserinfoVo);
		mv.setViewName("/user/findUserinfoByusernick");
		return mv;
	}
}
