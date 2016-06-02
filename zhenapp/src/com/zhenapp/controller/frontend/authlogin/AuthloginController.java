package com.zhenapp.controller.frontend.authlogin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/frontend")
public class AuthloginController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	/*
	 * 登录操作
	 */
	@RequestMapping(value="/login")
	public @ResponseBody ModelAndView login(HttpSession httpSession, HttpServletRequest request,String username,String password) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TUserInfoCustom> list=userInfoService.findUserBynick(username);
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		if (list.size()>0) {
			TUserInfoCustom tUserInfoCustom=list.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				httpSession.setMaxInactiveInterval(900); //15分钟
				httpSession.setAttribute("tUserInfoCustom", tUserInfoCustom);
				mv.setViewName("/user/responseuser");
			}else{
				mv.addObject("msg","密码不正确");
				mv.addObject("username",username);
				mv.setViewName("/frontend/authlogin.jsp");
			}
		}else{
			mv.addObject("msg","用户名不存在");
			mv.addObject("username",username);
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
}
