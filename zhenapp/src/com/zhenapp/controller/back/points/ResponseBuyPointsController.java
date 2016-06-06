package com.zhenapp.controller.back.points;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.ComboInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseBuyPointsController {
	
	@Autowired
	private ComboInfoService comboInfoService;
	/*
	 * 跳转到购买积分界面
	 */
	@RequestMapping(value="/responsebuypoints")
	public ModelAndView responsebuypoints(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("agentid", tUserInfoCustom.getAgentid());
		hashmap.put("page", 0);
		hashmap.put("rows", 1000);
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findComboByAgentid(hashmap);
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.setViewName("/backstage/points/buypoints.jsp");
		return mv;
	}
}
