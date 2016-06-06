package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;

@Controller
@RequestMapping(value="/task")
public class DeleteTaskLockController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

	@Autowired
	private TaskDetailInfoService taskDetailInfoService;

	/*
	 * 删除卡机任务，并返回该任务状态为执行失败
	 */
	@RequestMapping("/deletetasklockBypk")
	public @ResponseBody ModelAndView deletetasklockBypk(String pk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailBypk(pk);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		String visit = "notresult";
		String collect = "no";
		String trolley = "no";
		hashmap.put("phoneid", tTaskDetailInfoCustom.getPhoneid());
		hashmap.put("taskstate", tTaskDetailInfoCustom.getTaskstate());
		hashmap.put("taskdetailpk", tTaskDetailInfoCustom.getTaskdetailpk());
		hashmap.put("taskstatenew", 22);
		hashmap.put("visit", visit);
		hashmap.put("collect", collect);
		hashmap.put("trolley", trolley);
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", "卡机任务反馈");
		hashmap.put("isflow", "0");
		hashmap.put("iscreativetitle", "0");
		hashmap.put("isshopcollect", "0");
		taskDetailInfoService.updateTaskDetail(hashmap);
		mv.setViewName("/task/findtasklocklist");
		return mv;
	}
	
}
