package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;
@Controller
public class AllocationTask {
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	@RequestMapping(value="/api/allocationTask")
	public @ResponseBody ModelMap allocateiontask() throws Exception{
		ModelMap map = new ModelMap();
		StringBuffer sb=new StringBuffer();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		for (int i = 1; i <= Integer.parseInt(tSysconfInfoCustom.getSysconfvalue1()); i++) {
			hashmap.clear();
			hashmap.put("phoneid", i);
			hashmap.put("iscollection", 1);
			hashmap.put("today", yyyyMMdd.format(new Date()));
			hashmap.put("HHmm", HHmm.format(new Date()));
			TTaskDetailInfoCustom tTaskDetailInfoCustomtype1collection = taskDetailInfoService.requesttaskByphoneid_temp(hashmap);
			if(tTaskDetailInfoCustomtype1collection!=null){
				tTaskDetailInfoCustomtype1collection.setPhoneid(i+"");
				TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom = TTaskDetailinfoTempCustom.setTTaskDetailinfoTempCustom(tTaskDetailInfoCustomtype1collection);
				taskDetailInfoTempService.insertDetailinfo(tTaskDetailinfoTempCustom);
				sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype1collection);
				//将返回的字符串更新到数据表中
				hashmap.put("result", sb.toString());
				hashmap.put("taskdetailid", tTaskDetailinfoTempCustom.getTaskdetailid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "api手机端修改字符串");
				taskDetailInfoService.updateTaskDetailresultByid(hashmap);
			}
			hashmap.clear();
			hashmap.put("phoneid", i);
			hashmap.put("isshopping", 1);
			hashmap.put("today", yyyyMMdd.format(new Date()));
			hashmap.put("HHmm", HHmm.format(new Date()));
			TTaskDetailInfoCustom tTaskDetailInfoCustomtype1shopping = taskDetailInfoService.requesttaskByphoneid_temp(hashmap);
			if(tTaskDetailInfoCustomtype1shopping!=null){
				tTaskDetailInfoCustomtype1shopping.setPhoneid(i+"");
				TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom = TTaskDetailinfoTempCustom.setTTaskDetailinfoTempCustom(tTaskDetailInfoCustomtype1shopping);
				taskDetailInfoTempService.insertDetailinfo(tTaskDetailinfoTempCustom);
				sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustomtype1shopping);
				hashmap.put("result", sb.toString());
				hashmap.put("taskdetailid", tTaskDetailinfoTempCustom.getTaskdetailid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "api手机端修改字符串");
				taskDetailInfoService.updateTaskDetailresultByid(hashmap);
			}
		}
		return map;
	}
	
}
