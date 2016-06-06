package com.zhenapp.controller.back.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;

@Controller
@RequestMapping(value="/task")
public class GetResultstrController {

	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	/*
	 * 根据任务详情主键获取详细返回值
	 */
	@RequestMapping(value="/requesttaskstr/{taskdetailpk}")
	public @ResponseBody ModelMap requesttaskstr(@PathVariable(value="taskdetailpk")String taskdetailpk) throws Exception{
		ModelMap map = new ModelMap();
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailBypk(taskdetailpk);
		StringBuffer sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustom);
		map.put("res", sb.toString());
		return map;
	}
	
}
