package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.CheckErrorllService;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskInfoService;

@Controller
public class CheckErrorll {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private CheckErrorllService checkErrorllService;
	
	/*
	 * 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	 */
	@RequestMapping(value="/api/platform/checkErrorll")
	public @ResponseBody ModelMap checkErrorll() throws Exception{
		ModelMap map = new ModelMap();
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("counts", tSysconfInfoCustom.getSysconfname4());
		hashmap.put("tasktype", "33");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskerrorcounts(hashmap);
		if(tTaskInfoCustomlist != null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				checkErrorllService.checkErrorll(tTaskInfoCustom);
			}
		}
		return map;
	}
}
