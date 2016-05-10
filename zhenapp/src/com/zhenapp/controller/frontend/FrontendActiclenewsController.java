package com.zhenapp.controller.frontend;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;

@Controller
@RequestMapping(value="/frontend")
public class FrontendActiclenewsController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	
	
	@RequestMapping(value="/articlenews")
	public @ResponseBody ModelAndView articlenews(Integer page,Integer rows) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService
				.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService
				.findGuide_10();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 15;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		List<TelectricityCustom> telectricityCustomcountlist = electrityService.findAllElectrity();
		List<TelectricityCustom> TelectricityCustomAlllist = electrityService
				.findElectrityBypage(pagemap);
		mv.addObject("total", telectricityCustomcountlist.size());
		mv.addObject("pagenum", page);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("TelectricityCustomAlllist", TelectricityCustomAlllist);
		mv.setViewName("/frontend/articlenews.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/articlenewsdetail/{electricitypk}")
	public @ResponseBody ModelAndView articlenewsdetail(@PathVariable(value = "electricitypk") String electricitypk) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService
				.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService
				.findGuide_10();
		TelectricityCustom telectricityCustom = electrityService
				.findElectrityBypk(electricitypk);

		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("telectricityCustom", telectricityCustom);
		mv.setViewName("/frontend/articlenewsdetail.jsp");
		return mv;
	}
}
