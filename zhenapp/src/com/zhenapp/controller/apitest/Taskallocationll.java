package com.zhenapp.controller.apitest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
@RequestMapping(value="/api")
public class Taskallocationll {
	private static Logger logger = Logger.getLogger(Taskallocationll.class);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hh = new SimpleDateFormat("HH");
	SimpleDateFormat mm = new SimpleDateFormat("mm");
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskallocationllService taskallocationllService;
	
	/*
	 * 任务分配
	 */
	@RequestMapping(value="/allocationll")
	public @ResponseBody ModelMap allocationll() throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> hashmapstate = new HashMap<String, Object>();
		hashmapstate.put("taskstate", "15");
		hashmapstate.put("tasktype", "33");
		hashmapstate.put("allocationdate", yyyyMMdd.format(new Date()));
		List<TTaskInfoCustom> ttaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmapstate);
		if(ttaskInfoCustomlist!=null && ttaskInfoCustomlist.size()>0){
			for (int ii = 0; ii < ttaskInfoCustomlist.size(); ii++) {
				TTaskInfoCustom tTaskInfoCustom = ttaskInfoCustomlist.get(ii);
				taskallocationllService.allocationService(tTaskInfoCustom);
				logger.info("任务:"+tTaskInfoCustom.getTaskpk()+"分配完成");
			}
		}
		return map;
	}
}
