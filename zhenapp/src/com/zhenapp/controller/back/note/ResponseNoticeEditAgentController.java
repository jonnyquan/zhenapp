package com.zhenapp.controller.back.note;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class ResponseNoticeEditAgentController {
	@Autowired
	private NoteInfoService noteService;
	
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 跳转到公告编辑界面-----代理
	 */
	@RequestMapping(value="/responsenoticeEditagent/{noteid}/{notetype}")
	public @ResponseBody ModelAndView responsenoticeEditagent(@PathVariable(value="noteid")String noteid,@PathVariable(value="notetype")String notetype)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("noteid", noteid);
		hashmap.put("notetype", notetype);
		TNoteInfoCustom tNoteInfoCustom=noteService.findNoteinfoByIdAndType(hashmap);
		mv.addObject("tNoteInfoCustom",tNoteInfoCustom);
		mv.setViewName("/backstage/agent/noticeEdit.jsp");
		return mv;
	}
}
