package com.zhenapp.controller.back.task;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;

@Controller
@RequestMapping(value="/task")
public class FindTaskLockController {
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转卡机任务查询界面-----系统管理员
	 */
	@RequestMapping(value="/findtasklocklist")
	public ModelAndView findtasklocklist(Integer page,String taskdetailpk,String phoneid,String taskkeynum) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskdetailpk", taskdetailpk);
		//系统管理员
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByProblemAndPage(pagemap);
		int total = taskDetailInfoService.findTotalTaskDetailByProblemAndPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskdetailpk", taskdetailpk);
		mv.setViewName("/backstage/admin/tasklocklist.jsp");
		return mv;
	}
}
