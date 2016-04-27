package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		tSysconfInfoCustom.setUpdateuser(tUserInfoCustom.getUsernick());
		tSysconfInfoCustom.setUpdatetime(sdf.format(new Date()));
		int i= sysconfInfoService.updateSysinfo(tSysconfInfoCustom);
		System.out.println(i);
		mv.setViewName("findAllSysconf");
		return mv;
	}
}
