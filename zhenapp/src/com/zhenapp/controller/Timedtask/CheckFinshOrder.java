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
import org.springframework.transaction.annotation.Transactional;
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
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Controller
public class CheckFinshOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(CheckFinshOrder.class);
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
	
	@Value("${secret}")
	private String secret;
	/*
	 * 判断是否有任务执行完成        修改任务状态,积分处理
	 */
	@RequestMapping(value="/api/platform/cyclecheckTask")
	public @ResponseBody ModelMap cyclecheckTask() throws Exception{
		ModelMap map = new ModelMap();
		//首先判断收藏和加购是否完成
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "16");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				boolean isfinish = false;
				boolean isfinishflow = false;
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
				TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
				TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "21,22");
				int counts = taskDetailInfoService.findCounts(hashmap);
				int checkcount=tTaskInfoCustom.getCollectioncount()+tTaskInfoCustom.getShoppingcount();
				if(counts==checkcount){
					//收藏和加购任务已经执行完成
					isfinish=true;
				}
				/*TTaskDetailInfoFlowCustom TTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
				//调用接口判断流量任务是否完成
				HttpClient httpClient = new HttpClient();
				String result="";
		        GetMethod getMethod = new GetMethod("http://liuliangapp.com/api/tasks/"+TTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
		        getMethod.setRequestHeader("secret", secret);
		        int statusCode =  httpClient.executeMethod(getMethod);
		        if(statusCode == 200) {
		            result = getMethod.getResponseBodyAsString();
		            if(result.indexOf("total")==-1){
		            	result = StringUtilWxf.translat(result);
		            }else{
		            	ObjectMapper obj = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
		 	    		result=msgInfoCustom.getTotal();
		 	    		//更新完成数
		 	    		hashmap.put("finishcount", msgInfoCustom.getTotal());
		 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
		 	    		if(tTaskInfoCustom.getFlowcount()==Integer.parseInt(msgInfoCustom.getTotal())){
		 	    			isfinishflow = true;
		 	    		}
		            }
		            map.put("msg", result);
		        } else {
		            map.put("msg", "失败错误码" + statusCode);
		            throw new RuntimeException();
		        }*/
		        if(isfinish && isfinishflow){
		        	//表示任务已完成
		        	//更新任务状态
		        	hashmap.clear();
					hashmap.put("taskid", tTaskInfoCustom.getTaskid());
					hashmap.put("taskstate", 17);
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "sys");
		        	taskInfoService.updateTaskstate(hashmap);
		        	//任务失败积分数返回
		        	TTaskDetailInfoFlowCustom TTaskDetailInfoFlowCustombefore = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
		        	int pointsflow = (tTaskInfoCustom.getFlowcount()-TTaskDetailInfoFlowCustombefore.getFinishcount())*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		        	int pointsflowagent = (tTaskInfoCustom.getFlowcount()-TTaskDetailInfoFlowCustombefore.getFinishcount())*Integer.parseInt(tPriceAgentInfoCustom.getPricecounts1());
		        	//加购失败
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
					tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
					tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
					userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
					//给用户添加积分明细记录
					TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
					tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
					tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
					tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
					tPointsInfoCustom.setUpdateuser("sys");
					tPointsInfoCustom.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflow + pointscollect + pointsshopping));
					tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
					tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
					tPointsInfoCustom.setPointstype("28");
					tPointsInfoCustom.setPointsupdate((pointsflow + pointscollect + pointsshopping));
					tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
					tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
					pointsInfoService.savePoints(tPointsInfoCustom);
					
					//给代理添加终止任务所返回的积分
					tUserInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints() + pointsflowagent + pointscollectagent + pointsshoppingagent);
					tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
					tUserInfoCustomagent.setUpdateuser(tUserInfoCustomagent.getUserid());
					userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
					//给代理添加积分明细记录
					TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
					tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
					tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
					tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
					tPointsInfoCustomagent.setUpdateuser("sys");
					tPointsInfoCustomagent.setPointreason("任务完成" + tTaskInfoCustom.getTaskpk() + ",失败任务返回积分"+(pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
					tPointsInfoCustomagent.setPoints(tUserInfoCustomagent.getPoints());
					tPointsInfoCustomagent.setPointstype("28");
					tPointsInfoCustomagent.setPointsupdate((pointsflowagent + pointscollectagent + pointsshoppingagent));
					tPointsInfoCustomagent.setTaskpk(tTaskInfoCustom.getTaskpk());
					tPointsInfoCustomagent.setUserid(tUserInfoCustomagent.getUserid());
					pointsInfoService.savePoints(tPointsInfoCustomagent);
		        }
			}
			logger.info("检查订单是否已完成结束!");
			map.put("msg", "检查订单是否已完成结束!");
		}else{
			logger.info("没有正在运行中的订单!");
			map.put("msg", "没有正在运行中的订单!");
		}
		return map;	
	}
}
