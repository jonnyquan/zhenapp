package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.UsertestInfoService;
@Transactional
@Controller
@RequestMapping(value="/user")
public class SetUsertestController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UsertestInfoService usertestInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 * 设为代理----系统管理员
	 */
	@RequestMapping(value="/setUsertest/{userpk}")
	public @ResponseBody ModelAndView setAgent(@PathVariable(value="userpk") String userpk,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom TUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		TUsertestInfoCustom tUsertestInfoCustom = new TUsertestInfoCustom();
		tUsertestInfoCustom.setUsertestpk(TUserInfoCustom.getUserpk());
		tUsertestInfoCustom.setUsertestid(TUserInfoCustom.getUserid());
		tUsertestInfoCustom.setUsertestnick(TUserInfoCustom.getUsernick());
		tUsertestInfoCustom.setCreatetime(sdf.format(new Date()));
		tUsertestInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tUsertestInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUsertestInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		usertestInfoService.insertUsertest(tUsertestInfoCustom);
		mv.setViewName("/user/findUsertestAdmin");
		return mv;
	}
}
