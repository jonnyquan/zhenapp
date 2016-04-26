package com.zhenapp.controller.front;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.TElectricityInfo;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.test.TextImprot;

@Controller
@RequestMapping(value = "/electrity")
public class ElectrityController {

	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;

	@RequestMapping(value = "/insertelectrity")
	public ModelAndView insertelectrity() throws Exception {
		ModelAndView mv = new ModelAndView();

		TextImprot textImprot = new TextImprot();

		List<TElectricityInfo> list = textImprot.improt();
		for (int i = 0; i < list.size(); i++) {
			TElectricityInfo electricityInfo = list.get(i);

			int j = electrityService.insertElectrity(electricityInfo);

			if (j < 1) {
				System.out.println("=========================" + j
						+ "=========================");
			}

		}

		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}

	/*
	 * 查询前10条电商信息 用于侧边栏展示 按时间倒序排列
	 */
	@RequestMapping(value = "/findElectrity_10")
	public @ResponseBody
	ModelAndView findElectrity_10(String pagenum, String pagesize)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService
				.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService
				.findGuide_10();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		pagemap.put("page", 0);
		pagemap.put("rows", 15);
		List<TelectricityCustom> TelectricityCustomAlllist = electrityService
				.findElectrityBypage(pagemap);
		List<TelectricityCustom> telectricityCustomcountlist = electrityService
				.findAllElectrity();
		mv.addObject("total", telectricityCustomcountlist.size());
		mv.addObject("pagenum", Integer.parseInt(pagemap.get("page").toString()) + 1);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("TelectricityCustomAlllist", TelectricityCustomAlllist);
		mv.setViewName("/bootstrap/information.jsp");
		return mv;
	}

	/*
	 * 查询前10条电商信息 用于侧边栏展示 按时间倒序排列
	 */
	@RequestMapping(value = "/findElectrity_10/{pagenum}/{pagesize}")
	public @ResponseBody
	ModelAndView findElectrity_10_2(
			@PathVariable(value = "pagenum") Integer pagenum,
			@PathVariable(value = "pagesize") Integer pagesize)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<TelectricityCustom> TelectricityCustomlist = electrityService
				.findElectrity_10();
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService
				.findGuide_10();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (pagenum == null || pagesize == null) {
			pagenum = 1;
			pagesize = 15;
			pagemap.put("page", pagenum);
			pagemap.put("page", pagesize);
		} else {
			pagemap.put("page", pagenum);
			pagemap.put("page", pagesize);
		}
		pagemap.put("page", (pagenum - 1) * pagesize);
		List<TelectricityCustom> telectricityCustomcountlist = electrityService
				.findAllElectrity();
		List<TelectricityCustom> TelectricityCustomAlllist = electrityService
				.findElectrityBypage(pagemap);
		mv.addObject("total", telectricityCustomcountlist.size());
		mv.addObject("pagenum", pagenum);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		mv.addObject("TelectricityCustomAlllist", TelectricityCustomAlllist);
		mv.setViewName("/bootstrap/information.jsp");
		return mv;
	}

	/*
	 * 根据电商信息主键查询电商信息
	 */
	@RequestMapping(value = "/details/{electricitypk}")
	public ModelAndView details(
			@PathVariable(value = "electricitypk") String electricitypk)
			throws Exception {
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
		mv.setViewName("/bootstrap/electricitydetails.jsp");
		return mv;
	}
}
