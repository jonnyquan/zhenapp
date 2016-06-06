package com.zhenapp.controller.back.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class RechargeAdminforAgentController {
	@Autowired
	private UserInfoService userInfoService;

	/*
	 * 跳转到为代理手工充值扣款界面 -----系统管理员
	 */
	@RequestMapping(value="/rechargeadminforagent")
	public @ResponseBody ModelAndView rechargeadminforagent(String agentuserid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(agentuserid);
		mv.addObject("points", tUserInfoCustom.getPoints());
		mv.addObject("userpk", tUserInfoCustom.getUserpk());
		mv.setViewName("/backstage/admin/rechargeagent.jsp");
		return mv;
	}
}
