package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
@RequestMapping(value="/task")
public class TaskInfoController {
	
	@Autowired
	private TaskInfoService taskInfoService;

	/*
	 * 查询任务订单信息
	 */
	@RequestMapping(value="/findTaskBypage")
	public @ResponseBody ModelMap findTaskBypage(Integer page, Integer rows,String taskid,String datefrom,String dateto) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		datefrom=datefrom!=null?datefrom.replace("-", ""):"";
		dateto=dateto!=null?dateto.replace("-", ""):"";
		pagemap.put("taskid", taskid);
		pagemap.put("datefrom", datefrom);
		pagemap.put("dateto", dateto);
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TTaskInfoCustom> tTaskInfoCustomlist=taskInfoService.findTaskBypage(pagemap);
		List<TTaskInfoCustom> tTaskInfoCustomAlllist=taskInfoService.findAllTaskBypage(pagemap);
		
		map.put("total",tTaskInfoCustomAlllist.size());
		map.put("rows", tTaskInfoCustomlist);
		
		return map;
	}
	
	/*
	 * 删除任务订单信息
	 */
	@RequestMapping(value="/deleteTaskBypk")
	public @ResponseBody String deleteTaskBypk(Integer pks) throws Exception{
		taskInfoService.deleteTaskBypk(pks);
		return "removsuccess";
	}
}
