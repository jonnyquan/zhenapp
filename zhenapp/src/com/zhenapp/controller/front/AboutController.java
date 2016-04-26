package com.zhenapp.controller.front;

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
@RequestMapping(value="/about")
public class AboutController {
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	
	
	/*
	 * 查询前10条电商信息  用于侧边栏展示 按时间倒序排列
	 */
	@RequestMapping(value="/findGuideandelectrity")
	public @ResponseBody ModelAndView findGuideandelectrity() throws Exception{
		ModelAndView mv= new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist=electrityService.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist=guideService.findGuide_10();
		mv.addObject("TelectricityCustomlist",TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist",TGuideInfoCustomlist);
		mv.setViewName("/bootstrap/about.jsp");
		return mv;
	}
}
