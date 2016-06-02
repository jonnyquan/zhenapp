package com.zhenapp.controller.frontend.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/frontend")
public class CheckUserNickController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/ajax/checkUserNameUnique")
	public @ResponseBody ModelMap findUserByNick(String param) throws Exception{
		List<TUserInfoCustom> list=userInfoService.findUserBynick(param);
		ModelMap map= new ModelMap();
		if(list.size()>0){
			map.put("status", "n");
			map.put("info", "用户名已被占用");
		}else{
			map.put("status", "y");
		}
		return map;
	}
	@RequestMapping(value="/ajax/checkUserNameexist")
	public @ResponseBody ModelMap checkUserNameexist(String param) throws Exception{
		List<TUserInfoCustom> list=userInfoService.findUserBynick(param);
		ModelMap map= new ModelMap();
		if(list.size()>0){
			map.put("status", "y");
		}else{
			map.put("status", "n");
			map.put("info", "用户名不存在");
		}
		return map;
	}
}
