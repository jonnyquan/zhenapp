package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.service.AgentInfoService;

@Controller
@RequestMapping(value="/agent")
public class AgentInfoController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	private AgentInfoService agentInfoService;
	
	/*
	 * 跳转到代理管理界面-----系统管理员
	 */
	@RequestMapping(value="/responseagentmanage")
	public @ResponseBody ModelAndView responseagentmanage(Integer page,Integer rows) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		List<TAgentInfoCustom> tAgentInfoCustomlist= agentInfoService.findAgentBypage(pagemap);
		int total= agentInfoService.findTotalAgentBypage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum",page);
		mv.addObject("tAgentInfoCustomlist", tAgentInfoCustomlist);
		mv.setViewName("/backstage/admin/agentmanage.jsp");
		return mv;
	}
	
	/*
	 * 删除代理信息    修改状态假删除
	 */
	@RequestMapping(value="/updateagentstateByPk")
	public @ResponseBody ModelAndView updateagentstateByPk(String agentpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("agentpk", agentpk);
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", "修改代理 ");
		agentInfoService.updateagentstateByPk(hashmap);
		
		mv.setViewName("responseagentmanage");
		return mv;
	}
	
	
	@RequestMapping(value="/findAgentBypage")
	public @ResponseBody ModelMap findAgentBypage(Integer page,Integer rows) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TAgentInfoCustom> tAgentInfoCustomlist= agentInfoService.findAgentBypage(pagemap);
		//List<TAgentInfoCustom> tAgentInfoCustomAlllist= agentInfoService.findAllAgentBypage(pagemap);
		int total= agentInfoService.findTotalAgentBypage(pagemap);
		map.put("total", total);
		map.put("rows", tAgentInfoCustomlist);
		return map;
	}
	
}
