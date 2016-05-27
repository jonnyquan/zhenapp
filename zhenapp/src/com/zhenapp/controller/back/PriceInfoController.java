package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/price")
public class PriceInfoController {
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 查询单价列表 --代理
	 */
	@RequestMapping(value="/findPriceByAgentid")
	public @ResponseBody ModelAndView findPriceByAgentid(HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		mv.addObject("points", points);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.setViewName("/backstage/agent/sysconf.jsp");
		return mv;
	}
	/*
	 *根据代理id修改单价信息---代理
	 */
	@RequestMapping(value="/updatePriceByAgentid")
	public @ResponseBody ModelMap updatepriceByAgentid(HttpSession session,TPriceInfoCustom tPriceInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tPriceInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tPriceInfoCustom.setUpdatetime(sdf.format(new Date()));
		if(tPriceInfoCustom.getAgentid() == null || tPriceInfoCustom.getAgentid().equals("")){
			TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
			tPriceInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		}
		priceInfoService.updatePriceByagentid(tPriceInfoCustom);
		map.put("ec", "0");
		return map;
	}
	/*
	 *根据代理id查询单价信息-----系统管理员
	 */
	@RequestMapping(value="/findPriceByAgentidadmin")
	public @ResponseBody ModelAndView findPriceByAgentidadmin(String agentid) throws Exception{
		ModelAndView mv=new ModelAndView();
		TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(agentid);
		mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		mv.setViewName("/backstage/admin/pricesetting.jsp");
		return mv;
	}
	
	/*
	 *根据代理id修改单价信息-----系统管理员
	 */
	@RequestMapping(value="/updatePriceByAgentidadmin")
	public @ResponseBody ModelMap updatepriceByAgentidadmin(HttpSession session,TPriceInfoCustom tPriceInfoCustom,String agentid) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tPriceInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tPriceInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPriceInfoCustom.setAgentid(agentid);
		priceInfoService.updatePriceByagentid(tPriceInfoCustom);
		map.put("ec", "0");
		return map;
	}
	
	//=====================================================================
	
	/*
	 * 查询单价列表
	 
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
	}*/
	/*
	 * 管理用户查询代理单价列表
	 
	@RequestMapping(value="/findPriceByAgentid/{agentid}")
	public ModelAndView findPriceByAgentid(@PathVariable(value="agentid")String agentid) throws Exception{
		ModelAndView mv=new ModelAndView();
		TPriceInfoCustom tPriceInfoCustom=priceInfoService.findPriceByAgentid(agentid);
		mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		mv.setViewName("/page/main/pricemange.jsp");
		return mv;
	}*/
	/*
	 * 修改单价信息
	 */
	@RequestMapping(value="/updatePriceByagentid")
	public ModelAndView updatePriceByagentid(TPriceInfoCustom tPriceInfoCustom,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tPriceInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
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
