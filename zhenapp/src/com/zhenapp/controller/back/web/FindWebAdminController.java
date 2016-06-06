package com.zhenapp.controller.back.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/web")
public class FindWebAdminController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 根据代理id查询web信息--系统管理员
	 */
	@RequestMapping(value="/findWebByAgentidadmin")
	public @ResponseBody ModelAndView findWebByAgentidadmin(String agentid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(agentid);
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid(agentid);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.setViewName("/backstage/admin/websetting.jsp");
		return mv;
	}
}
