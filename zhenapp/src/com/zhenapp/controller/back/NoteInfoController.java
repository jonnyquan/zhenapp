package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class NoteInfoController {
	@Autowired
	private NoteInfoService noteService;
	@Autowired
	private ElectrityInfoService electrityInfoService;
	@Autowired
	private GuideInfoService guideInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 公告信息列表查询
	 */
	@RequestMapping(value="/findnoticeList")
	public @ResponseBody ModelAndView findnoticeList(HttpSession session,Integer page,Integer rows)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findNoteinfoByPage(pagemap);
		int total = noteService.findTotalNoteinfoByPage();
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/admin/noticeList.jsp");
		return mv;
	}
	
	/*
	 * 跳转到公告编辑界面
	 */
	@RequestMapping(value="/responsenoticeEdit/{noteid}/{notetype}")
	public @ResponseBody ModelAndView responsenoticeEdit(@PathVariable(value="noteid")String noteid,@PathVariable(value="notetype")String notetype)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("noteid", noteid);
		hashmap.put("notetype", notetype);
		TNoteInfoCustom tNoteInfoCustom=noteService.findNoteinfoByIdAndType(hashmap);
		mv.addObject("tNoteInfoCustom",tNoteInfoCustom);
		mv.setViewName("/backstage/admin/noticeEdit.jsp");
		return mv;
	}
	
	/*
	 * 修改公告信息
	 */
	@RequestMapping(value="/updatenote")
	public @ResponseBody ModelMap updatenote(HttpSession session,TNoteInfoCustom tNoteInfoCustom)throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		tNoteInfoCustom.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("noteid", tNoteInfoCustom.getNoteid());
		hashmap.put("notetext", tNoteInfoCustom.getNotetext());
		hashmap.put("notename", tNoteInfoCustom.getNotename());
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		if(tNoteInfoCustom.getNotetype().equals("0")){//类型为0表示电商信息
			electrityInfoService.updateElectrityById(hashmap);
		}else if(tNoteInfoCustom.getNotetype().equals("1")){//类型为1表示新手指引信息
			guideInfoService.updateGuideById(hashmap);
		}
		noteService.updatenoteByid(tNoteInfoCustom);
		
		map.put("ec", "0");
		return map;
	}
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
