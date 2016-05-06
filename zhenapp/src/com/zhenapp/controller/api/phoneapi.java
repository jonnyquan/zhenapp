package com.zhenapp.controller.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;

/*
 * 供手机端调用的api
 * 
 */
@Controller
public class phoneapi {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	/*
	 * 手机端获取任务
	 * http://120.24.44.130/api/phone/request/task?pid=1
	 *param:pid-->手机号
	 */
	@RequestMapping(value="/api/phone/request/task/{pid}")
	public @ResponseBody String requesttask(@PathVariable(value="pid")String pid) throws Exception{
		StringBuffer sb=new StringBuffer();
		/*
		 * 查询当前手机是否有未完成的任务
		 */
		HashMap<String, Object> hashmap = new HashMap<String,Object>();
		hashmap.put("phoneid", pid);
		hashmap.put("taskstate", 20);
		TTaskDetailInfoCustom tTaskDetailInfoCustoming = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
		if(tTaskDetailInfoCustoming!=null){
			sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustoming);
		}else{
			TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.requesttaskByphoneid(pid);
			if(tTaskDetailInfoCustom!= null){
				hashmap.put("taskdetailid", tTaskDetailInfoCustom.getTaskdetailid());
				int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
				if(i > 0){
					sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustom);
				}else{
					sb.append("未获取到符合要求的详细任务");
				}
			}else{
				sb.append("未获取到符合要求的详细任务");
			}
		}
		String result=sb.toString();
		return result;
	}
	
	
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
	public @ResponseBody ModelMap requesttask(String pid,String visit,String collect,String trolley) throws Exception{
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
			int i = taskDetailInfoService.updateTaskDetailByPidAndState(hashmap);
			if(i > 0){
				map.put("反馈情况", "已更新该手机执行任务状态!");
			}else{
				map.put("反馈情况", "更新该手机执行任务状态失败!");
			}
		}else{
			map.put("反馈情况", "该手机编号当前没有正在执行的任务!");
		}
		return map;
	}
}
