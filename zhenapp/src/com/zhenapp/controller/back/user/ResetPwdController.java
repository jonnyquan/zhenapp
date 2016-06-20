package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 根据用户主键修改用户密码
	 */
	@RequestMapping(value="/resetPwd")
	public @ResponseBody ModelAndView resetPwd(HttpSession session,String password,String userid) throws Exception{
		ModelAndView mv =new ModelAndView();
		TUserInfoCustom tUserInfoCustom = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom"));
		TUserInfoCustom tUserInfoCustomtemp = new TUserInfoCustom();
		tUserInfoCustomtemp.setUserid(userid);
		tUserInfoCustomtemp.setUserpwd(MD5Util.string2MD5(password));
		tUserInfoCustomtemp.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustomtemp.setUpdateuser(tUserInfoCustom.getUserid());
		userInfoService.updateUserpwdByuserid(tUserInfoCustomtemp);
		mv.setViewName("/user/findUserByPageAndAdmin");
		return mv;
	}
	
	/*
	 * 跳转到重置所有用户密码页面
	 */
	@RequestMapping(value="/requestresetpwd/{userid}")
	public @ResponseBody ModelAndView requestresetpwd(@PathVariable(value="userid")String userid) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid",userid);
		mv.setViewName("/backstage/admin/resetPwd.jsp");
		return mv;
	}
}
