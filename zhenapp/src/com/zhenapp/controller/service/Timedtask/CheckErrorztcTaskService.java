package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
@Transactional
@Service
public class CheckErrorztcTaskService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	/*
	 * 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	 */
	public @ResponseBody ModelMap checkErrorztcTask(TTaskInfoCustom tTaskInfoCustom) throws Exception{
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
