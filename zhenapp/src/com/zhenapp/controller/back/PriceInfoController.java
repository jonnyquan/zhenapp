package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;

@Controller
@RequestMapping(value="/price")
public class PriceInfoController {

	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	/*
	 * 查询单价列表
	 */
	@RequestMapping(value="/findPrice")
	public ModelAndView findPrice(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		mv.setViewName("/page/main/pricemange.jsp");
		return mv;
	}
	/*
	 * 管理用户查询代理单价列表
	 */
	@RequestMapping(value="/findPriceByAgentid/{agentid}")
	public ModelAndView findPriceByAgentid(@PathVariable(value="agentid")String agentid) throws Exception{
		ModelAndView mv=new ModelAndView();
		TPriceInfoCustom tPriceInfoCustom=priceInfoService.findPriceByAgentid(agentid);
		mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		mv.setViewName("/page/main/pricemange.jsp");
		return mv;
	}
	/*
	 * 修改单价信息
	 */
	@RequestMapping(value="/updatePriceByagentid")
	public ModelAndView updatePriceByagentid(TPriceInfoCustom tPriceInfoCustom,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tPriceInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPriceInfoCustom.setUpdatetime(sdf.format(new Date()));
		if(tPriceInfoCustom.getAgentid() == null || tPriceInfoCustom.getAgentid().equals("")){
			TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
			tPriceInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		}
		priceInfoService.updatePriceByagentid(tPriceInfoCustom);
		mv.setViewName("findPrice");
		return mv;
	}
}
