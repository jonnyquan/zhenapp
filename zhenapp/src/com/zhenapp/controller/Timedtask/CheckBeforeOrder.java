package com.zhenapp.controller.Timedtask;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.DateInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.StringUtilWxf;
@Controller
public class CheckBeforeOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckBeforeOrder.class);
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
	private PointsInfoService pointsInfoService;
	@Autowired
	private DateInfoService dateInfoService;
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
	 * 查询今天之前的任务      每天0点1分执行
	 */
	@RequestMapping(value="/api/platform/updateTaskstateByTime")
	public @ResponseBody ModelMap updateTaskstateByTime() throws Exception{
		ModelMap map = new ModelMap();
		//还在执行中的任务   变成已完成	状态为待分配（15） 和运行中（16）的任务
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "15,16");
		hashmap.put("before", yyyyMMdd.format(new Date()));
		List<TTaskInfoCustom> tTaskInfoCustomlistfinish = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlistfinish!=null && tTaskInfoCustomlistfinish.size()>0){
			hashmap.put("newstate", "21");
			hashmap.put("oldstate", "20,40");
			hashmap.put("taskstate", "17");
			for (int i = 0; i < tTaskInfoCustomlistfinish.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
				TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
				TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
				TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				//将每个任务分配好的详情任务给设置成已完成
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "系统凌晨0点1分执行");
				taskDetailInfoService.updateTaskDetailstateByTaskidAndoldstate(hashmap);//将所有带获取和执行中的详细任务设置为已完成
				taskInfoService.updateTaskstate(hashmap);//将该任务设置为已完成
				
				int finishcount = 0;
				//给用户添加积分明细记录
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				//给代理添加积分明细记录
				TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
				if(tTaskInfoCustom.getTasktype().equals("33")){
	        		TTaskDetailInfoFlowCustom TTaskDetailInfoFlowCustombefore = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
	        		finishcount = TTaskDetailInfoFlowCustombefore.getFinishcount();
	        		int pointsflow = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		        	int pointsflowagent = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
		        	//加购，收藏失败
		        	hashmap.clear();
		        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
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
					tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
					//给代理添加终止任务所返回的积分
					tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
					
					tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
	        	}else{
	        		hashmap.clear();
					hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
					hashmap.put("tasktype", "34");
					hashmap.put("iscollection", "0");
					hashmap.put("isshopping", "0");
					finishcount = taskDetailInfoService.findCounts(hashmap);
					int pointsflowztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
		        	int pointsflowagentztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
		        	hashmap.clear();
		        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
					hashmap.put("tasktype", "34");
					hashmap.put("iscollection", "1");
					hashmap.put("isshopping", "1");
		        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
					int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
					int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
					int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
					int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
					//给用户添加终止任务所返回的积分
					tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
					
					tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointscollectztc + pointsshoppingztc));
					tPointsInfoCustom.setPointsupdate((pointsflowztc + pointscollectztc + pointsshoppingztc));
					tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
					//给代理添加终止任务所返回的积分
					tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
					
					tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
					tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
					tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
	        	}
				
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				
				//给代理添加终止任务所返回的积分
				tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
				
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("凌晨处理未完成任务");
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPointstype("28");
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				
				tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
				tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdateuser("凌晨处理未完成任务");
				tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustomagent.setPointstype("28");
				tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustomagent);
			}
			logger.info("处理前一天未执行完成的任务结束");
		}
		
		//终止中的任务变成已终止      并且给用户返还积分		状态为终止中（18）的任务
		hashmap.put("taskstate", "18");
		List<TTaskInfoCustom> tTaskInfoCustomlistend = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlistend!=null && tTaskInfoCustomlistend.size()>0){
			hashmap.put("newstate", "23");
			hashmap.put("oldstate", "20");
			hashmap.put("taskstate", "18");
			for (int i = 0; i < tTaskInfoCustomlistend.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
				TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
				TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
				TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				//将状态为终止中的任务中 	详情任务状态为执行中	修改为已终止状态	并返还积分
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "凌晨处理未终止任务");
				taskDetailInfoService.updateTaskDetailstateByTaskidAndoldstate(hashmap);
				taskInfoService.updateTaskstate(hashmap);//将该任务设置为已终止
				
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
				            	logger.error("/api/platform/updateTaskstateByTime---->调用成功，执行失败返回信息" + result);
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
				            logger.error("/api/platform/updateTaskstateByTime---->调用成功返回码" + result);
				        }else {
				            logger.error("/api/platform/updateTaskstateByTime---->失败错误码" + statusCode);
				            throw new RuntimeException();
				        }
					}
				}else{
					//查询直通车任务完成个数
					hashmap.clear();
					hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "21");
					flowcounts = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
				}
				int finishcount = 0;
	        	//给用户添加积分明细记录
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				//给代理添加积分明细记录
				TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
				if(tTaskInfoCustom.getTasktype().equals("33")){
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
		        	//加购，收藏失败
		        	hashmap.clear();
		        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
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
					tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
					//给代理添加终止任务所返回的积分
					tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
					
					tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
	        	}else{
	        		hashmap.clear();
					hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
					hashmap.put("tasktype", "34");
					hashmap.put("iscollection", "0");
					hashmap.put("isshopping", "0");
					finishcount = taskDetailInfoService.findCounts(hashmap);
					int pointsflowztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
		        	int pointsflowagentztc = (tTaskInfoCustom.getFlowcount()-finishcount)*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
		        	hashmap.clear();
		        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", "22");
					hashmap.put("tasktype", "34");
					hashmap.put("iscollection", "1");
					hashmap.put("isshopping", "1");
		        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
					int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
					int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
					int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
					int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
					//给用户添加终止任务所返回的积分
					tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
					
					tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointscollectztc + pointsshoppingztc));
					tPointsInfoCustom.setPointsupdate((pointsflowztc + pointscollectztc + pointsshoppingztc));
					tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointscollectztc + pointsshoppingztc);
					//给代理添加终止任务所返回的积分
					tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
					
					tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
					tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc));
					tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointscollectagentztc + pointsshoppingagentztc);
	        	}
				
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("系统凌晨检查任务是否已终止");
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
				tPointsInfoCustomagent.setUpdateuser("系统凌晨检查任务是否已终止");
				tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustomagent.setPointstype("28");
				tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustomagent);
				logger.info("系统凌晨处理任务成功");
			}
		}
		return map;
	}
}
