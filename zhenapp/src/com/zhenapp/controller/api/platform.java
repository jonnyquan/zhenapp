package com.zhenapp.controller.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.OrderInfoCustom;
import com.zhenapp.po.Custom.OrderReturnInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;
import com.zhenapp.util.MD5Util;
import com.zhenapp.util.StringUtilWxf;

@Controller
@RequestMapping(value="/api/platform")
public class platform {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	
	/*
	 * API接口中 获取余额  restful风格
	 */
	@RequestMapping(value="/searchBalance/{partnerId}/{password}")
	public @ResponseBody ModelMap searchBalance(@PathVariable(value="partnerId") String partnerId,@PathVariable(value="password") String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=new TUserInfoCustom();
		tUserInfoCustom.setUsernick(partnerId);
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(password));
		String points=userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("code", "200");
		map.put("desc", points==null?"0":points);
		return map;
	}
	
	/*
	 * API接口中 获取余额  表单提交方式
	 */
	@RequestMapping(value="/searchBalance")
	public @ResponseBody ModelMap searchBalance_2(String partnerId,String password) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=new TUserInfoCustom();
		tUserInfoCustom.setUsernick(partnerId);
		tUserInfoCustom.setUserpwd(MD5Util.string2MD5(password));
		String points=userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("code", "200");
		map.put("desc", points);
		return map;
	}
	
	
	
	/*
	 * 递交订单方式 表单提交
	 * 
	 */
	@RequestMapping(value="/flow/save")
	public @ResponseBody ModelMap flowsave(String partnerId,String data,String validation) throws Exception{
		ModelMap map=new ModelMap();
		List<OrderReturnInfoCustom> orderReturnInfoCustomlist = new ArrayList<OrderReturnInfoCustom>();
		List<TUserInfoCustom> tUserinfoCustomlist=userInfoService.findUserBynick(partnerId);
		if(tUserinfoCustomlist.size()<0){
			map.put("code", "0");
			map.put("desc", "用户不存在");
			return map;
		}
		TUserInfoCustom tUserInfoCustom=tUserinfoCustomlist.get(0);
		String validationtest=MD5Util.string2MD5(tUserInfoCustom.getUsernick()+tUserInfoCustom.getUserpwd()+tUserInfoCustom.getUsernick());
		if(!validation.equals(validationtest)){
			map.put("code", "0");
			map.put("desc", "用户信息校验失败");
			return map;
		}
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("code", "0");
			map.put("desc", "系统暂时禁止发布任务");
			return map;
		}
		ObjectMapper obj = new ObjectMapper();
		OrderInfoCustom orderInfoCustom = obj.readValue(data, OrderInfoCustom.class);
		orderInfoCustom.setKwd(StringUtilWxf.trimFirstAndLastChar(orderInfoCustom.getKwd(), "===="));
		String [] taskkeywordarr=orderInfoCustom.getKwd().split("====");
		Date date = sdf.parse(orderInfoCustom.getTaskstartdate().replace("-", ""));
		int days = DateUtilWxf.getBetweenDays(orderInfoCustom.getTaskstartdate().replace("-", ""), orderInfoCustom.getTaskenddate().replace("-", ""));
		TTaskInfoCustom tTaskInfoCustom=new TTaskInfoCustom();
		tTaskInfoCustom.setTasktype(orderInfoCustom.getKtype());
		tTaskInfoCustom.setTaskkeynum(orderInfoCustom.getNid());
		tTaskInfoCustom.setTaskreleasekeyword(orderInfoCustom.getKwd());
		tTaskInfoCustom.setTaskstartdate(orderInfoCustom.getTaskstartdate().replace("-", ""));
		tTaskInfoCustom.setTaskenddate(orderInfoCustom.getTaskenddate().replace("-", ""));
		tTaskInfoCustom.setTaskhourcounts(orderInfoCustom.getTimecontrol());
		tTaskInfoCustom.setTaskminprice(orderInfoCustom.getMinPrice());
		tTaskInfoCustom.setTaskmaxprice(orderInfoCustom.getMaxPrice());
		tTaskInfoCustom.setTasksearchtype(orderInfoCustom.getSearchType());
		tTaskInfoCustom.setFlowcount(orderInfoCustom.getTotalTask());
		tTaskInfoCustom.setCollectioncount(orderInfoCustom.getTotalCollectProduct());
		tTaskInfoCustom.setShoppingcount(orderInfoCustom.getTotalShoppingCart());
		tTaskInfoCustom.setTaskstate("15");
		tTaskInfoCustom.setCreatetime(sdf.format(new Date()));
		tTaskInfoCustom.setUpdatetime(sdf.format(new Date()));
		tTaskInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tTaskInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		for (int i = 0; i <= days; i++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskdate(sdf.format(date));
				tTaskInfoCustom.setTaskstate("15");//待分配状态
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				OrderReturnInfoCustom orderReturnInfoCustom = new OrderReturnInfoCustom();
				orderReturnInfoCustom.setCode(200);
				orderReturnInfoCustom.setFid(tTaskInfoCustom.getTaskid());
				orderReturnInfoCustom.setDesc("下单成功");
				orderReturnInfoCustomlist.add(orderReturnInfoCustom);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		map.put("orderReturnInfoCustomlist", orderReturnInfoCustomlist);
		return map;
	}
	
	
	
	/*
	 * 查询订单
	 * partnerId 用户名
	 * 
	 * password 密码
	 * 
	 * fid 订单号
	 */
	@RequestMapping(value="/search/flow")
	public @ResponseBody ModelMap searchflow(String partnerId,String password,String fid) throws Exception{
		ModelMap map=new ModelMap();
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(partnerId);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()==1){
			if(tUserInfoCustomlist.get(0).getUserpwd().equals(MD5Util.string2MD5(password))){
				HashMap<String, Object> hashmap=new HashMap<String,Object>();
				hashmap.put("taskid", fid);
				hashmap.put("userid", tUserInfoCustomlist.get(0).getUserid());
				List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(hashmap);
				if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size() == 1){
					TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
					map.put("code", 200);
					map.put("msg", "success");
					map.put("fid", tTaskInfoCustom.getTaskid());
					map.put("hascollectamount", tTaskInfoCustom.getFinishcollectioncount());
					map.put("hasamount", tTaskInfoCustom.getFinishflowcount());
					map.put("hastrolleyamount", tTaskInfoCustom.getShoppingcount());
					map.put("status", tTaskInfoCustom.getDicinfoname());
					map.put("description", "");
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
		}
		return map;
	}
	
	
	
	/*
	 * 终止订单
	 */
	@RequestMapping(value="/shutdown")
	public @ResponseBody ModelMap shutdown(String partnerId,String password,String fid) throws Exception{
		ModelMap map = new ModelMap();
		/*
		 * 首先确保该用户能终止该订单
		 */
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(partnerId);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()==1){
			TUserInfoCustom tUserInfoCustom = tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				HashMap<String, Object> hashmap=new HashMap<String,Object>();
				hashmap.put("taskid", fid);
				hashmap.put("userid", tUserInfoCustomlist.get(0).getUserid());
				List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypage(hashmap);
				if(tTaskInfoCustomlist!=null && tTaskInfoCustomlist.size() == 1){
					TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(0);
					/*
					 * 修改任务状态为待分配和运行中的任务 状态为终止中
					 */
					if(tTaskInfoCustom.getTaskstate().equals("15") || tTaskInfoCustom.getTaskstate().equals("16")){
						hashmap.put("taskstate", "18");
						taskInfoService.updateTaskstate(hashmap);
					}
					/*
					 * 修改详细任务信息中待获取状态的数据为执行终止
					 */
					HashMap<String, Object> hashmap1=new HashMap<String,Object>();
					hashmap1.put("taskid", fid);
					hashmap1.put("taskstate", 23);
					int count = taskDetailInfoService.updateterminationstate(hashmap1);
					if(count > 0){
						/*
						 * 根据修改的状态的条件获取修改的详情任务的积分数
						 */
						int points = taskDetailInfoService.findPointsByteterminationstate(fid);
						/*
						 * 插入账户明细
						 */
						TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
						tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
						tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
						tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
						tPointsInfoCustom.setUpdateuser("sys");
						tPointsInfoCustom.setPointreason("终止任务,返回积分："+points);
						tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
						tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()+points);
						tPointsInfoCustom.setPointstype("28");
						tPointsInfoCustom.setPointsupdate(points);
						tPointsInfoCustom.setTaskid("0");
						tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
						pointsInfoService.savePoints(tPointsInfoCustom);
						/*
						 * 修改用户积分
						 */
						tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()+points);
						userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
					}
					hashmap.put("taskstate", "19");
					taskInfoService.updateTaskstate(hashmap);
					
				}else{
					map.put("code", 0);
					map.put("msg", "订单号不存在");
				}
			}else{
				map.put("code", 0);
				map.put("msg", "密码错误");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "用户名错误");
		}
		
		return map;
	}
}
