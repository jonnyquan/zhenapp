package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

@Controller
@RequestMapping(value="/task")
public class TaskInfoController {
	private static Log logger = LogFactory.getLog(TaskInfoController.class);
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
			logger.error("未查询到所属代理信息的单价,无法发布任务!");
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
	public @ResponseBody ModelMap insertTaskInfo(HttpServletRequest request, TTaskInfoCustom tTaskInfoCustom,String taskkeywords,String subtractpoints) throws Exception{
		ModelMap map=new ModelMap();
		/*
		 * 查询系统配置项中是否禁止发布任务
		 */
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points = userInfoService.findpointsByUserid(tUserInfoCustom);
		if(Integer.parseInt(points) < Integer.parseInt(subtractpoints)){
			map.put("data", "low");
			return map;
		}
		String desable = sysconfInfoService.findSysdesable();
		if(!desable.equals("1")){
			map.put("data", "refuse");
			return map;
		}
			String [] taskkeywordarr=taskkeywords.split("====");
			int counts = 0;
			for (int i = 0; i < taskkeywordarr.length; i++) {
				tTaskInfoCustom.setTaskid(UUID.randomUUID().toString().replace("-", ""));
				tTaskInfoCustom.setTaskkeyword(taskkeywordarr[i]);
				tTaskInfoCustom.setTaskstate("15");
				tTaskInfoCustom.setTaskstartdate(tTaskInfoCustom.getTaskstartdate().replace("-", ""));
				tTaskInfoCustom.setTaskenddate(tTaskInfoCustom.getTaskenddate().replace("-", ""));
				tTaskInfoCustom.setCreatetime(sdf.format(new Date()));
				tTaskInfoCustom.setUpdatetime(sdf.format(new Date()));
				tTaskInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tTaskInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				tTaskInfoCustom.setSubtractpoints(Integer.parseInt(subtractpoints));
				int count=taskInfoService.insertTaskInfo(tTaskInfoCustom);
				counts = counts + count;
			}
			map.put("data", "insertsuccess");
			/*
			 * 扣除消耗的积分
			 */
			tUserInfoCustom.setPoints(Integer.parseInt(points)-Integer.parseInt(subtractpoints));
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
			tPointsInfoCustom.setPointsupdate(Integer.parseInt(subtractpoints));
			tPointsInfoCustom.setTaskid("0");
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
		return map;
	}
	
}
