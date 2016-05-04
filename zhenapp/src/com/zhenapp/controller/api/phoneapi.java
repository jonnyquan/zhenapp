package com.zhenapp.controller.api;

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
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.requesttaskByphoneid(pid);
		int i =taskDetailInfoService.updateTaskDetailstate(tTaskDetailInfoCustom.getTaskdetailid());
		if(i > 0){
			sb.append(tTaskDetailInfoCustom.getTaskid()).append("&")
				.append(tTaskDetailInfoCustom.getTaskkeyword()).append("&")
				.append(tTaskDetailInfoCustom.getSearchtype()).append("&")
				.append(tTaskDetailInfoCustom.getMinpicture()).append("&")
				.append("null").append("&")//地区
				.append("null").append("&")//是否免运费
				.append("null").append("&")//是否天猫
				.append(tTaskDetailInfoCustom.getIscollection()).append("&")
				.append(tTaskDetailInfoCustom.getIsshopping()).append("&")
				.append(tTaskDetailInfoCustom.getTaskkeynum()).append("&")
				.append(tTaskDetailInfoCustom.getMinpicture()).append("&")
				.append(tTaskDetailInfoCustom.getMaxpicture()).append("&")
				.append(tTaskDetailInfoCustom.getTasktype()).append("&")
				.append(tTaskDetailInfoCustom.getIscreativetitle()).append("&")
				.append(tTaskDetailInfoCustom.getIsshopcollect());
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
		
		
		
		return map;
	}
}
