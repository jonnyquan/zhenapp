package com.zhenapp.controller.back.user;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/user")
public class CheckOldPasswordController {
	@Autowired
	private UserInfoService userInfoService;

	/*
	 * 查询该用户登录密码与该帐号是否匹配
	 */
	@RequestMapping(value="/ajax/checkOldPassword")
	public @ResponseBody ModelMap checkOldPassword(HttpSession session,String param) throws Exception{
		ModelMap map =new ModelMap();
		String usernick = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom")).getUsernick();
		List<TUserInfoCustom> tUserInfoCustomlist=userInfoService.findUserBynick(usernick);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
			TUserInfoCustom tUserInfoCustom=tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(param))){
				map.put("status", "y");
			}else{
				map.put("status", "n");
				map.put("info", "原密码不正确");
			}
		}
		return map;
	}
}
