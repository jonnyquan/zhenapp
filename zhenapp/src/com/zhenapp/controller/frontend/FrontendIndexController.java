package com.zhenapp.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/frontend")
public class FrontendIndexController {
	@RequestMapping(value="/index")
	public @ResponseBody ModelAndView index() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/frontend/index.jsp");
		return mv;
	}
	
	@RequestMapping(value="/anli")
	public @ResponseBody ModelAndView anli() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("anli",1);
		mv.setViewName("/frontend/index.jsp");
		return mv;
	}
}
