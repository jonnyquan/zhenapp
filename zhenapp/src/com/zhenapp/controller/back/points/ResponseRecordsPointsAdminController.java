package com.zhenapp.controller.back.points;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.service.PointsInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseRecordsPointsAdminController {
	
	@Autowired
	private PointsInfoService pointsInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到积分记录界面--系统管理员
	 */
	@RequestMapping(value="/responserecordspointsadmin")
	public ModelAndView responserecordspointsadmin(HttpSession session,Integer page,String datefrom ,String dateto,String usernick,String taskpk) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom != null && !datefrom.equals("")){
			pagemap.put("datefrom", datefrom.replace("-", "") + "000000");
		}
		if(dateto != null && !dateto.equals("")){
			pagemap.put("dateto", dateto.replace("-", "") + "235959");
		}
		pagemap.put("usernick", usernick);
		pagemap.put("taskpk", taskpk);
		//系统管理员
		List<TPointsInfoCustom> tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPage(pagemap);
		int total = pointsInfoService.findTotalPointsInfoByPage(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.addObject("usernick", usernick);
		mv.addObject("taskpk", taskpk);
		mv.addObject("tPointsInfoCustomlist",tPointsInfoCustomlist);
		mv.setViewName("/backstage/admin/listcoin.jsp");
		return mv;
	}
	
}
