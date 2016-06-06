package com.zhenapp.controller.back.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class FindPointsController {
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 根据用户信息查询余额
	 */
	@RequestMapping(value="/findpoints")
	public @ResponseBody ModelMap findpoints(HttpServletRequest request) throws Exception{
		ModelMap map= new ModelMap();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("points", points);
		return map;
	}
}
