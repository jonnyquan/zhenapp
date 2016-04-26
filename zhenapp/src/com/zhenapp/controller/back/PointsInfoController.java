package com.zhenapp.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/points")
public class PointsInfoController {

	@RequestMapping(value="/findPointsInfoByPage")
	public @ResponseBody ModelMap findPointsInfoByPage() throws Exception{
		
		
		return null;
	}
}
