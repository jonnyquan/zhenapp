package com.zhenapp.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/frontend")
public class FrontendAuthloginController {
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 跳转到登录页面
	 */
	@RequestMapping(value="/authlogin")
	public @ResponseBody ModelAndView authlogin(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("tUserInfoCustom") != null){
			mv.setViewName("/backstage/user/user.jsp");
		}else{
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
	
	/*
	 * 登录操作
	 */
	@RequestMapping(value="/login")
	public @ResponseBody ModelAndView login(HttpSession httpSession, String username,String password) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TUserInfoCustom> list=userInfoService.findUserBynick(username);
		if (list.size()>0) {
			TUserInfoCustom tUserInfoCustom=list.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				httpSession.setMaxInactiveInterval(900); //15分钟
				httpSession.setAttribute("tUserInfoCustom", tUserInfoCustom);
				mv.setViewName("/backstage/user/user.jsp");
			}else{
				mv.addObject("msg","密码不正确");
				mv.setViewName("/frontend/authlogin.jsp");
			}
		}else{
			mv.addObject("msg","用户名不存在");
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
}
