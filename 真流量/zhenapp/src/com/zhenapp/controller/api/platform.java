package com.zhenapp.controller.api;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.OrderInfo;
import com.zhenapp.po.TTaskInfo;
import com.zhenapp.po.Custom.TUserinfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/api/platform")
public class platform {
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private TaskInfoService taskInfoService;
	
	/*
	 * API接口中 获取余额  restful风格
	 */
	@RequestMapping(value="/searchBalance/{partnerId}/{password}")
	public @ResponseBody ModelMap searchBalance(@PathVariable(value="partnerId") String partnerId,@PathVariable(value="password") String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserinfoVo tUserinfoVo=new TUserinfoVo();
		TUserinfoCustom tUserinfoCustom=new TUserinfoCustom();
		tUserinfoCustom.setUsernick(partnerId);
		tUserinfoCustom.setUserpwd(MD5Util.string2MD5(password));
		tUserinfoVo.settUserinfoCustom(tUserinfoCustom);
		String points=userInfoService.findpointsByUserid(tUserinfoVo);
		map.put("code", "200");
		map.put("desc", points);
		return map;
	}
	
	/*
	 * API接口中 获取余额  表单提交方式
	 */
	@RequestMapping(value="/searchBalance")
	public @ResponseBody ModelMap searchBalance_2(String partnerId,String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserinfoVo tUserinfoVo=new TUserinfoVo();
		TUserinfoCustom tUserinfoCustom=new TUserinfoCustom();
		tUserinfoCustom.setUsernick(partnerId);
		tUserinfoCustom.setUserpwd(MD5Util.string2MD5(password));
		tUserinfoVo.settUserinfoCustom(tUserinfoCustom);
		String points=userInfoService.findpointsByUserid(tUserinfoVo);
		map.put("code", "200");
		map.put("desc", points);
		return map;
	}
	
	/*
	 * 递交订单方式 表单提交
	 * 
	 */
	@RequestMapping(value="/flow/save")
	public @ResponseBody ModelMap flowsave(String partnerId,String data,String validation) throws Exception{
		ModelMap map=new ModelMap();
		List<TUserinfoCustom> tUserinfoCustomlist=userInfoService.findUserBynick(partnerId);
		if(tUserinfoCustomlist.size()<0){
			map.put("code", "0");
			map.put("desc", "用户不存在");
		}
		TUserinfoCustom tUserinfoCustom=tUserinfoCustomlist.get(0);
		String validationtest=MD5Util.string2MD5(tUserinfoCustom.getUsernick()+tUserinfoCustom.getUserpwd()+tUserinfoCustom.getUsernick());
		if(!validation.equals(validationtest)){
			map.put("code", "0");
			map.put("desc", "用户信息校验失败");
		}
		ObjectMapper mapper = new ObjectMapper();
		OrderInfo orderInfo=mapper.readValue(data, OrderInfo.class); 
		
		TTaskInfo tTaskInfo=new TTaskInfo();
		
		taskInfoService.insertTask(tTaskInfo);
		tTaskInfo.setTaskminprice("");
		return map;
	}
	
	
	
	/*
	 * 查询订单
	 * partnerId 用户名
	 * 
	 * password 密码
	 * 
	 * fid 订单号
	 */
	@RequestMapping(value="/search/flow")
	public @ResponseBody ModelMap searchflow(String partnerId,String password,String fid){
		ModelMap map=new ModelMap();
		
		
		
		
		return map;
	}
	
	
}
