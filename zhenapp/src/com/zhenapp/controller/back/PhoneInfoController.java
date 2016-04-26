package com.zhenapp.controller.back;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.service.PhoneInfoService;

@Controller
@RequestMapping(value="/phone")
public class PhoneInfoController {
	@Autowired
	private PhoneInfoService phoneInfoService;
	
	/*
	 * 查询可以做该宝贝id的所有手机信息
	 */
	@RequestMapping(value="/findAllPhoneInfoBykeynum/{taskkeynum}")
	public @ResponseBody ModelMap findIsFirst(@PathVariable(value="taskkeynum") String taskkeynum) throws Exception{
		ModelMap map=new ModelMap();
		List<TPhoneInfoCustom> tPhoneInfoCustomlist = phoneInfoService.findAllPhoneBykeynum(taskkeynum);
		if(tPhoneInfoCustomlist!=null && tPhoneInfoCustomlist.size()>0){
			map.put("count", tPhoneInfoCustomlist.size());
		}else{
			map.put("count", 0);
		}
		return map;
	}

}
