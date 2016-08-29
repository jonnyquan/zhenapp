package com.zhenapp.controller.apitest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Service
public class CheckTaskallocationztcService {
	private static Logger logger = Logger.getLogger(CheckTaskallocationztcService.class);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hh = new SimpleDateFormat("HH");
	SimpleDateFormat mm = new SimpleDateFormat("mm");
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	
	/*
	 * 任务分配
	 */
	public @ResponseBody ModelMap allocationService(TTaskInfoCustom tTaskInfoCustom) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tTaskInfoCustom.getCreateuser());
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
		int []arrztc = new int[hourcount];
		int ztccount=0;
		for (int i = 0; i < hourarr.length; i++) {
			if(!hourarr[i].equals("0")){
				arrztc[ztccount]=Integer.parseInt(hourarr[i]);
				ztccount++;
			}
		}
		int collectioncounttemp = 0;
		int []collectionarrztc = new int[hourcount];
		for (int i = 0; i < hourcount; i++) {
			collectionarrztc[i] = arrztc[i]*tTaskInfoCustom.getCollectioncount()/tTaskInfoCustom.getFlowcount();
			collectioncounttemp =collectioncounttemp+collectionarrztc[i];
		}
		int Collectioncountys = tTaskInfoCustom.getCollectioncount() - collectioncounttemp;
		for (int i = 0; i < Collectioncountys; i++) {
			collectionarrztc[i] = collectionarrztc[i] + 1;
		}
		int count=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				int collectionhoursumztc = collectionarrztc[count];//每小时分配的收藏数
				int hoursumztc = arrztc[count];//每小时分配的流量数
				count=count+1;
				int [] collectionminuteztc = new int[collectionhoursumztc];
				for(int a=0;a<collectionhoursumztc ; a++){
					collectionminuteztc[a]=a*60/collectionhoursumztc;
				}
				int [] minuteztc = new int[hoursumztc];
				for(int a=0;a<hoursumztc ; a++){
					minuteztc[a]=a*60/hoursumztc;
				}
				
				//1.先分配单独的直通车流量
				for (int i = collectionminuteztc.length; i < minuteztc.length; i++) {
					TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
					tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
					tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
					tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
					tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
					tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
					tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
					tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskprice());
					tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
					tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
					tTaskDetailInfoCustom.setTaskimgztc(tTaskInfoCustom.getTaskimgztc());
					tTaskDetailInfoCustom.setDrillimg(tTaskInfoCustom.getDrillimg());
					tTaskDetailInfoCustom.setOrdernum(i);
					tTaskDetailInfoCustom.setCreativetitle(tTaskInfoCustom.getCreativetitle());
					tTaskDetailInfoCustom.setIscollection("0");
					tTaskDetailInfoCustom.setIsshopping("0");
					tTaskDetailInfoCustom.setIsstorecollection("0");
					tTaskDetailInfoCustom.setIsfakechat("0");
					tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
					tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
					tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts4()));
					tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskdate());
					tTaskDetailInfoCustom.setTaskhour(j);
					if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
						tTaskDetailInfoCustom.setTaskminute(minuteztc[i]);
						if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
							&& j< Integer.parseInt(hh.format(new Date())) && minuteztc[i] < Integer.parseInt(mm.format(new Date()))){
							tTaskDetailInfoCustom.setTaskstate("23");
						}else{
							tTaskDetailInfoCustom.setTaskstate("40");
						}
					}else{
						tTaskDetailInfoCustom.setTaskminute(0);
						if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
							&& j < Integer.parseInt(hh.format(new Date())) && 0 < Integer.parseInt(mm.format(new Date()))){
							tTaskDetailInfoCustom.setTaskstate("23");
						}else{
							tTaskDetailInfoCustom.setTaskstate("40");
						}
					}
					tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
					tTaskDetailInfoCustom.setCreateuser(tTaskInfoCustom.getCreateuser());
					tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
					tTaskDetailInfoCustom.setUpdateuser(tTaskInfoCustom.getCreateuser());
					taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
				}
				//2.再分配绑定的
				for (int i = 0; i < collectionminuteztc.length; i++) {
					TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
					tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
					tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
					tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
					tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
					tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
					tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
					tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskprice());
					tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
					tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
					tTaskDetailInfoCustom.setTaskimgztc(tTaskInfoCustom.getTaskimgztc());
					tTaskDetailInfoCustom.setDrillimg(tTaskInfoCustom.getDrillimg());
					tTaskDetailInfoCustom.setOrdernum(i);
					tTaskDetailInfoCustom.setCreativetitle(tTaskInfoCustom.getCreativetitle());
					tTaskDetailInfoCustom.setIscollection("1");
					tTaskDetailInfoCustom.setIsshopping("1");
					tTaskDetailInfoCustom.setIsstorecollection("0");
					tTaskDetailInfoCustom.setIsfakechat("0");
					tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
					tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
					tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts4())+Integer.parseInt(tPriceInfoCustom.getPricecounts5())+Integer.parseInt(tPriceInfoCustom.getPricecounts6()));
					tTaskDetailInfoCustom.setTaskdate(tTaskInfoCustom.getTaskdate());
					tTaskDetailInfoCustom.setTaskhour(j);
					if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
						tTaskDetailInfoCustom.setTaskminute(collectionminuteztc[i]);
						if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
							&& j< Integer.parseInt(hh.format(new Date())) && collectionminuteztc[i] < Integer.parseInt(mm.format(new Date()))){
							tTaskDetailInfoCustom.setTaskstate("23");
						}else{
							tTaskDetailInfoCustom.setTaskstate("40");
						}
					}else{
						tTaskDetailInfoCustom.setTaskminute(0);
						if(Integer.parseInt(tTaskInfoCustom.getTaskdate())<=Integer.parseInt(yyyyMMdd.format(new Date()))
							&& j< Integer.parseInt(hh.format(new Date())) && 0 < Integer.parseInt(mm.format(new Date()))){
							tTaskDetailInfoCustom.setTaskstate("23");
						}else{
							tTaskDetailInfoCustom.setTaskstate("40");
						}
					}
					tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
					tTaskDetailInfoCustom.setCreateuser(tTaskInfoCustom.getCreateuser());
					tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
					tTaskDetailInfoCustom.setUpdateuser(tTaskInfoCustom.getCreateuser());
					taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
				}
			}
		}
		HashMap<String,Object> hashmap3=new HashMap<String,Object>();
		hashmap3.put("taskid", tTaskInfoCustom.getTaskid());
		hashmap3.put("taskstate", "16");//任务运行中
		hashmap3.put("updatetime", sdf.format(new Date()));
		hashmap3.put("updateuser", "拆分任务");
		hashmap3.put("oldfinshtaskstate", "15");
		int i= taskInfoService.updateTaskstate(hashmap3);
		if(i<1){
			logger.error("任务："+tTaskInfoCustom.getTaskpk()+"已经拆分过了");
		}
		return map;
	}
}
