package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TDateInfoCustom;
import com.zhenapp.service.DateInfoService;
@Transactional
@Controller
public class InsertDate {
	private static Logger logger = Logger.getLogger(InsertDate.class);
	
	@Autowired
	private DateInfoService dateInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	@RequestMapping(value="/api/platform/insertDateByTimes")
	public @ResponseBody ModelMap insertDateByTimes() throws Exception{
		ModelMap map = new ModelMap();
		TDateInfoCustom tDateInfoCustom = new TDateInfoCustom();
		tDateInfoCustom.setDateid(yyyyMMdd.format(new Date()));
		tDateInfoCustom.setDatevalue(yyyyMMdd.format(new Date()));
		tDateInfoCustom.setCreatetime(sdf.format(new Date()));
		tDateInfoCustom.setCreateuser("sys");
		tDateInfoCustom.setUpdatetime(sdf.format(new Date()));
		tDateInfoCustom.setUpdateuser("sys");
		dateInfoService.insertDate(tDateInfoCustom);
		logger.info("插入当天日期成功");
		return map;
	}
	
}
