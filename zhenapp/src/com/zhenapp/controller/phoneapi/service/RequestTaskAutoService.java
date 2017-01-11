package com.zhenapp.controller.phoneapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;

@Transactional
@Service
public class RequestTaskAutoService {
	private static Logger logger = Logger.getLogger(RequestTaskAutoService.class);
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	public StringBuffer requestTaskAuto(int phoneid) throws Exception{
		StringBuffer sb=new StringBuffer();
		HashMap<String, Object> hashmap = new HashMap<String,Object>();
		hashmap.put("phoneid", phoneid);
		hashmap.put("taskstate", 20);
		
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
					return sb;
				}
				sb.append("暂时没有任务");
				logger.info(phoneid+"暂时没有任务");
				return sb;
			
	}
	
}
