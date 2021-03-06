package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Service
public class CheckEndOrderztcService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckEndOrderztcService.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	/*
	 * 每一分钟执行一次 查询任务状态为终止中的任务,检查是否所有详情任务都已返回，如果都已处理修改为已终止，结束任务，返回积分
	 */
	public @ResponseBody ModelMap checkEndOrderztc(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		//查询任务状态为终止中的任务
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		//查询该任务 执行中的详情任务条数
		hashmap.put("taskstate", "20");
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		int tempcount = taskDetailInfoService.findTaskDetailInfoByIdAndTaskstate(hashmap);
		if(tempcount==0){
			hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "19");
			hashmap.put("oldtaskendstate", "18");
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "检查任务是否已终止");
			int endcount = taskInfoService.updateTaskstate(hashmap);//将该任务id修改为已终止
			if(endcount>0){
				map.put("data", "success");
				logger.info("该订单已成功终止!");
			}else{
				logger.info("该订单"+tTaskInfoCustom.getTaskid()+"无法修改为已终止"+hashmap.toString());
				return map;
			}
			int finishcount = 0;
        	//给用户添加积分明细记录
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			//给代理添加积分明细记录
			TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
			TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		
    		hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "0");
			hashmap.put("isshopping", "0");
			finishcount = taskDetailInfoService.findCounts(hashmap);
			int pointsflowztc = finishcount*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
        	int pointsflowagentztc = finishcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
        	hashmap.clear();
        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "1");
			hashmap.put("isshopping", "1");
        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
        	int pointllztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
			int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
			int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
			int pointllagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
			int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
			int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
			//给用户添加终止任务所返回的积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc);
			
			tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPointsupdate((pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			//给代理添加终止任务所返回的积分
			tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc);
			
			tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
    	
			
			tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("检查任务是否已终止");
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPointstype("28");
			tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
			
			tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
			
			tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
			tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustomagent.setUpdateuser("检查任务是否已终止");
			tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustomagent.setPointstype("28");
			tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
			tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustomagent);
		}else{
			logger.info("该订单还有正在执行的任务!");
		}
		logger.info("检查终止中的直通车任务完成!");
		return map;
	}
}
