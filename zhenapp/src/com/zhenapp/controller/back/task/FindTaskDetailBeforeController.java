package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class FindTaskDetailBeforeController {
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");

	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Value("${middleRows}")
	private Integer middleRows;

	/*
	 * 跳转到任务详情界面-----系统管理员	历史详情查询
	 */
	@RequestMapping(value="/findtaskdetaillistbefore")
	public ModelAndView findtaskdetaillistbefore(Integer page,String tasktype,String phoneid,String taskkeynum,String taskstate,String taskpk,String taskhour,String detaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskhour", taskhour);
		pagemap.put("tasktype", tasktype);
		pagemap.put("detaid", detaid);
		pagemap.put("taskstate", taskstate);
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//系统管理员
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskhour", taskhour);
		mv.addObject("tasktype", tasktype);
		mv.addObject("taskstate", taskstate);
		mv.addObject("detaid", detaid);
		mv.setViewName("/backstage/admin/taskdetaillistbefore.jsp");
		return mv;
	}
	
}
