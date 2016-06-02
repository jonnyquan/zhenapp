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

import com.zhenapp.controller.apitest.platform;
import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.OrderInfoCustom;
import com.zhenapp.po.Custom.OrderReturnInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.DateInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;
import com.zhenapp.util.MD5Util;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Controller
public class SubmitOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(platform.class);
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
	
	@Value("${secret}")
	private String secret;
	/*
	 * 递交订单方式 表单提交
	 * 
	 */
	@RequestMapping(value="/api/platform/flow/save")
	public @ResponseBody ModelMap flowsave(String partnerId,String data,String validation) throws Exception{
		ModelMap map=new ModelMap();
		List<OrderReturnInfoCustom> orderReturnInfoCustomlist = new ArrayList<OrderReturnInfoCustom>();
		List<TUserInfoCustom> tUserinfoCustomlist=userInfoService.findUserBynick(partnerId);
		if(tUserinfoCustomlist.size()<0){
			map.put("code", "0");
			map.put("desc", "用户不存在");
			return map;
		}
		TUserInfoCustom tUserInfoCustom=tUserinfoCustomlist.get(0);
		String validationtest=MD5Util.string2MD5(tUserInfoCustom.getUsernick()+tUserInfoCustom.getUserpwd()+tUserInfoCustom.getUsernick());
		if(!validation.equals(validationtest)){
			map.put("code", "0");
			map.put("desc", "用户信息校验失败");
			return map;
		}
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("code", "0");
			map.put("desc", "系统暂时禁止发布任务");
			return map;
		}
		ObjectMapper obj = new ObjectMapper();
		OrderInfoCustom orderInfoCustom = obj.readValue(data, OrderInfoCustom.class);
		orderInfoCustom.setKwd(StringUtilWxf.trimFirstAndLastChar(orderInfoCustom.getKwd(), "===="));
		String [] taskkeywordarr=orderInfoCustom.getKwd().split("====");
		Date date = yyyyMMdd.parse(orderInfoCustom.getTaskstartdate().replace("-", ""));
		int days = DateUtilWxf.getBetweenDays(orderInfoCustom.getTaskstartdate().replace("-", ""), orderInfoCustom.getTaskenddate().replace("-", ""));
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		int subtractpoints = orderInfoCustom.getTotalTask()*Integer.parseInt(tPriceInfoCustom.getPricecounts1())+orderInfoCustom.getTotalCollectProduct()*Integer.parseInt(tPriceInfoCustom.getPricecounts2())+orderInfoCustom.getTotalShoppingCart()*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		subtractpoints = subtractpoints* taskkeywordarr.length * (days + 1);
		String [] hourarr = orderInfoCustom.getTimecontrol().split(",");
		//判断用户积分是否大于需要消耗的积分
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
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
		tTaskInfoCustom.setTasktype(orderInfoCustom.getKtype());
		tTaskInfoCustom.setTaskkeynum(orderInfoCustom.getNid());
		tTaskInfoCustom.setTaskreleasekeyword(orderInfoCustom.getKwd());
		tTaskInfoCustom.setTaskstartdate(orderInfoCustom.getTaskstartdate().replace("-", ""));
		tTaskInfoCustom.setTaskenddate(orderInfoCustom.getTaskenddate().replace("-", ""));
		tTaskInfoCustom.setTaskhourcounts(orderInfoCustom.getTimecontrol());
		tTaskInfoCustom.setTaskminprice(orderInfoCustom.getMinPrice());
		tTaskInfoCustom.setTaskmaxprice(orderInfoCustom.getMaxPrice());
		tTaskInfoCustom.setTasksearchtype(orderInfoCustom.getSearchType());
		tTaskInfoCustom.setFlowcount(orderInfoCustom.getTotalTask());
		tTaskInfoCustom.setCollectioncount(orderInfoCustom.getTotalCollectProduct());
		tTaskInfoCustom.setShoppingcount(orderInfoCustom.getTotalShoppingCart());
		tTaskInfoCustom.setTaskstate("15");
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
		for (int day = 0; day <= days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskstate("15");//待分配状态
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				//保存之后获取该任务的主键值
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()-(subtractpoints/(taskkeywordarr.length*(days + 1))));
				tPointsInfoCustom.setPointsupdate(subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpoints = newpoints-(subtractpoints/(taskkeywordarr.length*(days + 1)));
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
		            	//调用接口发布失败，需要删除保存的订单  积分明细信息
		            	throw new RuntimeException();
		            }else{
		            	ObjectMapper objmapper = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = objmapper.readValue(result, MsgInfoCustom.class);
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
								SimpleDateFormat hh = new SimpleDateFormat("HH");
								SimpleDateFormat mm = new SimpleDateFormat("mm");
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
								SimpleDateFormat hh = new SimpleDateFormat("HH");
								SimpleDateFormat mm = new SimpleDateFormat("mm");
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
								SimpleDateFormat hh = new SimpleDateFormat("HH");
								SimpleDateFormat mm = new SimpleDateFormat("mm");
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[j2] <= Integer.parseInt(mm.format(new Date()))){
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
				taskInfoService.updateTaskstate(hashmap3);
				OrderReturnInfoCustom orderReturnInfoCustom = new OrderReturnInfoCustom();
				orderReturnInfoCustom.setCode(200);
				orderReturnInfoCustom.setFid(tTaskInfoCustom.getTaskid());
				orderReturnInfoCustom.setDesc("下单成功");
				orderReturnInfoCustomlist.add(orderReturnInfoCustom);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		map.put("orderReturnInfoCustomlist", orderReturnInfoCustomlist);
		return map;
	}
}
