package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;
@Controller
public class Feedbacktask {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	/*
	 * 手机端反馈任务
	 * http://120.24.44.130/api/phone/deleteTask/task?pid=2&visit=notfound&collect=no&trolley=no
	 *param:pid-->手机号
	 *visit=，后面带的是流量完成情况
	 *collect=,后面带的是收藏完成的情况
	 *trolley=，后面带的是购物车完成情况
	 *
	 *下面列举全部
	 *visit=yes（完成了这个流量）
	 *visit=notresult（搜索这个任务的时候没有搜索结果）
	 *visit=notfound（搜索这个任务的时候没有找到这个宝贝）
	 *visit=notload（搜索这个任务的时候没有加载到任何东西）
	 *
	 *collect= yes（收藏成功）
	 *collect=no（收藏失败）
	 *collect= havecollect （已经收藏过）
	 *
	 *trolley=yes（加入购物车成功）
	 *trolley=no（加入购物车失败）
	 *
	 */
	@RequestMapping(value="/api/phone/deleteTask/task")
	public @ResponseBody ModelMap deleteTask(String pid,String visit,String collect,String trolley) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("phoneid", pid);
		hashmap.put("taskstate", "20");
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
		if(tTaskDetailInfoCustom!=null){
			if(visit.equals("yes")){
				hashmap.put("taskstatenew", 21);
			}else{
				hashmap.put("taskstatenew", 22);
			}
			hashmap.put("visit", visit);
			hashmap.put("collect", collect);
			hashmap.put("trolley", trolley);
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "api手机端反馈");
			/*if(visit.equals("yes")){
				hashmap.put("isflow", "1");
			}
			if(collect.equals("yes")){
				hashmap.put("iscreativetitle", "1");
			}
			if(trolley.equals("yes")){
				hashmap.put("isshopcollect", "1");
			}*/
			int i = taskDetailInfoService.updateTaskDetailByPidAndState(hashmap);
			if(i > 0){
				map.put("feedback", "已更新!");
			}else{
				map.put("feedback", "更新失败!");
			}
		}else{
			map.put("feedback", "暂时没有任务!");
		}
		return map;
	}
	
}
