package com.zhenapp.controller.back.sysconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.service.SysconfInfoService;


@Controller
@RequestMapping(value="/sysconf")
public class SysconfInfoController {
	@Autowired
	private SysconfInfoService sysconfInfoService;
	
	/*
	 * 跳转到系统设置界面 -----系统管理员
	 */
	@RequestMapping(value="/responsesyssetting")
	public @ResponseBody ModelAndView responsesyssetting() throws Exception {
		ModelAndView mv =new ModelAndView();
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		mv.addObject("tSysconfInfoCustom",tSysconfInfoCustom);
		mv.setViewName("/backstage/admin/syssetting.jsp");
		return mv;
	}
}
