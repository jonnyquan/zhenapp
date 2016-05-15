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
public class FrontendActicleguideController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	
	/*
	 * 查询电商信息及新手指引信息  用于界面展示
	 */
	@RequestMapping(value="/articleguide")
	public @ResponseBody ModelAndView articleguide(Integer page,Integer rows) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService.findGuide_10();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 15;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		int total = guideService.findTotalGuide();
		List<TGuideInfoCustom> tGuideInfoCustomAlllist = guideService.findGuideBypage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("tGuideInfoCustomAlllist", tGuideInfoCustomAlllist);
		mv.setViewName("/frontend/articleguide.jsp");
		return mv;
	}
	
	/*
	 * 根据主键查询具体新手指引信息
	 */
	@RequestMapping(value="/articleguidedetail/{guidepk}")
	public @ResponseBody ModelAndView articlenewsdetail(@PathVariable(value = "guidepk") String guidepk) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService.findGuide_10();
		TGuideInfoCustom tGuideInfoCustom=guideService.findElectrityBypk(guidepk);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("tGuideInfoCustom", tGuideInfoCustom);
		mv.setViewName("/frontend/articleguidedetail.jsp");
		return mv;
	}
}
