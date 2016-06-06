package com.zhenapp.controller.back.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
@RequestMapping(value="/task")
public class ResponseTaskManageController {
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private TaskInfoService taskInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 跳转到任务管理界面-----任务管理
	 */
	@RequestMapping(value="/responsetaskmanage")
	public @ResponseBody ModelAndView responsetaskmanage(HttpSession session,Integer page,String taskpk,String taskkeynum,String keyword,String tasktype,String datefrom,String dateto,String taskstate) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("keyword", keyword);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("tasktype", tasktype);
		pagemap.put("taskstate", taskstate);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("today", yyyyMMdd.format(new Date()));
		//普通用户
		pagemap.put("userid", tUserInfoCustom.getUserid());
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		int total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("keyword", keyword);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("tasktype", tasktype);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.addObject("taskstate", taskstate);
		mv.setViewName("/backstage/task/taskmanage.jsp");
		return mv;
	}
	/*
	 * 跳转到任务管理界面-----历史任务管理
	 */
	@RequestMapping(value="/responsetaskmanagebefore")
	public @ResponseBody ModelAndView responsetaskmanagebefore(HttpSession session,Integer page,String taskpk,String taskkeynum,String keyword,String tasktype,String datefrom,String dateto,String taskstate) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("keyword", keyword);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("tasktype", tasktype);
		pagemap.put("taskstate", taskstate);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//普通用户
		pagemap.put("userid", tUserInfoCustom.getUserid());
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		int total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("keyword", keyword);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("tasktype", tasktype);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.addObject("taskstate", taskstate);
		mv.setViewName("/backstage/task/taskmanagebefore.jsp");
		return mv;
	}
}
