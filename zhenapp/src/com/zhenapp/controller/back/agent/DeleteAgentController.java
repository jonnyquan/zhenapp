package com.zhenapp.controller.back.agent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Controller
@RequestMapping(value="/agent")
public class DeleteAgentController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * 删除代理信息    修改状态假删除
	 */
	@RequestMapping(value="/updateagentstateByPk")
	public @ResponseBody ModelAndView updateagentstateByPk(String agentpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("agentpk", agentpk);
		hashmap.put("page", 0);
		hashmap.put("rows", 1);
		List<TAgentInfoCustom> tAgentInfoCustomlist = agentInfoService.findAgentBypage(hashmap);
		if(tAgentInfoCustomlist!=null){
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "修改代理为无效");
			agentInfoService.updateagentstateByPk(hashmap);
			//修改用户状态也为无效
			userInfoService.updateUserState(hashmap);
		}
		mv.setViewName("/agent/responseagentmanage");
		return mv;
	}
}
