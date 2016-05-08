package com.zhenapp.controller.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PointsInfoService;

@Controller
@RequestMapping(value="/points")
public class PointsInfoController {
	@Autowired
	private PointsInfoService pointsInfoService;
	
	/*
	 * 跳转到购买积分界面
	 */
	@RequestMapping(value="/responsebuypoints")
	public ModelAndView responsebuypoints() throws Exception{
		ModelAndView mv=new ModelAndView();
		
		
		mv.setViewName("/backstage/points/buypoints.jsp");
		return mv;
	}
	
	/*
	 * 跳转到积分明细界面
	 */
	@RequestMapping(value="/responserecordspoints")
	public ModelAndView responserecordspoints() throws Exception{
		ModelAndView mv=new ModelAndView();
		
		
		mv.setViewName("/backstage/points/recordspoints.jsp");
		return mv;
	}
	
//============================================================================================以上为最新
	@RequestMapping(value="/findPointsInfoByPage")
	public @ResponseBody ModelMap findPointsInfoByPage(Integer page,Integer rows,HttpServletRequest request) throws Exception{
		ModelMap map=new ModelMap();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		
		List<TPointsInfoCustom> tPointsInfoCustomlist = new ArrayList<TPointsInfoCustom>();
		int counts = 0;
		if(tUserInfoCustom.getUserroleid()==1){
			/*
			 * 系统管理员
			 */
			tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPage(pagemap);
			counts = pointsInfoService.findPointsCountsByPage(pagemap);
		}else if(tUserInfoCustom.getUserroleid()==2){
			/*
			 * 代理用户
			 */
			pagemap.put("userid", tUserInfoCustom.getUserid());
			tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPageandRole(pagemap);
			counts = pointsInfoService.findPointsCountsByPageandRole(pagemap);
		}else{
			/*
			 * 普通用户
			 */
			pagemap.put("createuser", tUserInfoCustom.getUserid());
			tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPage(pagemap);
			counts = pointsInfoService.findPointsCountsByPage(pagemap);
		}
		map.put("total", counts);
		map.put("rows", tPointsInfoCustomlist);
		
		return map;
	}
}
