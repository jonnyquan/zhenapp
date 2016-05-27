package com.zhenapp.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static void Send(String password) throws Exception{
		Properties properties=new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "smtp.sina.com");
		Session session=Session.getInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("qq319809430@sina.com", "WXF010014");
					}
				}
				);
		session.setDebug(true);
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("qq319809430@sina.com"));//发件人
		msg.setSubject("密码找回");
		msg.setRecipients(RecipientType.TO,  InternetAddress.parse("319809430@qq.com"));//收件人
		msg.setContent("<span style='color:red'>您的密码为"+password+"</span>", "text/html;charset=UTF-8");
		Transport.send(msg);
	}
}
