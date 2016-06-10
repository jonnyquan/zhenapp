package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.NoteInfoService;
@Transactional
@Controller
@RequestMapping(value="/note")
public class AddNoteController {
	@Autowired
	private NoteInfoService noteService;
	@Autowired
	private ElectrityInfoService electrityInfoService;
	@Autowired
	private GuideInfoService guideInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

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
