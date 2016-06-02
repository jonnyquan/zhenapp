package com.zhenapp.controller.frontend.news;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ActiclenewsController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${maxRows}")
	private Integer maxRows;
	/*
	 * 查询电商信息及新手指引信息  用于电商信息展示
	 */
	@RequestMapping(value="/articlenews")
	public @ResponseBody ModelAndView articlenews(HttpServletRequest request,Integer page) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10(pagemap);
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService.findGuide_10(pagemap);
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * maxRows);
		pagemap.put("rows", maxRows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TelectricityCustom> telectricityCustomcountlist = electrityService.findAllElectrity(pagemap);
		List<TelectricityCustom> TelectricityCustomAlllist = electrityService.findElectrityBypage(pagemap);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("total", telectricityCustomcountlist.size());
		mv.addObject("pagenum", page);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("TelectricityCustomAlllist", TelectricityCustomAlllist);
		mv.setViewName("/frontend/articlenews.jsp");
		return mv;
	}
}
