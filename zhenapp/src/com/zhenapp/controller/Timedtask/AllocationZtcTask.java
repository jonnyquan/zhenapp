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

import com.zhenapp.controller.service.Timedtask.AllocationZtcTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationZtcllTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationcollectionTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationfakechatTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationshoppingTaskService;
import com.zhenapp.controller.service.Timedtask.AllocationstorecollectionTaskService;
import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
import com.zhenapp.service.TaskInfoService;

@Controller
public class AllocationZtcTask {
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
	private AllocationcollectionTaskService allocationcollectionTaskService;
	@Autowired
	private AllocationshoppingTaskService allocationshoppingTaskService;
	@Autowired
	private AllocationfakechatTaskService allocationfakechatTaskService;
	@Autowired
	private AllocationstorecollectionTaskService allocationstorecollectionTaskService;
	@Autowired
	private AllocationZtcTaskService allocationZtcTaskService;
	@Autowired
	private AllocationZtcllTaskService allocationZtcllTaskService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	@RequestMapping(value="/api/allocationztcTask")
	public @ResponseBody ModelMap allocationztcTask() throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("phonetype", "2");
		List<TPhoneInfoCustom> TPhoneInfoCustomlist = phoneInfoService.findPhoneAndTask(hashmap);
		for (int i = 0; i < TPhoneInfoCustomlist.size(); i++) {
			TPhoneInfoCustom tPhoneInfoCustom = TPhoneInfoCustomlist.get(i);
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			//hashmap.put("isshopping", "1");
			//hashmap.put("iscollection", "1");
			hashmap.put("tasktype", "34");
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlist = taskDetailInfoTempService.findtaskkeynumlistll(hashmap);
			StringBuffer sbztc = new StringBuffer();
			for (int j = 0; j < TTaskDetailinfoTempCustomlist.size(); j++) {
				sbztc.append(TTaskDetailinfoTempCustomlist.get(j).getTaskkeynum()).append(",").append("'").append(TTaskDetailinfoTempCustomlist.get(j).getTaskkeyword()).append("'").append("====");
			}
			String taskkeynumztc =sbztc.toString().length()>1?sbztc.toString():"";
			allocationZtcTaskService.allocateionztctask(tPhoneInfoCustom,taskkeynumztc);
			
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			//hashmap.put("isshopping", "0");
			//hashmap.put("iscollection", "0");
			hashmap.put("tasktype", "34");
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlistll = taskDetailInfoTempService.findtaskkeynumlistll(hashmap);
			StringBuffer sbztcll = new StringBuffer();
			for (int j = 0; j < TTaskDetailinfoTempCustomlistll.size(); j++) {
				sbztcll.append(TTaskDetailinfoTempCustomlistll.get(j).getTaskkeynum()).append(",").append("'").append(TTaskDetailinfoTempCustomlistll.get(j).getTaskkeyword()).append("'").append("====");
			}
			String taskkeynumztcll =sbztcll.toString().length()>1?sbztcll.toString():"";
			allocationZtcllTaskService.allocateionztctaskll(tPhoneInfoCustom,taskkeynumztcll);
			
			/*
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("isstorecollection", 1);
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlisstorecollection = taskDetailInfoTempService.findtaskkeynumlist(hashmap);
			StringBuffer sbisstorecollection = new StringBuffer();
			for (int j = 0; j < TTaskDetailinfoTempCustomlisisshopping.size(); j++) {
				sbisstorecollection.append(TTaskDetailinfoTempCustomlisstorecollection.get(j).getTaskkeynum()).append(",");
			}
			String taskkeynumstrisstorecollection =sbisstorecollection.toString().length()>1?sbisstorecollection.toString().substring(0, sbisstorecollection.toString().length()-1):"";
			allocationstorecollectionTaskService.allocateiontaskstorecollection(tPhoneInfoCustom,taskkeynumstrisstorecollection);
			
			hashmap.clear();
			hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
			hashmap.put("isfakechat", 1);
			hashmap.put("taskdate", yyyyMMdd.format(new Date()));
			hashmap.put("HHmm", HHmm.format(new Date().getTime() + 2*60*1000));
			List<TTaskDetailinfoTempCustom> TTaskDetailinfoTempCustomlisfakechat = taskDetailInfoTempService.findtaskkeynumlist(hashmap);
			StringBuffer sbisfakechat = new StringBuffer();
			for (int j = 0; j < TTaskDetailinfoTempCustomlisfakechat.size(); j++) {
				sbisfakechat.append(TTaskDetailinfoTempCustomlisfakechat.get(j).getTaskkeynum()).append(",");
			}
			String taskkeynumstrisfakechat =sbisfakechat.toString().length()>1?sbisfakechat.toString().substring(0, sbisfakechat.toString().length()-1):"";
			allocationfakechatTaskService.allocateiontaskfakechat(tPhoneInfoCustom,taskkeynumstrisfakechat);
			*/
		}
		return map;
	}
	
}
