package com.zhenapp.controller.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
/*
 * 任务分配
 */

@Controller
@RequestMapping(value="/test")
public class Taskallocation {
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PhoneInfoService phoneInfoService;
	
	@RequestMapping(value="/allocation")
	public @ResponseBody ModelMap allocation() throws Exception{
		ModelMap map=new ModelMap();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		HashMap<String,Object> hashmap1=new HashMap<String,Object>();
		hashmap1.put("taskstate", 15);
		hashmap1.put("taskstartdate", sdf.format(new Date()));
		List<TTaskInfoCustom> tTaskInfoCustomlist= taskInfoService.findTaskallocation(hashmap1);
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom=tTaskInfoCustomlist.get(i);
			HashMap<String,Object> hashmap2=new HashMap<String,Object>();
			/*
			 * 发流量，无购物车，无收藏
			 */
			if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() == 0 && tTaskInfoCustom.getShoppingcount() == 0){
				String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
				for (int j = 0; j < hourarr.length; j++) {
					if(!hourarr[j].equals("0")){
						int hourcount = Integer.parseInt(hourarr[j]);
						int [] minute = new int[hourcount];
						for(int a=0;a<hourcount ; a++){
							minute[a]=a*60/hourcount;
						}
						for (int j2 = 0; j2 < minute.length; j2++) {
							hashmap2.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
							hashmap2.put("taskdate", tTaskInfoCustom.getTaskstartdate());
							TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
							tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString());
							tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
							tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
							tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
							tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
							tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
							tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
							tTaskDetailInfoCustom.setIsflow("1");
							tTaskDetailInfoCustom.setIscollection("0");
							tTaskDetailInfoCustom.setIsshopping("0");
							tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
							tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
							tTaskDetailInfoCustom.setTaskstate("1");
							tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskstartdate());
							tTaskDetailInfoCustom.setTaskhour(j+"");
							tTaskDetailInfoCustom.setTaskminute((minute[j2]+"").length()>1?(minute[j2]+""):("0"+minute[j2]));
							tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setCreateuser("sys");
							tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
							tTaskDetailInfoCustom.setUpdateuser("sys");
							taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
						}
					}
				}
				
				/*
				 * 分配完成后修改任务状态
				 */
				int state = taskInfoService.updateTaskstate(tTaskInfoCustom.getTaskid());
				System.out.println(state);
			}
			/*
			 * 发流量，无购物车，有收藏
			 */
			else if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() > 0 && tTaskInfoCustom.getShoppingcount() == 0){
				
			}
			/*
			 * 发流量，有购物车，无收藏
			 */
			else if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() == 0 && tTaskInfoCustom.getShoppingcount() > 0){
				
			}
			/*
			 * 发流量，有购物车，有收藏
			 */
			else if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() > 0 && tTaskInfoCustom.getShoppingcount() > 0){
				
			}
		}
		
		return map;
	}
}
