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
				
  		        //更新完成数
 	    		hashmap.put("finishcount", tTaskInfoCustom.getFlowcount());
 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
				
 	    		//加购失败
	        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "22");
				int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
				int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
				
				int pointscollectAgent = collectcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts2());
				int pointsshoppingAgent = shoppingcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts3());
				
				
				//给用户添加终止任务所返回的积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()  + pointscollect + pointsshopping);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				
				//给代理添加终止任务所返回的积分
				tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints()  + pointscollectAgent + pointsshoppingAgent);
				tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
				//给用户添加积分明细记录
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("sys");
				tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+( pointscollect + pointsshopping));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
				tPointsInfoCustom.setPointstype("28");
				tPointsInfoCustom.setPointsupdate(( pointscollect + pointsshopping));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				//给代理添加积分明细记录
				TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
				tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
				tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdateuser("sys");
				tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+( pointscollectAgent + pointsshoppingAgent));
				tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
				tPointsInfoCustomagent.setPointstype("28");
				tPointsInfoCustomagent.setPointsupdate(( pointscollectAgent + pointsshoppingAgent));
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
				hashmap.put("updateuser", "系统凌晨0点1分执行");
				taskDetailInfoService.updateTaskDetailstateByTaskidAndoldstate(hashmap);
				taskInfoService.updateTaskstate(hashmap);//将该任务设置为已终止
				//int points = taskDetailInfoService.findPointsByteterminationstate(tTaskInfoCustom.getTaskid());
				int endcounts = taskDetailInfoService.findcountEndstate(tTaskInfoCustom.getTaskid());
				int endpoints = endcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
				int endpointsagent = endcounts * Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
				
				//收藏，加购失败需要返回的积分
	        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "22");
				int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
				int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
				int pointserror=pointscollect+pointsshopping;
				
				int pointscollectagent = collectcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts2());
				int pointsshoppingagent = shoppingcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts3());
				int pointserroragent = pointscollectagent + pointsshoppingagent;
				
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "21");
				int tempcollectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int tempshoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int maxcount=tempcollectcount;
				if(maxcount < tempshoppingcount){
					maxcount = tempshoppingcount;
				}
				//查询完成了多少个流量任务
				int flowpoints=0;
				int flowcounts=0;
				int flowpointsagent=0;
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
			        GetMethod getMethod = new GetMethod("http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
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
		        if(maxcount < flowcounts){
 	    			maxcount = flowcounts;
 	    		}
		        flowpoints = (tTaskInfoCustom.getFlowcount() - maxcount) * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		        flowpointsagent = (tTaskInfoCustom.getFlowcount() - maxcount) * Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
		        //插入用户账户明细
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				tPointsInfoCustom.setCreateuser("系统过凌晨处理");
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("sys");
				tPointsInfoCustom.setPointreason("终止任务" + tTaskInfoCustom.getTaskpk() + "返回积分："+( endpoints + pointserror + flowpoints));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints() + endpoints + pointserror + flowpoints);
				tPointsInfoCustom.setPointstype("28");
				tPointsInfoCustom.setPointsupdate(endpoints + pointserror + flowpoints);
				tPointsInfoCustom.setTaskpk(0);
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				//修改用户积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + endpoints + pointserror + flowpoints);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser("系统过凌晨处理修改用户积分");
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				
				//插入代理账户明细
				TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
				tPointsInfoCustomagent.setCreateuser("系统过凌晨处理");
				tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustomagent.setUpdateuser("sys");
				tPointsInfoCustomagent.setPointreason("终止任务" + tTaskInfoCustom.getTaskpk() + "返回积分："+(endpointsagent + pointserroragent + flowpointsagent));
				tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints()+endpointsagent + pointserroragent + flowpointsagent);
				tPointsInfoCustomagent.setPointstype("28");
				tPointsInfoCustomagent.setPointsupdate(endpointsagent + pointserroragent + flowpointsagent);
				tPointsInfoCustomagent.setTaskpk(0);
				tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustomagent);
				//修改代理积分
				tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + endpointsagent + pointserroragent + flowpointsagent);
				tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustomagent.setUpdateuser("系统过凌晨处理修改用户积分");
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
				map.put("state", "处理成功");
				logger.info("处理成功");
			}
		}
		return map;
	}
}
