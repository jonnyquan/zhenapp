package com.zhenapp.controller.apitest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

import com.zhenapp.mapper.Custom.FirstWebInfoCustom;
import com.zhenapp.po.Custom.ApireturnCustom;
import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.util.StringUtilWxf;


@Controller
public class FirstWebController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	private static Logger logger = Logger.getLogger(FirstWebController.class);
	//private final String secrettest="bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K";//测试
	//private final String secret= "Ko;l47q6P`KZo:=xTc]39CJ`JPwGJ=fss8n:MaxR[YjPVN/2DI6`>5g3KdfMKpS9";//正式
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Value("${secret}")
	private String secret;
	/*
	 * 发布任务接口
	 */
	@RequestMapping(value="/api/tasks")
	public @ResponseBody ModelMap apitasks() throws Exception{
		ModelMap map = new ModelMap();
		String url="http://liuliangapp.com/api/tasks";
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findAllTaskBypage(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
			HttpClient httpClient = new HttpClient();
			String result="";
	        PostMethod postMethod = new PostMethod(url);
	        postMethod.addParameter("name", "任务");
	        //postMethod.addParameter("keywords", tTaskInfoCustom.getTaskkeyword());
	        postMethod.addParameter("keywords", "沙滩中裤男");
	        postMethod.addParameter("product_url", "https://detail.tmall.com/item.htm?id="+tTaskInfoCustom.getTaskkeynum());
	        //postMethod.addParameter("start_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskdate())));
	        //postMethod.addParameter("end_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskdate())));
	        postMethod.addParameter("start_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate())));
	        postMethod.addParameter("end_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskenddate())));
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
	            result = postMethod.getResponseBodyAsString();
	            if(result.indexOf("id")==-1){
	            	result = StringUtilWxf.translat(result);
	            }else{
	            	ObjectMapper obj = new ObjectMapper();
	 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
	 	    		result=msgInfoCustom.getId()+"";
	            }
	            map.put("msg", result);
	        }
	        else {
	            map.put("msg", "失败错误码" + statusCode);
	        }
		}
		return map;
	}
	/*
	 * 停留时长接口
	 * http://liuliangapp.com/api/tasks/durations
	 */
	@RequestMapping(value="/api/tasks/durations")
	public @ResponseBody ModelMap apitasksdurations() throws Exception{
		String url="http://liuliangapp.com/api/tasks/durations";
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(getMethod);
        if(statusCode == 200) {
            result = getMethod.getResponseBodyAsString();
            map.put("msg", result);
        }
        else {
            map.put("msg", "失败错误码" + statusCode);
        }
		return map;
	}
	/*
	 *三      积分计算接口
	 * http://liuliangapp.com/api/tasks/cost
	 */
	@RequestMapping(value="/api/tasks/cost")
	public @ResponseBody ModelMap apitaskscost() throws Exception{
		String url="http://liuliangapp.com/api/tasks/cost";
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findAllTaskBypage(hashmap);
		if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size()>0){
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
			HttpClient httpClient = new HttpClient();
			String result="";
	        PostMethod postMethod = new PostMethod(url);
	        postMethod.addParameter("name", "任务"+tTaskInfoCustom.getTaskpk());
	        //postMethod.addParameter("keywords", tTaskInfoCustom.getTaskkeyword());
	        postMethod.addParameter("keywords", "背心");
	        postMethod.addParameter("product_url", "https://detail.tmall.com/item.htm?id="+tTaskInfoCustom.getTaskkeynum());
	        //postMethod.addParameter("start_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskdate())));
	        //postMethod.addParameter("end_date", sdf.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskdate())));
	        postMethod.addParameter("start_date", "2016-05-17");
	        postMethod.addParameter("end_date", "2016-05-17");
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
	            result = postMethod.getResponseBodyAsString();
	            map.put("msg", result);
	        }
	        else {
	            map.put("msg", "失败错误码" + statusCode);
	        }
		}
		return map;
	}
	/*
	 * 四          结束任务接口
	 * http://liuliangapp.com/api/tasks/{id}/finish
	 */
	@RequestMapping(value="/api/tasks/{id}/finish")
	public @ResponseBody ModelMap apitasksfinish(@PathVariable(value="id") String id) throws Exception{
		String url="http://liuliangapp.com/api/tasks/"+id+"/finish";
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            map.put("msg", result);
        }
        else {
            map.put("msg", "失败错误码" + statusCode);
        }
		return map;
	}
	/*
	 * 五.	获取任务完成流量总数
	 * http://liuliangapp.com/api/tasks/{id}/total
	 * 参数：日期    格式:yyyy-MM-dd 例如2015-05-21
	 */
	@RequestMapping(value="/api/tasks/{id}/total")
	public @ResponseBody ModelMap apitaskstotal(@PathVariable(value="id") String id) throws Exception{
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        GetMethod getMethod = new GetMethod("http://liuliangapp.com/api/tasks/"+id+"/total");
        getMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(getMethod);
        if(statusCode == 200) {
            result = getMethod.getResponseBodyAsString();
            map.put("msg", result);
        }
        else {
            map.put("msg", "失败错误码" + statusCode);
        }
		return map;
	}
	/*
	 *六.	验证宝贝url
	 * http://liuliangapp.com/api/url/validate
	 */
	@RequestMapping(value="/api/url/validate")
	public @ResponseBody ModelMap apiurlvalidate(String param,String taskkeynum) throws Exception{
		String url="http://liuliangapp.com/api/url/validate";
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        //postMethod.setParameter("url", "https://item.taobao.com/item.htm?id=531027639098");
        //https://detail.tmall.com/item.htm?id=531027639098
        postMethod.setParameter("url", param);
        postMethod.setParameter("cache", "true");
        postMethod.setRequestHeader("secret", secret);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            ObjectMapper obj = new ObjectMapper();
    		FirstWebInfoCustom firstWebInfoCustom = obj.readValue(result, FirstWebInfoCustom.class);
    		if(firstWebInfoCustom.isSuccess()){
    			map.put("status", "y");
    			map.put("info", "验证成功");
    			logger.info("验证成功");
    			TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
    			//做过该宝贝id的收藏任务数
    			HashMap<String, Object> hashmap = new HashMap<String, Object>();
    			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
    			hashmap.put("taskkeynum", taskkeynum);
    			hashmap.put("iscollection", "1");
    			//hashmap.put("taskstate", "20,21");
    			int collectiontaskcount = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
    			hashmap.clear();
    			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
    			hashmap.put("taskkeynum", taskkeynum);
    			hashmap.put("isshopping", "1");
    			//hashmap.put("taskstate", "20,21");
    			int shoppingtaskcount = taskDetailInfoService.findTaskDetailByIdAndtask(hashmap);
    			map.put("count", tSysconfInfoCustom.getSysconfvalue1());
    			map.put("collectiontaskcount", Integer.parseInt(tSysconfInfoCustom.getSysconfvalue1()) - collectiontaskcount);
    			map.put("shoppingtaskcount", Integer.parseInt(tSysconfInfoCustom.getSysconfvalue1()) - shoppingtaskcount);
    		}else{
    			map.put("status", "n");
				map.put("info", "验证失败");
				logger.error("验证失败");
    		}
        }
        else {
            logger.error("调用失败" + statusCode);
            map.put("status", "n");
			map.put("info", "验证失败");
        }
		return map;
	}
	/*
	 *七.	验证关键词
	 * http://liuliangapp.com/api/keywords/validate
	 */
	@RequestMapping(value="/api/keywords/validate/{keywords}/{product_id}")
	public @ResponseBody ModelMap apikeywordsvalidate(@PathVariable(value="keywords")String keywords,@PathVariable(value="product_id")String product_id) throws Exception{
		String url="http://liuliangapp.com/api/keywords/validate";
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("secret", secret);
        //postMethod.setParameter("keywords",URLEncoder.encode(keywords.trim(), "UTF-8") );
        postMethod.setParameter("keywords",keywords.trim().replace(" ", "　") );
        postMethod.setParameter("product_id", product_id);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            ObjectMapper obj = new ObjectMapper();
    		ApireturnCustom apireturnCustom = obj.readValue(result, ApireturnCustom.class);
    		if(apireturnCustom.getSuccess().equals("false")){
    			map.put("msg", "0");
    		}else{
    			map.put("msg", "1");
    		}
        }
        else {
            logger.error("调用失败,失败错误码:" + statusCode);
            map.put("msg", "0");
        }
		return map;
	}
	/*
	 *八.	查询账号积分
	 * http://liuliangapp.com/api/points
	 */
	@RequestMapping(value="/api/points")
	public @ResponseBody ModelMap apipoints() throws Exception{
		String url="http://liuliangapp.com/api/points";
		ModelMap map = new ModelMap();
		HttpClient httpClient = new HttpClient();
		String result="";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(getMethod);
        if(statusCode == 200) {
            result = getMethod.getResponseBodyAsString();
            map.put("msg", result);
        }
        else {
            map.put("msg", "失败错误码" + statusCode);
        }
		return map;
	}
	
	//================================================================================
}
