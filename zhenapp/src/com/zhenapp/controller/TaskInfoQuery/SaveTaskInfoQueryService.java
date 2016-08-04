package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskInfoQueryService;
@Transactional
@Service
public class SaveTaskInfoQueryService {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;

	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	@RequestMapping("/api/saveTaskInfoQuery")
	public @ResponseBody ModelMap saveTaskInfo(TTaskInfoQueryCustom tTaskInfoQueryCustom) throws Exception{
		ModelMap map = new ModelMap();
		taskInfoQueryService.saveTaskInfo(tTaskInfoQueryCustom);
		return map;
	}
}
