package com.zhenapp.controller.back.datacount;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.DatacountInfoCustom;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TDatacountInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.DatacountInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/datacount")
public class DatacountInfoController {
	private static Logger logger = Logger.getLogger(DatacountInfoController.class);
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private DatacountInfoService datacountInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 根据日期和任务类型查询统计 -----代理
	 */
	@RequestMapping(value="/findDataByDateAndTasktype")
	public @ResponseBody ModelAndView findDataByDateAndTasktype(HttpSession session,String tasktype,String datefrom,String dateto) throws Exception{
		ModelAndView mv= new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		if(datefrom == null && dateto == null){
			hashmap.put("datefrom", yyyyMMdd.format(new Date()));
			hashmap.put("dateto", yyyyMMdd.format(new Date()));
		}
		hashmap.put("tasktype", tasktype);
		hashmap.put("agentid", tAgentInfoCustom.getAgentid());
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		DatacountInfoCustom datacountInfoCustom=datacountInfoService.findSUMDataBydate(hashmap);
		logger.info("代理"+tAgentInfoCustom.getAgentid()+"查询数据统计");
		mv.addObject("datacountInfoCustomlist", datacountInfoCustomlist);
		mv.addObject("datacountInfoCustom", datacountInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.addObject("datefrom",datefrom);
		mv.addObject("dateto",dateto);
		mv.addObject("tasktype",tasktype);
		mv.addObject("points", points);
		mv.setViewName("/backstage/agent/datasum.jsp");
		return mv;
	}
	
	/*
	 * 根据日期和任务类型查询统计 -----系统管理员
	 */
	@RequestMapping(value="/responsedatasumadmin")
	public @ResponseBody ModelAndView responsedatasumadmin(String tasktype,String datefrom,String dateto,String agentpk) throws Exception{
		ModelAndView mv= new ModelAndView();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null && !datefrom.equals("")){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null && !dateto.equals("")){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		if(datefrom == null && dateto == null){
			hashmap.put("datefrom", yyyyMMdd.format(new Date()));
			hashmap.put("dateto", yyyyMMdd.format(new Date()));
		}
		hashmap.put("tasktype", tasktype);
		hashmap.put("agentpk", agentpk);
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		DatacountInfoCustom datacountInfoCustom=datacountInfoService.findSUMDataBydate(hashmap);
		//查询所有代理信息
		List<TAgentInfoCustom> tAgentInfoCustomlist = agentInfoService.findAllAgentBypage(hashmap);
		mv.addObject("total", datacountInfoCustomlist.size());
		mv.addObject("agentpk", agentpk);
		mv.addObject("datacountInfoCustomlist", datacountInfoCustomlist);
		mv.addObject("datacountInfoCustom", datacountInfoCustom);
		mv.addObject("tAgentInfoCustomlist", tAgentInfoCustomlist);
		mv.setViewName("/backstage/admin/datasum.jsp");
		return mv;
	}
	/*
	 * 根据日期和任务类型查询统计 -----系统管理员
	 */
	@RequestMapping(value="/responsedatacountsumadmin")
	public @ResponseBody ModelAndView responsedatacountsumadmin(String tasktype,String datefrom,String dateto,String agentid) throws Exception{
		ModelAndView mv= new ModelAndView();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null && !datefrom.equals("")){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null && !dateto.equals("")){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		if(datefrom == null && dateto == null){
			hashmap.put("datefrom", yyyyMMdd.format(new Date()));
			hashmap.put("dateto", yyyyMMdd.format(new Date()));
		}
		//hashmap.put("tasktype", tasktype);
		hashmap.put("agentid", agentid);
		List<TDatacountInfoCustom> tDatacountInfoCustomlist=datacountInfoService.findDatacountBydate(hashmap);
		TDatacountInfoCustom tDatacountInfoCustom=datacountInfoService.findSUMDatacountBydate(hashmap);
		//查询所有代理信息
		List<TAgentInfoCustom> tAgentInfoCustomlist = agentInfoService.findAllAgentBypage(hashmap);
		mv.addObject("total", tDatacountInfoCustomlist.size());
		mv.addObject("agentid", agentid);
		mv.addObject("tDatacountInfoCustomlist", tDatacountInfoCustomlist);
		mv.addObject("tDatacountInfoCustom", tDatacountInfoCustom);
		mv.addObject("tAgentInfoCustomlist", tAgentInfoCustomlist);
		mv.setViewName("/backstage/admin/datacountsum.jsp");
		return mv;
	}
}
