package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.CheckBeforeOrderServiceztc;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;
@Controller
public class CheckBeforeOrderztc {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckBeforeOrderztc.class);
	@Autowired
	private CheckBeforeOrderServiceztc checkBeforeOrderServiceztc;
	@Autowired
	private TaskInfoService taskInfoService;
	/*
	 * 每天0点3分执行一次 将未完成的直通车任务自动终止
	 */
	@RequestMapping(value="/api/platform/CheckBeforeOrderztc")
	public @ResponseBody ModelMap checkBeforeOrder() throws Exception{
		ModelMap map = new ModelMap();
		//还在执行中的任务   变成终止中	状态为待分配（15） 和运行中（16）的任务
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "15,16");
		hashmap.put("before", yyyyMMdd.format(new Date()));
		hashmap.put("tasktype", "34");
		List<TTaskInfoCustom> tTaskInfoCustomlistfinish = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlistfinish!=null && tTaskInfoCustomlistfinish.size()>0){
			for (int i = 0; i < tTaskInfoCustomlistfinish.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
				map = checkBeforeOrderServiceztc.updateTaskstateByTime(tTaskInfoCustom);
			}
			logger.info("每天0点3分执行一次 将未完成的任务自动终止");
		}
		return map;
	}
}
