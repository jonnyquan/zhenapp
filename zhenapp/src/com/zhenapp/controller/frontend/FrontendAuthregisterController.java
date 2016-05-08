package com.zhenapp.controller.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/frontend")
public class FrontendAuthregisterController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	@RequestMapping(value="/authregister")
	public @ResponseBody ModelAndView authlogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/frontend/authregister.jsp");
		return mv;
	}
	
	@RequestMapping(value="/saveuser")
	public @ResponseBody ModelAndView saveuser(HttpServletRequest request,TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv=new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		String time = sdf.format(new Date());
		tUserInfoCustom.setUserroleid(3);//默认初始化角色id
		tUserInfoCustom.setRegdomain(webwww);
		tUserInfoCustom.setRegip(webwww);
		tUserInfoCustom.setUserstate("29");//默认初始化用户状态
		tUserInfoCustom.setUserid(UUID.randomUUID().toString().replace("-", ""));
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(tUserInfoCustom.getUserpwd()));
		tUserInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tUserInfoCustom.setCreatetime(time);
		tUserInfoCustom.setCreateuser("sys");
		tUserInfoCustom.setUpdatetime(time);
		tUserInfoCustom.setUpdateuser("sys");
		int i=userInfoService.saveUser(tUserInfoCustom);
		if(i>0){
			mv.addObject("msg","注册成功..");
			mv.setViewName("/frontend/authlogin");
		}else{
			mv.addObject("msg","注册失败..");
			mv.setViewName("authregister");
		}
		return mv;
	}
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
	
	@RequestMapping(value="/ajax/checkEmailUnique")
	public @ResponseBody ModelMap checkEmailUnique(String param) throws Exception{
		int i= userInfoService.checkEmailUnique(param);
		ModelMap map= new ModelMap();
		if(i > 0){
			map.put("status", "n");
			map.put("info", "此邮箱账号已被占用");
		}else{
			map.put("status", "y");
		}
		return map;
	}
	
	@RequestMapping(value="/ajax/checkMobileUnique")
	public @ResponseBody ModelMap checkMobileUnique(String param) throws Exception{
		int i= userInfoService.checkMobileUnique(param);
		ModelMap map= new ModelMap();
		if(i > 0){
			map.put("status", "n");
			map.put("info", "此手机号已被占用");
		}else{
			map.put("status", "y");
		}
		return map;
	}
	
	
}
