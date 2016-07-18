package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.mapper.Custom.FirstWebInfoCustom;
import com.zhenapp.po.Custom.OrderInfoCustom;
import com.zhenapp.po.Custom.OrderReturnInfoCustom;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.DateUtilWxf;
import com.zhenapp.util.MD5Util;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Controller
public class SubmitOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(SubmitOrder.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Value("${liuliangapp}")
	private String liuliangapp;
	@Value("${secret}")
	private String secret;
	/*
	 * 递交订单方式 表单提交
	 */
	@RequestMapping(value="/api/platform/flow/save")
	public @ResponseBody ModelMap flowsave(String partnerId,String data,String validation) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> hashmapuser = new HashMap<String, Object>();
		hashmapuser.put("usernick", partnerId);
		hashmapuser.put("userstate", "29");
		hashmapuser.put("userroleid", "2");
		List<OrderReturnInfoCustom> orderReturnInfoCustomlist = new ArrayList<OrderReturnInfoCustom>();
		List<TUserInfoCustom> tUserinfoCustomlist=userInfoService.findUserBynick(hashmapuser);
		if(tUserinfoCustomlist.size()<0){
			map.put("code", "0");
			map.put("desc", "用户不存在");
			return map;
		}
		TUserInfoCustom tUserInfoCustom=tUserinfoCustomlist.get(0);
		String validationtest = MD5Util.string2MD5(tUserInfoCustom.getUsernick()+tUserInfoCustom.getUserpwd()+tUserInfoCustom.getUsernick());
		if(!validation.equals(validationtest)){
			map.put("code", "0");
			map.put("desc", "用户信息校验失败");
			return map;
		}
		ObjectMapper obj = new ObjectMapper();
		OrderInfoCustom orderInfoCustom = obj.readValue(data, OrderInfoCustom.class);
		if(orderInfoCustom.getTaskstartdate()==null){
			orderInfoCustom.setTaskstartdate(yyyyMMdd.format(new Date()));
			orderInfoCustom.setTaskenddate(yyyyMMdd.format(new Date()));
		}else{
			orderInfoCustom.setTaskstartdate(orderInfoCustom.getTaskstartdate().replace("-", ""));
			orderInfoCustom.setTaskenddate(orderInfoCustom.getTaskenddate().replace("-", ""));
		}
		
		if(orderInfoCustom.getKtype().equals("FLOW")){
			orderInfoCustom.setKtype("33");
		}else if(orderInfoCustom.getKtype().equals("ZTCFLOW")){
			orderInfoCustom.setKtype("34");
		}
		if(orderInfoCustom.getTaskurl()==null || orderInfoCustom.getTaskurl().equals("")){
			orderInfoCustom.setTaskurl("https://item.taobao.com/item.htm?id="+orderInfoCustom.getNid());
		}
		
		orderInfoCustom.setKwd(StringUtilWxf.trimFirstAndLastChar(orderInfoCustom.getKwd(), "===="));
		String [] taskkeywordarr = orderInfoCustom.getKwd().split("====");
		Date date = yyyyMMdd.parse(orderInfoCustom.getTaskstartdate().replace("-", ""));
		int days = DateUtilWxf.getBetweenDays(orderInfoCustom.getTaskstartdate().replace("-", ""), orderInfoCustom.getTaskenddate().replace("-", ""));
		
		int subtractpointsagent = 0;
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		TPriceAgentInfoCustom tPriceAgentInfoCustomagent = priceAgentInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());
		if(orderInfoCustom.getKtype().equals("33")){
			subtractpointsagent = orderInfoCustom.getTotalTask()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts1()) + orderInfoCustom.getTotalCollectProduct()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts2()) + orderInfoCustom.getTotalShoppingCart()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts3());
		}else{
			subtractpointsagent = orderInfoCustom.getTotalTask()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts4()) + orderInfoCustom.getTotalCollectProduct()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts5()) + orderInfoCustom.getTotalShoppingCart()*Integer.parseInt(tPriceAgentInfoCustomagent.getPricecounts6());			
		}
		subtractpointsagent = subtractpointsagent * taskkeywordarr.length * (days + 1);
		
		//判断用户积分是否大于需要消耗的积分
		String pointsagent = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(pointsagent) < subtractpointsagent){
			map.put("data", "110");
			return map;
		}
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("code", "0");
			map.put("desc", "系统暂时禁止发布任务");
			return map;
		}
		
		HashMap<String, Object> hashmaping=new HashMap<String, Object>();
		hashmaping.put("taskstate", "15");
		hashmaping.put("taskkeynum", orderInfoCustom.getNid());
		hashmaping.put("taskdate", yyyyMMdd.format(new Date()));
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskallocation(hashmaping);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			map.put("data", "123");
			return map;
		}
		if(orderInfoCustom.getTotalTask() <0 || orderInfoCustom.getTotalShoppingCart() <0 ||  orderInfoCustom.getTotalCollectProduct()<0){
			map.put("data", "count0");
			return map;
		}
		if(orderInfoCustom.getKtype().equals("33")){
			HashMap<String, Object> hashmaptest = new HashMap<String, Object>();
			hashmaptest.put("usertestnick", tUserInfoCustom.getUsernick());
			hashmaptest.put("page", 0);
			hashmaptest.put("rows", 10);
			List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmaptest);
			if(tUsertestInfoCustomlist != null && tUsertestInfoCustomlist.size()>0){
				
			}else{
				if(orderInfoCustom.getTotalTask()<orderInfoCustom.getTotalCollectProduct() 
						|| orderInfoCustom.getTotalTask()<orderInfoCustom.getTotalShoppingCart()){
					map.put("data", "124");
					return map;
				}
			}
		}else{
			if(orderInfoCustom.getTotalTask()<orderInfoCustom.getTotalCollectProduct() 
					|| orderInfoCustom.getTotalTask()<orderInfoCustom.getTotalShoppingCart()){
				map.put("data", "124");
				return map;
			}
		}
		
		String [] hourarr = orderInfoCustom.getTimecontrol().split(",");
		int flowtemp=0;
		for (int j = 0; j < hourarr.length; j++) {
			flowtemp = flowtemp + Integer.parseInt(hourarr[j]);
		}
		if(flowtemp - orderInfoCustom.getTotalTask()!=0){
			map.put("data", "flowerror");
			return map;
		}
		if(hourarr.length!=24){
			map.put("data", "100");
			return map;
		}
		//验证url
		HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(liuliangapp+"/api/url/validate");
        postMethod.setParameter("url", orderInfoCustom.getTaskurl());
        postMethod.setParameter("cache", "true");
        postMethod.setRequestHeader("secret", secret);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
        	String result = postMethod.getResponseBodyAsString();
        	ObjectMapper objmapper = new ObjectMapper();
    		FirstWebInfoCustom firstWebInfoCustom = objmapper.readValue(result, FirstWebInfoCustom.class);
    		if(firstWebInfoCustom.isSuccess()){
    			
    		}else{
    			map.put("data", "101");
    			return map;
    		}
        }else {
        	map.put("data", "102");
			return map;
		}
        try{
        	yyyyMMdd.parse(orderInfoCustom.getTaskstartdate());
        	yyyyMMdd.parse(orderInfoCustom.getTaskenddate());
        }catch(Exception e){
        	map.put("data", "108");
			return map;
        }
        if(orderInfoCustom.getKwd()!=null && orderInfoCustom.getKwd().length()>0){
        	
        }else{
        	map.put("data", "109");
			return map;
        }
        
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		TTaskInfoCustom tTaskInfoCustom=new TTaskInfoCustom();
		tTaskInfoCustom.setTasktitle(orderInfoCustom.getTasktitle());//宝贝标题
		tTaskInfoCustom.setTaskurl(orderInfoCustom.getTaskurl());//宝贝url
		tTaskInfoCustom.setDeepclick(orderInfoCustom.getDeepclick());//深入点击率%
		tTaskInfoCustom.setTaskwirelesstitle(null);//无线端标题
		tTaskInfoCustom.setShipaddress(orderInfoCustom.getShipaddress());//地区
		tTaskInfoCustom.setTasktype(orderInfoCustom.getKtype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(orderInfoCustom.getNid());//宝贝id
		tTaskInfoCustom.setTaskreleasekeyword(orderInfoCustom.getKwd());//多个标题以====分割
		tTaskInfoCustom.setTaskhourcounts(orderInfoCustom.getTimecontrol());//时间轴
		tTaskInfoCustom.setTaskprice(orderInfoCustom.getTaskprice());//宝贝价格
		tTaskInfoCustom.setTaskminprice(orderInfoCustom.getMinPrice());//最小价格
		tTaskInfoCustom.setTaskmaxprice(orderInfoCustom.getMaxPrice());//最大价格
		tTaskInfoCustom.setTaskimgztc(orderInfoCustom.getImage());//直通车图片地址
		tTaskInfoCustom.setCreativetitle(orderInfoCustom.getCreativetitle());//创意标题
		tTaskInfoCustom.setTasksearchtype(orderInfoCustom.getSearchType());//搜索类型
		tTaskInfoCustom.setFlowcount(orderInfoCustom.getTotalTask());//流量数
		tTaskInfoCustom.setCollectioncount(orderInfoCustom.getTotalCollectProduct());//收藏数
		tTaskInfoCustom.setShoppingcount(orderInfoCustom.getTotalShoppingCart());//加购数
		//tTaskInfoCustom.setStorecollectioncount(tTaskInfoCustom.getStorecollectioncount());
		//tTaskInfoCustom.setFakechatcount(tTaskInfoCustom.getFakechatcount());
		//tTaskInfoCustom.setFakechatstr1(tTaskInfoCustom.getFakechatstr1());
		//tTaskInfoCustom.setFakechatstr2(tTaskInfoCustom.getFakechatstr2());
		//tTaskInfoCustom.setFakechatstr3(tTaskInfoCustom.getFakechatstr3());
		//tTaskInfoCustom.setFakechatstr4(tTaskInfoCustom.getFakechatstr4());
		tTaskInfoCustom.setSubtractpoints(subtractpointsagent);//消耗的积分数
		tTaskInfoCustom.setTaskstate("15");//待分配状态
		tTaskInfoCustom.setCreatetime(sdf.format(new Date()));
		tTaskInfoCustom.setUpdatetime(sdf.format(new Date()));
		tTaskInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tTaskInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		
		//添加积分明细记录
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setPointstype("27");
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if(orderInfoCustom.getKtype().equals("34")){
			if(orderInfoCustom.getCreativetitle()==null){
				map.put("data", "118");
				return map;
			}
			if(!orderInfoCustom.getCreativetitle().equals("") && orderInfoCustom.getCreativetitle().length() < 9){
				map.put("data", "118");
				return map;
			}
			if(orderInfoCustom.getCreativetitle().indexOf("http")!=-1){
				map.put("data", "118");
				return map;
			}
			if(tTaskInfoCustom.getTaskimgztc()!=null && tTaskInfoCustom.getTaskimgztc().indexOf("/T")==-1){
				map.put("data", "直通车地址不符合规范!");
				return map;
			}
			
			int gwcmax = 0;
			int scmax = 0;
			hashmap.clear();
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("taskkeynum", orderInfoCustom.getNid());
			hashmap.put("taskstatenot", "22,23");
			hashmap.put("tasktype", "34");
			hashmap.put("iscollection", "1");
			hashmap.put("isshopping", "1");
			int shoppingerror = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
			scmax=Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2())-shoppingerror;
			gwcmax=Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2())-shoppingerror;
			
			if(orderInfoCustom.getTotalCollectProduct() - scmax > 0){
				map.put("data", "110");
				return map;
			}
			if(orderInfoCustom.getTotalShoppingCart() - gwcmax > 0){
				map.put("data", "111");
				return map;
			}
			if(orderInfoCustom.getTotalShoppingCart() - orderInfoCustom.getTotalCollectProduct() !=0){
				map.put("data", "122");
				return map;
			}
		}
		int newpointsagent = Integer.parseInt(pointsagent);
		for (int day = 0; day <= days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				if(orderInfoCustom.getKtype().equals("34")){
					int llmax = 0;
					hashmap.clear();
					hashmap.put("taskdate", yyyyMMdd.format(new Date()));
					hashmap.put("taskkeynum", orderInfoCustom.getNid());
					hashmap.put("taskkeyword", taskkeywordarr[ii]);
					hashmap.put("taskstatenot", "22,23");
					hashmap.put("tasktype", "34");
					//做过该宝贝id的直通车任务数
					int llerror = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
					llmax = Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2()) - llerror;
					if(orderInfoCustom.getTotalTask() - llmax > 0){
						map.put("data", "119");
						return map;
					}
				}
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskstartdate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskenddate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskstate("15");//待分配状态
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				//保存代理的积分变动
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()-(subtractpointsagent/(taskkeywordarr.length*(days + 1))));
				tPointsInfoCustom.setPointsupdate(subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpointsagent = newpointsagent-(subtractpointsagent/(taskkeywordarr.length*(days + 1)));
				//扣除消耗的积分
				tUserInfoCustom.setPoints(newpointsagent);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser("代理调用接口发布任务消耗积分");
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				OrderReturnInfoCustom orderReturnInfoCustom = new OrderReturnInfoCustom();
				orderReturnInfoCustom.setCode(200);
				orderReturnInfoCustom.setFid(tTaskInfoCustom.getTaskid());
				orderReturnInfoCustom.setDesc("下单成功");
				orderReturnInfoCustomlist.add(orderReturnInfoCustom);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		map.put("orderReturnInfoCustomlist", orderReturnInfoCustomlist);
		logger.info("调用接口发布任务成功");
		return map;
	}
}
