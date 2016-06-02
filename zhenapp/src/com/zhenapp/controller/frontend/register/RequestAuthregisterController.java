package com.zhenapp.controller.frontend.register;

import javax.servlet.http.HttpServletRequest;

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
public class RequestAuthregisterController {
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private WebInfoService webInfoService;
	
	@RequestMapping(value="/authregister")
	public @ResponseBody ModelAndView requestauthregister(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.setViewName("/frontend/authregister.jsp");
		return mv;
	}
	
}
