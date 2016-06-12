package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.UsertestInfoService;

@Controller
@RequestMapping(value="/user")
public class DeleteUsertestController {
	@Autowired
	private UsertestInfoService usertestInfoService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	@RequestMapping(value="/deleteUsertest")
	public @ResponseBody ModelMap deleteUserByUserpkAdmin(String usertestpk) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("usertestpk", usertestpk);
		usertestInfoService.deleteUsertest(hashmap);
		map.put("ec", 0);
		return map;
	}
}
