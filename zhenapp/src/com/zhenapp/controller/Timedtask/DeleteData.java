package com.zhenapp.controller.Timedtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.DeleteDataService;

@Controller
public class DeleteData {
	@Autowired
	private DeleteDataService deleteDataService;
	
	/*
	 * 每天1点30分删除前一天的数据
	 */
	@RequestMapping("/api/deleteData")
	public @ResponseBody ModelMap deleteData() throws Exception{
		ModelMap map = new ModelMap();
		deleteDataService.deleteData();
		return map;
	}
	
	/**
	 * 每10分钟删除已完成和已终止的详情任务数据
	 */
	public void deleteDetailinfoDate() throws Exception{
		deleteDataService.deleteDetailinfoDate();
	}
}
