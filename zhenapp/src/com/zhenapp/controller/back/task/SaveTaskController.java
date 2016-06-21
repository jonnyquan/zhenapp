package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
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
	private TaskDetailInfoTempService taskDetailInfoTempService;
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
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	
	@Value("${secret}")
	private String secret;
	@Value("${middleRows}")
	private Integer middleRows;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 发布任务 新增订单信息
	 */
	@RequestMapping(value="/saveTaskInfo")
	public @ResponseBody ModelMap saveTaskInfo(HttpSession session, TTaskInfoCustom tTaskInfoCustom,String taskkeywords,String llmax,String gwcmax,String scmax) throws Exception{
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
		
		if(tTaskInfoCustom.getTasktype().equals("34")){
			if(tTaskInfoCustom.getFlowcount() > Integer.parseInt(llmax)){
				map.put("data", "llmaxerror");
				return map;
			}
			if(tTaskInfoCustom.getCollectioncount() > Integer.parseInt(scmax)){
				map.put("data", "scmaxerror");
				return map;
			}
			if(tTaskInfoCustom.getShoppingcount() > Integer.parseInt(gwcmax)){
				map.put("data", "gwcmaxerror");
				return map;
			}
			if(tTaskInfoCustom.getShoppingcount() - tTaskInfoCustom.getCollectioncount() !=0){
				map.put("data", "gwcnotsc");
				return map;
			}
			
			
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
		
		Date date = yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		for (int day = 0; day <= days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
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
				/*
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
				tTaskDetailInfoFlowCustom.setDeepclick(tTaskInfoCustom.getDeepclick());
				tTaskDetailInfoFlowCustom.setFinishcount(0);
				tTaskDetailInfoFlowCustom.setErrorcount(0);
				tTaskDetailInfoFlowCustom.setSubtractpoints(tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
				tTaskDetailInfoFlowCustom.setTaskdate(yyyyMMdd.format(date));
				tTaskDetailInfoFlowCustom.setCreatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setCreateuser("sys");
				tTaskDetailInfoFlowCustom.setUpdatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setUpdateuser("sys");
				taskDetailInfoFlowService.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
				HashMap<String, Object> hashmaptest = new HashMap<String, Object>();
				hashmaptest.put("usertestnick", tUserInfoCustom.getUsernick());
				hashmaptest.put("page", 0);
				hashmaptest.put("rows", middleRows);
				List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmaptest);
				if(tUsertestInfoCustomlist == null || tUsertestInfoCustomlist.size()<1){
					//调用接口发送任务
					HttpClient httpClient = new HttpClient();
					String result="";
				    PostMethod postMethod = new PostMethod("http://liuliangapp.com/api/tasks");
				    postMethod.addParameter("name", tTaskDetailInfoFlowCustom.getTaskkeyword());
				    postMethod.addParameter("keywords", tTaskDetailInfoFlowCustom.getTaskkeyword());
				    postMethod.addParameter("product_url", "https://item.taobao.com/item.htm?id="+tTaskInfoCustom.getTaskkeynum());
				    postMethod.addParameter("start_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate())));
				    postMethod.addParameter("end_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskenddate())));
				    postMethod.addParameter("hour_counts", "["+tTaskInfoCustom.getTaskhourcounts()+"]");
				    postMethod.addParameter("duration", "2");
				    postMethod.addParameter("plus", "true");
				    postMethod.addParameter("gprs_pct", "40");
				    postMethod.addParameter("tmall_app_pct", "20");
				    postMethod.addParameter("deep_click_pct", tTaskDetailInfoFlowCustom.getDeepclick()==null?"0":tTaskDetailInfoFlowCustom.getDeepclick());
				    postMethod.setRequestHeader("secret", secret);
				    postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
				    int statusCode =  httpClient.executeMethod(postMethod);
				    if(statusCode == 200) {
				        result = postMethod.getResponseBodyAsString();
				        if(result.indexOf("id")==-1){
			            	result = StringUtilWxf.translat(result);
			            	logger.info("调用发布任务接口失败，错误信息:" + result);
			            	map.put("msg", "调用发布任务接口失败，错误信息:" + result);
			            	throw new RuntimeException();
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
				        throw new RuntimeException();
				    }
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
						TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
						if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
							//1.如果系统配置为均匀发布则按照小时分钟来平分
							for (int i = 0; i < collectionminute.length; i++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("1");
								tTaskDetailInfoCustom.setIsshopping("0");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(collectionminute[i]);
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[i] <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
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
								tTaskDetailInfoCustom.setIscollection("0");
								tTaskDetailInfoCustom.setIsshopping("1");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setTaskstate("40");
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(shoppingminute[j2]);
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
						}else{
							//2.如果系统设置为快速发布则按照小时分配   分钟数全部为0
							for (int i = 0; i < collectionminute.length; i++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("1");
								tTaskDetailInfoCustom.setIsshopping("0");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(0);
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && 0<= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
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
								tTaskDetailInfoCustom.setIscollection("0");
								tTaskDetailInfoCustom.setIsshopping("1");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && 0 <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(0);
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
						}
					}
				}
				HashMap<String,Object> hashmap3=new HashMap<String,Object>();
				hashmap3.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap3.put("taskstate", "16");//任务运行中
				hashmap3.put("updatetime", sdf.format(new Date()));
				hashmap3.put("updateuser", "拆分任务");
				taskInfoService.updateTaskstate(hashmap3);*/
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		logger.info("发布任务成功!");
		map.put("data", "insertsuccess");
		return map;
	}
	
}
