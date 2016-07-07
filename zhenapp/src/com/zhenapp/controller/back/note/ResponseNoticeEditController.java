package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class ResponseNoticeEditController {
	@Autowired
	private NoteInfoService noteService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

	/*
	 * 跳转到公告编辑界面-----系统管理员
	 */
	@RequestMapping(value="/responsenoticeEdit/{noteid}/{notetype}")
	public @ResponseBody ModelAndView responsenoticeEdit(HttpSession session,@PathVariable(value="noteid")String noteid,@PathVariable(value="notetype")String notetype)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		hashmap.put("noteid", noteid);
		hashmap.put("notetype", notetype);
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		TNoteInfoCustom tNoteInfoCustom=noteService.findNoteinfoByIdAndType(hashmap);
		mv.addObject("tNoteInfoCustom",tNoteInfoCustom);
		mv.setViewName("/backstage/admin/noticeEdit.jsp");
		return mv;
	}
}
