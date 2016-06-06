package com.zhenapp.controller.back.user;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class ResonsePersonalController {
	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * 跳转到个人基本信息页面
	 */
	@RequestMapping(value="/responsepersonal")
	public ModelAndView responsepersonal(HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("tUserInfoCustom")==null){
			mv.setViewName("/frontend/authlogin.jsp");
		}else{
			TUserInfoCustom tUserInfoCustom = (TUserInfoCustom)session.getAttribute("tUserInfoCustom");
			tUserInfoCustom = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
			session.setAttribute("tUserInfoCustom", tUserInfoCustom);
			mv.setViewName("/backstage/user/personal.jsp");
		}
		return mv;
	}
}
