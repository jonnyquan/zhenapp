package com.zhenapp.controller.publishinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;
@Controller
public class GetBalance {
	@Autowired
	private UserInfoService userInfoService;
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
}
