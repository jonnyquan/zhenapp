package com.zhenapp.controller.frontend.register;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/frontend")
public class AuthregisterController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	@RequestMapping(value="/saveuser")
	public @ResponseBody ModelAndView saveuser(HttpServletRequest request,TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv=new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		tUserInfoCustom.setUserroleid(3);//默认初始化角色id
		tUserInfoCustom.setRegurl(webwww);
		tUserInfoCustom.setPoints(0);//默认用户注册积分为0 并插入积分明细记录
		tUserInfoCustom.setRegip(webwww);
		tUserInfoCustom.setUserstate("29");//默认初始化用户状态
		tUserInfoCustom.setUserid(UUID.randomUUID().toString().replace("-", ""));
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(tUserInfoCustom.getUserpwd()));
		tUserInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tUserInfoCustom.setCreatetime(sdf.format(new Date()));
		tUserInfoCustom.setCreateuser("注册");
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser("sys");
		int i=userInfoService.saveUser(tUserInfoCustom);
		if(i>0){
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("sys");
			tPointsInfoCustom.setPointreason("注册账号,赠送积分"+0);
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPoints(0);
			tPointsInfoCustom.setPointstype("27");
			tPointsInfoCustom.setPointsupdate(0);
			tPointsInfoCustom.setTaskpk(0);
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
			mv.addObject("msg","注册成功..");
			mv.setViewName("/frontend/authlogin");
		}else{
			mv.addObject("msg","注册失败..");
			mv.setViewName("authregister");
		}
		return mv;
	}
	
}
