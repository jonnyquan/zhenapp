package com.zhenapp.controller.back.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/note")
public class ResponseNoteAddAgentController {

	/*
	 * 跳转到添加公告信息页面-----代理
	 */
	@RequestMapping(value="/responseNoteaddagent")
	public @ResponseBody ModelAndView responseNoteaddagent() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backstage/agent/noticeAdd.jsp");
		return mv;
	}
}
