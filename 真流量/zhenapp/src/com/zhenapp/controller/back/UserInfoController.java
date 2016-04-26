package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.TUserInfo;
import com.zhenapp.po.Custom.TUserinfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/user")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	/*
	 * 使用用户名密码登录
	 */
	@RequestMapping(value="/Loginrest/{username}/{password}"
			,method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody TUserInfo Loginrest(HttpSession httpSession, String username,String password) throws Exception{
		TUserInfo tUserInfo=new TUserInfo();
		tUserInfo.setUserstate("1");
		List<TUserinfoCustom> list=userInfoService.findUserBynick(username);
		if (list.size()>0) {
			tUserInfo=list.get(0);
			httpSession.setMaxInactiveInterval(900); //15分钟
			httpSession.setAttribute("username", tUserInfo.getUsernick());
			
		}else{
			tUserInfo=null;
		}
		return tUserInfo;
	}
	
	/*
	 * 注册
	 */
	@RequestMapping(value="/register"
			,method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ModelAndView register(TUserInfo tUserInfo) throws Exception{
		ModelAndView mv=new ModelAndView();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		System.out.println(sdf.format(new Date()));
		tUserInfo.setRegdate(sdf.format(new Date()));
		tUserInfo.setUserroleid(1);//默认初始化角色id
		tUserInfo.setUserstate("1");//默认初始化用户状态
		tUserInfo.setUserpwd(MD5Util.string2MD5(tUserInfo.getUserpwd()));
		int i=userInfoService.saveUser(tUserInfo);
		if(i>0){
			mv.addObject("msg","注册成功..");
			mv.setViewName("/page/main/login.jsp");
		}else{
			mv.addObject("msg","注册失败..");
			mv.setViewName("/page/main/reg.jsp");
		}
		return mv;
	}
	
	/*
	 * 用于校验注册时用户名是否存在
	 */
	@RequestMapping(value="/findUserByNick"
			,method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String findUserByNick(String usernick) throws Exception{
		List<TUserinfoCustom> list=userInfoService.findUserBynick(usernick);
		if(list.size()>0){
			return "1";
		}
		return "0";
	}
	
	/*
	 * 查询用户列表
	 */
	@RequestMapping(value="/findAllUser")
	public @ResponseBody ModelMap findAllUser() throws Exception{
		ModelMap map=new ModelMap();
		List<TUserinfoCustom> list=userInfoService.findAllUser();
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	
	/*
	 * 退出系统
	 */
	@RequestMapping(value="Logout")
	public ModelAndView Logout(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		mv.setViewName("/page/main/login.jsp");
		return mv;
	}
}
