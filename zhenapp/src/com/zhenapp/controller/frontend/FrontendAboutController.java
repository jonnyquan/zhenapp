package com.zhenapp.controller.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;

@Controller
@RequestMapping(value="/frontend")
public class FrontendAboutController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	
	@RequestMapping(value="/about")
	public @ResponseBody ModelAndView about() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService .findGuide_10();
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.setViewName("/frontend/about.jsp");
		return mv;
	}
}
