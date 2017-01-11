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

import com.zhenapp.controller.phoneapi.service.RequestTaskAutoService;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;

@Controller
public class RequestTaskAuto {
	private static Logger logger = Logger.getLogger(RequestTaskAuto.class);
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private RequestTaskAutoService requestTaskAutoService;
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
		synchronized(this){
			//查询该手机是否有执行中未返回的任务
			TTaskDetailInfoCustom tTaskDetailInfoCustoming = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
			if(tTaskDetailInfoCustoming!=null){
				sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustoming);
				logger.info(phoneid+"号手机:有正在执行中的任务");
				return sb.toString();
			}else{
				sb = requestTaskAutoService.requestTaskAuto(phoneid);
				return sb.toString();
			}
		}
	}
	
}
