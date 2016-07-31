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

import com.zhenapp.controller.service.Timedtask.CheckBeforeOrderService;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;
@Controller
public class CheckBeforeOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckBeforeOrder.class);
	@Autowired
	private CheckBeforeOrderService checkBeforeOrderService;
	@Autowired
	private TaskInfoService taskInfoService;
	/*
	 * 查询今天之前的任务      每天0点1分执行
	 */
	@RequestMapping(value="/api/platform/updateTaskstateByTime")
	public @ResponseBody ModelMap checkBeforeOrder() throws Exception{
		ModelMap map = new ModelMap();
		//还在执行中的任务   变成已完成	状态为待分配（15） 和运行中（16）的任务
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "15,16");
		hashmap.put("before", yyyyMMdd.format(new Date()));
		List<TTaskInfoCustom> tTaskInfoCustomlistfinish = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlistfinish!=null && tTaskInfoCustomlistfinish.size()>0){
			for (int i = 0; i < tTaskInfoCustomlistfinish.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
				map = checkBeforeOrderService.updateTaskstateByTime(tTaskInfoCustom);
			}
			logger.info("处理前一天未执行完成的任务结束");
		}
		return map;
	}
}
