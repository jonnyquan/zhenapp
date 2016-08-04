package com.zhenapp.controller.TaskInfoQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoQueryService;
@Transactional
@Service
public class UpdateTaskInfoQueryllService {
	@Autowired
	private TaskInfoQueryService taskInfoQueryService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public @ResponseBody ModelMap updateTaskInfo33(TTaskInfoQueryCustom tTaskInfoQueryCustom) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		hashmap.put("taskid", tTaskInfoQueryCustom.getTaskid());
		TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);
		hashmap.put("taskstate", "21");
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomList = taskDetailInfoService.findTaskDetail(hashmap);
		hashmap.clear();
		hashmap.put("taskdate", yyyyMMdd.format(new Date()));
		hashmap.put("taskid", tTaskInfoQueryCustom.getTaskid());
		hashmap.put("taskstate", "22");
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomErrorList = taskDetailInfoService.findTaskDetail(hashmap);
		int finshflows=tTaskDetailInfoFlowCustom.getFinishcount();
		int finshcollectioncounts = 0;
		int finshshoppingcounts = 0;
		int errorcounts=tTaskDetailInfoCustomErrorList!=null?tTaskDetailInfoCustomErrorList.size():0;
		for (int j = 0; j < tTaskDetailInfoCustomList.size(); j++) {
			TTaskDetailInfoCustom tTaskDetailInfoCustom = tTaskDetailInfoCustomList.get(j);
			if(tTaskDetailInfoCustom.getIscollection().equals("1")){
				finshcollectioncounts++;
			}
			if(tTaskDetailInfoCustom.getIsshopping().equals("1")){
				finshshoppingcounts++;
			}
		}
		hashmap.put("taskid", tTaskInfoQueryCustom.getTaskid());
		hashmap.put("finshflowcounts", finshflows);
		hashmap.put("finshcollectioncounts", finshcollectioncounts);
		hashmap.put("finshshoppingcounts", finshshoppingcounts);
		hashmap.put("errorcounts", errorcounts);
		hashmap.put("updatetime", yyyyMMddHHmmss.format(new Date()));
		hashmap.put("updateuser", "更新数量");
		taskInfoQueryService.updateTaskInfo(hashmap);
		return map;
	}
}
