package com.zhenapp.service.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;

import com.zhenapp.controller.back.TaskInfoController;
import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;
import com.zhenapp.util.StringUtilWxf;

public class TaskInfoDao {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd=new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(TaskInfoController.class);
	
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
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
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	
	@Value("${secret}")
	private String secret;
	
	public ModelMap insertTaskInfo(HttpSession session,TTaskInfoCustom tTaskInfoCustom,String taskkeywords)throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		//取当前小时
		//long curren = System.currentTimeMillis();
		//curren += 60 * 60 * 1000;
		//Date da = new Date(curren);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		//int hours = Integer.parseInt(dateFormat.format(da));
		//计算需要消耗的积分数
		int days = DateUtilWxf.getBetweenDays(tTaskInfoCustom.getTaskstartdate().replace("-", ""), tTaskInfoCustom.getTaskenddate().replace("-", ""));
		String [] taskkeywordarr=taskkeywords.split("====");
		int subtractpoints = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts1())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		subtractpoints = subtractpoints* taskkeywordarr.length * (days + 1);
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		/*
		 * 判断用户积分是否大于需要消耗的积分
		 */
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
			return map;
		}
		/*
		 * 查询系统配置项中是否禁止发布任务
		 */
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		tTaskInfoCustom.setTasktitle(tTaskInfoCustom.getTasktitle());
		tTaskInfoCustom.setTaskwirelesstitle(tTaskInfoCustom.getTaskwirelesstitle());
		tTaskInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
		tTaskInfoCustom.setTaskreleasekeyword(taskkeywords);
		tTaskInfoCustom.setTaskstartdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		tTaskInfoCustom.setTaskenddate(tTaskInfoCustom.getTaskenddate().replace("-", ""));
		tTaskInfoCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());
		tTaskInfoCustom.setTaskminprice(tTaskInfoCustom.getTaskminprice());
		tTaskInfoCustom.setTaskmaxprice(tTaskInfoCustom.getTaskmaxprice());
		tTaskInfoCustom.setTasksearchtype(tTaskInfoCustom.getTasksearchtype());
		tTaskInfoCustom.setFlowcount(tTaskInfoCustom.getFlowcount());
		tTaskInfoCustom.setCollectioncount(tTaskInfoCustom.getCollectioncount());
		tTaskInfoCustom.setShoppingcount(tTaskInfoCustom.getShoppingcount());
		tTaskInfoCustom.setSubtractpoints(subtractpoints);
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
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointstype("27");
		int newpoints =Integer.parseInt(points);
		//获取系统设置中总的手机数目
		//TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		//int phonecount = Integer.parseInt(tSysconfInfoCustom.getSysconfvalue1());
		Date date = sdf.parse(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		for (int day = 0; day < days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				//保存之后获取该任务的主键值
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpoints/(taskkeywordarr.length));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()-(subtractpoints/(taskkeywordarr.length)));
				tPointsInfoCustom.setPointsupdate(subtractpoints/(taskkeywordarr.length));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpoints = newpoints-(subtractpoints/(taskkeywordarr.length));
				//扣除消耗的积分
				tUserInfoCustom.setPoints(newpoints);
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				
				int collectionys = tTaskInfoCustom.getCollectioncount() / hourcount;
				int collectionfps = tTaskInfoCustom.getCollectioncount() % hourcount;
				int []collectionarr = new int[hourcount];
				for (int i = 0; i < collectionarr.length; i++) {
					collectionarr[i]=collectionys;
				}
				for (int i = 0; i < collectionfps; i++) {
					collectionarr[i]=collectionarr[i]+1;
				}
				int shoppingys = tTaskInfoCustom.getShoppingcount() / hourcount;
				int shoppingfps = tTaskInfoCustom.getShoppingcount() % hourcount;
				int []shoppingarr = new int[hourcount];
				for (int i = 0; i < shoppingarr.length; i++) {
					shoppingarr[i]=shoppingys;
				}
				for (int i = 0; i < shoppingfps; i++) {
					shoppingarr[i]=shoppingarr[i]+1;
				}
				//任务拆分
				//1.先将流量任务单独提取出来调用接口发布，并保存返回的订单号
				TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom=new TTaskDetailInfoFlowCustom();
				tTaskDetailInfoFlowCustom.setTaskid(tTaskInfoCustom.getTaskid());
				tTaskDetailInfoFlowCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
				tTaskDetailInfoFlowCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());
				tTaskDetailInfoFlowCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
				tTaskDetailInfoFlowCustom.setPrice(tTaskInfoCustom.getTaskminprice());
				tTaskDetailInfoFlowCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
				tTaskDetailInfoFlowCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
				tTaskDetailInfoFlowCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
				tTaskDetailInfoFlowCustom.setTasktype(tTaskInfoCustom.getTasktype());
				tTaskDetailInfoFlowCustom.setTaskstate("40");
				tTaskDetailInfoFlowCustom.setFinishcount(0);
				tTaskDetailInfoFlowCustom.setErrorcount(0);
				tTaskDetailInfoFlowCustom.setSubtractpoints(tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
				tTaskDetailInfoFlowCustom.setTaskdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
				tTaskDetailInfoFlowCustom.setCreatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setCreateuser("sys");
				tTaskDetailInfoFlowCustom.setUpdatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setUpdateuser("sys");
				taskDetailInfoFlowService.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
				//调用接口发送任务
				HttpClient httpClient = new HttpClient();
				String result="";
			    PostMethod postMethod = new PostMethod("http://liuliangapp.com/api/tasks");
			    postMethod.addParameter("name", "任务"+tTaskInfoCustom.getTaskpk());
			    postMethod.addParameter("keywords", tTaskDetailInfoFlowCustom.getTaskkeyword());
			    postMethod.addParameter("product_url", "https://item.taobao.com/item.htm?id="+tTaskInfoCustom.getTaskkeynum());
			    postMethod.addParameter("start_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate())));
			    postMethod.addParameter("end_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskenddate())));
			    postMethod.addParameter("hour_counts", "["+tTaskInfoCustom.getTaskhourcounts()+"]");
			    postMethod.addParameter("duration", "1");
			    postMethod.addParameter("plus", "true");
			    postMethod.addParameter("gprs_pct", "30");
			    postMethod.addParameter("tmall_app_pct", "100");
			    postMethod.addParameter("deep_click_pct", "0");
			    postMethod.setRequestHeader("secret", secret);
			    postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			    int statusCode =  httpClient.executeMethod(postMethod);
			    if(statusCode == 200) {
			        System.out.println("调用成功");
			        result = postMethod.getResponseBodyAsString();
			        if(result.indexOf("id")==-1){
		            	result = StringUtilWxf.translat(result);
		            	logger.info("调用发布任务接口失败，错误信息:" + result);
		            	map.put("msg", "调用发布任务接口失败，错误信息:" + result);
		            	return map;
		            }else{
		            	ObjectMapper obj = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
		 	    		result = msgInfoCustom.getId() + "";
		 	    		logger.info("调用发布任务接口成功!");
		 	    		//将调用接口返回的订单号设置到流量任务记录中
		 	    		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		 	    		hashmap.put("taskdetailid", msgInfoCustom.getId());
		 	    		hashmap.put("taskdetailpk", tTaskDetailInfoFlowCustom.getTaskdetailpk());
		 	    		hashmap.put("taskid", tTaskDetailInfoFlowCustom.getTaskid());
		 	    		int i = taskDetailInfoFlowService.updateTaskdetailIdByPk(hashmap);
		 	    		if(i>0){
		 	    			logger.info("更新返回的订单号成功!");
		 	    		}
		            }
			    }else {
			        map.put("msg", "失败错误码" + statusCode);
			        return map;
			    }
				
				//2.再分配收藏和加购
				int count=0;
				for (int j = 0; j < hourarr.length; j++) {
					if(!hourarr[j].equals("0")){
						int collectionhoursum = collectionarr[count];//每小时分配的收藏数
						int shoppinghoursum = shoppingarr[count];//每小时分配的加购数
						count=count+1;
						int [] collectionminute = new int[collectionhoursum];
						for(int a=0;a<collectionhoursum ; a++){
							collectionminute[a]=a*60/collectionhoursum;
						}
						int [] shoppingminute = new int[shoppinghoursum];
						for(int a=0;a<shoppinghoursum ; a++){
							shoppingminute[a]=a*60/shoppinghoursum;
						}
						//先分配收藏任务
						for (int i = 0; i < collectionminute.length; i++) {
							TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
							tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
							tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
							tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
							tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
							tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
							tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
							tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
							//tTaskDetailInfoCustom.setIsflow("1");
							tTaskDetailInfoCustom.setIscollection("1");
							tTaskDetailInfoCustom.setIsshopping("0");
							tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
							tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
							tTaskDetailInfoCustom.setTaskstate("40");
							tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
							tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
							tTaskDetailInfoCustom.setTaskhour(j);
							tTaskDetailInfoCustom.setTaskminute(collectionminute[i]);
							tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setCreateuser("sys");
							tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setUpdateuser("sys");
							taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
						}
						//分配购物车任务
						for (int j2 = 0; j2 < shoppingminute.length; j2++) {
							TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
							tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
							tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
							tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
							tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
							tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
							tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
							tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
							//tTaskDetailInfoCustom.setIsflow("1");
							tTaskDetailInfoCustom.setIscollection("0");
							tTaskDetailInfoCustom.setIsshopping("1");
							tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
							tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
							tTaskDetailInfoCustom.setTaskstate("40");
							tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
							tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
							tTaskDetailInfoCustom.setTaskhour(j);
							tTaskDetailInfoCustom.setTaskminute(shoppingminute[j2]);
							tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setCreateuser("sys");
							tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setUpdateuser("sys");
							taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
						}
					}
				}
				HashMap<String,Object> hashmap3=new HashMap<String,Object>();
				hashmap3.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap3.put("taskstate", "16");//任务运行中
				hashmap3.put("updatetime", sdf.format(new Date()));
				hashmap3.put("updateuser", "拆分任务");
				taskInfoService.updateTaskstate(hashmap3);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		return map;
	}
}
