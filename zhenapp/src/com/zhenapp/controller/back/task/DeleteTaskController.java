package com.zhenapp.controller.back.task;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
@Transactional
@Controller
@RequestMapping(value="/task")
public class DeleteTaskController {
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	
	/*
	 * 删除任务
	 */
	@RequestMapping(value="/deleteTaskBypk/{taskpk}")
	public ModelAndView deleteTaskBypk(HttpSession session,@PathVariable(value="taskpk")String taskpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		taskInfoService.deleteTaskBypk(taskpk);
		mv.setViewName("/task/responsetaskmanage");
		return mv;
	}
	/*
	 * 批量删除任务
	 */
	@RequestMapping(value="/deletetaskByPks/{pks}")
	public @ResponseBody ModelMap deletetaskByIds(@PathVariable(value="pks") String pks) throws Exception{
		ModelMap map = new ModelMap();
		String [] pkarr = pks.split("==");
		String pk="";
		for (int i = 0; i < pkarr.length; i++) {
			pk= pk + pkarr[i]+",";
		}
		pk= pk.substring(0, pk.length()-1);
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoBypks(pk);
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			if(tTaskInfoCustom.getTaskstate().equals("15")){
				map.put("data", "stateexc");
				return map;
			}
		}
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			taskInfoService.deleteTaskBypk(tTaskInfoCustom.getTaskpk()+"");
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			taskDetailInfoService.deleteTaskBystate(hashmap);
		}
		map.put("data", "success");
		return map;
	}
}
