package com.zhenapp.controller.back.task;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;

@Controller
@RequestMapping(value="/task")
public class ResponseZtcTaskAddController {
	private static Logger logger = Logger.getLogger(ResponseZtcTaskAddController.class);
	
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	/*
	 * 跳转到发布直通车任务界面
	 */
	@RequestMapping(value="/responsetaskztcadd")
	public ModelAndView responsetaskztcadd(HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());//根据登陆用户查询所属代理信息
		try{
			TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());//根据代理信息查询所设置的价格信息
			mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		}catch(NullPointerException e){
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
		mv.setViewName("/backstage/task/taskztcadd.jsp");
		return mv;
	}
}
