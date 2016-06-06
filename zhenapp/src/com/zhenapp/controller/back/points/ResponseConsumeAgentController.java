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
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseConsumeAgentController {
	
	
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 跳转到充值记录界面--代理
	 */
	@RequestMapping(value="/responseconsumeagent")
	public ModelAndView responseconsumeagent(HttpSession session,Integer page,String datefrom,String dateto,String usernick,String rechargeid) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom != null && !datefrom.equals("")){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto != null && !dateto.equals("")){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("usernick", usernick);
		pagemap.put("rechargeid", rechargeid);
		//代理用户
		pagemap.put("userid", tUserInfoCustom.getUserid());
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		int total = rechargeInfoService.findTotalRechargeinfoByUserAndpage(pagemap);
		List<TRechargeInfoCustom> tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.addObject("usernick", usernick);
		mv.addObject("rechargeid", rechargeid);
		mv.addObject("points", points);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.addObject("tRechargeInfoCustomlist",tRechargeInfoCustomlist);
		mv.setViewName("/backstage/agent/listrecharge.jsp");
		return mv;
	}
}
