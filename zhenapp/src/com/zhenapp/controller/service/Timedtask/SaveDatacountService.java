package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.service.DatacountInfoService;
@Transactional
@Service
public class SaveDatacountService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static Logger logger = Logger.getLogger(SaveDatacountService.class);
	@Autowired
	private DatacountInfoService datacountInfoService;
	
	/*
	 * 每天0点50分执行一次 保存数据统计信息
	 */
	public @ResponseBody ModelMap saveDatacount() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("datevalue", sdf.format(new Date().getTime()-(24*3600*1000)));
		datacountInfoService.saveDatacount(hashmap);
		logger.info("保存数据统计信息!");
		return map;
	}
}
