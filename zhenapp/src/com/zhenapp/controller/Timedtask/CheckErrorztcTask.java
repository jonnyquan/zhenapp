package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.CheckErrorztcTaskService;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskInfoService;

@Controller
public class CheckErrorztcTask {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckErrorztcTask.class);
	@Autowired
	private CheckErrorztcTaskService checkErrorztcTaskService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	/*
	 * 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	 */
	@RequestMapping(value="/api/platform/checkErrorztcTaskztc")
	public @ResponseBody ModelMap checkErrorztcTask() throws Exception{
		ModelMap map = new ModelMap();
		logger.info("将直通车任务错误数大于等于系统设置的最大直通车任务错误数即终止该直通车任务-----开始");
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("counts", tSysconfInfoCustom.getSysconfname3());
		hashmap.put("tasktype", "34");
		List<TTaskInfoCustom> tTaskInfoCustomlistztc = taskInfoService.findTaskerrorcounts(hashmap);
		if(tTaskInfoCustomlistztc != null && tTaskInfoCustomlistztc.size()>0){
			for (int i = 0; i < tTaskInfoCustomlistztc.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistztc.get(i);
				checkErrorztcTaskService.checkErrorztcTask(tTaskInfoCustom);
			}
		}
		logger.info("将直通车任务错误数大于等于系统设置的最大直通车任务错误数即终止该直通车任务-----结束");
		return map;
	}
}
