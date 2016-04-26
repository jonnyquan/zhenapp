package com.zhenapp.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	@Autowired
	private WebInfoService webInfoService;
	
	/*
	 * 查询首页中QQ信息 图片信息 二维码信息
	 */
	@RequestMapping(value="/findwebinfo")
	public @ResponseBody ModelAndView findwebinfo(HttpServletRequest request) throws Exception{
		ModelAndView mv= new ModelAndView();
		String webwww=request.getServerName();
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebBywebwww(webwww);
		
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.setViewName("/bootstrap/index.jsp");
		
		return mv;
	}
	
	
}
