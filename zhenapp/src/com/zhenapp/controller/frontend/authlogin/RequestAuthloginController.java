package com.zhenapp.controller.frontend.authlogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/frontend")
public class RequestAuthloginController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	/*
	 * 跳转到登录页面
	 */
	@RequestMapping(value="/authlogin")
	public @ResponseBody ModelAndView authlogin(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		if(session.getAttribute("tUserInfoCustom") != null){
			mv.setViewName("/user/responseuser");
		}else{
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
}
