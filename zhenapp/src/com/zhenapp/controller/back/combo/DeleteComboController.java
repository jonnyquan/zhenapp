package com.zhenapp.controller.back.combo;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;

@Controller
@RequestMapping(value = "/combo")
public class DeleteComboController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	/*
	 * 删除套餐信息 ---代理
	 */
	@RequestMapping(value="/deletecombo")
	public @ResponseBody ModelMap deletecombo(HttpSession session,String pk) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		pagemap.put("combopk", pk);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		comboInfoService.deleteCombo(pagemap);
		map.put("ec", 0);
		return map;
	}
}
