package com.zhenapp.controller.back.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/user")
public class AuthLogoutController {
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private WebInfoService webInfoService;
	/*
	 * 退出系统
	 */
	@RequestMapping(value="/authlogout")
	public ModelAndView authlogout(HttpSession session,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		if (tAgentInfoCustom !=null) {
			TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
			mv.addObject("tWebInfoCustom",tWebInfoCustom);
			session.removeAttribute("tUserInfoCustom");
			mv.setViewName("/frontend/authlogin.jsp");
		}else{
			session.removeAttribute("tUserInfoCustom");
			mv.addObject("msg","您访问的网址查询不到对应的代理!");
			mv.setViewName("/agenterror.jsp");
		}
		return mv;
	}	
}
