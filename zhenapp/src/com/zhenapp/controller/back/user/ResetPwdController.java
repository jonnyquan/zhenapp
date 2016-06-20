package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/user")
public class ResetPwdController {
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

	/*
	 * 修改全体用户密码
	 */
	@RequestMapping(value="/resetPwd")
	public @ResponseBody ModelAndView resetPwd(HttpSession session,String password) throws Exception{
		ModelAndView mv =new ModelAndView();
		TUserInfoCustom tUserInfoCustom = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom"));
		TUserInfoCustom tUserInfoCustomtemp = new TUserInfoCustom();
		tUserInfoCustomtemp.setUserpwd(MD5Util.string2MD5(password));
		tUserInfoCustomtemp.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustomtemp.setUpdateuser(tUserInfoCustom.getUserid());
		userInfoService.updateUserpwdByuserid(tUserInfoCustomtemp);
		mv.setViewName("/user/requestresetpwd");
		return mv;
	}
	
	/*
	 * 跳转到重置所有用户密码页面
	 */
	@RequestMapping(value="/requestresetpwd")
	public @ResponseBody ModelAndView requestresetpwd() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/backstage/admin/resetPwd.jsp");
		return mv;
	}
}
