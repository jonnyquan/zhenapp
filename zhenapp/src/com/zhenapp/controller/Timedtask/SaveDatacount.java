package com.zhenapp.controller.Timedtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.SaveDatacountService;

@Controller
public class SaveDatacount {
	@Autowired
	private SaveDatacountService saveDatacountService;
	/**
	 * 每天0点50分执行一次 保存数据统计信息
	 */
	@RequestMapping("/api/saveDatacount")
	public @ResponseBody ModelMap saveDatacount() throws Exception{
		ModelMap map = new ModelMap();
		saveDatacountService.saveDatacount();
		return map;
	}
}
