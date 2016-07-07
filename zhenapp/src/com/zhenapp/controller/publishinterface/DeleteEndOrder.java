package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
@Controller
public class DeleteEndOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(DeleteEndOrder.class);
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	
	/*
	 * 详情任务状态为执行终止	的详情任务删除
	 */
	@RequestMapping(value="/api/platform/deleteTaskstate")
	public @ResponseBody ModelMap deleteTaskstate() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "19");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findEndTaskfordel(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				hashmap.put("taskstate", "23");
				hashmap.put("taskid", tTaskInfoCustomlist.get(i).getTaskid());
				taskDetailInfoService.deleteTaskBystate(hashmap);
				taskDetailInfoTempService.deletetaskDetailInfoTemp(hashmap);
				logger.info("删除订单号为:"+ tTaskInfoCustomlist.get(i).getTaskpk()+"的所有已终止订单!");
			}
		}
		return map;
	}
}
