package com.zhenapp.controller.publishinterface;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

public class GetOrder {
	private static Logger logger = Logger.getLogger(GetOrder.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	/*
	 * 查询订单  partnerId 用户名		password 密码 	 fid 订单号
	 */
	@RequestMapping(value="/api/platform/search/flow")
	public @ResponseBody ModelMap searchflow(String partnerId,String password,String fid) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> hashmapuser = new HashMap<String, Object>();
		hashmapuser.put("usernick", partnerId);
		hashmapuser.put("userstate", "29");
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(hashmapuser);
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
					logger.info("查询订单成功");
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
					logger.info("查询订单不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
				logger.info("查询订单用户密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
			logger.info("查询订单用户名错误");
		}
		return map;
	}
	
	@RequestMapping(value="/api/platform/search/flow/{partnerId}/{password}/{fid}")
	public @ResponseBody ModelMap searchflowrest(@PathVariable(value="partnerId")String partnerId,@PathVariable(value="password")String password,@PathVariable(value="fid")String fid) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> hashmapuser = new HashMap<String, Object>();
		hashmapuser.put("usernick", partnerId);
		hashmapuser.put("userstate", "29");
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(hashmapuser);
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
					logger.info("查询订单成功");
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
					logger.info("查询订单不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
				logger.info("查询订单用户密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
			logger.info("查询订单用户名错误");
		}
		return map;
	}
}
