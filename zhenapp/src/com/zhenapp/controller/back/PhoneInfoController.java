package com.zhenapp.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhenapp.service.PhoneInfoService;

@Controller
@RequestMapping(value="/phone")
public class PhoneInfoController {
	@Autowired
	private PhoneInfoService phoneInfoService;
	
	/*
	 * 查询可以做该宝贝id的有多少部手机
	 *
	@RequestMapping(value="/findAllPhoneInfoBykeynum/{taskkeynum}")
	public @ResponseBody ModelMap findIsFirst(@PathVariable(value="taskkeynum") String taskkeynum) throws Exception{
		ModelMap map=new ModelMap();
		int count = phoneInfoService.findPhonecountBykeynum(taskkeynum);
		map.put("count", count);
		return map;
	}*/

}
