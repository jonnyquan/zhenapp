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
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Service
public class CheckBeforeOrderServiceztc {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckBeforeOrderServiceztc.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private AgentInfoService agentInfoService;
	/*
	 * 每天0点3分执行一次 将未完成的直通车任务自动终止
	 */
	public @ResponseBody ModelMap updateTaskstateByTime(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(tTaskInfoCustom.getTaskid());
		if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
			map.put("data", "stateerror");
			return map;
		}
		hashmap.put("taskstate", "18");
		hashmap.put("oldtaskendstate", "16");
		int endcounts = taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
		if(endcounts>0){
			taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
			taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
			hashmap.put("newstate", "40");
			hashmap.put("oldstate", "23");
			taskDetailInfoTempService.updatestate(hashmap);
		}
		return map;
	}
}
