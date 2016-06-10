package com.zhenapp.controller.back.note;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class DeleteNoteAndInfoController {
	@Autowired
	private NoteInfoService noteService;
	@Autowired
	private ElectrityInfoService electrityInfoService;
	@Autowired
	private GuideInfoService guideInfoService;

	/*
	 * 删除公告信息及对应的电商信息或者新手指引信息
	 */
	@RequestMapping(value="/DeleteNoteAndinfo/{noteid}/{notetype}")
	public @ResponseBody ModelAndView DeleteNoteAndinfo(@PathVariable(value="noteid")String noteid,@PathVariable(value="notetype")String notetype) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("noteid", noteid);
		hashmap.put("notetype", notetype);
		noteService.deleteByIdAndType(hashmap);
		if(notetype.equals("0")){
			electrityInfoService.deleteById(hashmap);
		}else if(notetype.equals("1")){
			guideInfoService.deleteById(hashmap);
		}
		mv.setViewName("/note/findnoticeList");
		return mv;
	}
}
