package com.zhenapp.controller.back.task;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskInfoService;
@Transactional
@Controller
@RequestMapping(value="/task")
public class RepublishTaskController {
	private static Logger logger = Logger.getLogger(RepublishTaskController.class);
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	@RequestMapping(value="/againtaskBytaskid/{taskid}")
	public @ResponseBody ModelAndView againtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TTaskInfoCustom tTaskInfoCustom = taskInfoService.findTaskInfoByTaskid(taskid);
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());//根据登陆用户查询所属代理信息
		try{
			TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());//根据代理信息查询所设置的价格信息
			mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
			mv.addObject("tTaskInfoCustom",tTaskInfoCustom);
			if(tTaskInfoCustom.getTasktype().equals("33")){
				mv.setViewName("/backstage/task/taskadd.jsp");
			}else{
				int price = 0;
				if(tTaskInfoCustom.getTaskprice().indexOf(".")!=-1){
					price = Integer.parseInt(tTaskInfoCustom.getTaskprice().split("\\.")[0]);
				}else{
					price = Integer.parseInt(tTaskInfoCustom.getTaskprice());
				}
				int minprice = 0;
				if(tTaskInfoCustom.getTaskminprice().indexOf(".")!=-1){
					minprice = Integer.parseInt(tTaskInfoCustom.getTaskminprice().split("\\.")[0]);
				}else{
					minprice = Integer.parseInt(tTaskInfoCustom.getTaskminprice());
				}
				if(price-minprice==1){
					tTaskInfoCustom.setPriceMode("1");
				}else if(tTaskInfoCustom.getTaskminprice().equals("0") && tTaskInfoCustom.getTaskmaxprice().equals("0")){
					tTaskInfoCustom.setPriceMode("0");
				}else if(price-minprice==10){
					tTaskInfoCustom.setPriceMode("2");
				}else{
					tTaskInfoCustom.setPriceMode("3");
				}
				mv.setViewName("/backstage/task/taskztcadd.jsp");
			}
			return mv;
		}catch(NullPointerException e){
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
	}
	
}
