package com.zhenapp.controller.back.note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.IndexInfoService;
import com.zhenapp.service.IntroInfoService;
import com.zhenapp.service.NoteInfoService;
@Transactional
@Controller
@RequestMapping(value="/note")
public class UpdateNoteController {
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
}
