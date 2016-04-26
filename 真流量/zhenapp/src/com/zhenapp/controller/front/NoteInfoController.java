package com.zhenapp.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.TNoteInfo;
import com.zhenapp.service.NoteService;

@Controller
@RequestMapping(value="/note")
public class NoteInfoController {
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value="/findNoteInfo")
	public @ResponseBody TNoteInfo findNoteInfo() throws Exception{
		List<TNoteInfo> list=noteService.findAllNoteinfo();
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
