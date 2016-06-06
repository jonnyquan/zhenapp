package com.zhenapp.controller.back.combo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value = "/combo")
public class FindComboAgentController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 根据登录代理id查询套餐信息-----代理
	 */
	@RequestMapping(value = "/findComboByagent")
	public @ResponseBody
	ModelAndView findComboByagent(HttpSession session,Integer page) throws Exception {
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		//根据代理id查询套餐信息
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findComboByAgentid(pagemap);
		int total = comboInfoService.findTotalComboByAgentid(pagemap);
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("points", points);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.setViewName("/backstage/agent/combo.jsp");
		return mv;
	}
}
