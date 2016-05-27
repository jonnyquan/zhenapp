package com.zhenapp.service.api;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;

@Service
public class FirstWebService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	//private static Logger logger = Logger.getLogger(FirstWebController.class);
	//private final String secrettest="bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K";//测试
	//private final String secret= "Ko;l47q6P`KZo:=xTc]39CJ`JPwGJ=fss8n:MaxR[YjPVN/2DI6`>5g3KdfMKpS9";//正式
	
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	//@Value("${secret}")
	//private String secret;
	
	/*
	 * 发布任务
	 */
	
}
