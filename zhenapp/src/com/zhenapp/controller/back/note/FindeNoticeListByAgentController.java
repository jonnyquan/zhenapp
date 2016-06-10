package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.NoteInfoService;

@Controller
@RequestMapping(value="/note")
public class FindeNoticeListByAgentController {
	@Autowired
	private NoteInfoService noteService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 查询公告信息列表-----代理
	 */
	@RequestMapping(value="/findnoticeListByAgent")
	public @ResponseBody ModelAndView findnoticeListByAgent(HttpSession session,Integer page)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findNoteinfoByPage(pagemap);
		int total = noteService.findTotalNoteinfoByPage(pagemap);
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/agent/noticeList.jsp");
		return mv;
	}
}
