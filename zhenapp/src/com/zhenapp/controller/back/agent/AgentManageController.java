package com.zhenapp.controller.back.agent;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.service.AgentInfoService;
@Transactional
@Controller
@RequestMapping(value="/agent")
public class AgentManageController {
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${maxRows}")
	private Integer maxRows;
	/*
	 * 跳转到代理管理界面-----系统管理员
	 */
	@RequestMapping(value="/responseagentmanage")
	public @ResponseBody ModelAndView responseagentmanage(Integer page) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * maxRows);
		pagemap.put("rows", maxRows);
		pagemap.put("agentstate", 29);
		List<TAgentInfoCustom> tAgentInfoCustomlist= agentInfoService.findAgentBypage(pagemap);
		int total= agentInfoService.findTotalAgentBypage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum",page);
		mv.addObject("tAgentInfoCustomlist", tAgentInfoCustomlist);
		mv.setViewName("/backstage/admin/agentmanage.jsp");
		return mv;
	}	
}
