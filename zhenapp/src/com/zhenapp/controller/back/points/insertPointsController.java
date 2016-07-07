package com.zhenapp.controller.back.points;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/points")
public class insertPointsController {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private WebInfoService webInfoService;

	/*
	 * 插入充值记录
	 */
	@RequestMapping(value="/buypoints")
	public ModelAndView buypoints(String id,HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		String verificationcode = UUID.randomUUID().toString().replace("-", "");
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TComboInfoCustom tComboInfoCustom= comboInfoService.findComboByid(id);
		TRechargeInfoCustom tRechargeInfoCustom=new TRechargeInfoCustom();
		tRechargeInfoCustom.setRechargeid(UUID.randomUUID().toString().replace("-", ""));
		tRechargeInfoCustom.setRechargemoney(tComboInfoCustom.getCombomoney());
		tRechargeInfoCustom.setRechargepoints(tComboInfoCustom.getCombointegral());
		tRechargeInfoCustom.setRechargegivemoney(tComboInfoCustom.getCombogivemoney());
		tRechargeInfoCustom.setRechargegivepoints(tComboInfoCustom.getCombogiveintegral());
		tRechargeInfoCustom.setRechargestate("24");//待确认状态
		tRechargeInfoCustom.setRechargeverification(verificationcode);
		tRechargeInfoCustom.setUpdatetime(sdf.format(new Date()));
		tRechargeInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tRechargeInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tRechargeInfoCustom.setCreatetime(sdf.format(new Date()));
		rechargeInfoService.insertRechargeinfo(tRechargeInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("alipay", tWebInfoCustom.getAlipay());
		mv.addObject("tComboInfoCustom", tComboInfoCustom);
		mv.addObject("Verificationcode", verificationcode);
		mv.setViewName("/backstage/points/buyingpoints.jsp");
		return mv;
	}
}
