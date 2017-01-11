package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoQueryService;
import com.zhenapp.service.TaskInfoService;
@Transactional
@Service
public class DeleteDataService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = Logger.getLogger(DeleteDataService.class);
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	/*
	 * 每天1点30分删除前一天的数据
	 */
	public @ResponseBody ModelMap deleteData() throws Exception{
		ModelMap map = new ModelMap();
		String time = sdf.format(new Date().getTime()-(1*24*3600*1000)-(30*60*1000));
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("time", time);
		try{
			taskInfoService.deleteDate(hashmap);
			taskDetailInfoService.deleteDate(hashmap);
			taskDetailInfoTempService.deleteDate(hashmap);
			taskInfoQueryService.deleteDate(hashmap);
		}catch(Exception e){
			logger.error("每天0点20分删除前一天的数据,删除时间节点为:"+time+"==============删除失败!!!");
		}
		logger.info("每天0点20分删除前一天的数据,删除时间节点为:"+time);
		return map;
	}
	
	/**
	 * 每10分钟删除已完成和已终止的详情任务数据
	 */
	public void deleteDetailinfoDate() throws Exception{
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "17,19");
		
		taskDetailInfoService.deleteDate(hashmap);
		
	}
}
