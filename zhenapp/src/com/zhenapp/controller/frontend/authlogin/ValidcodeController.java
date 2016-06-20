package com.zhenapp.controller.frontend.authlogin;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/frontend")
public class ValidcodeController {
	@Autowired
	private UserInfoService userInfoService;
	@Value("${sendemail}")
	private String sendemail;
	@Value("${sendemailpwd}")
	private String sendemailpwd;
	
	/*
	 * 发送重置密码的验证码
	 */
	@RequestMapping(value="/sendvalidcode/{email}/{usernick}")
	public @ResponseBody ModelMap sendvalidcode(@PathVariable(value="email")String email,@PathVariable(value="usernick")String usernick) throws Exception{
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
							return new PasswordAuthentication(sendemail, sendemailpwd);//发送邮件账号密码
						}
					}
				);
		session.setDebug(true);
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress(sendemail));//发件人
		msg.setSubject("密码找回");
		msg.setRecipients(RecipientType.TO,  InternetAddress.parse(email));//收件人
		msg.setContent("<span style='color:red'>您此次重置密码的验证码为"+result+"</span>", "text/html;charset=UTF-8");
		Transport.send(msg);
		map.put("msg", "success");
		return map;
	}
}
