package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class FindNoticeListController {
	@Autowired
	private NoteInfoService noteService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 公告信息列表查询-----系统管理员
	 */
	@RequestMapping(value="/findnoticeList")
	public @ResponseBody ModelAndView findnoticeList(Integer page)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findNoteinfoByPage(pagemap);
		int total = noteService.findTotalNoteinfoByPage(pagemap);
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/admin/noticeList.jsp");
		return mv;
	}
}
