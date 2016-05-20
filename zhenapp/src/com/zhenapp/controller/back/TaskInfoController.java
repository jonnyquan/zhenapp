package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
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
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
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
	 * 跳转到发布直通车任务界面
	 */
	@RequestMapping(value="/responsetaskztcadd")
	public ModelAndView responsetaskztcadd(HttpSession session) throws Exception{
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
		mv.setViewName("/backstage/task/taskztcadd.jsp");
		return mv;
	}
	/*
	 * 跳转到订单查询界面--代理
	 */
	@RequestMapping(value="/responsetaskmanageagent")
	public ModelAndView responsetaskmanageagent(HttpSession session,Integer page,Integer rows,String datefrom,String dateto,String taskpk,String usernick,String taskkeynum,String taskkeyword,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
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
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskkeyword", taskkeyword);
		pagemap.put("tasktype", tasktype);
		pagemap.put("userid", tUserInfoCustom.getUserid());
		/*
		* 代理用户
		*/
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskBypageAndrole(pagemap);
		int total = taskInfoService.findTotalTaskBypageAndrole(pagemap);
		mv.addObject("tTaskInfoCustomlist", tTaskInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("points", points);
		
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskkeyword", taskkeyword);
		mv.addObject("tasktype", tasktype);
		
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.setViewName("/backstage/agent/tasklist.jsp");
		return mv;
	}
	
	/*
	 * 跳转到任务管理界面
	 */
	@RequestMapping(value="/responsetaskmanage")
	public ModelAndView responsetaskmanage(HttpSession session,Integer page,Integer rows,String taskpk,String taskkeynum,String keyword,String tasktype,String datefrom,String dateto) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("keyword", keyword);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("tasktype", tasktype);
		if(datefrom!=null){
			pagemap.put("datefrom", datefrom.replace("-", "")+"000000");
		}
		if(dateto!=null){
			pagemap.put("dateto", dateto.replace("-", "")+"235959");
		}
		/*
		 * 普通用户
		 */
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
	 * 批量删除任务
	 */
	
	@RequestMapping(value="/deletetaskByPks/{pks}")
	public ModelAndView deletetaskByIds(@PathVariable(value="pks") String pks) throws Exception{
		ModelAndView mv = new ModelAndView();
		String [] pkarr = pks.split("==");
		String pk="";
		for (int i = 0; i < pkarr.length; i++) {
			pk= pk + pkarr[i]+",";
		}
		pk= pk.substring(0, pk.length()-1);
		taskInfoService.deleteTaskBypk(pk);
		mv.setViewName("/task/responsetaskmanage");
		return mv;
	}
	
	/*
	 * 跳转到订单查询界面-----系统管理员
	 */
	@RequestMapping(value="/responsetaskmanageadmin")
	public ModelAndView responsetaskmanageadmin(HttpSession session,Integer page,Integer rows,String taskpk,String taskkeyword,String datefrom,String dateto,String taskid,String usernick,String taskkeynum,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
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
		/*
		* 系统管理员
		*/
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
	 * 跳转到有问题任务查询界面-----系统管理员
	 */
	@RequestMapping(value="/findproblemtaskadmin")
	public ModelAndView findproblemtaskadmin(Integer page,Integer rows,String phoneid,String taskkeynum,String taskpk,String hours) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskpk", taskpk);
		pagemap.put("hours", hours);
		/*
		* 系统管理员
		*/
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskpk", taskpk);
		mv.addObject("hours", hours);
		mv.setViewName("/backstage/admin/findproblemtask.jsp");
		return mv;
	}
	/*
	 * 跳转到任务详情界面-----系统管理员
	 */
	@RequestMapping(value="/findtaskdetaillist")
	public ModelAndView findtaskdetaillist(Integer page,Integer rows,String tasktype,String phoneid,String taskkeynum,String taskid,String taskhour) throws Exception{
		ModelAndView mv=new ModelAndView();
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
		if(tasktype != null){
			pagemap.put("tasktype", tasktype);
		}
		/*
		* 系统管理员
		*/
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
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
	public ModelAndView findtasklocklist(Integer page,Integer rows,String taskdetailpk,String phoneid,String taskkeynum) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskdetailpk", taskdetailpk);
		/*
		* 系统管理员
		*/
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskdetailpk", taskdetailpk);
		mv.setViewName("/backstage/admin/tasklocklist.jsp");
		return mv;
	}
	
	/*
	 * 根据任务id终止任务
	 */
	@RequestMapping(value="/endtaskBytaskid/{taskid}")
	public @ResponseBody ModelMap endtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskid", taskid);
		hashmap.put("taskstate", 18);
		taskInfoService.updateTaskstate(hashmap);
		taskDetailInfoService.updateterminationstate(hashmap);
		int points = taskDetailInfoService.findPointsByteterminationstate(taskid);
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		/*
		 * 添加终止任务所返回的积分
		 */
		tUserInfoCustom.setPoints(tUserInfoCustom.getPoints() + points);
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		/*
		 * 添加积分明细记录
		 */
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason("终止任务返回积分"+points);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints());
		tPointsInfoCustom.setPointstype("28");
		tPointsInfoCustom.setPointsupdate(points);
		tPointsInfoCustom.setTaskid(taskid);
		tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		map.put("data", "success");
		return map;
	}
	
	/*
	 * 再次发布任务
	 */
	@RequestMapping(value="/againtaskBytaskid/{taskid}")
	public @ResponseBody ModelMap againtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelMap map = new ModelMap();
		TTaskInfoCustom tTaskInfoCustom = taskInfoService.findTaskInfoByTaskid(taskid);
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		Date date = new Date();
		long curren = System.currentTimeMillis();
		curren += 60 * 60 * 1000;
		Date da = new Date(curren);
		SimpleDateFormat dateFormat = new SimpleDateFormat( "HH");
		int hours = Integer.parseInt(dateFormat.format(da));
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		int flowcounts = 0;
		int subflowcounts = 0;
		for (int i = 0; i < hourarr.length; i++) {
			flowcounts = flowcounts + Integer.parseInt(hourarr[i]);
		}
		for (int i = 0; i < hours; i++) {
			subflowcounts = subflowcounts + Integer.parseInt(hourarr[i]);
		}
		int flowpoints = flowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1())  - subflowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		int Collectionpoints = tTaskInfoCustom.getCollectioncount() * Integer.parseInt(tPriceInfoCustom.getPricecounts2());
		int Shoppingpoints = tTaskInfoCustom.getShoppingcount() * Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		int subtractpoints=flowpoints + Collectionpoints + Shoppingpoints;
		
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
			return map;
		}
		
		/*
		 * 查询系统配置项中是否禁止发布任务
		 */
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		tTaskInfoCustom.setTasktitle(tTaskInfoCustom.getTasktitle());
		tTaskInfoCustom.setTaskwirelesstitle(tTaskInfoCustom.getTaskwirelesstitle());
		tTaskInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
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
		tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
		tTaskInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
		tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
		taskInfoService.insertTaskInfo(tTaskInfoCustom);
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
		tPointsInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
		tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
	
	
		map.put("data", "success");
		return map;
	}
//=================================================================================================================
	/*
	 * 发布任务 新增订单信息
	 */
	@RequestMapping(value="/saveTaskInfo")
	public @ResponseBody ModelMap saveTaskInfo(HttpSession session, TTaskInfoCustom tTaskInfoCustom,String taskkeywords) throws Exception{
		ModelMap map=new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid(tUserInfoCustom.getAgentid());
		Date date = new Date();
		long curren = System.currentTimeMillis();
		curren += 60 * 60 * 1000;
		Date da = new Date(curren);
		SimpleDateFormat dateFormat = new SimpleDateFormat( "HH");
		int hours = Integer.parseInt(dateFormat.format(da));
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
		
		/*
		 * 查询系统配置项中是否禁止发布任务
		 */
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		tTaskInfoCustom.setTasktitle(tTaskInfoCustom.getTasktitle());
		tTaskInfoCustom.setTaskwirelesstitle(tTaskInfoCustom.getTaskwirelesstitle());
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
				tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
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
		tPointsInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
		tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		return map;
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
		long curren = System.currentTimeMillis();
		curren += 60 * 60 * 1000;
		Date da = new Date(curren);
		SimpleDateFormat dateFormat = new SimpleDateFormat( "HH");
		int hours = Integer.parseInt(dateFormat.format(da));
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
