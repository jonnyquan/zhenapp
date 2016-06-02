package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.TaskDetailInfoService;

@Controller
@RequestMapping(value="/phone")
public class PhoneInfoController {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	private static Logger logger = Logger.getLogger(PhoneInfoController.class);
	
	/*
	 * 查询每个手机完成了多少个任务
	 */
	@RequestMapping(value="/responsetaskdatasum")
	public @ResponseBody ModelAndView responsetaskdatasum() throws Exception{
		ModelAndView mv = new ModelAndView();
		//按手机编号分组查询当天完成的加购数和收藏数
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("date", yyyyMMdd.format(new Date()));
		logger.info("按手机编号分组查询当天完成的加购数和收藏数");
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findtaskdatacount(hashmap);
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findtaskdatasum(hashmap);
		if(tTaskDetailInfoCustomlist!=null && tTaskDetailInfoCustomlist.size()>0){
			mv.addObject("tTaskDetailInfoCustomlist",tTaskDetailInfoCustomlist);	
			mv.addObject("tTaskDetailInfoCustom",tTaskDetailInfoCustom);	
		}
		mv.setViewName("/backstage/admin/taskdatasum.jsp");
		return mv;
	}
}
