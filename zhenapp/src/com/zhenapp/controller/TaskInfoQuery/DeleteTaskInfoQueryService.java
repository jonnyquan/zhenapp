package com.zhenapp.controller.TaskInfoQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.TaskInfoQueryService;
@Transactional
@Service
public class DeleteTaskInfoQueryService {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	
	@RequestMapping("/api/deleteTaskInfoQuery")
	public @ResponseBody ModelMap deleteTaskInfoQuery() throws Exception{
		ModelMap map = new ModelMap();
		taskInfoQueryService.deleteTaskInfo();
		return map;
	}
}
