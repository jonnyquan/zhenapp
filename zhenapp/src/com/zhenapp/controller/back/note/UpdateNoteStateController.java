package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class UpdateNoteStateController {
	@Autowired
	private NoteInfoService noteService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${middleRows}")
	private Integer middleRows;

	/*
	 * 审核通过,修改公告状态
	 */
	@RequestMapping(value="/updatenotestate/{noteid}/{notetype}")
	public @ResponseBody ModelAndView updatenotestate(HttpSession session,@PathVariable(value="noteid")String noteid,@PathVariable(value="notetype")String notetype)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		hashmap.put("noteid", noteid);
		hashmap.put("notetype", notetype);
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		noteService.updatenotestateByidandtype(hashmap);
		mv.setViewName("/note/findnoticeList");
		return mv;
	}
}
