package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Service
public class CheckBeforeOrderService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckBeforeOrderService.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
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
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private AgentInfoService agentInfoService;
	/*
	 * 查询今天之前的任务      每天0点1分执行
	 */
	public @ResponseBody ModelMap updateTaskstateByTime(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		taskDetailInfoTempService.deletetaskDetailInfoTemp(hashmap);
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
		TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		hashmap.clear();
		hashmap.put("newstate", "21");
		hashmap.put("oldstate", "20,40");
		hashmap.put("taskstate", "17");
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
    		if(TTaskDetailInfoFlowCustombefore!=null){
    			finishcount = TTaskDetailInfoFlowCustombefore.getFinishcount();
    		}else{
    			finishcount = 0;
    		}
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
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			//给代理添加终止任务所返回的积分
			tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
			
			tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
			tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
			tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
			hashmap.clear();
        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "17");
			taskDetailInfoFlowService.updateTaskstate(hashmap);
    	}else{
    		hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "0");
			hashmap.put("isshopping", "0");
			finishcount = taskDetailInfoService.findCounts(hashmap);
			int pointsflowztc = finishcount*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
        	int pointsflowagentztc = finishcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
        	hashmap.clear();
        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "1");
			hashmap.put("isshopping", "1");
        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
        	int pointsllztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
			int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
			int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
			int pointsllagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
			int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
			int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
			//给用户添加终止任务所返回的积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointsllztc + pointscollectztc + pointsshoppingztc);
			
			tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointsllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPointsupdate((pointsflowztc + pointsllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			//给代理添加终止任务所返回的积分
			tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointsllagentztc + pointscollectagentztc + pointsshoppingagentztc);
			
			tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointsllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointsllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
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
		
		logger.info("凌晨处理任务"+tTaskInfoCustom.getTaskpk()+"完成");
		return map;
	}
}
