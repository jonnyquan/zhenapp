package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.CheckFinshOrderByllService;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
public class CheckFinshOrderByll {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckFinshOrderByll.class);
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private CheckFinshOrderByllService checkFinshOrderByllService;
	
	/*每隔3分钟执行一次 判断流量任务是否已完成
	 * 判断是否有流量任务执行完成        修改任务状态,积分处理
	 */
	@RequestMapping(value="/api/platform/cyclecheckTaskByll")
	public @ResponseBody ModelMap checkFinshOrderByll() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "16");
		hashmap.put("tasktype", "33");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				checkFinshOrderByllService.cyclecheckTaskByll(tTaskInfoCustom);
			}
			logger.info("检查订单是否已完成结束!");
		}else{
			logger.info("没有正在运行中的订单!");
		}
		return map;	
	}
}
