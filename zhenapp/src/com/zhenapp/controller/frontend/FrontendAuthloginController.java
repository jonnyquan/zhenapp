package com.zhenapp.controller.frontend;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/frontend")
public class FrontendAuthloginController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	/*
	 * 发送重置密码的验证码
	 */
	@RequestMapping(value="/sendvalidcode/{email}/{usernick}")
	public @ResponseBody ModelMap sendvalidcode(@PathVariable(value="email")String email,String usernick) throws Exception{
		ModelMap map = new ModelMap();
		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",  
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
                "W", "X", "Y", "Z" };  
        List<String> list = Arrays.asList(beforeShuffle);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        String result = afterShuffle.substring(0, 6);
        HashMap<String, Object> hashmap = new HashMap<String, Object>();
        hashmap.put("email", email);
        hashmap.put("usernick", usernick);
        hashmap.put("regvalidcode", result);
		userInfoService.updateValidByemailandusernick(hashmap);
        
		Properties properties=new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "smtp.sina.com");
		Session session=Session.getInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("qq319809430@sina.com", "WXF010014");//发送邮件账号密码
					}
				}
				);
		session.setDebug(true);
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("qq319809430@sina.com"));//发件人
		msg.setSubject("密码找回");
		msg.setRecipients(RecipientType.TO,  InternetAddress.parse("319809430@qq.com"));//收件人
		msg.setContent("<span style='color:red'>您此次重置密码的验证码为"+result+"</span>", "text/html;charset=UTF-8");
		Transport.send(msg);
		
		map.put("msg", "success");
		return map;
	}
	/*
	 * 根据用户名，邮箱，临时验证码修改密码，并清空临时验证码
	 */
	@RequestMapping(value="/password/reset")
	public @ResponseBody ModelAndView passwordreset(TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv = new ModelAndView();
		int i = userInfoService.passwordreset(tUserInfoCustom);
		if(i>0){
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","error");
		}
		mv.setViewName("/frontend/passwordsms.jsp");
		return mv;
	}
	
	/*
	 * 跳转到登录页面
	 */
	@RequestMapping(value="/authlogin")
	public @ResponseBody ModelAndView authlogin(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		
		if(session.getAttribute("tUserInfoCustom") != null){
			mv.setViewName("/user/responseuser");
		}else{
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
	
	/*
	 * 登录操作
	 */
	@RequestMapping(value="/login")
	public @ResponseBody ModelAndView login(HttpSession httpSession, HttpServletRequest request,String username,String password) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<TUserInfoCustom> list=userInfoService.findUserBynick(username);
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		if (list.size()>0) {
			TUserInfoCustom tUserInfoCustom=list.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				httpSession.setMaxInactiveInterval(900); //15分钟
				httpSession.setAttribute("tUserInfoCustom", tUserInfoCustom);
				mv.setViewName("/user/responseuser");
			}else{
				mv.addObject("msg","密码不正确");
				mv.addObject("username",username);
				mv.setViewName("/frontend/authlogin.jsp");
			}
		}else{
			mv.addObject("msg","用户名不存在");
			mv.addObject("username",username);
			mv.setViewName("/frontend/authlogin.jsp");
		}
		return mv;
	}
}
