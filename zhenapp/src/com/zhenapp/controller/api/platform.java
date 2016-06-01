package com.zhenapp.controller.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.OrderInfoCustom;
import com.zhenapp.po.Custom.OrderReturnInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
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

@Controller
public class platform {
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
	 * API接口中 获取余额  restful风格
	 */
	@RequestMapping(value="/api/platform/searchBalance/{partnerId}/{password}")
	public @ResponseBody ModelMap searchBalance(@PathVariable(value="partnerId") String partnerId,@PathVariable(value="password") String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=new TUserInfoCustom();
		tUserInfoCustom.setUsernick(partnerId);
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(password));
		String points=userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("code", "200");
		map.put("desc", points==null?"0":points);
		return map;
	}
	/*
	 * API接口中 获取余额  表单提交方式
	 */
	@RequestMapping(value="/api/platform/searchBalance")
	public @ResponseBody ModelMap searchBalance_2(String partnerId,String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=new TUserInfoCustom();
		tUserInfoCustom.setUsernick(partnerId);
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(password));
		String points=userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("code", "200");
		map.put("desc", points);
		return map;
	}
	
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
		Date date = sdf.parse(orderInfoCustom.getTaskstartdate().replace("-", ""));
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
				tTaskInfoCustom.setTaskdate(sdf.format(date));
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
		            	
		            	return map;
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
	
	/*
	 * 查询订单  partnerId 用户名		password 密码 	 fid 订单号
	 */
	@RequestMapping(value="/api/platform/search/flow")
	public @ResponseBody ModelMap searchflow(String partnerId,String password,String fid) throws Exception{
		ModelMap map=new ModelMap();
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(partnerId);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()==1){
			if(tUserInfoCustomlist.get(0).getUserpwd().equals(MD5Util.string2MD5(password))){
				HashMap<String, Object> hashmap=new HashMap<String,Object>();
				hashmap.put("taskid", fid);
				hashmap.put("userid", tUserInfoCustomlist.get(0).getUserid());
				List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(hashmap);
				if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size() == 1){
					TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
					map.put("code", 200);
					map.put("msg", "success");
					map.put("fid", tTaskInfoCustom.getTaskid());
					map.put("hascollectamount", tTaskInfoCustom.getFinishcollectioncount());
					map.put("hasamount", tTaskInfoCustom.getFinishflowcount());
					map.put("hastrolleyamount", tTaskInfoCustom.getShoppingcount());
					map.put("status", tTaskInfoCustom.getDicinfoname());
					map.put("description", "");
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
		}
		return map;
	}
	
	/*
	 * 终止订单
	 */
	@RequestMapping(value="/api/platform/shutdown")
	public @ResponseBody ModelMap shutdown(String partnerId,String password,String fid) throws Exception{
		ModelMap map = new ModelMap();
		//首先确保该用户能终止该订单
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(partnerId);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()==1){
			TUserInfoCustom tUserInfoCustom = tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				HashMap<String, Object> hashmap=new HashMap<String,Object>();
				hashmap.put("taskid", fid);
				hashmap.put("userid", tUserInfoCustomlist.get(0).getUserid());
				List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(hashmap);
				if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size() == 1){
					TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
					if(!tTaskInfoCustom.getTaskstate().equals("16")){
						map.put("code", "0");
						map.put("msg", "只有运行中的任务可以进行终止操作");
						return map;
					}
					hashmap.put("taskstate", 18);
					taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
					taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
					taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
					TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
					//并调用接口终止发布到第一个手机网站的任务
					String url="http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
					HttpClient httpClient = new HttpClient();
					String result="";
			        PostMethod postMethod = new PostMethod(url);
			        postMethod.setRequestHeader("secret", secret);
			        int statusCode =  httpClient.executeMethod(postMethod);
			        if(statusCode == 200) {
			            System.out.println("调用成功");
			            result = postMethod.getResponseBodyAsString();
			            map.put("msg", result);
			        }
			        else {
			            System.out.println("调用失败" + statusCode);
			            map.put("msg", "失败错误码" + statusCode);
			        }
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
		}
		return map;
	}
	/*
	 * 每一分钟执行一次 查询任务状态为终止中的任务,检查是否所有详情任务都已返回，如果都已处理修改为已终止，结束任务，返回积分
	 */
	@RequestMapping("/api/platform/updateTaskstateByTiming")
	public @ResponseBody ModelMap updateTaskstateByTiming() throws Exception{
		ModelMap map = new ModelMap();
		//查询任务状态为终止中的任务
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "18");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			//查询该任务 执行中的详情任务条数
			hashmap.put("taskstate", "20");
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			int tempcount = taskDetailInfoService.findTaskDetailInfoByIdAndTaskstate(hashmap);
			if(tempcount==0){
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", 19);
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "sys");
				taskInfoService.updateTaskstate(hashmap);
				//hashmap.put("taskstate", "23");
				//taskDetailInfoService.deleteTaskBystate(hashmap);
				
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				int points = taskDetailInfoService.findPointsByteterminationstate(tTaskInfoCustom.getTaskid());
				
				//收藏，加购失败需要返回的积分
	        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "22");
				int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
				int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
				int pointserror=pointscollect+pointsshopping;
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
				TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
				HttpClient httpClient = new HttpClient();
				String result="";
		        GetMethod getMethod = new GetMethod("http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
		        getMethod.setRequestHeader("secret", secret);
		        int statusCode =  httpClient.executeMethod(getMethod);
		        if(statusCode == 200) {
		            System.out.println("调用成功");
		            result = getMethod.getResponseBodyAsString();
		            if(result.indexOf("total")==-1){
		            	result = StringUtilWxf.translat(result);
		            }else{
		            	ObjectMapper obj = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
		 	    		result=msgInfoCustom.getTotal()+"";
		 	    		//更新完成数
		 	    		hashmap.put("finishcount", msgInfoCustom.getTotal());
		 	    		taskDetailInfoFlowService.updatefinishcount(hashmap);
		 	    		if(maxcount < Integer.parseInt(msgInfoCustom.getTotal())){
		 	    			maxcount = Integer.parseInt(msgInfoCustom.getTotal());
		 	    		}
		 	    		flowpoints =(tTaskInfoCustom.getFlowcount() - maxcount) * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		            }
		            map.put("msg", result);
		        }
		        else {
		            System.out.println("调用失败" + statusCode);
		            map.put("msg", "失败错误码" + statusCode);
		        }
		        
				//添加终止任务所返回的积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + points + flowpoints + pointserror);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				//添加积分明细记录
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("sys");
				tPointsInfoCustom.setPointreason("终止任务" + tTaskInfoCustom.getTaskpk() + "返回积分"+(points+flowpoints+pointserror));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
				tPointsInfoCustom.setPointstype("28");
				tPointsInfoCustom.setPointsupdate((points+flowpoints+pointserror));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
			}
		}
		map.put("data", "success");
		return map;
	}
	
	/*
	 * 每隔1分钟执行一次     将任务为已终止的订单   详情任务状态为执行终止	的详情任务删除
	 */
	@RequestMapping(value="/api/platform/deleteTaskstate")
	public @ResponseBody ModelMap deleteTaskstate() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskstate", "19");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				hashmap.put("taskstate", "23");
				hashmap.put("taskid", tTaskInfoCustomlist.get(i).getTaskid());
				taskDetailInfoService.deleteTaskBystate(hashmap);
				logger.info("删除订单号为:"+ tTaskInfoCustomlist.get(i).getTaskpk()+"的所有已终止订单!");
			}
		}
		return map;
	}
	
	/*
	 * 每10分钟执行一次判断是否有任务执行完成        修改任务状态,积分处理
	 */
	@RequestMapping(value="/api/platform/cyclecheckTask")
	public @ResponseBody ModelMap cyclecheckTask() throws Exception{
		ModelMap map = new ModelMap();
		//首先判断收藏和加购是否完成
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "16");
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoByTaskstate(hashmap);
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			boolean isfinish = false;
			boolean isfinishflow = false;
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("taskstate", "21,22,23");
			int counts = taskDetailInfoService.findCounts(hashmap);
			int checkcount=tTaskInfoCustom.getCollectioncount()+tTaskInfoCustom.getShoppingcount();
			if(counts==checkcount){
				//收藏和加购任务已经执行完成
				isfinish=true;
			}
			TTaskDetailInfoFlowCustom TTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
			//调用接口判断流量任务是否完成
			HttpClient httpClient = new HttpClient();
			String result="";
	        GetMethod getMethod = new GetMethod("http://liuliangapp.com/api/tasks/"+TTaskDetailInfoFlowCustom.getTaskdetailid()+"/total");
	        getMethod.setRequestHeader("secret", secret);
	        int statusCode =  httpClient.executeMethod(getMethod);
	        if(statusCode == 200) {
	            System.out.println("调用成功");
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
	            System.out.println("调用失败" + statusCode);
	            map.put("msg", "失败错误码" + statusCode);
	        }
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
	        	int pointsflow= (tTaskInfoCustom.getFlowcount()-TTaskDetailInfoFlowCustombefore.getFinishcount())*Integer.parseInt(tPriceInfoCustom.getPricecounts1());
	        	//加购失败
	        	hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap.put("taskstate", "22");
				int collectcount = taskDetailInfoService.findcollectioncount(hashmap);
				int shoppingcount = taskDetailInfoService.findshoppingcount(hashmap);
				int pointscollect = collectcount*Integer.parseInt(tPriceInfoCustom.getPricecounts2());
				int pointsshopping = shoppingcount*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
				//添加终止任务所返回的积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + pointsflow + pointscollect + pointsshopping);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				//添加积分明细记录
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
	        }
		}
		return map;	
	}
		
	/*
	 * 查询今天之前的任务      每天0点1分执行
	 */
	@RequestMapping(value="/api/platform/updateTaskstateByTime")
	public @ResponseBody ModelMap updateTaskstateByTime() throws Exception{
		ModelMap map = new ModelMap();
		//还在执行中的任务   变成已完成	状态为待分配（15） 和运行中（16）的任务
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("taskstate", "15,16");
		List<TTaskInfoCustom> tTaskInfoCustomlistfinish = taskInfoService.findTaskInfoByTaskstate(hashmap);
		hashmap.put("newstate", "21");
		hashmap.put("oldstate", "20,40");
		hashmap.put("taskstate", "17");
		for (int i = 0; i < tTaskInfoCustomlistfinish.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
			//将每个任务分配好的详情任务给设置成已完成
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "系统凌晨0点1分执行");
			taskDetailInfoService.updateTaskDetailstateByTaskidAndoldstate(hashmap);//将所有带获取和执行中的详细任务设置为已完成
			taskInfoService.updateTaskstate(hashmap);//将该任务设置为已完成
		}
		//终止中的任务变成已终止      并且给用户返还积分		状态为终止中（18）的任务
		hashmap.put("taskstate", "18");
		List<TTaskInfoCustom> tTaskInfoCustomlistend = taskInfoService.findTaskInfoByTaskstate(hashmap);
		hashmap.put("newstate", "23");
		hashmap.put("oldstate", "20");
		hashmap.put("taskstate", "18");
		for (int i = 0; i < tTaskInfoCustomlistend.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlistfinish.get(i);
			//将状态为终止中的任务中 	详情任务状态为执行中	修改为已终止状态	并返还积分
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "系统凌晨0点1分执行");
			taskDetailInfoService.updateTaskDetailstateByTaskidAndoldstate(hashmap);
			taskInfoService.updateTaskstate(hashmap);//将该任务设置为已终止
			int points = taskDetailInfoService.findPointsByteterminationstate(tTaskInfoCustom.getTaskid());
			List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(tTaskInfoCustom.getCreateuser());
			if(tUserInfoCustomlist != null && tUserInfoCustomlist.size()==1){
				TUserInfoCustom tUserInfoCustom = tUserInfoCustomlist.get(0);
				//插入账户明细
				TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
				tPointsInfoCustom.setCreateuser("系统过凌晨处理");
				tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
				tPointsInfoCustom.setUpdateuser("sys");
				tPointsInfoCustom.setPointreason("终止任务" + tTaskInfoCustom.getTaskpk() + "返回积分："+points);
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()+points);
				tPointsInfoCustom.setPointstype("28");
				tPointsInfoCustom.setPointsupdate(points);
				tPointsInfoCustom.setTaskpk(0);
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				//修改用户积分
				tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()+points);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser("系统过凌晨处理修改用户积分");
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				map.put("state", "处理成功");
			}else{
				map.put("state", "处理失败,创建任务人用户名不存在或者不唯一");
			}
		}
		return map;
	}
	
	/*
	 * 通过接口调用		确认充值
	 */
	@RequestMapping(value="/api/platform/updateRechargestate/{verificationcode}")
	public @ResponseBody ModelMap updateRechargestate(@PathVariable(value="verificationcode")String verificationcode) throws Exception{
		ModelMap map = new ModelMap();
		//修改充值记录状态为已确认
		int i= rechargeInfoService.updateRechargestate(verificationcode);
		if(i>0){
			TRechargeInfoCustom tRechargeInfoCustom=rechargeInfoService.findRechargeBycode(verificationcode);
			//插入账户明细
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tRechargeInfoCustom.getCreateuser());
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser("接口确认充值");
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("接口确认充值");
			tPointsInfoCustom.setPointreason("确认充值,到账"+tRechargeInfoCustom.getRechargepoints()+"赠送"+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointstype("26");
			tPointsInfoCustom.setPointsupdate(tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setTaskpk(0);
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			int ii1 = pointsInfoService.savePoints(tPointsInfoCustom);
			//修改用户当前积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser("接口确认充值");
			int ii2 = userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			System.out.println(ii1+"============"+ii2);
		}
		map.put("data", "success");
		return map;
	}
	
	/*
	 * 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	 */
	@RequestMapping(value="/api/platform/endTaskstate")
	public @ResponseBody ModelMap endTaskstate() throws Exception{
		ModelMap map = new ModelMap();
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("counts", tSysconfInfoCustom.getSysconfname4());
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskerrorcounts(hashmap);
		if(tTaskInfoCustomlist != null){
			for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
				TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
				hashmap.clear();
				hashmap.put("taskid", tTaskInfoCustom.getTaskid());
				TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(tTaskInfoCustom.getTaskid());
				if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
					map.put("data", "stateerror");
					return map;
				}
				hashmap.put("taskstate", 18);
				taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
				taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
				taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
				TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
				//并调用接口终止发布到第一个手机网站的任务
				String url="http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
				HttpClient httpClient = new HttpClient();
				String result="";
		        PostMethod postMethod = new PostMethod(url);
		        postMethod.setRequestHeader("secret", secret);
		        int statusCode =  httpClient.executeMethod(postMethod);
		        if(statusCode == 200) {
		            System.out.println("调用成功");
		            result = postMethod.getResponseBodyAsString();
		            map.put("msg", result);
		        }
		        else {
		            System.out.println("调用失败" + statusCode);
		            map.put("msg", "失败错误码" + statusCode);
		        }
			}
		}
		return map;
	}
	
}
