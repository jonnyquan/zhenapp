package com.zhenapp.controller.back.combo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;

@Controller
@RequestMapping(value = "/combo")
public class SaveComboController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	
	/*
	 * 保存套餐信息 ---代理
	 */
	@RequestMapping(value="/savecombo")
	public @ResponseBody ModelMap savecombo(HttpSession session,TComboInfoCustom tComboInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
		tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		if(tComboInfoCustom.getCombopk()==null){
			tComboInfoCustom.setComboid(UUID.randomUUID().toString().replace("-", ""));
			tComboInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
			tComboInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tComboInfoCustom.setCreatetime(sdf.format(new Date()));
			comboInfoService.insertComboto(tComboInfoCustom);
		}else{
			tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
			tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			comboInfoService.updateCombotoByid(tComboInfoCustom);
		}
		map.put("ec", 0);
		return map;
	}
}
