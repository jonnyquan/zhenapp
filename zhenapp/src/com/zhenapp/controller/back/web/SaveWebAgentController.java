package com.zhenapp.controller.back.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/web")
public class SaveWebAgentController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	@RequestMapping(value="/agentAndwebSave")
	public @ResponseBody ModelMap agentAndwebSave(HttpSession session,TWebInfoCustom tWebInfoCustom,TAgentInfoCustom tAgentInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tWebInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tWebInfoCustom.setUpdatetime(sdf.format(new Date()));
		webInfoService.updateWebByAgentid(tWebInfoCustom);
		tAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		if(tAgentInfoCustom.getAgentperson() == null){
			tAgentInfoCustom.setAgentperson(null);
		}else if(tAgentInfoCustom.getAgentperson().length()<2){
			tAgentInfoCustom.setAgentperson(null);
		}
		agentInfoService.updateAgentByid(tAgentInfoCustom);
		map.put("ec", "0");
		return map;
	}
}
