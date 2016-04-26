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
@RequestMapping(value="/web")
public class WebInfoController {

	@Autowired
	private WebInfoService webInfoService;
	
	@RequestMapping(value="/findWebBywebwww")
	public @ResponseBody ModelAndView findWebBywebwww(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebBywebwww(webwww);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.setViewName("/page/upload/webEdit.jsp");
		return mv;
	}
}
