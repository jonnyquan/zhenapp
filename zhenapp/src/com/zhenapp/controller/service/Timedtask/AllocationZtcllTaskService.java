package com.zhenapp.controller.service.Timedtask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskDetailInfoTempService;
@Transactional
@Service
public class AllocationZtcllTaskService {
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	
	public synchronized @ResponseBody String allocateionztctaskll(TPhoneInfoCustom tPhoneInfoCustom,String tasknumstr) throws Exception{
		StringBuffer sb=new StringBuffer();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<TTaskDetailInfoCustom> numwordslist = new ArrayList<TTaskDetailInfoCustom>();
		if(tasknumstr.length()>0){
			String[] numwordsarr = tasknumstr.split("====");
			if(numwordsarr.length>0){
				for (int i = 0; i < numwordsarr.length; i++) {
					TTaskDetailInfoCustom tTaskDetailInfoCustom = new TTaskDetailInfoCustom();
					String []numwordarr = numwordsarr[i].split(",");
					if(numwordarr.length>1){
						tTaskDetailInfoCustom.setTaskkeynum(numwordarr[0]);
						tTaskDetailInfoCustom.setTaskkeyword(numwordarr[1]);
						numwordslist.add(tTaskDetailInfoCustom);
					}
				}
				hashmap.put("numwordslist", numwordslist);
			}
			hashmap.put("today", yyyyMMdd.format(new Date()));
			List<TTaskDetailInfoCustom> idslist = taskDetailInfoService.findexitid(hashmap);
			hashmap.clear();
			if(idslist!=null && idslist.size()>0){
				hashmap.put("idslist", idslist);
			}
		}
		hashmap.put("phoneid",tPhoneInfoCustom.getPhoneid());
		hashmap.put("today", yyyyMMdd.format(new Date()));
		hashmap.put("HHmm", HHmm.format(new Date().getTime() + 1*60*1000));
		hashmap.put("isshopping", "0");
		hashmap.put("iscollection", "0");
		hashmap.put("tasktype", "34");
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.requesttaskByphoneid_temp(hashmap);
		if(tTaskDetailInfoCustom!=null){
			tTaskDetailInfoCustom.setPhoneid(tPhoneInfoCustom.getPhoneid());
			TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom = TTaskDetailinfoTempCustom.setTTaskDetailinfoTempCustom(tTaskDetailInfoCustom);
			tTaskDetailinfoTempCustom.setCreatetime(sdf.format(new Date()));
			tTaskDetailinfoTempCustom.setCreateuser(tTaskDetailInfoCustom.getCreateuser());;
			tTaskDetailinfoTempCustom.setUpdatetime(sdf.format(new Date()));
			tTaskDetailinfoTempCustom.setUpdateuser("分配任务到手机");
			taskDetailInfoTempService.insertDetailinfo(tTaskDetailinfoTempCustom);
			sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustom);
			//将返回的字符串更新到数据表中
			hashmap.put("result", sb.toString());
			hashmap.put("taskdetailid", tTaskDetailinfoTempCustom.getTaskdetailid());
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "api手机端修改字符串");
			taskDetailInfoService.updateTaskDetailresultByid(hashmap);
		}
		return sb.toString();
	}
}
