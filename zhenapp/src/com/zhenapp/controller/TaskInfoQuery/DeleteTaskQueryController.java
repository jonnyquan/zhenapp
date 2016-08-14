package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteTaskQueryController {
	@Autowired
	private DeleteTaskInfoQueryService deleteTaskInfoQueryService;
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@RequestMapping("/api/deleteTaskInfoQuery")
	public @ResponseBody ModelMap deleteTaskInfoQuery() throws Exception{
		ModelMap map = new ModelMap();
		deleteTaskInfoQueryService.deleteTaskInfoQuery();
		return map;
	}
}
