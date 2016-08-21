package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;
@Transactional
@Controller
@RequestMapping(value="/task")
public class SaveTaskController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hh = new SimpleDateFormat("HH");
	SimpleDateFormat mm = new SimpleDateFormat("mm");
	private static Logger logger = Logger.getLogger(SaveTaskController.class);
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	
	/*
	 * 发布任务 新增订单信息
	 */
	@RequestMapping(value="/saveTaskInfo")
	public @ResponseBody ModelMap saveTaskInfo(String mode,HttpSession session, TTaskInfoCustom tTaskInfoCustom,String taskkeywords) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom = (TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());
		TUserInfoCustom TUserInfoCustomagent = userInfoService.findUserByuserid(tAgentInfoCustom.getAgentuserid());
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		TPriceAgentInfoCustom tPriceAgentInfoCustomagent = priceAgentInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());
		//计算需要消耗的积分数
		int days = DateUtilWxf.getBetweenDays(tTaskInfoCustom.getTaskstartdate().replace("-", ""), tTaskInfoCustom.getTaskenddate().replace("-", ""));
		String [] taskkeywordarr=taskkeywords.split("====");
		int subtractpoints = 0;
		int subtractpointsagent = 0;
		if(tTaskInfoCustom.getTasktype().equals("33")){
			subtractpoints = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts1())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
			subtractpointsagent = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts1())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts2())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts3());
		}else{
			subtractpoints = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts4())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceInfoCustom.getPricecounts5())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts6());
			subtractpointsagent = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts4())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts5())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts6());			
		}
		subtractpoints = subtractpoints * taskkeywordarr.length * (days + 1);
		subtractpointsagent = subtractpointsagent * taskkeywordarr.length * (days + 1);
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		//判断用户积分是否大于需要消耗的积分
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
			return map;
		}
		//判断用户所属代理积分是否大于需要消耗的积分数
		String pointsagent = userInfoService.findpointsByUsernickAndPwd(TUserInfoCustomagent);
		if(Integer.parseInt(pointsagent) < subtractpointsagent){
			map.put("data", "agentlow");
			return map;
		}
		
		//查询系统配置项中是否禁止发布任务
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		
		HashMap<String, Object> hashmaping=new HashMap<String, Object>();
		hashmaping.put("taskstate", "15");
		hashmaping.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
		hashmaping.put("taskdate", yyyyMMdd.format(new Date()));
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskallocation(hashmaping);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			map.put("data", "allocationing");
			return map;
		}
		if(tTaskInfoCustom.getFlowcount() <0 || tTaskInfoCustom.getShoppingcount() <0 ||  tTaskInfoCustom.getCollectioncount()<0){
			map.put("data", "count0");
			return map;
		}
		
		int flowtemp=0;
		for (int j = 0; j < hourarr.length; j++) {
			flowtemp = flowtemp + Integer.parseInt(hourarr[j]);
		}
		if(flowtemp - tTaskInfoCustom.getFlowcount()!=0){
			map.put("data", "flowerror");
			return map;
		}
		
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		
		tTaskInfoCustom.setTasktitle(tTaskInfoCustom.getTasktitle());//宝贝标题
		tTaskInfoCustom.setTaskurl(tTaskInfoCustom.getTaskurl());//宝贝url
		tTaskInfoCustom.setDeepclick(tTaskInfoCustom.getDeepclick());//深入点击率%
		tTaskInfoCustom.setTaskwirelesstitle(tTaskInfoCustom.getTaskwirelesstitle());//无线端标题
		tTaskInfoCustom.setShipaddress(tTaskInfoCustom.getShipaddress());//地区
		tTaskInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());//宝贝id
		tTaskInfoCustom.setTaskreleasekeyword(taskkeywords);//多个标题以====分割
		tTaskInfoCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());//时间轴
		tTaskInfoCustom.setTaskprice(tTaskInfoCustom.getTaskprice());//宝贝价格
		tTaskInfoCustom.setTaskminprice(tTaskInfoCustom.getTaskminprice());//最小价格
		tTaskInfoCustom.setTaskmaxprice(tTaskInfoCustom.getTaskmaxprice());//最大价格
		tTaskInfoCustom.setTaskimgztc(tTaskInfoCustom.getTaskimgztc());//直通车图片地址
		tTaskInfoCustom.setCreativetitle(tTaskInfoCustom.getCreativetitle());//创意标题
		tTaskInfoCustom.setTasksearchtype(tTaskInfoCustom.getTasksearchtype());//搜索类型
		tTaskInfoCustom.setFlowcount(tTaskInfoCustom.getFlowcount());//流量数
		tTaskInfoCustom.setCollectioncount(tTaskInfoCustom.getCollectioncount());//收藏数
		tTaskInfoCustom.setShoppingcount(tTaskInfoCustom.getShoppingcount());//加购数
		//tTaskInfoCustom.setStorecollectioncount(tTaskInfoCustom.getStorecollectioncount());
		//tTaskInfoCustom.setFakechatcount(tTaskInfoCustom.getFakechatcount());
		//tTaskInfoCustom.setFakechatstr1(tTaskInfoCustom.getFakechatstr1());
		//tTaskInfoCustom.setFakechatstr2(tTaskInfoCustom.getFakechatstr2());
		//tTaskInfoCustom.setFakechatstr3(tTaskInfoCustom.getFakechatstr3());
		//tTaskInfoCustom.setFakechatstr4(tTaskInfoCustom.getFakechatstr4());
		tTaskInfoCustom.setSubtractpoints(subtractpoints);//消耗的积分数
		tTaskInfoCustom.setTaskstate("15");//待分配状态
		tTaskInfoCustom.setCreatetime(sdf.format(new Date()));
		tTaskInfoCustom.setUpdatetime(sdf.format(new Date()));
		tTaskInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tTaskInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		//添加积分明细记录
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setPointstype("27");
		int newpoints =Integer.parseInt(points);
		int newpointsagent = Integer.parseInt(pointsagent);
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if(tTaskInfoCustom.getTasktype().equals("34")){
			if(mode.equals("0")){
				if(tTaskInfoCustom.getCreativetitle()==null || tTaskInfoCustom.getCreativetitle().length()<9){
					map.put("data", "118");
					return map;
				}
				if(tTaskInfoCustom.getCreativetitle().indexOf("http")!=-1){
					map.put("data", "118");
					return map;
				}
			}else{
				if(tTaskInfoCustom.getTaskimgztc().indexOf("/T")==-1){
					map.put("data", "直通车地址不符合规范!");
					return map;
				}
			}
			hashmap.clear();
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
			hashmap.put("taskstatenot", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "1");
			hashmap.put("isshopping", "1");
			int shoppingerror = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
			int scmax=Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2())-shoppingerror;
			int gwcmax=Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2())-shoppingerror;
			if(tTaskInfoCustom.getCollectioncount()*taskkeywordarr.length - scmax > 0){
				map.put("data", "scmaxerror");
				return map;
			}
			if(tTaskInfoCustom.getShoppingcount()*taskkeywordarr.length - gwcmax > 0){
				map.put("data", "gwcmaxerror");
				return map;
			}
			if(tTaskInfoCustom.getShoppingcount() - tTaskInfoCustom.getCollectioncount() !=0){
				map.put("data", "gwcnotsc");
				return map;
			}
		}
		
		Date date = yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		for (int day = 0; day <= days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				if(tTaskInfoCustom.getTasktype().equals("34")){
					hashmap.clear();
					hashmap.put("taskdate", yyyyMMdd.format(new Date()));
					hashmap.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
					hashmap.put("taskkeyword", taskkeywordarr[ii]);
					hashmap.put("taskstatenot", "22,23");
					hashmap.put("tasktype", "34");
					int llerror = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
					int llmax = Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2()) - llerror;
					
					if(tTaskInfoCustom.getFlowcount().intValue() - llmax > 0){
						map.put("data", "llmaxerror");
						return map;
					}
				}
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskstartdate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskenddate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				//保存用户的积分变动
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()-(subtractpoints/(taskkeywordarr.length*(days + 1))));
				tPointsInfoCustom.setPointsupdate(subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpoints = newpoints-(subtractpoints/(taskkeywordarr.length*(days + 1)));
				//保存代理的积分变动
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(TUserInfoCustomagent.getPoints()-(subtractpointsagent/(taskkeywordarr.length*(days + 1))));
				tPointsInfoCustom.setPointsupdate(subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(TUserInfoCustomagent.getUserid());
				tPointsInfoCustom.setCreateuser(TUserInfoCustomagent.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpointsagent = newpointsagent-(subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				
				//扣除用户消耗的积分
				tUserInfoCustom.setPoints(newpoints);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				//扣除代理消耗的积分
				TUserInfoCustomagent.setPoints(newpointsagent);
				TUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
				userInfoService.updateUserinfoPointByUserid(TUserInfoCustomagent);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		logger.info("发布任务成功!");
		map.put("data", "insertsuccess");
		return map;
	}
	
}
