package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.TUserInfo;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.MD5Util;
import com.zhenapp.util.Mail;

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
		List<TUserInfoCustom> list=userInfoService.findUserBynick(username);
		if (list.size()>0) {
			TUserInfoCustom tUserInfoCustom=list.get(0);
			httpSession.setMaxInactiveInterval(900); //15分钟
			httpSession.setAttribute("tUserInfoCustom", tUserInfoCustom);
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
	@RequestMapping(value="/findUserByNick")
	public @ResponseBody String findUserByNick(String usernick) throws Exception{
		List<TUserInfoCustom> list=userInfoService.findUserBynick(usernick);
		if(list.size()>0){
			return "1";
		}
		return "0";
	}
	
	/*
	 * 查询用户列表
	 */
	@RequestMapping(value="/findUserByPage")
	public @ResponseBody ModelMap findUserByPage(Integer page,Integer rows) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TUserInfoCustom> list=userInfoService.findUserByPage(pagemap);
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	
	
	/*
	 * 退出系统
	 */
	@RequestMapping(value="/Logout")
	public ModelAndView Logout(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		session.removeAttribute("tUserInfoCustom");
		mv.setViewName("/page/main/login.jsp");
		return mv;
	}
	
	/*
	 * 基本信息页面数据显示
	 */
	@RequestMapping(value="/findUserinfoByusernick")
	public ModelAndView findUserinfoByusernick(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TUserInfoCustom> list=userInfoService.findUserBynick(tUserInfoCustom.getUsernick());
		TUserInfoCustom tUserinfoCustom=null;
		if(list != null && list.size()>0){
			tUserinfoCustom = list.get(0);
		}
		mv.addObject("tUserinfoCustom",tUserinfoCustom);
		mv.setViewName("/page/personalcenter/personaldetails.jsp");
		return mv;
	}
	/*
	 * 重置密码页面数据显示
	 */
	@RequestMapping(value="/findUserinfoByusernicktopassword")
	public ModelAndView findUserinfoByusernicktopassword(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TUserInfoCustom> list=userInfoService.findUserBynick(tUserInfoCustom.getUsernick());
		TUserInfoCustom tUserinfoCustom=null;
		if(list != null && list.size()>0){
			tUserinfoCustom = list.get(0);
		}
		mv.addObject("tUserinfoCustom",tUserinfoCustom);
		mv.setViewName("/page/personalcenter/personalPassword.jsp");
		return mv;
	}
	
	/*
	 * 使用邮件找回密码
	 */
	@RequestMapping(value="/findPasswordByemail")
	public @ResponseBody ModelAndView findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception{
		ModelAndView mv =new ModelAndView();
		TUserInfoCustom TUserinfoCustomtemp=userInfoService.findPasswordByemail(tUserinfoVo);
		if(TUserinfoCustomtemp!=null){
			try{
				Mail.Send(TUserinfoCustomtemp.getUserpwd());
				mv.addObject("msg", "请查收邮件!");
			}catch(Exception e){
				mv.addObject("msg", "系统异常,请联系管理员!");
			}
		}else{
			mv.addObject("msg", "用户名或注册邮箱错误");
		}
		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}
	/*
	 * 用于用户修改基本信息
	 */
	@RequestMapping(value="/updateUserinfo")
	public @ResponseBody ModelAndView updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception{
		ModelAndView mv =new ModelAndView();
		int i=userInfoService.updateUserinfo(tUserinfoVo);
		if(i>0){
			mv.setViewName("/user/findUserinfoByusernick");
		}
		return mv;
	}
	/*
	 * 删除用户信息
	 */
	@RequestMapping(value="/deleteUserinfoBypk/{userpk}")
	public @ResponseBody ModelMap deleteUserinfoBypk(@PathVariable(value="userpk")String userpk) throws Exception{
		ModelMap map= new ModelMap();
		
		int i= userInfoService.deleteUserinfoBypk(userpk);
		map.put("data", i);
		return map;
	}
}
