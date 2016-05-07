package com.zhenapp.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/frontend")
public class FrontendIntroController {
	@RequestMapping(value="/intro")
	public @ResponseBody ModelAndView intro() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/frontend/intro.jsp");
		return mv;
	}
}
