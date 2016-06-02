package com.zhenapp.controller.frontend.authlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/frontend")
public class PasswordRestController {
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 根据用户名，邮箱，临时验证码修改密码，并清空临时验证码
	 */
	@RequestMapping(value="/password/reset")
	public @ResponseBody ModelAndView passwordreset(TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv = new ModelAndView();
		int i = userInfoService.passwordreset(tUserInfoCustom);
		if(i>0){
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","error");
		}
		mv.setViewName("/frontend/passwordsms.jsp");
		return mv;
	}
	@RequestMapping(value="/passwordsms")
	public @ResponseBody ModelAndView passwordsms() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/frontend/passwordsms.jsp");
		return mv;
	}
}
