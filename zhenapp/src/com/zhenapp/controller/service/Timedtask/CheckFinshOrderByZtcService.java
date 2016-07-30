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
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Service
public class CheckFinshOrderByZtcService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckFinshOrderByZtcService.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private AgentInfoService agentInfoService;

	/*
	 * 判断是否有任务执行完成        修改任务状态,积分处理 直通车
	 */
	public @ResponseBody ModelMap cyclecheckTaskByztc(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		boolean isfinish = false;
		boolean isfinishflow = false;
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		hashmap.put("taskstate", "21,22");
		int counts = 0;
		int checkcount = 0;
		hashmap.put("iscollection", "1");
		hashmap.put("isshopping", "1");
		counts = taskDetailInfoService.findCounts(hashmap);
		checkcount = tTaskInfoCustom.getCollectioncount();
		if(counts>=checkcount){
			//收藏和加购任务已经执行完成
			isfinish=true;
		}else{
			return map;	
		}
		hashmap.clear();
		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		hashmap.put("taskstate", "21,22");
		int counts_ztc = taskDetailInfoService.findCounts(hashmap);
		if(counts_ztc==tTaskInfoCustom.getFlowcount()){
			isfinishflow = true;
		}else{
			isfinishflow = false;
		}
        if(isfinish && isfinishflow){
        	//表示任务已完成
        	//更新任务状态
        	hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "17");
			hashmap.put("oldfinshtaskstate", "16");
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "检查任务是否已完成");
			int finshcount = taskInfoService.updateTaskstate(hashmap);
			if(finshcount > 0){
				map.put("data", "success");
				logger.info(tTaskInfoCustom.getTaskpk()+"该订单已成功完成!");
			}else{
				logger.info("该订单"+tTaskInfoCustom.getTaskpk()+"无法修改为已完成"+hashmap.toString());
				return map;
			}
        	//任务失败积分数返回
        	int finishcount = 0;
        	//给用户添加积分明细记录
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			//给代理添加积分明细记录
			TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
			TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
    		hashmap.clear();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "0");
			hashmap.put("isshopping", "0");
			finishcount = taskDetailInfoService.findCounts(hashmap);
			int pointsflowztc = finishcount*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
        	int pointsflowagentztc = finishcount*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
        	hashmap.clear();
        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "1");
			hashmap.put("isshopping", "1");
        	int errorcounts = taskDetailInfoService.findCounts(hashmap);
        	int pointllztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts4());
			int pointscollectztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts5());
			int pointsshoppingztc = errorcounts*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
			int pointllagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts4());
			int pointscollectagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts5());
			int pointsshoppingagentztc = errorcounts*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts6());
			//给用户添加终止任务所返回的积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc);
			tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPointsupdate((pointsflowztc + pointllztc + pointscollectztc + pointsshoppingztc));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			//给代理添加终止任务所返回的积分
			tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc);
			tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPointsupdate((pointsflowagentztc + pointllagentztc + pointscollectagentztc + pointsshoppingagentztc));
			tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
        	tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("检查订单是否完成");
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
			tPointsInfoCustomagent.setUpdateuser("检查订单是否完成");
			tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustomagent.setPointstype("28");
			tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
			tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustomagent);
        }
		return map;	
	}
}
