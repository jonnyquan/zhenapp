package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.controller.service.Timedtask.AllocationcollectionTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationshoppingTaskService;
import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;

@Controller
public class AllocationTask {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private AllocationcollectionTaskService allocationcollectionTaskService;
	@Autowired
	private AllocationshoppingTaskService allocationshoppingTaskService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	@RequestMapping(value="/api/allocationTask")
	public @ResponseBody ModelMap allocateiontask() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("phonetype", "1");
		List<TPhoneInfoCustom> TPhoneInfoCustomlist = phoneInfoService.findPhoneAndTask(hashmap);
		for (int i = 0; i < TPhoneInfoCustomlist.size(); i++) {
			StringBuffer sbiscollection = new StringBuffer();
			TPhoneInfoCustom tPhoneInfoCustom = TPhoneInfoCustomlist.get(i);
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("iscollection", "1");
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("tasktype", "33");
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlistiscollection = taskDetailInfoTempService.findtaskkeynumlist(hashmap);
			for (int j = 0; j < TTaskDetailinfoTempCustomlistiscollection.size(); j++) {
				sbiscollection.append(TTaskDetailinfoTempCustomlistiscollection.get(j).getTaskkeynum()).append(",");
			}
			String taskkeynumstriscollection =sbiscollection.toString().length()>1?sbiscollection.toString().substring(0, sbiscollection.toString().length()-1):"";
			allocationcollectionTaskService.allocateiontaskcollection(tPhoneInfoCustom,taskkeynumstriscollection);
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("isshopping", "1");
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("tasktype", "33");
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlisisshopping = taskDetailInfoTempService.findtaskkeynumlist(hashmap);
			StringBuffer sbisshopping = new StringBuffer();
			for (int j = 0; j < TTaskDetailinfoTempCustomlisisshopping.size(); j++) {
				sbisshopping.append(TTaskDetailinfoTempCustomlisisshopping.get(j).getTaskkeynum()).append(",");
			}
			String taskkeynumstrisshopping =sbisshopping.toString().length()>1?sbisshopping.toString().substring(0, sbisshopping.toString().length()-1):"";
			allocationshoppingTaskService.allocateiontaskshopping(tPhoneInfoCustom,taskkeynumstrisshopping);
		}
		return map;
	}
	
}
