package com.zhenapp.controller.back.points;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseRecordsPointsAgentController {
	
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 跳转到积分记录界面--代理
	 */
	@RequestMapping(value="/responserecordspointsagent")
	public ModelAndView responserecordspointsagent(HttpSession session,Integer page,String datefrom ,String dateto,String usernick,String taskpk) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustomsession);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustomsession.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom != null && !datefrom.equals("")){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto != null && !dateto.equals("")){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		pagemap.put("usernick", usernick);
		pagemap.put("taskpk", taskpk);
		//代理用户
		pagemap.put("userid", tUserInfoCustomsession.getUserid());
		List<TPointsInfoCustom> tPointsInfoCustomlist = pointsInfoService.findPointsInfoByPageandRole(pagemap);
		int total = pointsInfoService.findPointsCountsByPageandRole(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("datefrom",datefrom);
		mv.addObject("dateto",dateto);
		mv.addObject("usernick",usernick);
		mv.addObject("points", points);
		mv.addObject("taskpk", taskpk);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.addObject("tPointsInfoCustomlist",tPointsInfoCustomlist);
		mv.setViewName("/backstage/agent/listcoin.jsp");
		return mv;
	}
}
