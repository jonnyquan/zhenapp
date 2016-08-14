package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;

@Controller
public class RequestTaskAuto {
	private static Logger logger = Logger.getLogger(RequestTaskAuto.class);
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	@RequestMapping(value="/api/phone/requestTaskAuto/{pid}")
	public @ResponseBody String requestTaskAuto(@PathVariable(value="pid")String pid) throws Exception{
		StringBuffer sb=new StringBuffer();
		//查询当前手机是否有未完成的任务
		HashMap<String, Object> hashmap = new HashMap<String,Object>();
		int phoneid = 0;
		try{
			phoneid = Integer.parseInt(pid);
		}catch(Exception e){
			sb.append("手机编号必须为数字!");
			return sb.toString();
		}
		hashmap.put("phoneid", phoneid);
		hashmap.put("taskstate", 20);
		//查询该手机是否有执行中未返回的任务
		TTaskDetailInfoCustom tTaskDetailInfoCustoming = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
		if(tTaskDetailInfoCustoming!=null){
			sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustoming);
			return sb.toString();
		}else{
			HashMap<String, Object> hashmap2 = new HashMap<String, Object>();
			hashmap2.put("phoneid", phoneid);
			hashmap2.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap2.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			TTaskDetailInfoCustom tTaskDetailInfoCustomtype1collection = taskDetailInfoService.requesttaskAuto(hashmap2);
			if(tTaskDetailInfoCustomtype1collection!=null){
				hashmap.put("taskdetailid", tTaskDetailInfoCustomtype1collection.getTaskdetailid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "api手机端获取");
				taskDetailInfoService.updateTaskDetailstate(hashmap);
				//将临时表的详情任务状态修改为执行中
				hashmap.put("oldstate", "20");
				taskDetailInfoTempService.updatestate(hashmap);
				sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype1collection);
				logger.info(phoneid+"获取任务:"+sb.toString());
				return sb.toString();
			}
			sb.append("暂时没有任务");
			logger.info("暂时没有任务");
			return sb.toString();
		}
	}
	
}
