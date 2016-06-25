package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.DateInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
@Transactional
@Controller
public class CheckErrorTask {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckErrorTask.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private DateInfoService dateInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	
	@Value("${secret}")
	private String secret;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	 */
	@RequestMapping(value="/api/platform/endTaskstate")
	public @ResponseBody ModelMap endTaskstate() throws Exception{
		ModelMap map = new ModelMap();
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("counts", tSysconfInfoCustom.getSysconfname4());
		hashmap.put("tasktype", "33");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskerrorcounts(hashmap);
		if(tTaskInfoCustomlist != null){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(tTaskInfoCustom.getTaskid());
				if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
					map.put("data", "stateerror");
					return map;
				}
				hashmap.put("taskstate", 18);
				hashmap.put("oldtaskendstate", "16");
				int endcounts = taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
				if(endcounts>0){
					taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
					taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
					hashmap.put("newstate", 40);
					hashmap.put("oldstate", 23);
					taskDetailInfoTempService.updatestate(hashmap);
					TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
					
					HashMap<String,Object> hashmapusertest= new HashMap<String, Object>();
					hashmapusertest.put("page", 0);
					hashmapusertest.put("rows", 10);
					hashmapusertest.put("usertestid", tTaskDetailInfoFlowCustom.getCreateuser());
					List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmapusertest);
					if(tUsertestInfoCustomlist!=null && tUsertestInfoCustomlist.size()>0){
						if(tUsertestInfoCustomlist.get(0).getUserroleid().equals("2")
								&& tTaskInfoCustom.getFlowcount() !=0){
							//并调用接口终止发布到第一个手机网站的任务
							String url = liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
							HttpClient httpClient = new HttpClient();
							String result="";
					        PostMethod postMethod = new PostMethod(url);
					        postMethod.setRequestHeader("secret", secret);
					        int statusCode =  httpClient.executeMethod(postMethod);
					        if(statusCode == 200) {
					            result = postMethod.getResponseBodyAsString();
					            if(result.indexOf("delay") != -1){
						            map.put("msg", result);
						            logger.info("任务错误数超出预定值，自动终止任务成功");
					            }else{
					            	logger.error("任务错误数超出预定值，自动终止任务失败，失败返回值："+result);
						            throw new RuntimeException();
					            }
					        }else {
					            logger.error("任务错误数超出预定值，自动终止任务失败，失败错误码："+statusCode);
					            throw new RuntimeException();
					        }
						}
					}else{
						//并调用接口终止发布到第一个手机网站的任务
						String url = liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
						HttpClient httpClient = new HttpClient();
						String result="";
				        PostMethod postMethod = new PostMethod(url);
				        postMethod.setRequestHeader("secret", secret);
				        int statusCode =  httpClient.executeMethod(postMethod);
				        if(statusCode == 200) {
				            result = postMethod.getResponseBodyAsString();
				            if(result.indexOf("delay") != -1){
					            map.put("msg", result);
					            logger.info("任务错误数超出预定值，自动终止任务成功");
				            }else{
				            	logger.error("任务错误数超出预定值，自动终止任务失败，失败返回值："+result);
					            throw new RuntimeException();
				            }
				        }else {
				            logger.error("任务错误数超出预定值，自动终止任务失败，失败错误码："+statusCode);
				            throw new RuntimeException();
				        }
					}
				}
			}
		}
		hashmap.clear();
		hashmap.put("counts", tSysconfInfoCustom.getSysconfname3());
		hashmap.put("tasktype", "34");
		List<TTaskInfoCustom> tTaskInfoCustomlistztc = taskInfoService.findTaskerrorcounts(hashmap);
		if(tTaskInfoCustomlistztc != null){
			for (int i = 0; i < tTaskInfoCustomlistztc.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistztc.get(i);
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(tTaskInfoCustom.getTaskid());
				if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
					map.put("data", "stateerror");
					return map;
				}
				hashmap.put("taskstate", "18");
				hashmap.put("oldtaskendstate", "16");
				int endcounts = taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
				if(endcounts>0){
					taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
					taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
					hashmap.put("newstate", "40");
					hashmap.put("oldstate", "23");
					taskDetailInfoTempService.updatestate(hashmap);
				}
			}
		}
		return map;
	}
}
