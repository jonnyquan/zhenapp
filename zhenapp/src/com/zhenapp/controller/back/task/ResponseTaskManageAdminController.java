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
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

@Controller
@RequestMapping(value="/task")
public class ResponseTaskManageAdminController {
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private TaskInfoService taskInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到订单查询界面-----系统管理员		当前订单管理
	 */
	@RequestMapping(value="/responsetaskmanageadmin")
	public ModelAndView responsetaskmanageadmin(HttpSession session,Integer page,String taskpk,String taskkeyword,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskkeyword", taskkeyword);
		pagemap.put("tasktype", tasktype);
		pagemap.put("today", yyyyMMdd.format(new Date()));
		//系统管理员
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		int total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskkeyword", taskkeyword);
		mv.addObject("tasktype", tasktype);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.setViewName("/backstage/admin/tasklist.jsp");
		return mv;
	}
	/*
	 * 跳转到订单查询界面-----系统管理员		当前订单管理
	 */
	@RequestMapping(value="/responsetaskmanageadminbefore")
	public ModelAndView responsetaskmanageadminbefore(HttpSession session,Integer page,String taskpk,String taskkeyword,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskkeyword", taskkeyword);
		pagemap.put("tasktype", tasktype);
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//系统管理员
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		int total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskkeyword", taskkeyword);
		mv.addObject("tasktype", tasktype);
		mv.addObject("datefrom", datefrom);
		mv.addObject("dateto", dateto);
		mv.setViewName("/backstage/admin/tasklistbefore.jsp");
		return mv;
	}
		
}
