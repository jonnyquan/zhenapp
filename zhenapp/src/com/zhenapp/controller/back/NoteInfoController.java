package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.IndexInfoService;
import com.zhenapp.service.IntroInfoService;
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
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private IntroInfoService introInfoService;
	@Autowired
	private IndexInfoService indexInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 公告信息列表查询-----系统管理员
	 */
	@RequestMapping(value="/findnoticeList")
	public @ResponseBody ModelAndView findnoticeList(Integer page,Integer rows)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findNoteinfoByPage(pagemap);
		int total = noteService.findTotalNoteinfoByPage(pagemap);
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/admin/noticeList.jsp");
		return mv;
	}
	/*
	 * 查询公告信息列表-----代理
	 */
	@RequestMapping(value="/findnoticeListByAgent")
	public @ResponseBody ModelAndView findnoticeListByAgent(HttpSession session,Integer page,Integer rows)throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TNoteInfoCustom> tNoteInfoCustomlist=noteService.findNoteinfoByPage(pagemap);
		int total = noteService.findTotalNoteinfoByPage(pagemap);
		mv.addObject("tNoteInfoCustomlist",tNoteInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/agent/noticeList.jsp");
		return mv;
	}
		
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
		hashmap.put("notetype", tNoteInfoCustom.getNotetype());
		hashmap.put("notename", tNoteInfoCustom.getNotename());
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		if(tNoteInfoCustom.getNotetype().equals("0")){//类型为0表示电商信息
			electrityInfoService.updateElectrityById(hashmap);
		}else if(tNoteInfoCustom.getNotetype().equals("1")){//类型为1表示新手指引信息
			guideInfoService.updateGuideById(hashmap);
		}else if(tNoteInfoCustom.getNotetype().equals("2")){//类型为2表示服务介绍信息
			introInfoService.updateIntroById(hashmap);
		}else if(tNoteInfoCustom.getNotetype().equals("3")){//类型为3表示首页信息
			indexInfoService.updateIndex(hashmap);
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
	/*
	 * 跳转到添加公告信息页面-----代理
	 */
	@RequestMapping(value="/responseNoteaddagent")
	public @ResponseBody ModelAndView responseNoteaddagent() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backstage/agent/noticeAdd.jsp");
		return mv;
	}
	/*
	 * 添加公告信息 ----- 代理
	 */
	@RequestMapping(value="/Addnoteagent")
	public @ResponseBody ModelMap Addnoteagent(HttpSession session,TNoteInfoCustom tNoteInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String id=UUID.randomUUID().toString().replace("-", "");
		tNoteInfoCustom.setNoteid(id);
		tNoteInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tNoteInfoCustom.setNotestate("66");
		tNoteInfoCustom.setCreatetime(sdf.format(new Date()));
		tNoteInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tNoteInfoCustom.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		noteService.savenote(tNoteInfoCustom);
		if(tNoteInfoCustom.getNotetype().equals("0")){
			//添加电商信息
			TelectricityCustom telectricityCustom = new TelectricityCustom();
			telectricityCustom.setElectricityid(id);
			telectricityCustom.setElectricityname(tNoteInfoCustom.getNotename());
			telectricityCustom.setElectricitytext(tNoteInfoCustom.getNotetext());
			telectricityCustom.setCreatetime(sdf.format(new Date()));
			telectricityCustom.setCreateuser(tUserInfoCustom.getUserid());
			telectricityCustom.setUpdatetime(sdf.format(new Date()));
			telectricityCustom.setUpdateuser(tUserInfoCustom.getUserid());
			electrityInfoService.saveElectrity(telectricityCustom);
		}else if(tNoteInfoCustom.getNotetype().equals("1")){
			//新手指引信息
			TGuideInfoCustom tGuideInfoCustom = new TGuideInfoCustom();
			tGuideInfoCustom.setGuideid(id);
			tGuideInfoCustom.setGuidename(tNoteInfoCustom.getNotename());
			tGuideInfoCustom.setGuidetext(tNoteInfoCustom.getNotetext());
			tGuideInfoCustom.setCreatetime(sdf.format(new Date()));
			tGuideInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tGuideInfoCustom.setUpdatetime(sdf.format(new Date()));
			tGuideInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			guideInfoService.insertGuideInfo(tGuideInfoCustom);
		}
		map.put("ec", "0");
		return map;
	}
	
	/*
	 * 跳转到添加公告信息页面-----系统管理员
	 */
	@RequestMapping(value="/responseNoteadd")
	public @ResponseBody ModelAndView responseNoteadd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backstage/admin/noticeAdd.jsp");
		return mv;
	}
	
	/*
	 * 添加公告信息 -----系统管理员
	 */
	@RequestMapping(value="/Addnote")
	public @ResponseBody ModelMap Addnote(HttpSession session,TNoteInfoCustom tNoteInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String id=UUID.randomUUID().toString().replace("-", "");
		tNoteInfoCustom.setNoteid(id);
		tNoteInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tNoteInfoCustom.setNotestate("66");
		tNoteInfoCustom.setCreatetime(sdf.format(new Date()));
		tNoteInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tNoteInfoCustom.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		noteService.savenote(tNoteInfoCustom);
		if(tNoteInfoCustom.getNotetype().equals("0")){
			//添加电商信息
			TelectricityCustom telectricityCustom = new TelectricityCustom();
			telectricityCustom.setElectricityid(id);
			telectricityCustom.setElectricityname(tNoteInfoCustom.getNotename());
			telectricityCustom.setElectricitytext(tNoteInfoCustom.getNotetext());
			telectricityCustom.setCreatetime(sdf.format(new Date()));
			telectricityCustom.setCreateuser(tUserInfoCustom.getUserid());
			telectricityCustom.setUpdatetime(sdf.format(new Date()));
			telectricityCustom.setUpdateuser(tUserInfoCustom.getUserid());
			electrityInfoService.saveElectrity(telectricityCustom);
		}else if(tNoteInfoCustom.getNotetype().equals("1")){
			//新手指引信息
			TGuideInfoCustom tGuideInfoCustom = new TGuideInfoCustom();
			tGuideInfoCustom.setGuideid(id);
			tGuideInfoCustom.setGuidename(tNoteInfoCustom.getNotename());
			tGuideInfoCustom.setGuidetext(tNoteInfoCustom.getNotetext());
			tGuideInfoCustom.setCreatetime(sdf.format(new Date()));
			tGuideInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tGuideInfoCustom.setUpdatetime(sdf.format(new Date()));
			tGuideInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			guideInfoService.insertGuideInfo(tGuideInfoCustom);
		}
		map.put("ec", "0");
		return map;
	}
}
