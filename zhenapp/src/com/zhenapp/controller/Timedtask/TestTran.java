package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Transactional
@Controller
public class TestTran {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	
	@Autowired
	private TestTranService testTranService;
	@RequestMapping(value="/api/platform/TestTran")
	public @ResponseBody ModelMap allocateiontask() throws Exception{
		ModelMap map = new ModelMap();
		for (int i = 0; i < 10; i++) {
			testTranService.test(i);
		}
		
		return map;
	}
	
}
