package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskInfoQueryService;

@Controller
public class TaskInfoQueryController {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	@Autowired
	private SaveTaskInfoQueryService saveTaskInfoQueryService;
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	@RequestMapping("/api/saveTaskInfoQuery")
	public @ResponseBody ModelMap saveTaskInfo() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		List<TTaskInfoQueryCustom> tTaskInfoQueryCustomList = taskInfoQueryService.findTaskInfo(hashmap);
		for (int i = 0; i < tTaskInfoQueryCustomList.size(); i++) {
			TTaskInfoQueryCustom tTaskInfoQueryCustom = tTaskInfoQueryCustomList.get(i);
			tTaskInfoQueryCustom.setFinshcollectioncounts(0);
			tTaskInfoQueryCustom.setFinshflowcounts(0);
			tTaskInfoQueryCustom.setFinshshoppingcounts(0);
			tTaskInfoQueryCustom.setErrorcounts(0);
			saveTaskInfoQueryService.saveTaskInfo(tTaskInfoQueryCustom);
		}
		return map;
	}
}
