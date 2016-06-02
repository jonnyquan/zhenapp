package com.zhenapp.controller.phoneapi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;

@Controller
public class DownLoadScriptFile {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	private static Logger logger = Logger.getLogger(DownLoadScriptFile.class);
	/*
	 * 手机端下载脚本文件
	 * http://120.24.44.130/api/phone/down?name=hqfh2.lua
	 */
	@RequestMapping(value = "/api/phone/down")
	public void downloadFile(String name, HttpServletResponse response,HttpServletRequest request)  {
		logger.info("开始下载脚本文件");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			byte bb[];
	        bb = name.getBytes("ISO-8859-1"); //以"ISO-8859-1"方式解析name字符串
	        name= new String(bb, "UTF-8"); //再用"utf-8"格式表示name
			TScriptInfoCustom tScriptInfoCustom = scriptInfoService.findScriptByname(name);
			request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	        //获取下载文件路径
	        String downLoadPath = tScriptInfoCustom.getScriptpath();
	        //获取文件的长度
	        long fileLength = new File(downLoadPath).length();
	        //设置文件输出类型
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String(tScriptInfoCustom.getScriptname().getBytes("utf-8"), "ISO8859-1")); 
	        //设置输出长度
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	        //获取输入流
	        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	        //输出流
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        //关闭流
	        bis.close();  
	        bos.close();  
	        logger.info("下载脚本文件完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.info("下载脚本文件异常,文件未找到!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("下载脚本文件异常!");
		}
	}
}
