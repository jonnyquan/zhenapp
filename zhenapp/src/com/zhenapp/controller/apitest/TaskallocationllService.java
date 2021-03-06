package com.zhenapp.controller.apitest;
import java.text.SimpleDateFormat;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Service
public class TaskallocationllService {
	private static Logger logger = Logger.getLogger(TaskallocationllService.class);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hh = new SimpleDateFormat("HH");
	SimpleDateFormat mm = new SimpleDateFormat("mm");
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	
	@Value("${secret}")
	private String secret;
	@Value("${middleRows}")
	private Integer middleRows;
	@Value("${liuliangapp}")
	private String liuliangapp;
	
	/*
	 * 任务分配
	 */
	public @ResponseBody ModelMap allocationService(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
			int []arrll = new int[hourcount];
			int llcount=0;
			for (int i = 0; i < hourarr.length; i++) {
				if(!hourarr[i].equals("0")){
					arrll[llcount]=Integer.parseInt(hourarr[i]);
					llcount++;
				}
			}
			int collectioncounttemp = 0;
			int []collectionarr = new int[hourcount];
			for (int i = 0; i < hourcount; i++) {
				collectionarr[i] = arrll[i]*tTaskInfoCustom.getCollectioncount()/tTaskInfoCustom.getFlowcount();
				collectioncounttemp =collectioncounttemp+collectionarr[i];
			}
			int collectioncountys = tTaskInfoCustom.getCollectioncount() - collectioncounttemp;
			for (int i = 0; i < collectioncountys; i++) {
				collectionarr[i] = collectionarr[i] + 1;
			}
			
			int shoppingcounttemp = 0;
			int []shoppingarr = new int[hourcount];
			for (int i = 0; i < hourcount; i++) {
				shoppingarr[i] = arrll[i]*tTaskInfoCustom.getShoppingcount()/tTaskInfoCustom.getFlowcount();
				shoppingcounttemp = shoppingcounttemp + shoppingarr[i];
			}
			int shoppingcountys = tTaskInfoCustom.getShoppingcount() - shoppingcounttemp;
			for (int i = 0; i < shoppingcountys; i++) {
				shoppingarr[i] = shoppingarr[i] + 1;
			}
			//1.分配收藏和加购
			int count=0;
			for (int j = 0; j < hourarr.length; j++) {
				if(!hourarr[j].equals("0")){
					int collectionhoursum = collectionarr[count];//每小时分配的收藏数
					int shoppinghoursum = shoppingarr[count];//每小时分配的加购数
					//int storecollectionhoursum = storecollectionarr[count];//每小时分配的店铺收藏数
					//int fakechathoursum = fakechatarr[count];//每小时分配的假聊数
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
						tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskprice());
						tTaskDetailInfoCustom.setIscollection("1");
						tTaskDetailInfoCustom.setIsshopping("0");
						tTaskDetailInfoCustom.setIsstorecollection("0");
						tTaskDetailInfoCustom.setIsfakechat("0");
						tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
						tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
						tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
						tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskdate());
						tTaskDetailInfoCustom.setTaskhour(j);
						if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
							tTaskDetailInfoCustom.setTaskminute(collectionminute[i]);
							if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
								&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[i] <= Integer.parseInt(mm.format(new Date()))){
								tTaskDetailInfoCustom.setTaskstate("23");
							}else{
								tTaskDetailInfoCustom.setTaskstate("40");
							}
						}else{
							tTaskDetailInfoCustom.setTaskminute(0);
							if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
								&& j<= Integer.parseInt(hh.format(new Date())) && 0<= Integer.parseInt(mm.format(new Date()))){
								tTaskDetailInfoCustom.setTaskstate("23");
							}else{
								tTaskDetailInfoCustom.setTaskstate("40");
							}
						}
						tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
						tTaskDetailInfoCustom.setCreateuser(tTaskInfoCustom.getCreateuser());
						tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
						tTaskDetailInfoCustom.setUpdateuser(tTaskInfoCustom.getCreateuser());
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
						tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskprice());
						tTaskDetailInfoCustom.setIscollection("0");
						tTaskDetailInfoCustom.setIsshopping("1");
						tTaskDetailInfoCustom.setIsstorecollection("0");
						tTaskDetailInfoCustom.setIsfakechat("0");
						tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
						tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
						tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
						tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskdate());
						tTaskDetailInfoCustom.setTaskhour(j);
						if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
							tTaskDetailInfoCustom.setTaskminute(shoppingminute[j2]);
							if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && shoppingminute[j2] <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
						}else{
							tTaskDetailInfoCustom.setTaskminute(0);
							if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
								&& j<= Integer.parseInt(hh.format(new Date())) && 0 <= Integer.parseInt(mm.format(new Date()))){
								tTaskDetailInfoCustom.setTaskstate("23");
							}else{
								tTaskDetailInfoCustom.setTaskstate("40");
							}
						}
						tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
						tTaskDetailInfoCustom.setCreateuser(tTaskInfoCustom.getCreateuser());
						tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
						tTaskDetailInfoCustom.setUpdateuser(tTaskInfoCustom.getCreateuser());
						taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
					}
				}
			}
			//2.将流量任务单独提取出来调用接口发布，并保存返回的订单号
			TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom=new TTaskDetailInfoFlowCustom();
			tTaskDetailInfoFlowCustom.setTaskid(tTaskInfoCustom.getTaskid());
			tTaskDetailInfoFlowCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
			tTaskDetailInfoFlowCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());
			tTaskDetailInfoFlowCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
			tTaskDetailInfoFlowCustom.setPrice(tTaskInfoCustom.getTaskprice());
			tTaskDetailInfoFlowCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
			tTaskDetailInfoFlowCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
			tTaskDetailInfoFlowCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
			tTaskDetailInfoFlowCustom.setTasktype(tTaskInfoCustom.getTasktype());
			tTaskDetailInfoFlowCustom.setTaskstate("40");
			tTaskDetailInfoFlowCustom.setDeepclick(tTaskInfoCustom.getDeepclick());
			tTaskDetailInfoFlowCustom.setFinishcount(0);
			tTaskDetailInfoFlowCustom.setErrorcount(0);
			tTaskDetailInfoFlowCustom.setSubtractpoints(tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
			tTaskDetailInfoFlowCustom.setTaskdate(tTaskInfoCustom.getTaskdate());
			tTaskDetailInfoFlowCustom.setCreatetime(sdf.format(new Date()));
			tTaskDetailInfoFlowCustom.setCreateuser(tTaskInfoCustom.getCreateuser());
			tTaskDetailInfoFlowCustom.setUpdatetime(sdf.format(new Date()));
			tTaskDetailInfoFlowCustom.setUpdateuser(tTaskInfoCustom.getCreateuser());
			
			HashMap<String, Object> hashmaptest = new HashMap<String, Object>();
			hashmaptest.put("usertestnick", tUserInfoCustom.getUsernick());
			hashmaptest.put("page", 0);
			hashmaptest.put("rows", middleRows);
			List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmaptest);
			//调用接口发送任务
			HttpClient httpClient = new HttpClient();
			String result="";
		    PostMethod postMethod = new PostMethod(liuliangapp + "/api/tasks");
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
			if(tUsertestInfoCustomlist != null && tUsertestInfoCustomlist.size()>0){
				if(tUsertestInfoCustomlist.get(0).getUserroleid().equals("2")
						&& tTaskInfoCustom.getFlowcount() !=0){
				    if(statusCode == 200) {
				        result = postMethod.getResponseBodyAsString();
				        if(result.indexOf("id")==-1){
				        	String tempcode=result;
			            	result = StringUtilWxf.translat(result);
			            	logger.info("调用发布任务"+ tTaskInfoCustom.getTaskpk() +"接口失败，错误信息:" + result);
			            	map.put("msg", "调用发布任务接口失败，错误信息:" + result);
			            	//如果是因为深入点击比例错误，则修改任务信息中深入点击比例为0
			            	if(tempcode.equals("116")){
			            		HashMap<String, Object> hashmap = new HashMap<String, Object>();
			            		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			            		taskInfoService.updatedeepclick(hashmap);
			            	}
			            	throw new RuntimeException();
			            }else{
			            	ObjectMapper obj = new ObjectMapper();
			 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
			 	    		result = msgInfoCustom.getId() + "";
			 	    		logger.info("调用发布任务接口成功!");
			 	    		tTaskDetailInfoFlowCustom.setTaskdetailid(msgInfoCustom.getId()+"");
			 	    		taskDetailInfoFlowService.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
			            }
				    }else {
				        map.put("msg", "调用接口失败,失败错误码" + statusCode);
				        throw new RuntimeException();
				    }
				}
			}else{
			    if(statusCode == 200) {
			        result = postMethod.getResponseBodyAsString();
			        if(result.indexOf("id")==-1){
			        	String tempcode=result;
		            	result = StringUtilWxf.translat(result);
		            	logger.info("调用发布任务"+ tTaskInfoCustom.getTaskpk() +"接口失败，错误信息:" + result);
		            	map.put("msg", "调用发布任务接口失败，错误信息:" + result);
		            	//如果是因为深入点击比例错误，则修改任务信息中深入点击比例为0
		            	if(tempcode.equals("116")){
		            		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		            		hashmap.put("taskid", tTaskInfoCustom.getTaskid());
		            		taskInfoService.updatedeepclick(hashmap);
		            	}
		            	throw new RuntimeException();
		            }else{
		            	ObjectMapper obj = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
		 	    		result = msgInfoCustom.getId() + "";
		 	    		logger.info("调用发布任务接口成功!");
		 	    		tTaskDetailInfoFlowCustom.setTaskdetailid(msgInfoCustom.getId()+"");
		 	    		taskDetailInfoFlowService.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
		            }
			    }else {
			        map.put("msg", "调用接口失败,失败错误码" + statusCode);
			        throw new RuntimeException();
			    }
			}
		HashMap<String,Object> hashmap3=new HashMap<String,Object>();
		hashmap3.put("taskid", tTaskInfoCustom.getTaskid());
		hashmap3.put("taskstate", "16");//任务运行中
		hashmap3.put("updatetime", sdf.format(new Date()));
		hashmap3.put("updateuser", "拆分任务");
		hashmap3.put("oldfinshtaskstate", "15");
		int i= taskInfoService.updateTaskstate(hashmap3);
		if(i<1){
			logger.error("任务："+tTaskInfoCustom.getTaskpk()+"已经拆分过了");
			throw new RuntimeException();
		}
		return map;
	}
}
