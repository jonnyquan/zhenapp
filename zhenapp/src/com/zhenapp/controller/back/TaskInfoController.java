package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.MsgInfoCustom;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.DateUtilWxf;
import com.zhenapp.util.StringUtilWxf;
@Transactional
@Controller
@RequestMapping(value="/task")
public class TaskInfoController {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hh = new SimpleDateFormat("HH");
	SimpleDateFormat mm = new SimpleDateFormat("mm");
	private static Logger logger = Logger.getLogger(TaskInfoController.class);
	
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
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	
	@Value("${secret}")
	private String secret;
	@Value("${middleRows}")
	private Integer middleRows;
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
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
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
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
		mv.setViewName("/backstage/task/taskztcadd.jsp");
		return mv;
	}
	/*
	 * 跳转到订单查询界面--代理  当前订单管理
	 */
	@RequestMapping(value="/responsetaskmanageagent")
	public @ResponseBody ModelAndView responsetaskmanageagent(HttpSession session,Integer page,String datefrom,String dateto,String taskpk,String usernick,String taskkeynum,String taskkeyword,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
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
		pagemap.put("today", yyyyMMdd.format(new Date()));
		//代理用户
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
	 * 跳转到订单查询界面--代理  历史订单管理
	 */
	@RequestMapping(value="/responsetaskmanageagentbefore")
	public @ResponseBody ModelAndView responsetaskmanageagentbefore(HttpSession session,Integer page,String datefrom,String dateto,String taskpk,String usernick,String taskkeynum,String taskkeyword,String tasktype) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
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
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//代理用户
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
		mv.setViewName("/backstage/agent/tasklistbefore.jsp");
		return mv;
	}
	
	/*
	 * 跳转到任务管理界面-----任务管理
	 */
	@RequestMapping(value="/responsetaskmanage")
	public ModelAndView responsetaskmanage(HttpSession session,Integer page,String taskpk,String taskkeynum,String keyword,String tasktype,String datefrom,String dateto,String taskstate) throws Exception{
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
		mv.addObject("taskstate", taskstate);
		mv.setViewName("/backstage/task/taskmanage.jsp");
		return mv;
	}
	/*
	 * 跳转到任务管理界面-----历史任务管理
	 */
	@RequestMapping(value="/responsetaskmanagebefore")
	public ModelAndView responsetaskmanagebefore(HttpSession session,Integer page,String taskpk,String taskkeynum,String keyword,String tasktype,String datefrom,String dateto,String taskstate) throws Exception{
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
	public @ResponseBody ModelMap deletetaskByIds(@PathVariable(value="pks") String pks) throws Exception{
		ModelMap map = new ModelMap();
		String [] pkarr = pks.split("==");
		String pk="";
		for (int i = 0; i < pkarr.length; i++) {
			pk= pk + pkarr[i]+",";
		}
		pk= pk.substring(0, pk.length()-1);
		List<TTaskInfoCustom> tTaskInfoCustomlist = taskInfoService.findTaskInfoBypks(pk);
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			if(tTaskInfoCustom.getTaskstate().equals("15")){
				map.put("data", "stateexc");
				return map;
			}
		}
		for (int i = 0; i < tTaskInfoCustomlist.size(); i++) {
			TTaskInfoCustom tTaskInfoCustom = tTaskInfoCustomlist.get(i);
			taskInfoService.deleteTaskBypk(tTaskInfoCustom.getTaskpk()+"");
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("taskid", tTaskInfoCustom.getTaskid());
			taskDetailInfoService.deleteTaskBystate(hashmap);
		}
		
		map.put("data", "success");
		return map;
	}
	
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
	/*
	 * 跳转到任务详情界面-----系统管理员	当前详情查询
	 */
	@RequestMapping(value="/findtaskdetaillist")
	public ModelAndView findtaskdetaillist(Integer page,String tasktype,String phoneid,String taskkeynum,String taskpk,String taskhour,String detaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskhour", taskhour);
		pagemap.put("tasktype", tasktype);
		pagemap.put("detaid", detaid);
		pagemap.put("today", yyyyMMdd.format(new Date()));
		//系统管理员
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskhour", taskhour);
		mv.addObject("tasktype", tasktype);
		mv.addObject("detaid", detaid);
		mv.setViewName("/backstage/admin/taskdetaillist.jsp");
		return mv;
	}
	
	/*
	 * 跳转到任务详情界面-----系统管理员	历史详情查询
	 */
	@RequestMapping(value="/findtaskdetaillistbefore")
	public ModelAndView findtaskdetaillistbefore(Integer page,String tasktype,String phoneid,String taskkeynum,String taskpk,String taskhour,String detaid) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskpk", taskpk);
		pagemap.put("taskhour", taskhour);
		pagemap.put("tasktype", tasktype);
		pagemap.put("detaid", detaid);
		pagemap.put("before", yyyyMMdd.format(new Date()));
		//系统管理员
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByPage(pagemap);
		int total = taskDetailInfoService.findTaskDetailTotalByPage(pagemap);
		mv.addObject("tTaskDetailInfoCustomlist", tTaskDetailInfoCustomlist);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("phoneid", phoneid);
		mv.addObject("taskkeynum", taskkeynum);
		mv.addObject("taskpk", taskpk);
		mv.addObject("taskhour", taskhour);
		mv.addObject("tasktype", tasktype);
		mv.addObject("detaid", detaid);
		mv.setViewName("/backstage/admin/taskdetaillist.jsp");
		return mv;
	}
	/*
	 * 跳转卡机任务查询界面-----系统管理员
	 */
	@RequestMapping(value="/findtasklocklist")
	public ModelAndView findtasklocklist(Integer page,String taskdetailpk,String phoneid,String taskkeynum) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("phoneid", phoneid);
		pagemap.put("taskkeynum", taskkeynum);
		pagemap.put("taskdetailpk", taskdetailpk);
		/*
		* 系统管理员
		*/
		List<TTaskDetailInfoCustom> tTaskDetailInfoCustomlist = taskDetailInfoService.findTaskDetailByProblemAndPage(pagemap);
		int total = taskDetailInfoService.findTotalTaskDetailByProblemAndPage(pagemap);
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
	 * 根据任务id修改任务状态为终止中
	 */
	@RequestMapping(value="/endtaskBytaskid/{taskid}")
	public @ResponseBody ModelMap endtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("taskid", taskid);
		TTaskInfoCustom tTaskInfoCustomtemp = taskInfoService.findTaskInfoByTaskid(taskid);
		if(!tTaskInfoCustomtemp.getTaskstate().equals("16")){
			map.put("data", "stateerror");
			return map;
		}
		hashmap.put("taskstate", 18);
		taskInfoService.updateTaskstate(hashmap);//修改状态为终止中
		taskDetailInfoService.updateterminationstate(hashmap);//修改状态为执行终止
		taskDetailInfoFlowService.updateTaskstate(hashmap);//流量详情修改为终止中
		TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom = taskDetailInfoFlowService.findTaskdetailInfo(hashmap);//根据任务id查询出流量详情信息
		//并调用接口终止发布到第一个手机网站的任务
		String url="http://liuliangapp.com/api/tasks/"+tTaskDetailInfoFlowCustom.getTaskdetailid()+"/finish";
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("secret", secret);
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            map.put("msg", result);
        }
        else {
            System.out.println("调用失败" + statusCode);
            map.put("msg", "失败错误码" + statusCode);
        }
		map.put("data", "success");
		return map;
	}
	
	@RequestMapping(value="/againtaskBytaskid/{taskid}")
	public @ResponseBody ModelAndView againtaskBytaskid(HttpSession session,@PathVariable(value="taskid") String taskid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TTaskInfoCustom tTaskInfoCustom = taskInfoService.findTaskInfoByTaskid(taskid);
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByAgentid(tUserInfoCustom.getAgentid());//根据登陆用户查询所属代理信息
		try{
			TPriceInfoCustom tPriceInfoCustom= priceInfoService.findPriceByAgentid(tAgentInfoCustom.getAgentid());//根据代理信息查询所设置的价格信息
			mv.addObject("tPriceInfoCustom",tPriceInfoCustom);
			mv.addObject("tTaskInfoCustom",tTaskInfoCustom);
		}catch(NullPointerException e){
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
			mv.addObject("msg","未查询到所属代理信息");
			throw e;
		}
		if(tTaskInfoCustom.getTasktype().equals("33")){
			mv.setViewName("/backstage/task/taskadd.jsp");
		}else{
			mv.setViewName("/backstage/task/taskztcadd.jsp");
		}
		return mv;
	}

	/*
	 * 根据任务详情主键获取详细返回值
	 */
	@RequestMapping(value="/requesttaskstr/{taskdetailpk}")
	public @ResponseBody ModelMap requesttaskstr(@PathVariable(value="taskdetailpk")String taskdetailpk) throws Exception{
		ModelMap map = new ModelMap();
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailBypk(taskdetailpk);
		StringBuffer sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustom);
		map.put("res", sb.toString());
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
		//取当前小时
		//long curren = System.currentTimeMillis();
		//curren += 60 * 60 * 1000;
		//Date da = new Date(curren);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		//int hours = Integer.parseInt(dateFormat.format(da));
		//计算需要消耗的积分数
		int days = DateUtilWxf.getBetweenDays(tTaskInfoCustom.getTaskstartdate().replace("-", ""), tTaskInfoCustom.getTaskenddate().replace("-", ""));
		String [] taskkeywordarr=taskkeywords.split("====");
		int subtractpoints = tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts1())+tTaskInfoCustom.getCollectioncount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2())+tTaskInfoCustom.getShoppingcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		subtractpoints = subtractpoints* taskkeywordarr.length * (days + 1);
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		//判断用户积分是否大于需要消耗的积分
		String points = userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		if(Integer.parseInt(points) < subtractpoints){
			map.put("data", "low");
			return map;
		}
		//查询系统配置项中是否禁止发布任务
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
		//得到有多少小时是需要发布任务的
		int hourcount=0;
		for (int j = 0; j < hourarr.length; j++) {
			if(!hourarr[j].equals("0")){
				hourcount=hourcount+1;
			}
		}
		tTaskInfoCustom.setTasktitle(tTaskInfoCustom.getTasktitle());
		tTaskInfoCustom.setTaskwirelesstitle(tTaskInfoCustom.getTaskwirelesstitle());
		tTaskInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());//33 流量   34 直通车
		tTaskInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
		tTaskInfoCustom.setTaskreleasekeyword(taskkeywords);
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
		//添加积分明细记录
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointstype("27");
		int newpoints =Integer.parseInt(points);
		//获取系统设置中总的手机数目
		Date date = yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
		for (int day = 0; day <= days; day++) {
			for (int ii = 0; ii < taskkeywordarr.length; ii++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[ii]);
				tTaskInfoCustom.setTaskstartdate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskenddate(yyyyMMdd.format(date));
				tTaskInfoCustom.setTaskdate(yyyyMMdd.format(date));
				taskInfoService.insertTaskInfo(tTaskInfoCustom);
				//保存之后获取该任务的主键值
				tPointsInfoCustom.setPointreason("发布任务冻结积分"+subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
				tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()-(subtractpoints/(taskkeywordarr.length*(days + 1))));
				tPointsInfoCustom.setPointsupdate(subtractpoints/(taskkeywordarr.length*(days + 1)));
				tPointsInfoCustom.setTaskpk(tTaskInfoCustom.getTaskpk());
				tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
				pointsInfoService.savePoints(tPointsInfoCustom);
				newpoints = newpoints-(subtractpoints/(taskkeywordarr.length*(days + 1)));
				//扣除消耗的积分
				tUserInfoCustom.setPoints(newpoints);
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
				int collectionys = tTaskInfoCustom.getCollectioncount() / hourcount;
				int collectionfps = tTaskInfoCustom.getCollectioncount() % hourcount;
				int []collectionarr = new int[hourcount];
				for (int i = 0; i < collectionarr.length; i++) {
					collectionarr[i]=collectionys;
				}
				for (int i = 0; i < collectionfps; i++) {
					collectionarr[i]=collectionarr[i]+1;
				}
				int shoppingys = tTaskInfoCustom.getShoppingcount() / hourcount;
				int shoppingfps = tTaskInfoCustom.getShoppingcount() % hourcount;
				int []shoppingarr = new int[hourcount];
				for (int i = 0; i < shoppingarr.length; i++) {
					shoppingarr[i]=shoppingys;
				}
				for (int i = 0; i < shoppingfps; i++) {
					shoppingarr[i]=shoppingarr[i]+1;
				}
				//任务拆分
				//1.先将流量任务单独提取出来调用接口发布，并保存返回的订单号
				TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom=new TTaskDetailInfoFlowCustom();
				tTaskDetailInfoFlowCustom.setTaskid(tTaskInfoCustom.getTaskid());
				tTaskDetailInfoFlowCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
				tTaskDetailInfoFlowCustom.setTaskhourcounts(tTaskInfoCustom.getTaskhourcounts());
				tTaskDetailInfoFlowCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
				tTaskDetailInfoFlowCustom.setPrice(tTaskInfoCustom.getTaskminprice());
				tTaskDetailInfoFlowCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
				tTaskDetailInfoFlowCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
				tTaskDetailInfoFlowCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
				tTaskDetailInfoFlowCustom.setTasktype(tTaskInfoCustom.getTasktype());
				tTaskDetailInfoFlowCustom.setTaskstate("40");
				tTaskDetailInfoFlowCustom.setDeepclick(tTaskInfoCustom.getDeepclick());
				tTaskDetailInfoFlowCustom.setFinishcount(0);
				tTaskDetailInfoFlowCustom.setErrorcount(0);
				tTaskDetailInfoFlowCustom.setSubtractpoints(tTaskInfoCustom.getFlowcount()*Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
				tTaskDetailInfoFlowCustom.setTaskdate(yyyyMMdd.format(date));
				tTaskDetailInfoFlowCustom.setCreatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setCreateuser("sys");
				tTaskDetailInfoFlowCustom.setUpdatetime(sdf.format(new Date()));
				tTaskDetailInfoFlowCustom.setUpdateuser("sys");
				taskDetailInfoFlowService.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
				//调用接口发送任务
				HttpClient httpClient = new HttpClient();
				String result="";
			    PostMethod postMethod = new PostMethod("http://liuliangapp.com/api/tasks");
			    postMethod.addParameter("name", "任务"+tTaskInfoCustom.getTaskpk());
			    postMethod.addParameter("keywords", tTaskDetailInfoFlowCustom.getTaskkeyword());
			    postMethod.addParameter("product_url", "https://item.taobao.com/item.htm?id="+tTaskInfoCustom.getTaskkeynum());
			    postMethod.addParameter("start_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskstartdate())));
			    postMethod.addParameter("end_date", yyyy_MM_dd.format(yyyyMMdd.parse(tTaskInfoCustom.getTaskenddate())));
			    postMethod.addParameter("hour_counts", "["+tTaskInfoCustom.getTaskhourcounts()+"]");
			    postMethod.addParameter("duration", "2");
			    postMethod.addParameter("plus", "true");
			    postMethod.addParameter("gprs_pct", "40");
			    postMethod.addParameter("tmall_app_pct", "20");
			    postMethod.addParameter("deep_click_pct", tTaskDetailInfoFlowCustom.getDeepclick()==null?"0":tTaskDetailInfoFlowCustom.getDeepclick());
			    postMethod.setRequestHeader("secret", secret);
			    postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			    int statusCode =  httpClient.executeMethod(postMethod);
			    if(statusCode == 200) {
			        result = postMethod.getResponseBodyAsString();
			        if(result.indexOf("id")==-1){
		            	result = StringUtilWxf.translat(result);
		            	logger.info("调用发布任务接口失败，错误信息:" + result);
		            	map.put("msg", "调用发布任务接口失败，错误信息:" + result);
		            	throw new RuntimeException();
		            	//return map;
		            }else{
		            	ObjectMapper obj = new ObjectMapper();
		 	    		MsgInfoCustom msgInfoCustom = obj.readValue(result, MsgInfoCustom.class);
		 	    		result = msgInfoCustom.getId() + "";
		 	    		logger.info("调用发布任务接口成功!");
		 	    		//将调用接口返回的订单号设置到流量任务记录中
		 	    		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		 	    		hashmap.put("taskdetailid", msgInfoCustom.getId());
		 	    		hashmap.put("taskdetailpk", tTaskDetailInfoFlowCustom.getTaskdetailpk());
		 	    		hashmap.put("taskid", tTaskDetailInfoFlowCustom.getTaskid());
		 	    		int i = taskDetailInfoFlowService.updateTaskdetailIdByPk(hashmap);
		 	    		if(i>0){
		 	    			logger.info("更新返回的订单号成功!");
		 	    		}
		            }
			    }else {
			        map.put("msg", "失败错误码" + statusCode);
			        throw new RuntimeException();
			        //return map;
			    }
				//2.再分配收藏和加购
				int count=0;
				for (int j = 0; j < hourarr.length; j++) {
					if(!hourarr[j].equals("0")){
						int collectionhoursum = collectionarr[count];//每小时分配的收藏数
						int shoppinghoursum = shoppingarr[count];//每小时分配的加购数
						count=count+1;
						int [] collectionminute = new int[collectionhoursum];
						for(int a=0;a<collectionhoursum ; a++){
							collectionminute[a]=a*60/collectionhoursum;
						}
						int [] shoppingminute = new int[shoppinghoursum];
						for(int a=0;a<shoppinghoursum ; a++){
							shoppingminute[a]=a*60/shoppinghoursum;
						}
						//先分配收藏任务
						TSysconfInfoCustom tSysconfInfoCustom = sysconfInfoService.findSysconf();
						if(tSysconfInfoCustom.getSysconfvalue5().equals("1")){
							//1.如果系统配置为均匀发布则按照小时分钟来平分
							for (int i = 0; i < collectionminute.length; i++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("1");
								tTaskDetailInfoCustom.setIsshopping("0");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(collectionminute[i]);
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[i] <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
							//分配购物车任务
							for (int j2 = 0; j2 < shoppingminute.length; j2++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("0");
								tTaskDetailInfoCustom.setIsshopping("1");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setTaskstate("40");
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(shoppingminute[j2]);
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
						}else{
							//2.如果系统设置为快速发布则按照小时分配   分钟数全部为0
							for (int i = 0; i < collectionminute.length; i++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("1");
								tTaskDetailInfoCustom.setIsshopping("0");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts2()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(0);
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[i] <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
							//分配购物车任务
							for (int j2 = 0; j2 < shoppingminute.length; j2++) {
								TTaskDetailInfoCustom tTaskDetailInfoCustom=new TTaskDetailInfoCustom();
								tTaskDetailInfoCustom.setTaskdetailid(UUID.randomUUID().toString().replace("-", ""));
								tTaskDetailInfoCustom.setTaskid(tTaskInfoCustom.getTaskid());
								tTaskDetailInfoCustom.setTaskkeyword(tTaskInfoCustom.getTaskkeyword());
								tTaskDetailInfoCustom.setTaskkeynum(tTaskInfoCustom.getTaskkeynum());
								tTaskDetailInfoCustom.setSearchtype(tTaskInfoCustom.getTasksearchtype());
								tTaskDetailInfoCustom.setTasktype(tTaskInfoCustom.getTasktype());
								tTaskDetailInfoCustom.setPrice(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setIscollection("0");
								tTaskDetailInfoCustom.setIsshopping("1");
								tTaskDetailInfoCustom.setMinpicture(tTaskInfoCustom.getTaskminprice());
								tTaskDetailInfoCustom.setMaxpicture(tTaskInfoCustom.getTaskmaxprice());
								
								if(Integer.parseInt(yyyyMMdd.format(date))<=Integer.parseInt(yyyyMMdd.format(new Date()))
									&& j<= Integer.parseInt(hh.format(new Date())) && collectionminute[j2] <= Integer.parseInt(mm.format(new Date()))){
									tTaskDetailInfoCustom.setTaskstate("23");
								}else{
									tTaskDetailInfoCustom.setTaskstate("40");
								}
								tTaskDetailInfoCustom.setSubtractpoints(Integer.parseInt(tPriceInfoCustom.getPricecounts3()));
								tTaskDetailInfoCustom.setTaskdate(yyyyMMdd.format(date));
								tTaskDetailInfoCustom.setTaskhour(j);
								tTaskDetailInfoCustom.setTaskminute(0);
								tTaskDetailInfoCustom.setCreatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setCreateuser("sys");
								tTaskDetailInfoCustom.setUpdatetime(sdf.format(new Date()));
								tTaskDetailInfoCustom.setUpdateuser("sys");
								taskDetailInfoService.insertDetailinfo(tTaskDetailInfoCustom);
							}
						}
					}
				}
				HashMap<String,Object> hashmap3=new HashMap<String,Object>();
				hashmap3.put("taskid", tTaskInfoCustom.getTaskid());
				hashmap3.put("taskstate", "16");//任务运行中
				hashmap3.put("updatetime", sdf.format(new Date()));
				hashmap3.put("updateuser", "拆分任务");
				taskInfoService.updateTaskstate(hashmap3);
			}
			date = sdf.parse(sdf.format(date.getTime()+24*3600*1000));
		}
		map.put("data", "insertsuccess");
		return map;
	}
	/*
	 * 删除卡机任务，并返回该任务状态为执行失败
	 */
	@RequestMapping("/deletetasklockBypk")
	public @ResponseBody ModelAndView deletetasklockBypk(String pk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailBypk(pk);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		String visit = "notresult";
		String collect = "no";
		String trolley = "no";
		hashmap.put("phoneid", tTaskDetailInfoCustom.getPhoneid());
		hashmap.put("taskstate", tTaskDetailInfoCustom.getTaskstate());
		hashmap.put("taskdetailpk", tTaskDetailInfoCustom.getTaskdetailpk());
		hashmap.put("taskstatenew", 22);
		hashmap.put("visit", visit);
		hashmap.put("collect", collect);
		hashmap.put("trolley", trolley);
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", "卡机任务反馈");
		hashmap.put("isflow", "0");
		hashmap.put("iscreativetitle", "0");
		hashmap.put("isshopcollect", "0");
		taskDetailInfoService.updateTaskDetail(hashmap);
		mv.setViewName("/task/findtasklocklist");
		return mv;
	}
	
}
