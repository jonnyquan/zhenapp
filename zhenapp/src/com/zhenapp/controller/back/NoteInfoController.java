package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class NoteInfoController {
	@Autowired
	private NoteInfoService noteService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 公告信息列表查询
	 */
	@RequestMapping(value="/findnoticeList")
	public @ResponseBody ModelAndView findnoticeList()throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findAllNoteinfo();
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.setViewName("/backstage/admin/noticeList.jsp");
		return mv;
	}
	
	/*
	 * 跳转到公告编辑界面
	 */
	@RequestMapping(value="/responsenoticeEdit")
	public @ResponseBody ModelAndView responsenoticeEdit(String noteid)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("noteid", noteid);
		TNoteInfoCustom tNoteInfoCustom=noteService.findNoteinfoById(hashmap);
		mv.addObject("tNoteInfoCustom",tNoteInfoCustom);
		mv.setViewName("/backstage/admin/noticeEdit.jsp");
		return mv;
	}
	
	/*
	 * 保存公告信息
	 */
	@RequestMapping(value="/updatenote")
	public @ResponseBody ModelMap updatenote(HttpSession session,TNoteInfoCustom tNoteInfoCustom)throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		
		tNoteInfoCustom.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		
		noteService.updatenoteByid(tNoteInfoCustom);
		
		map.put("ec", "0");
		return map;
	}
}
