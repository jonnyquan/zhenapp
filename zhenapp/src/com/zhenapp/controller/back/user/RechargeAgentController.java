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
public class RechargeAgentController {
	@Autowired
	private UserInfoService userInfoService;

	/*
	 * 跳转到手工充值扣款界面 -----代理
	 */
	@RequestMapping(value="/recharge")
	public @ResponseBody ModelAndView recharge(String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom= userInfoService.findUserByuserpk(userpk);
		mv.addObject("points", tUserInfoCustom.getPoints());
		mv.addObject("userpk", userpk);
		mv.setViewName("/backstage/agent/recharge.jsp");
		return mv;
	}
}
