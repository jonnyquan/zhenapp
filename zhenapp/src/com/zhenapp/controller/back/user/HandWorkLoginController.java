package com.zhenapp.controller.back.user;

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
public class HandWorkLoginController {
	@Autowired
	private UserInfoService userInfoService;

	/*
	 * 后台登录用户账号 -----代理
	 */
	@RequestMapping(value="/handworkLogin")
	public @ResponseBody ModelAndView handworkLogin(HttpSession session,String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom= userInfoService.findUserByuserpk(userpk);
		if(tUserInfoCustom!=null){
			session.removeAttribute("tUserInfoCustom");//删除原session中的用户信息
			session.setAttribute("tUserInfoCustom", tUserInfoCustom);//重新设置session中的用户信息
		}
		mv.setViewName("redirect:/user/responseuser");
		return mv;
	}
}
