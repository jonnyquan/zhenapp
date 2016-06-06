package com.zhenapp.controller.frontend.index;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TIndexInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.IndexInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/frontend")
public class IndexController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private IndexInfoService indexInfoService;
	
	/*
	 * 查询web信息 跳转到主页
	 */
	@RequestMapping(value="/index")
	public @ResponseBody ModelAndView index(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("agentid", tAgentInfoCustom.getAgentid());
		TIndexInfoCustom tIndexInfoCustom = indexInfoService.findIndex(hashmap);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tIndexInfoCustom",tIndexInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.setViewName("/frontend/index.jsp");
		return mv;
	}
	
	/*
	 * 成功案例界面的锚点设置
	 */
	@RequestMapping(value="/anli")
	public @ResponseBody ModelAndView anli(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("anli",1);
		mv.setViewName("/frontend/index.jsp");
		return mv;
	}
}
