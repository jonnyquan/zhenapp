package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;
@Controller
public class EndOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(EndOrder.class);
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
	private TaskDetailInfoTempService taskDetailInfoTempService;
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
					hashmap.put("newstate", 40);
					hashmap.put("oldstate", 23);
					taskDetailInfoTempService.updatestate(hashmap);
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
			            logger.info("终止订单成功!");
			        }else {
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
}
