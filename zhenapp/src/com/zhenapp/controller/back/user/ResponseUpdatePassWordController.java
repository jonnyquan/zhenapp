package com.zhenapp.controller.back.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class ResponseUpdatePassWordController {

	/*
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value="/responseupdatepassword")
	public ModelAndView responseupdatepassword() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/backstage/user/updatepassword.jsp");
		return mv;
	}
}
