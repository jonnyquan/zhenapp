package com.zhenapp.controller.api;

import java.awt.Point;
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

import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
/*
 * 任务分配
 */

@Controller
@RequestMapping(value="/test")
public class Taskallocation {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/allocation")
	public @ResponseBody ModelMap allocation() throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> hashmap1=new HashMap<String,Object>();
		hashmap1.put("taskstate", 15);
		hashmap1.put("taskstartdate", sdf.format(new Date()));
		Date date = new Date();
		int hours = date.getHours()+1;
		List<TTaskInfoCustom> tTaskInfoCustomlist= taskInfoService.findTaskallocation(hashmap1);
		
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom=tTaskInfoCustomlist.get(i);
			
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
			TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
			HashMap<String,Object> hashmap2=new HashMap<String,Object>();
			/*
			 * 发流量，无购物车，无收藏
			 */
			String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
			if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() == 0 && tTaskInfoCustom.getShoppingcount() == 0){
				for (int j = 0; j < hourarr.length; j++) {
					if(!hourarr[j].equals("0") && j < hours){//当天大于当前小时的不分配
						int hourcount = Integer.parseInt(hourarr[j]);
						int [] minute = new int[hourcount];
						for(int a=0;a<hourcount ; a++){
							minute[a]=a*60/hourcount;
						}
						for (int j2 = 0; j2 < minute.length; j2++) {
							hashmap2.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
							hashmap2.put("taskdate", tTaskInfoCustom.getTaskstartdate());
							TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
							tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
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
							tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts1()));
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
				int collectioncount = tTaskInfoCustom.getCollectioncount();
					for (int j = 0; j < hourarr.length; j++) {
						if(!hourarr[j].equals("0") && j < hours){//当天大于当前小时的不分配
							int hourcount = Integer.parseInt(hourarr[j]);
							int [] minute = new int[hourcount];
							for(int a=0;a<hourcount ; a++){
								minute[a]=a*60/hourcount;
							}
							for (int j2 = 0; j2 < minute.length; j2++) {
								hashmap2.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
								hashmap2.put("taskdate", tTaskInfoCustom.getTaskstartdate());
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIsflow("1");
								collectioncount=collectioncount-1;
								if(collectioncount==0){
									tTaskDetailInfoCustom.setIscollection("0");
									tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts1()));
								}else{
									collectioncount = collectioncount -1 ;
									tTaskDetailInfoCustom.setIscollection("1");
									tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts1()+Integer.parseInt(tPriceInfoCustom.getPricecounts2())));
								}
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
			}
			/*
			 * 发流量，有购物车，无收藏
			 */
			else if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() == 0 && tTaskInfoCustom.getShoppingcount() > 0){
				int shoppingcount = tTaskInfoCustom.getShoppingcount();
					for (int j = 0; j < hourarr.length; j++) {
						if(!hourarr[j].equals("0") && j < hours){//当天大于当前小时的不分配
							int hourcount = Integer.parseInt(hourarr[j]);
							int [] minute = new int[hourcount];
							for(int a=0;a<hourcount ; a++){
								minute[a]=a*60/hourcount;
							}
							for (int j2 = 0; j2 < minute.length; j2++) {
								hashmap2.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
								hashmap2.put("taskdate", tTaskInfoCustom.getTaskstartdate());
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIsflow("1");
								tTaskDetailInfoCustom.setIscollection("0");
								shoppingcount=shoppingcount-1;
								if(shoppingcount==0){
									tTaskDetailInfoCustom.setIsshopping("0");
									tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts1()));
								}else{
									shoppingcount = shoppingcount -1;
									tTaskDetailInfoCustom.setIsshopping("1");
									tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts1()+Integer.parseInt(tPriceInfoCustom.getPricecounts3())));
								}
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
			}
			/*
			 * 发流量，有购物车，有收藏
			 */
			else if(tTaskInfoCustom.getFlowcount() > 0 && tTaskInfoCustom.getCollectioncount() > 0 && tTaskInfoCustom.getShoppingcount() > 0){
				int shoppingcount = tTaskInfoCustom.getShoppingcount();
				int collectioncount = tTaskInfoCustom.getCollectioncount();
				for (int j = 0; j < hourarr.length; j++) {
					if(!hourarr[j].equals("0") && j < hours){//当天大于当前小时的不分配
						int hourcount = Integer.parseInt(hourarr[j]);
						int [] minute = new int[hourcount];
						for(int a=0;a<hourcount ; a++){
							minute[a]=a*60/hourcount;
						}
						for (int j2 = 0; j2 < minute.length; j2++) {
							hashmap2.put("taskkeynum", tTaskInfoCustom.getTaskkeynum());
							hashmap2.put("taskdate", tTaskInfoCustom.getTaskstartdate());
							TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
							tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
							tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
							tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
							tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
							tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
							tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
							tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
							tTaskDetailInfoCustom.setIsflow("1");
							int count=Integer.parseInt(tPriceInfoCustom.getPricecounts1());
							if(collectioncount==0){
								tTaskDetailInfoCustom.setIscollection("0");
							}else{
								count = count + Integer.parseInt(tPriceInfoCustom.getPricecounts2());
								collectioncount= collectioncount-1;
								tTaskDetailInfoCustom.setIscollection("1");
							}
							shoppingcount=shoppingcount-1;
							if(shoppingcount==0){
								tTaskDetailInfoCustom.setIsshopping("0");
							}else{
								count = count + Integer.parseInt(tPriceInfoCustom.getPricecounts2());
								shoppingcount= shoppingcount-1;
								tTaskDetailInfoCustom.setIsshopping("1");
							}
							tTaskDetailInfoCustom.setSubtractpoints(count);
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
			}
		}
		return map;
	}
}
