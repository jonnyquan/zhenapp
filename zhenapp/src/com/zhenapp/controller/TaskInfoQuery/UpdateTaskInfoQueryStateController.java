package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
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
public class UpdateTaskInfoQueryStateController {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	@Autowired
	private UpdateTaskInfoQueryStateService updateTaskInfoQueryStateService;

	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	@RequestMapping("/api/updateTaskInfostate")
	public @ResponseBody ModelMap updateTaskInfostate() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		//hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		hashmap.put("taskstate", "16,18,15");
		hashmap.put("page", 0);
		hashmap.put("rows", 1000);
		List<TTaskInfoQueryCustom> tTaskInfoQueryCustomList = taskInfoQueryService.findTaskInfoByMap(hashmap);
		for (int i = 0; i < tTaskInfoQueryCustomList.size(); i++) {
			TTaskInfoQueryCustom tTaskInfoQueryCustom = tTaskInfoQueryCustomList.get(i);
			updateTaskInfoQueryStateService.updateTaskInfoQueryState(tTaskInfoQueryCustom);
		}
		return map;
	}
}
