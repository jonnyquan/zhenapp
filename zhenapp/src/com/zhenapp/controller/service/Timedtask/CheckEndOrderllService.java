package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Service
public class CheckEndOrderllService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckEndOrderllService.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	
	@Value("${secret}")
	private String secret;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 每一分钟执行一次 查询任务状态为终止中的任务,检查是否所有详情任务都已返回，如果都已处理修改为已终止，结束任务，返回积分
	 */
	public @ResponseBody ModelMap checkEndOrderll(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		//查询该任务 执行中的详情任务条数
		hashmap.put("taskstate", "20");
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		int tempcount = taskDetailInfoService.findTaskDetailInfoByIdAndTaskstate(hashmap);
		if(tempcount==0){
			hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "19");
			hashmap.put("oldtaskendstate", "18");
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "检查任务是否已终止");
			int endcount = taskInfoService.updateTaskstate(hashmap);//将该任务id修改为已终止
			if(endcount>0){
				map.put("data", "success");
				logger.info("该订单已成功终止!");
			}else{
				logger.info("该订单"+tTaskInfoCustom.getTaskid()+"无法修改为已终止"+hashmap.toString());
				return map;
			}
			//查询完成了多少个流量任务
			int flowcounts=0;
			if(tTaskInfoCustom.getTasktype().equals("33")){
				TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
				HashMap<String,Object> hashmapusertest= new HashMap<String, Object>();
				hashmapusertest.put("page", 0);
				hashmapusertest.put("rows", 10);
				hashmapusertest.put("usertestid", tTaskDetailInfoFlowCustom.getCreateuser());
				List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmapusertest);
				if(tUsertestInfoCustomlist!=null && tUsertestInfoCustomlist.size()>0){
					if(tUsertestInfoCustomlist.get(0).getUserroleid().equals("2")
							&& tTaskInfoCustom.getFlowcount() !=0){
						HttpClient httpClient = new HttpClient();
						String result="";
				        GetMethod getMethod = new GetMethod(liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
				        getMethod.setRequestHeader("secret", secret);
				        int statusCode =  httpClient.executeMethod(getMethod);
				        if(statusCode == 200) {
				            result = getMethod.getResponseBodyAsString();
				            if(result.indexOf("total")==-1){
				            	result = StringUtilWxf.translat(result);
				            	throw new RuntimeException();
				            }else{
				            	ObjectMapper obj = new ObjectMapper();
				 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
				 	    		result=msgInfoCustom.getTotal()+"";
				 	    		//更新完成数
				 	    		hashmap.put("finishcount", msgInfoCustom.getTotal());
				 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
				 	    		flowcounts= Integer.parseInt(msgInfoCustom.getTotal());
				            }
				            map.put("msg", result);
				        }else {
				            map.put("msg", "失败错误码" + statusCode);
				            throw new RuntimeException();
				        }
					}
				}else{
					HttpClient httpClient = new HttpClient();
					String result="";
			        GetMethod getMethod = new GetMethod(liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
			        getMethod.setRequestHeader("secret", secret);
			        int statusCode =  httpClient.executeMethod(getMethod);
			        if(statusCode == 200) {
			            result = getMethod.getResponseBodyAsString();
			            if(result.indexOf("total")==-1){
			            	result = StringUtilWxf.translat(result);
			            	throw new RuntimeException();
			            }else{
			            	ObjectMapper obj = new ObjectMapper();
			 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
			 	    		result=msgInfoCustom.getTotal()+"";
			 	    		//更新完成数
			 	    		hashmap.put("finishcount", msgInfoCustom.getTotal());
			 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
			 	    		flowcounts= Integer.parseInt(msgInfoCustom.getTotal());
			            }
			            map.put("msg", result);
			        }else {
			            map.put("msg", "失败错误码" + statusCode);
			            throw new RuntimeException();
			        }
				}
			}
        	//给用户添加积分明细记录
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			//给代理添加积分明细记录
			TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
			TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "21");
				int tempcollectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int tempshoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int maxcount=tempcollectcount;
				if(maxcount < tempshoppingcount){
					maxcount = tempshoppingcount;
				}
		        if(maxcount < flowcounts){
 	    			maxcount = flowcounts;
		        }
		        
		     	int pointsflow = (tTaskInfoCustom.getFlowcount()-maxcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
	        	int pointsflowagent = (tTaskInfoCustom.getFlowcount()-maxcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
	        	//加购，收藏失败和终止的
	        	hashmap.clear();
	        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "22,23");
				int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
				int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
				int pointscollectagent = collectcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts2());
				int pointsshoppingagent = shoppingcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts3());
				//给用户添加终止任务所返回的积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
				
				tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflow + pointscollect + pointsshopping));
				tPointsInfoCustom.setPointsupdate((pointsflow + pointscollect + pointsshopping));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
				//给代理添加终止任务所返回的积分
				tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
				
				tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
				tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
				tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
        	
			
			tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("检查任务是否已终止");
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPointstype("28");
			tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
			
			tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
			
			tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
			tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustomagent.setUpdateuser("检查任务是否已终止");
			tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustomagent.setPointstype("28");
			tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
			tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustomagent);
		}else{
			logger.info("该订单还有正在执行的任务!");
			map.put("data", "error");
		}
		logger.info("检查终止中的订单完成!");
		return map;
	}
	
	
	public @ResponseBody ModelMap checkEndErrorOrderll(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		hashmap.put("taskstate", "19");
		hashmap.put("oldtaskendstate", "18");
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", "检查任务是否已终止");
		int endcount = taskInfoService.updateTaskstate(hashmap);//将该任务id修改为已终止
		if(endcount>0){
			map.put("data", "success");
			logger.info("该订单已成功终止!");
		}else{
			logger.info("该订单"+tTaskInfoCustom.getTaskid()+"无法修改为已终止"+hashmap.toString());
			return map;
		}
		
		
		int flowcounts=0;
		//给用户添加积分明细记录
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		//给代理添加积分明细记录
		TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
		TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		
			
			int tempcollectcount = 0;
			int tempshoppingcount = 0;
			int maxcount=tempcollectcount;
			if(maxcount < tempshoppingcount){
				maxcount = tempshoppingcount;
			}
	        if(maxcount < flowcounts){
	    			maxcount = flowcounts;
	        }
	        
	     	int pointsflow = (tTaskInfoCustom.getFlowcount()-maxcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
        	int pointsflowagent = (tTaskInfoCustom.getFlowcount()-maxcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
        	//加购，收藏失败和终止的
        	
			int collectcount = 0;
			int shoppingcount = 0;
			int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
			int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
			int pointscollectagent = collectcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts2());
			int pointsshoppingagent = shoppingcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts3());
			//给用户添加终止任务所返回的积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
			
			tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflow + pointscollect + pointsshopping));
			tPointsInfoCustom.setPointsupdate((pointsflow + pointscollect + pointsshopping));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			//给代理添加终止任务所返回的积分
			tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
			
			tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
			tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
			tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
    	
		
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("检查任务是否已终止");
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPointstype("28");
		tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
		tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		
		tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
		
		tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
		tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustomagent.setUpdateuser("检查任务是否已终止");
		tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustomagent.setPointstype("28");
		tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
		tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustomagent);
		return map;
	}
}
