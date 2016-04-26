package com.zhenapp.controller.api;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.TaskApi;
import com.zhenapp.po.Custom.TDurationInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.service.DurationInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskInfoService;

@Controller
@RequestMapping(value="/api")
public class tasks {
	
	@Autowired
	private DurationInfoService durationService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceInfoService priceInfoService;

	/*
	 * 发布任务接口
	 * http://liuliangapp.com/api/tasks
	 */
	@RequestMapping(value="/tasks")
	public ModelMap tasks(TaskApi taskApi) throws Exception{
		ModelMap map=new ModelMap();
		int [] hour_counts=taskApi.getHour_counts();
		int counts=0;
		for (int i = 0; i < hour_counts.length; i++) {
			counts=counts+hour_counts[i];
		}
		TPriceInfoCustom tPriceInfoCustom=priceInfoService.findPriceBycode("ptll");
		/*
		 * 保存任务信息
		 * 并返回订单号
		 */
		String startdate=taskApi.getStart_date().replace("-", "");
		String enddate=taskApi.getEnd_date().replace("-", "");
		int times=Integer.parseInt(enddate)-Integer.parseInt(startdate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, String> hashmap=new HashMap<String,String>();
		
		map.put("cost", hashmap);
		return map;
	}
	
	/*
	 * 停留时长接口
	 */
	@RequestMapping(value="/tasks/durations")
	public @ResponseBody Set<LinkedHashMap<String, Integer>> durations() throws Exception{
		Set<LinkedHashMap<String, Integer>> set =new HashSet<LinkedHashMap<String, Integer>>();
		List<TDurationInfoCustom>  tDurationInfoCustomlist=durationService.findAllDuration();
		for (int i = 0; i < tDurationInfoCustomlist.size(); i++) {
			LinkedHashMap<String, Integer> map=new LinkedHashMap<String,Integer>();
			TDurationInfoCustom tDurationInfoCustom=tDurationInfoCustomlist.get(i);
			map.put("id", tDurationInfoCustom.getDurationid());
			map.put("min", Integer.parseInt(tDurationInfoCustom.getDurationmin()));
			map.put("max", Integer.parseInt(tDurationInfoCustom.getDurationmax()));
			set.add(map);
		}
		return set;
	}
	
	/*
	 * 积分计算接口
	 * http://liuliangapp.com/api/tasks/cost
	 */
	@RequestMapping(value="/tasks/cost")
	public @ResponseBody ModelMap cost(TaskApi taskApi) throws Exception{
ModelMap map=new ModelMap();
		
		int [] hour_counts=taskApi.getHour_counts();
		int counts=0;
		for (int i = 0; i < hour_counts.length; i++) {
			counts=counts+hour_counts[i];
		}
		TPriceInfoCustom tPriceInfoCustom=priceInfoService.findPriceBycode("ptll");
		/*
		 * 保存任务信息
		 * 并返回订单号
		 */
		String startdate=taskApi.getStart_date().replace("-", "");
		String enddate=taskApi.getEnd_date().replace("-", "");
		int times=Integer.parseInt(enddate)-Integer.parseInt(startdate);
		HashMap<String, String> hashmap=new HashMap<String,String>();
		for(int i=0;i<times;i++){
			int cost=counts*Integer.parseInt(tPriceInfoCustom.getPricecounts());
			hashmap.put("cost", cost+"");
		}
		map.put("cost", hashmap);
		return map;
	}
	
	/*
	 * 结束任务接口
	 * http://liuliangapp.com/api/tasks/{id}/finish
	 */
	@RequestMapping(value="/tasks/{id}/finish")
	public @ResponseBody ModelMap finish(@PathVariable(value="id")String taskid) throws Exception{
		ModelMap map=new ModelMap();
		
		return map;
	}
	
	/*
	 *获取任务完成流量总数
	 *http://liuliangapp.com/api/tasks/{id}/total
	 */
	@RequestMapping(value="/tasks/{id}/total")
	public @ResponseBody ModelMap total(@PathVariable(value="id")String id,String date) throws Exception{
		ModelMap map=new ModelMap();
		
		return map;
	}
	
	
	
}
