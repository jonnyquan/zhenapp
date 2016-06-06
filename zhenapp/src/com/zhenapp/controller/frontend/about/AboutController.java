package com.zhenapp.controller.frontend.about;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/frontend")
public class AboutController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	@RequestMapping(value="/about")
	public @ResponseBody ModelAndView requestabout(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		HashMap<String, Object> pagemap = new HashMap<String, Object>();
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10(pagemap);
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService .findGuide_10(pagemap);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.setViewName("/frontend/about.jsp");
		return mv;
	}
}
