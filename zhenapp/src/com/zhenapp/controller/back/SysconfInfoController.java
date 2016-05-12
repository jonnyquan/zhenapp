package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.SysconfInfoService;


@Controller
@RequestMapping(value="/sysconf")
public class SysconfInfoController {
	@Autowired
	private SysconfInfoService sysconfInfoService;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	
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
	
	/*
	 * 修改系统配置信息
	 */
	@RequestMapping(value="/updatesyssetting")
	public @ResponseBody ModelMap updatesyssetting(HttpSession session,TSysconfInfoCustom tSysconfInfoCustom) throws Exception {
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tSysconfInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tSysconfInfoCustom.setUpdatetime(sdf.format(new Date()));
		sysconfInfoService.updateSysinfo(tSysconfInfoCustom);
		map.put("ec", "0");
		return map;
	}
	
	
	
	@RequestMapping(value="/findAllSysconf")
	public @ResponseBody ModelAndView findAllSysconf() throws Exception {
		ModelAndView mv =new ModelAndView();
		
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		
		mv.addObject("tSysconfInfoCustom",tSysconfInfoCustom);
		
		mv.setViewName("/page/main/sysmange.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/updateSysinfo")
	public @ResponseBody ModelAndView updateSysinfo(TSysconfInfoCustom tSysconfInfoCustom,HttpServletRequest request) throws Exception{
		ModelAndView mv =new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tSysconfInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tSysconfInfoCustom.setUpdatetime(sdf.format(new Date()));
		int i= sysconfInfoService.updateSysinfo(tSysconfInfoCustom);
		System.out.println(i);
		mv.setViewName("findAllSysconf");
		return mv;
	}
}
