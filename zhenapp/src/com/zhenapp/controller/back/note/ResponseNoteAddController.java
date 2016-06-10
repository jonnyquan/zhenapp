package com.zhenapp.controller.back.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/note")
public class ResponseNoteAddController {
	/*
	 * 跳转到添加公告信息页面-----系统管理员
	 */
	@RequestMapping(value="/responseNoteadd")
	public @ResponseBody ModelAndView responseNoteadd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backstage/admin/noticeAdd.jsp");
		return mv;
	}
}
