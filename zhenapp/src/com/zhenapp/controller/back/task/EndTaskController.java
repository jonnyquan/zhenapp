package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoQueryService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UsertestInfoService;
@Transactional
@Controller
@RequestMapping(value="/task")
public class EndTaskController {
	private static Logger logger = Logger.getLogger(EndTaskController.class);
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${secret}")
	private String secret;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 根据任务id修改任务状态为终止中
	 */
	@RequestMapping(value="/endtaskBytaskid/{taskid}")
	public @ResponseBody ModelMap endtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskid", taskid);
		TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(taskid);
		if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
			map.put("data", "stateerror");
			return map;
		}
		hashmap.put("taskstate", 18);
		hashmap.put("oldfinshtaskstate", "16");
		int endcounts = taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
		
		if(endcounts>0){
			taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
			taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
			hashmap.put("newstate", 40);
			hashmap.put("oldstate", 23);
			taskDetailInfoTempService.updatestate(hashmap);
		}else{
			map.put("data", "stateerror");
			logger.error("终止订单失败,无法修改为已终止"+hashmap.toString());
			return map;
		}
		hashmap.put("updatetime", yyyyMMddHHmmss.format(new Date()));
		hashmap.put("updateuser", "修改状态");
		taskInfoQueryService.updateTaskInfoState(hashmap);//修改状态为终止中
		if(tTaskInfoCustomtemp.getTasktype().equals("33")){
			TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
			hashmap.clear();
			hashmap.put("page", 0);
			hashmap.put("rows", 10);
			hashmap.put("usertestid", tTaskDetailInfoFlowCustom.getCreateuser());
			List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmap);
			if(tUsertestInfoCustomlist!=null && tUsertestInfoCustomlist.size()>0){
				if(tUsertestInfoCustomlist.get(0).getUserroleid().equals("2")
						&& tTaskInfoCustomtemp.getFlowcount() !=0){
					//并调用接口终止发布到第一个手机网站的任务
					String url=liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
					HttpClient httpClient = new HttpClient();
					String result="";
			        PostMethod postMethod = new PostMethod(url);
			        postMethod.setRequestHeader("secret", secret);
			        int statusCode =  httpClient.executeMethod(postMethod);
			        if(statusCode == 200) {
			            result = postMethod.getResponseBodyAsString();
			            map.put("msg", result);
			            if(result.indexOf("delay")!=-1){
			            	logger.info("终止流量任务成功");
			        		map.put("data", "success");
			        		return map;
			            }else{
			            	logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败代码："+result);
			                throw new RuntimeException();
			            }
			        }else {
			            map.put("msg", "失败错误码" + statusCode);
			            logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败错误码："+result);
			            throw new RuntimeException();
			        }
				}else{
					logger.info("终止任务成功");
		    		map.put("data", "success");
		    		return map;
				}
			}else{
				//并调用接口终止发布到第一个手机网站的任务
				String url=liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
				HttpClient httpClient = new HttpClient();
				String result="";
		        PostMethod postMethod = new PostMethod(url);
		        postMethod.setRequestHeader("secret", secret);
		        int statusCode =  httpClient.executeMethod(postMethod);
		        if(statusCode == 200) {
		            result = postMethod.getResponseBodyAsString();
		            map.put("msg", result);
		            if(result.indexOf("delay")!=-1){
		            	logger.info("终止流量任务成功");
		        		map.put("data", "success");
		        		return map;
		            }else{
		            	logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败代码："+result);
		                throw new RuntimeException();
		            }
		        }else {
		            map.put("msg", "失败错误码" + statusCode);
		            logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败错误码："+result);
		            throw new RuntimeException();
		        }
			}
		}else{
			logger.info("终止直通车任务成功");
    		map.put("data", "success");
    		return map;
		}
	}
}
