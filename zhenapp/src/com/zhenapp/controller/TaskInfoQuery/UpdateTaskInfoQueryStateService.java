package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskInfoQueryService;
import com.zhenapp.service.TaskInfoService;
@Transactional
@Service
public class UpdateTaskInfoQueryStateService {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	@Autowired
	private TaskInfoService taskInfoService;

	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	public @ResponseBody ModelMap updateTaskInfoQueryState(TTaskInfoQueryCustom tTaskInfoQueryCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		TTaskInfoCustom tTaskInfoCustom = taskInfoService.findTaskInfoByTaskid(tTaskInfoQueryCustom.getTaskid());
		hashmap.put("taskid", tTaskInfoQueryCustom.getTaskid());
		hashmap.put("taskstate", tTaskInfoCustom.getTaskstate());
		hashmap.put("updatetime", yyyyMMddHHmmss.format(new Date()));
		hashmap.put("updateuser", "修改状态");
		taskInfoQueryService.updateTaskInfoState(hashmap);
		
		return map;
	}
}
