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
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PointsInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseRecordsPointsController {
	
	@Autowired
	private PointsInfoService pointsInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到积分明细界面--用户
	 */
	@RequestMapping(value="/responserecordspoints")
	public ModelAndView responserecordspoints(HttpSession session,Integer page,String taskpk) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("taskpk", taskpk);
		//普通用户
		pagemap.put("createuser", tUserInfoCustom.getUserid());
		List<TPointsInfoCustom> tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPage(pagemap);
		int total = pointsInfoService.findTotalPointsInfoByPage(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("taskpk", taskpk);
		mv.addObject("tPointsInfoCustomlist",tPointsInfoCustomlist);
		mv.setViewName("/backstage/points/recordspoints.jsp");
		return mv;
	}
}
