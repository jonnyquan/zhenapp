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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoService;
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
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
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
	 * 跳转到订单查询界面--代理
	 */
	@RequestMapping(value="/responsetaskmanageagent")
	public ModelAndView responsetaskmanageagent(HttpSession session,Integer page,Integer rows,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		if(taskid!=null){
			pagemap.put("taskid", taskid);
		}
		if(usernick!=null && !usernick.equals("")){
			List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(usernick);
			if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
				pagemap.put("createuser", tUserInfoCustomlist.get(0).getUserid());
			}else{
				pagemap.put("createuser", "未查询到该用户信息!");
			}
		}
		if(taskkeynum!=null){
			pagemap.put("taskkeynum", taskkeynum);
		}
		if(tasktype!=null){
			pagemap.put("tasktype", tasktype);
		}
		pagemap.put("userid", tUserInfoCustom.getUserid());
		int total = 0;
		/*
		* 代理用户
		*/
		tTaskInfoCustomlist = taskInfoService.findTaskBypageAndrole(pagemap);
		total = taskInfoService.findTotalTaskBypageAndrole(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/agent/tasklist.jsp");
		return mv;
	}
	
	/*
	 * 跳转到任务管理界面
	 */
	@RequestMapping(value="/responsetaskmanage")
	public ModelAndView responsetaskmanage(HttpSession session,Integer page,Integer rows,String keyword,String title,String status,String datefrom,String dateto) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		
		HashMap<String,Object> pagemap=new HashMap<String,Object>();

		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(keyword!=null){
			pagemap.put("keyword", keyword);
		}
		if(title!=null){
			pagemap.put("title", title);
		}
		if(status!=null){
			pagemap.put("status", status);
		}
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		
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
		
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/task/taskmanage.jsp");
		return mv;
	}
	/*
	 * 删除任务
	 */
	@RequestMapping(value="/deleteTaskBypk/{taskpk}")
	public ModelAndView deleteTaskBypk(HttpSession session,@PathVariable(value="taskpk")String taskpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		taskInfoService.deleteTaskBypk(taskpk);
		
		mv.setViewName("/task/responsetaskmanage");
		return mv;
	}
	
	/*
	 * 跳转到订单查询界面-----系统管理员
	 */
	@RequestMapping(value="/responsetaskmanageadmin")
	public ModelAndView responsetaskmanageadmin(HttpSession session,Integer page,Integer rows,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		if(taskid!=null){
			pagemap.put("taskid", taskid);
		}
		if(usernick!=null && !usernick.equals("")){
			List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserBynick(usernick);
			if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
				pagemap.put("createuser", tUserInfoCustomlist.get(0).getUserid());
			}else{
				pagemap.put("createuser", "未查询到该用户信息!");
			}
		}
		if(taskkeynum!=null){
			pagemap.put("taskkeynum", taskkeynum);
		}
		if(tasktype!=null){
			pagemap.put("tasktype", tasktype);
		}
		pagemap.put("userid", tUserInfoCustom.getUserid());
		int total = 0;
		/*
		* 系统管理员
		*/
		tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/tasklist.jsp");
		return mv;
	}
	/*
	 * 跳转到有问题任务查询界面-----系统管理员
	 */
	@RequestMapping(value="/findproblemtaskadmin")
	public ModelAndView findproblemtaskadmin(HttpSession session,Integer page,Integer rows,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		if(taskid!=null){
			pagemap.put("taskid", taskid);
		}
		
		pagemap.put("userid", tUserInfoCustom.getUserid());
		int total = 0;
		/*
		* 系统管理员
		*/
		tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		total = taskInfoService.findTotalTaskBypage(pagemap);
		
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/findproblemtask.jsp");
		return mv;
	}
	/*
	 * 跳转到任务详情界面-----系统管理员
	 */
	@RequestMapping(value="/findtaskdetaillist")
	public ModelAndView findtaskdetaillist(HttpSession session,Integer page,Integer rows,String phoneid,String taskkeynum,String taskid,String taskhour) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(phoneid !=null){
			pagemap.put("phoneid", phoneid);
		}
		if(taskkeynum!=null){
			pagemap.put("taskkeynum", taskkeynum);
		}
		if(taskid!=null){
			pagemap.put("taskid", taskid);
		}
		if(taskhour!=null){
			pagemap.put("taskhour", taskhour);
		}
		pagemap.put("userid", tUserInfoCustom.getUserid());
		int total = 0;
		/*
		* 系统管理员
		*/
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/taskdetaillist.jsp");
		return mv;
	}
	/*
	 * 跳转卡机任务查询界面-----系统管理员
	 */
	@RequestMapping(value="/findtasklocklist")
	public ModelAndView findtasklocklist(HttpSession session,Integer page,Integer rows,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		List<TTaskInfoCustom> tTaskInfoCustomlist =new ArrayList<TTaskInfoCustom>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		if(taskid!=null){
			pagemap.put("taskid", taskid);
		}
		
		pagemap.put("userid", tUserInfoCustom.getUserid());
		int total = 0;
		/*
		* 系统管理员
		*/
		tTaskInfoCustomlist = taskInfoService.findTaskBypage(pagemap);
		total = taskInfoService.findTotalTaskBypage(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/tasklocklist.jsp");
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
	 * 发布任务 新增订单信息
	 */
	@RequestMapping(value="/saveTaskInfo")
	public @ResponseBody ModelMap saveTaskInfo(HttpServletRequest request, TTaskInfoCustom tTaskInfoCustom,String taskkeywords) throws Exception{
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
		tTaskInfoCustom.setTaskreleasekeyword(taskkeywords);
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
