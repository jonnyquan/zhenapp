package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.CheckBeforeOrderEndService;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
public class CheckBeforeOrderEnd {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private CheckBeforeOrderEndService checkBeforeOrderEndService;
	@Autowired
	private TaskInfoService taskInfoService;
	/*
	 * 查询今天之前的终止中任务      每天0点20分执行
	 */
	@RequestMapping(value="/api/platform/updateTaskstateByTimeEnd")
	public @ResponseBody ModelMap updateTaskstateByTime() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		//终止中的任务变成已终止      并且给用户返还积分		状态为终止中（18）的任务
		hashmap.put("taskstate", "18");
		List<TTaskInfoCustom> tTaskInfoCustomlistend = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlistend!=null && tTaskInfoCustomlistend.size()>0){
			for (int i = 0; i < tTaskInfoCustomlistend.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistend.get(i);
				checkBeforeOrderEndService.updateTaskstateByTime(tTaskInfoCustom);
			}
		}
		return map;
	}
}
