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

import com.zhenapp.controller.service.Timedtask.CheckEndOrderztcService;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
public class CheckEndOrderztc {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckEndOrderztc.class);
	@Autowired
	private CheckEndOrderztcService checkEndOrderztcService;
	@Autowired
	private TaskInfoService taskInfoService;
	/*
	 * 每一分钟执行一次 查询任务状态为终止中的任务,检查是否所有详情任务都已返回，如果都已处理修改为已终止，结束任务，返回积分
	 */
	@RequestMapping("/api/platform/checkEndOrderztc")
	public @ResponseBody ModelMap checkEndOrderztc() throws Exception{
		ModelMap map = new ModelMap();
		//查询任务状态为终止中的任务
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "18");
		hashmap.put("tasktype", "34");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				checkEndOrderztcService.checkEndOrderztc(tTaskInfoCustom);
			}
		}
		logger.info("检查终止中的直通车任务完成!");
		return map;
	}
}
