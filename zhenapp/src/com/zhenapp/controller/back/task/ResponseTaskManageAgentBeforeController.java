package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Controller
@RequestMapping(value="/task")
public class ResponseTaskManageAgentBeforeController {
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到订单查询界面--代理  历史订单管理
	 */
	@RequestMapping(value="/responsetaskmanageagentbefore")
	public @ResponseBody ModelAndView responsetaskmanageagentbefore(HttpSession session,Integer page,String datefrom,String dateto,String taskpk,String usernick,String taskkeynum,String taskkeyword,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom!=null && !datefrom.equals("")){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null && !dateto.equals("")){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskkeyword", taskkeyword);
		pagemap.put("tasktype", tasktype);
		pagemap.put("userid", tUserInfoCustom.getUserid());
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//代理用户
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypageAndrole(pagemap);
		int total = taskInfoService.findTotalTaskBypageAndrole(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("points", points);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskkeyword", taskkeyword);
		mv.addObject("tasktype", tasktype);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.setViewName("/backstage/agent/tasklistbefore.jsp");
		return mv;
	}
}
