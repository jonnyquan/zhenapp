package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;

@Controller
public class Requesttask {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	/*
	 * 手机端获取任务
	 * http://120.24.44.130/api/phone/request/task?pid=1
	 *param:pid-->手机号
	 */
	@RequestMapping(value="/api/phone/request/task/{pid}")
	public synchronized @ResponseBody String requesttask(@PathVariable(value="pid")String pid) throws Exception{
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
		//if(tTaskDetailInfoCustoming!=null){
			sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustoming);
			return sb.toString();
		/*}else{
			HashMap<String, Object> countmap= new HashMap<String, Object>();
			countmap.put("today", yyyyMMdd.format(new Date()));
			countmap.put("taskstate", "40");
			int taskdetainfocounts = taskDetailInfoService.findTaskDetailInfoByIdAndTaskstate(countmap);
			if(taskdetainfocounts>0){
				/*HashMap<String, Object> hashmap2 = new HashMap<String, Object>();
				hashmap2.put("phoneid", phoneid);
				hashmap2.put("type", "1");
				hashmap2.put("iscollection", "1");
				//查询当前小时之前的收藏任务
				TTaskDetailInfoCustom tTaskDetailInfoCustomtype1collection = taskDetailInfoService.requesttaskByphoneid(hashmap2);
				if(tTaskDetailInfoCustomtype1collection!=null){
					hashmap.put("taskdetailid", tTaskDetailInfoCustomtype1collection.getTaskdetailid());
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "api手机端获取");
					int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
					if(i > 0){
						sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype1collection);
						//将返回的字符串更新到数据表中
						hashmap.put("result", sb.toString());
						hashmap.put("updatetime", sdf.format(new Date()));
						hashmap.put("updateuser", "api手机端修改字符串");
						taskDetailInfoService.updateTaskDetailresultByid(hashmap);
						return sb.toString();
					}else{
						sb.append("暂时没有任务");
						return sb.toString();
					}
				}
				
				//查询有没有当前小时之前的待执行的任务
				hashmap2.clear();
				hashmap2.put("phoneid", phoneid);
				hashmap2.put("type", "1");
				hashmap2.put("isshopping", "1");
				TTaskDetailInfoCustom tTaskDetailInfoCustomtype1shopping = taskDetailInfoService.requesttaskByphoneid(hashmap2);
				if(tTaskDetailInfoCustomtype1shopping!=null){
					hashmap.put("taskdetailid", tTaskDetailInfoCustomtype1shopping.getTaskdetailid());
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "api手机端获取");
					int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
					if(i > 0){
						sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype1shopping);
						//将返回的字符串更新到数据表中
						hashmap.put("result", sb.toString());
						hashmap.put("updatetime", sdf.format(new Date()));
						hashmap.put("updateuser", "api手机端修改字符串");
						taskDetailInfoService.updateTaskDetailresultByid(hashmap);
						return sb.toString();
					}
				}
				//查询满足当前时间小时和分钟都大于分配的小时和分钟
				hashmap2.clear();
				hashmap2.put("phoneid", phoneid);
				hashmap2.put("type", "2");
				hashmap2.put("iscollection", "1");
				TTaskDetailInfoCustom tTaskDetailInfoCustomtype2collection = taskDetailInfoService.requesttaskByphoneid(hashmap2);
				if(tTaskDetailInfoCustomtype2collection!= null){
					hashmap.put("taskdetailid", tTaskDetailInfoCustomtype2collection.getTaskdetailid());
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "api手机端获取");
					int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
					if(i > 0){
						sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype2collection);
						//将返回的字符串更新到数据表中
						hashmap.put("result", sb.toString());
						hashmap.put("updatetime", sdf.format(new Date()));
						hashmap.put("updateuser", "api手机端修改字符串");
						taskDetailInfoService.updateTaskDetailresultByid(hashmap);
						return sb.toString();
					}else{
						sb.append("暂时没有任务");
						return sb.toString();
					}
				}
				hashmap2.clear();
				hashmap2.put("phoneid", phoneid);
				hashmap2.put("type", "2");
				hashmap2.put("isshopping", "1");
				TTaskDetailInfoCustom tTaskDetailInfoCustomtype2shopping = taskDetailInfoService.requesttaskByphoneid(hashmap2);
				if(tTaskDetailInfoCustomtype2shopping!= null){
					hashmap.put("taskdetailid", tTaskDetailInfoCustomtype2shopping.getTaskdetailid());
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "api手机端获取");
					int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
					if(i > 0){
						sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype2shopping);
						//将返回的字符串更新到数据表中
						hashmap.put("result", sb.toString());
						hashmap.put("updatetime", sdf.format(new Date()));
						hashmap.put("updateuser", "api手机端修改字符串");
						taskDetailInfoService.updateTaskDetailresultByid(hashmap);
						return sb.toString();
					}else{
						sb.append("暂时没有任务");
						return sb.toString();
					}
				}
				
				sb.append("暂时没有任务");
				return sb.toString();
				
			}else{
				sb.append("暂时没有任务");
				return sb.toString();
			}
		}*/
	}
	
}
