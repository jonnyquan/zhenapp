package com.zhenapp.controller.back.task;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.TaskDetailInfoTempService;


@Controller
public class FindallocationController {
	@Autowired
	private TaskDetailInfoTempService taskDetailInfoTempService;
	@Value("${middleRows}")
	private Integer middleRows;
	@RequestMapping(value="/task/findallocation")
	public @ResponseBody ModelAndView findallocation(Integer page) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		List<TTaskDetailinfoTempCustom> tTaskDetailinfoTempCustomlist = taskDetailInfoTempService.findallocation(pagemap);
		int total = taskDetailInfoTempService.findTotalallocation(pagemap);
		mv.addObject("tTaskDetailinfoTempCustomlist", tTaskDetailinfoTempCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/taskallocationlist.jsp");
		return mv;
	}
	
}
