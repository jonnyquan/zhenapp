package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;

@Controller
@RequestMapping(value="/task")
public class TaskInfoController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	
	/*
	 * 跳转到发布任务界面
	 */
	@RequestMapping(value="/responsetaskadd")
	public ModelAndView responsetaskadd(HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
	
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());//根据登陆用户查询所属代理信息
		try{
			TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());//根据代理信息查询所设置的价格信息
			mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		}catch(NullPointerException e){
			System.out.println("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
		
		mv.setViewName("/backstage/task/taskadd.jsp");
		return mv;
	}
	/*
	 * 跳转到任务管理界面
	 */
	@RequestMapping(value="/responsetaskmanage")
	public ModelAndView responsetaskmanage() throws Exception{
		ModelAndView mv=new ModelAndView();
		
		
		mv.setViewName("/backstage/task/taskmanage.jsp");
		return mv;
	}
	
	
	
//=================================================================================================================
	
	/*
	 * 查询价格信息  转发到发布任务界面
	 */
	@RequestMapping(value="/findPriceToTask")
	public ModelAndView findPriceToTask(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());//根据登陆用户查询所属代理信息
		try{
			TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());//根据代理信息查询所设置的价格信息
			mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
		}catch(NullPointerException e){
			System.out.println("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
		mv.setViewName("/page/task/tasklladd.jsp");
		return mv;
	}
	

	/*
	 * 查询任务订单信息
	 */
	@RequestMapping(value="/findTaskBypage")
	public @ResponseBody ModelMap findTaskBypage(HttpServletRequest request,Integer page, Integer rows,String taskid,String datefrom,String dateto) throws Exception{
		ModelMap map=new ModelMap();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		
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
		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		int total = 0;
		if(tUserInfoCustom.getUserroleid()==1){
			/*
			 * 系统管理员
			 */
			tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
			total = taskInfoService.findTotalTaskBypage(pagemap);
		}else if(tUserInfoCustom.getUserroleid()==2){
			/*
			 * 代理用户
			 */
			tTaskInfoCustomlist = taskInfoService.findTaskBypageAndrole(pagemap);
			total = taskInfoService.findTotalTaskBypageAndrole(pagemap);
		}else{
			/*
			 * 普通用户
			 */
			pagemap.put("userid", tUserInfoCustom.getUserid());
			tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
			total = taskInfoService.findTotalTaskBypage(pagemap);
		}
		
		
		map.put("total",total);
		map.put("rows", tTaskInfoCustomlist);
		
		return map;
	}
	
	/*
	 * 删除任务订单信息
	 */
	@RequestMapping(value="/deleteTaskBypk")
	public @ResponseBody String deleteTaskBypk(String pks) throws Exception{
		taskInfoService.deleteTaskBypk(pks);
		return "removsuccess";
	}
	/*
	 * 发布任务 新增订单信息
	 */
	@RequestMapping(value="/insertTaskInfo")
	public @ResponseBody ModelMap insertTaskInfo(HttpServletRequest request, TTaskInfoCustom tTaskInfoCustom,String taskkeywords) throws Exception{
		ModelMap map=new ModelMap();
		/*
		 * 查询系统配置项中是否禁止发布任务
		 */
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		
		Date date = new Date();
		int hours = date.getHours()+1;
		int days = DateUtilWxf.getBetweenDays(tTaskInfoCustom.getTaskstartdate().replace("-", ""), tTaskInfoCustom.getTaskenddate().replace("-", ""));
		String [] taskkeywordarr=taskkeywords.split("====");
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		int flowcounts = 0;
		int subflowcounts = 0;
		for (int i = 0; i < hourarr.length; i++) {
			flowcounts = flowcounts + Integer.parseInt(hourarr[i]);
		}
		for (int i = 0; i < hours; i++) {
			subflowcounts = subflowcounts + Integer.parseInt(hourarr[i]);
		}
		int flowpoints = flowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1()) * taskkeywordarr.length * (days + 1)  - subflowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		int Collectionpoints = tTaskInfoCustom.getCollectioncount() * Integer.parseInt(tPriceInfoCustom.getPricecounts2());
		int Shoppingpoints = tTaskInfoCustom.getShoppingcount() * Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		int subtractpoints=flowpoints + Collectionpoints + Shoppingpoints;
		
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
			return map;
		}
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		
		tTaskInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
		tTaskInfoCustom.setTaskkeyword(taskkeywords);
		tTaskInfoCustom.setTaskstartdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		tTaskInfoCustom.setTaskenddate(tTaskInfoCustom.getTaskenddate().replace("-", ""));
		tTaskInfoCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());
		tTaskInfoCustom.setTaskminprice(tTaskInfoCustom.getTaskminprice());
		tTaskInfoCustom.setTaskmaxprice(tTaskInfoCustom.getTaskmaxprice());
		tTaskInfoCustom.setTasksearchtype(tTaskInfoCustom.getTasksearchtype());
		tTaskInfoCustom.setFlowcount(tTaskInfoCustom.getFlowcount());
		tTaskInfoCustom.setCollectioncount(tTaskInfoCustom.getCollectioncount());
		tTaskInfoCustom.setShoppingcount(tTaskInfoCustom.getShoppingcount());
		tTaskInfoCustom.setSubtractpoints(subtractpoints);
		tTaskInfoCustom.setTaskstate("15");//待分配状态
		tTaskInfoCustom.setCreatetime(sdf.format(new Date()));
		tTaskInfoCustom.setUpdatetime(sdf.format(new Date()));
		tTaskInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tTaskInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		for (int i = 0; i <= days; i++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskdate(sdf.format(date));
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
			map.put("data", "insertsuccess");
			/*
			 * 扣除消耗的积分
			 */
			tUserInfoCustom.setPoints(Integer.parseInt(points)-subtractpoints);
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			/*
			 * 添加积分明细记录
			 */
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("sys");
			tPointsInfoCustom.setPointreason("发布任务消耗积分"+subtractpoints);
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
			tPointsInfoCustom.setPointstype("27");
			tPointsInfoCustom.setPointsupdate(subtractpoints);
			tPointsInfoCustom.setTaskid("0");
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
		return map;
	}
	
}
