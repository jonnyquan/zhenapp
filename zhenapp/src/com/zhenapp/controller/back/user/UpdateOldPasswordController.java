package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class UpdateOldPasswordController {
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

	/*
	 * 修改用户密码
	 */
	@RequestMapping(value="/updateOldPassword")
	public @ResponseBody ModelAndView updateOldPassword(HttpSession session,String oldpassword,String userpwd) throws Exception{
		ModelAndView mv =new ModelAndView();
		String usernick = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom")).getUsernick();
		List<TUserInfoCustom> tUserInfoCustomlist=userInfoService.findUserBynick(usernick);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
			TUserInfoCustom tUserInfoCustom=tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(oldpassword))){
				tUserInfoCustom.setUserpwd(MD5Util.string2MD5(userpwd));
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				int i = userInfoService.updateUserpwdByuserid(tUserInfoCustom);
				if(i > 0){
					session.setAttribute("tUserInfoCustom", tUserInfoCustom);
				}
				mv.addObject("msg", "修改密码成功");
			}else{
				mv.addObject("msg", "修改密码失败");
			}
		}
		mv.setViewName("responseupdatepassword");
		return mv;
	}
}
