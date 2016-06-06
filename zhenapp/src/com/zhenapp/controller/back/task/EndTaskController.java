package com.zhenapp.controller.back.task;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
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
	
	@Value("${secret}")
	private String secret;
	
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
		taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
		taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
		taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
		hashmap.put("newstate", 40);
		hashmap.put("oldstate", 23);
		taskDetailInfoTempService.updatestate(hashmap);
		/*TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
		
		//并调用接口终止发布到第一个手机网站的任务
		String url="http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            map.put("msg", result);
            if(result.indexOf("delay")!=-1){
            	
            }else{
            	logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败代码："+result);
                throw new RuntimeException();
            }
        }else {
            map.put("msg", "失败错误码" + statusCode);
            logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败错误码："+result);
            throw new RuntimeException();
        }*/
		map.put("data", "success");
		return map;
	}
	
}
