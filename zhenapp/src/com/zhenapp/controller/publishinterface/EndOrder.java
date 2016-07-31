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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
import com.zhenapp.util.MD5Util;
@Transactional
@Controller
public class EndOrder {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(EndOrder.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Value("${secret}")
	private String secret;
	@Value("${liuliangapp}")
	private String liuliangapp;
	/*
	 * 终止订单
	 */
	@RequestMapping(value="/api/platform/shutdown")
	public @ResponseBody ModelMap shutdown(String partnerId,String password,String fid) throws Exception{
		ModelMap map = new ModelMap();
		//首先确保该用户能终止该订单
		HashMap<String, Object> hashmapuser = new HashMap<String, Object>();
		hashmapuser.put("usernick", partnerId);
		hashmapuser.put("userstate", "29");
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(hashmapuser);
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
					hashmap.put("oldfinshtaskstate", "16");
					int endcounts = taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
					if(endcounts>0){
						taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
						taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
						hashmap.put("newstate", 40);
						hashmap.put("oldstate", 23);
						taskDetailInfoTempService.updatestate(hashmap);
					}else{
						map.put("data", "stateerror");
						logger.error("终止订单失败,无法修改为已终止"+hashmap.toString());
						return map;
					}
					
					if(tTaskInfoCustom.getTasktype().equals("33")){
						TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
						hashmap.clear();
						hashmap.put("page", 0);
						hashmap.put("rows", 10);
						hashmap.put("usertestid", tTaskDetailInfoFlowCustom.getCreateuser());
						List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(hashmap);
						if(tUsertestInfoCustomlist!=null && tUsertestInfoCustomlist.size()>0){
							if(tUsertestInfoCustomlist.get(0).getUserroleid().equals("2")
									&& tTaskInfoCustom.getFlowcount() !=0){
								//并调用接口终止发布到第一个手机网站的任务
								String url=liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
								HttpClient httpClient = new HttpClient();
								String result="";
						        PostMethod postMethod = new PostMethod(url);
						        postMethod.setRequestHeader("secret", secret);
						        int statusCode =  httpClient.executeMethod(postMethod);
						        if(statusCode == 200) {
						            result = postMethod.getResponseBodyAsString();
						            map.put("msg", result);
						            if(result.indexOf("delay")!=-1){
						            	logger.info("终止流量任务成功");
						        		map.put("data", "success");
						        		return map;
						            }else{
						            	logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败代码："+result);
						                throw new RuntimeException();
						            }
						        }else {
						            map.put("msg", "失败错误码" + statusCode);
						            logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败错误码："+result);
						            throw new RuntimeException();
						        }
							}else{
								logger.info("终止任务成功");
					    		map.put("data", "success");
					    		return map;
							}
						}else{
							//并调用接口终止发布到第一个手机网站的任务
							String url=liuliangapp + "/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
							HttpClient httpClient = new HttpClient();
							String result="";
					        PostMethod postMethod = new PostMethod(url);
					        postMethod.setRequestHeader("secret", secret);
					        int statusCode =  httpClient.executeMethod(postMethod);
					        if(statusCode == 200) {
					            result = postMethod.getResponseBodyAsString();
					            map.put("msg", result);
					            if(result.indexOf("delay")!=-1){
					            	logger.info("终止流量任务成功");
					        		map.put("data", "success");
					        		return map;
					            }else{
					            	logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败代码："+result);
					                throw new RuntimeException();
					            }
					        }else {
					            map.put("msg", "失败错误码" + statusCode);
					            logger.error("终止任务订单："+tTaskDetailInfoFlowCustom.getTaskdetailid()+"失败,失败错误码："+result);
					            throw new RuntimeException();
					        }
						}
					}else{
						logger.info("终止直通车任务成功");
			    		map.put("data", "success");
			    		return map;
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
