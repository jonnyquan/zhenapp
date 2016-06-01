package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.po.Custom.TIntroInfoCustom;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.po.Vo.TUserinfoVo;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.ElectrityInfoService;
import com.zhenapp.service.GuideInfoService;
import com.zhenapp.service.IntroInfoService;
import com.zhenapp.service.NoteInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;
import com.zhenapp.util.MD5Util;

@Controller
@RequestMapping(value="/user")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private ElectrityInfoService electrityService;
	@Autowired
	private GuideInfoService guideService;
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private IntroInfoService introInfoService;
	@Autowired
	private NoteInfoService noteInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = Logger.getLogger(UserInfoController.class);
	/*
	 * 跳转到个人中心页面
	 */
	@RequestMapping(value="/responseuser")
	public ModelAndView responseuser(HttpSession session,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		List<TelectricityCustom> TelectricityCustomlist = electrityService.findElectrity_10(pagemap);
		List<TGuideInfoCustom> TGuideInfoCustomlist = guideService.findGuide_10(pagemap);
		mv.addObject("TelectricityCustomlist", TelectricityCustomlist);
		mv.addObject("TGuideInfoCustomlist", TGuideInfoCustomlist);
		TUserInfoCustom tUserInfoCustom = (TUserInfoCustom)session.getAttribute("tUserInfoCustom");
		String url="";
		if(tUserInfoCustom.getUserroleid()==3){//普通用户角色
			url = "/backstage/user/user.jsp";
		}else if(tUserInfoCustom.getUserroleid()==2){//代理角色
			url = "findUserByPageandRole";
		}else if(tUserInfoCustom.getUserroleid()==1){//系统管理员
			url = "findUserByPageAndAdmin";
		}
		mv.setViewName(url);	
		return mv;
	}
	/*
	 * 跳转到个人基本信息页面
	 */
	@RequestMapping(value="/responsepersonal")
	public ModelAndView responsepersonal(HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("tUserInfoCustom")==null){
			mv.setViewName("/frontend/authlogin.jsp");
		}else{
			TUserInfoCustom tUserInfoCustom = (TUserInfoCustom)session.getAttribute("tUserInfoCustom");
			tUserInfoCustom = userInfoService.findUserByuserid(tUserInfoCustom.getUserid());
			session.setAttribute("tUserInfoCustom", tUserInfoCustom);
			//mv.setViewName("responseuser");
			mv.setViewName("/backstage/user/personal.jsp");
		}
		return mv;
	}
	/*
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value="/responseupdatepassword")
	public ModelAndView responseupdatepassword() throws Exception{
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("/backstage/user/updatepassword.jsp");
		return mv;
	}
	/*
	 * 退出系统
	 */
	@RequestMapping(value="/authlogout")
	public ModelAndView authlogout(HttpSession session,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String webwww=request.getServerName();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentBywww(webwww);
		if (tAgentInfoCustom !=null) {
			TWebInfoCustom tWebInfoCustom=webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
			mv.addObject("tWebInfoCustom",tWebInfoCustom);
			session.removeAttribute("tUserInfoCustom");
			mv.setViewName("/frontend/authlogin.jsp");
		}else{
			session.removeAttribute("tUserInfoCustom");
			mv.addObject("msg","您访问的网址查询不到对应的代理!");
			mv.setViewName("/agenterror.jsp");
		}
		return mv;
	}
	
	/*
	 * 用于用户修改基本信息
	 */
	@RequestMapping(value="/updateUser")
	public @ResponseBody ModelAndView updateUser(HttpSession session,TUserInfoCustom tUserInfoCustom) throws Exception{
		ModelAndView mv =new ModelAndView();
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		int i=userInfoService.updateUser(tUserInfoCustom);
		if(i>0){
			mv.setViewName("responsepersonal");
		}else{
			mv.setViewName("/info.jsp");
		}
		return mv;
	}
	/*
	 * 查询该用户登录密码与该帐号是否匹配
	 */
	@RequestMapping(value="/ajax/checkOldPassword")
	public @ResponseBody ModelMap checkOldPassword(HttpSession session,String param) throws Exception{
		ModelMap map =new ModelMap();
		String usernick = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom")).getUsernick();
		List<TUserInfoCustom> tUserInfoCustomlist=userInfoService.findUserBynick(usernick);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
			TUserInfoCustom tUserInfoCustom=tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(param))){
				map.put("status", "y");
			}else{
				map.put("status", "n");
				map.put("info", "原密码不正确");
			}
		}
		return map;
	}
	/*
	 * 修改用户密码
	 */
	@RequestMapping(value="/updateOldPassword")
	public @ResponseBody ModelAndView updateOldPassword(HttpSession session,String oldpassword,String userpwd) throws Exception{
		ModelAndView mv =new ModelAndView();
		String usernick = ((TUserInfoCustom)session.getAttribute("tUserInfoCustom")).getUsernick();
		List<TUserInfoCustom> tUserInfoCustomlist=userInfoService.findUserBynick(usernick);
		if(tUserInfoCustomlist!=null && tUserInfoCustomlist.size()>0){
			TUserInfoCustom tUserInfoCustom=tUserInfoCustomlist.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(oldpassword))){
				tUserInfoCustom.setUserpwd(MD5Util.string2MD5(userpwd));
				tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
				tUserInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				int i = userInfoService.updateUserpwdByuserid(tUserInfoCustom);
				if(i > 0){
					session.setAttribute("tUserInfoCustom", tUserInfoCustom);
				}
				mv.addObject("msg", "修改密码成功");
			}else{
				mv.addObject("msg", "修改密码失败");
			}
		}
		mv.setViewName("responseupdatepassword");
		return mv;
	}
	/*
	 * 查询用户列表-----代理
	 */
	@RequestMapping(value="/findUserByPageandRole")
	public @ResponseBody ModelAndView findUserByPageandRole(HttpSession session,Integer page,Integer rows,String usernick,String userpk,String userphone) throws Exception{
		ModelAndView mv = new ModelAndView();
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
		pagemap.put("usernick", usernick);
		pagemap.put("userpk", userpk);
		pagemap.put("userphone", userphone);
		/*
		* 代理用户
		*/
		pagemap.put("userid", tUserInfoCustom.getUserid());
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserByPageandRole(pagemap);
		int total = userInfoService.findTotalUserByPageandRole(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("usernick", usernick);
		mv.addObject("userpk", userpk);
		mv.addObject("userphone", userphone);
		mv.addObject("points", points);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.addObject("tUserInfoCustomlist", tUserInfoCustomlist);
		mv.setViewName("/backstage/agent/useragent.jsp");
		return mv;
	}
	/*
	 * 查询代理积分
	 */
	@RequestMapping(value="/findPointsByUsernick")
	public @ResponseBody ModelAndView findPointsByUsernick(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.addObject("points", points);
		mv.setViewName("/backstage/agent/points.jsp");
		return mv;
	}
	/*
	 * 删除用户信息  ------代理
	 */
	@RequestMapping(value="/deleteUserByUserpkAndRole")
	public @ResponseBody ModelMap deleteUserByUserpkAndRole(HttpSession session,String userpk) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("userpk", userpk);
		hashmap.put("agentid", tAgentInfoCustom.getAgentid());
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		hashmap.put("updatetime", sdf.format(new Date()));
		//根据要删除的用户主键及登录人的代理id修改需要删除的用户的状态为30
		userInfoService.updateUserState(hashmap);
		//userInfoService.deleteUserByUserpkAndRole(hashmap);
		map.put("ec", 0);
		return map;
	}
	/*
	 * 删除用户信息  ------系统管理员
	 */
	@RequestMapping(value="/deleteUserByUserpkAndAdmin")
	public @ResponseBody ModelMap deleteUserByUserpkAdmin(HttpSession session,String userpk) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		hashmap.put("userpk", userpk);
		hashmap.put("updateuser", tUserInfoCustom.getUserid());
		hashmap.put("updatetime", sdf.format(new Date()));
		//根据要删除的用户主键及登录人的代理id修改需要删除的用户的状态为30
		userInfoService.updateUserState(hashmap);
		map.put("ec", 0);
		return map;
	}
	/*
	 * 跳转到手工充值扣款界面 -----代理
	 */
	@RequestMapping(value="/recharge")
	public @ResponseBody ModelAndView recharge(String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom= userInfoService.findUserByuserpk(userpk);
		mv.addObject("points", tUserInfoCustom.getPoints());
		mv.addObject("userpk", userpk);
		mv.setViewName("/backstage/agent/recharge.jsp");
		return mv;
	}
	/*
	 * 跳转到手工充值扣款界面 -----系统管理员
	 */
	@RequestMapping(value="/rechargeadmin")
	public @ResponseBody ModelAndView rechargeadmin(String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom= userInfoService.findUserByuserpk(userpk);
		mv.addObject("points", tUserInfoCustom.getPoints());
		mv.addObject("userpk", userpk);
		mv.setViewName("/backstage/admin/recharge.jsp");
		return mv;
	}
	/*
	 * 跳转到为代理手工充值扣款界面 -----系统管理员
	 */
	@RequestMapping(value="/rechargeadminforagent")
	public @ResponseBody ModelAndView rechargeadminforagent(String agentuserid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(agentuserid);
		mv.addObject("points", tUserInfoCustom.getPoints());
		mv.addObject("userpk", tUserInfoCustom.getUserpk());
		mv.setViewName("/backstage/admin/rechargeagent.jsp");
		return mv;
	}
	/*
	 * 对用户积分手工充值扣款-----代理 
	 */
	@RequestMapping(value="/handworkrecharge")
	public @ResponseBody ModelMap handworkrecharge(HttpSession session,String userpk,String updatepoints,String recharge,String memo) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom tUserInfoCustomagent = userInfoService.findUserByuserpk(tUserInfoCustomsession.getUserpk()+"");
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		Integer newpoints = 0;
		Integer newpointsagent = 0;
		String Pointstype = "";
		String Pointstypeagent = "";
		if(recharge.equals("recharge")){
			newpoints=tUserInfoCustom.getPoints() + Integer.parseInt(updatepoints);
			newpointsagent = tUserInfoCustomagent.getPoints() - Integer.parseInt(updatepoints);
			if(newpointsagent<0){
				map.put("msg", "充值积分超出代理最大积分数");
				logger.error("充值积分超出代理最大积分数,代理：" + tUserInfoCustomsession.getUserid() + " 用户："+ tUserInfoCustom.getUserid());
				return map;
			}
			Pointstype = "31";//充值
			Pointstypeagent = "32";//扣款
		}else{
			newpoints=tUserInfoCustom.getPoints() - Integer.parseInt(updatepoints);
			if(newpoints<0){
				map.put("msg", "扣除积分超出用户最大积分数");
				logger.error("扣除积分超出用户最大积分数,代理：" + tUserInfoCustomsession.getUserid() + " 用户："+ tUserInfoCustom.getUserid());
				return map;
			}
			newpointsagent = tUserInfoCustomagent.getPoints() + Integer.parseInt(updatepoints);
			Pointstype = "32";//扣款
			Pointstypeagent = "31";//充值
		}
		//修改代理积分
		tUserInfoCustomagent.setPoints(newpointsagent);
		tUserInfoCustomagent.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustomagent.setUpdateuser(tUserInfoCustomsession.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustomagent);
		//插入账户明细
		TPointsInfoCustom tPointsInfoCustomagent =new TPointsInfoCustom();
		tPointsInfoCustomagent.setCreateuser(tUserInfoCustomagent.getUserid());
		tPointsInfoCustomagent.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustomagent.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustomagent.setUpdateuser("sys");
		tPointsInfoCustomagent.setPointreason(memo);
		tPointsInfoCustomagent.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustomagent.setPoints(newpointsagent);
		tPointsInfoCustomagent.setPointstype(Pointstypeagent);
		tPointsInfoCustomagent.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustomagent.setTaskpk(0);
		tPointsInfoCustomagent.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustomagent);
		//修改用户积分
		tUserInfoCustom.setPoints(newpoints);
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		//插入账户明细
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason(memo);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(newpoints);
		tPointsInfoCustom.setPointstype(Pointstype);
		tPointsInfoCustom.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustom.setTaskpk(0);
		tPointsInfoCustom.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		map.put("ec", "0");
		return map;
	}
	/*
	 * 对用户积分手工充值扣款-----系统管理员
	 */
	@RequestMapping(value="/handworkrechargeadmin")
	public @ResponseBody ModelMap handworkrechargeadmin(HttpSession session,String userpk,String updatepoints,String recharge,String memo) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		Integer newpoints = 0;
		String Pointstype = "";
		if(recharge.equals("recharge")){
			newpoints=tUserInfoCustom.getPoints() + Integer.parseInt(updatepoints);
			Pointstype = "31";//充值
		}else{
			newpoints=tUserInfoCustom.getPoints() - Integer.parseInt(updatepoints);
			if(newpoints<0){
				map.put("msg", "扣除积分超出用户最大积分数");
				logger.error("扣除积分超出用户最大积分数,代理：" + tUserInfoCustomsession.getUserid() + " 用户："+ tUserInfoCustom.getUserid());
				return map;
			}
			Pointstype = "32";//扣款
		}
		//修改用户积分
		tUserInfoCustom.setPoints(newpoints);
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		//插入账户明细
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason(memo);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(newpoints);
		tPointsInfoCustom.setPointstype(Pointstype);
		tPointsInfoCustom.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustom.setTaskpk(0);
		tPointsInfoCustom.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		map.put("ec", "0");
		return map;
	}
	/*
	 * 对代理用户积分手工充值扣款-----系统管理员
	 */
	@RequestMapping(value="/handworkrechargeadminforagent")
	public @ResponseBody ModelMap handworkrechargeadminforagent(HttpSession session,String userpk,String updatepoints,String recharge,String memo) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		Integer newpoints = 0;
		String Pointstype = "";
		if(recharge.equals("recharge")){
			newpoints=tUserInfoCustom.getPoints() + Integer.parseInt(updatepoints);
			Pointstype = "31";//充值
		}else{
			newpoints=tUserInfoCustom.getPoints() - Integer.parseInt(updatepoints);
			if(newpoints<0){
				map.put("msg", "扣除积分超出用户最大积分数");
				logger.error("扣除积分超出用户最大积分数,代理：" + tUserInfoCustomsession.getUserid() + " 用户："+ tUserInfoCustom.getUserid());
				return map;
			}
			Pointstype = "32";//扣款
		}
		//修改用户积分
		tUserInfoCustom.setPoints(newpoints);
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		//插入账户明细
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason(memo);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(newpoints);
		tPointsInfoCustom.setPointstype(Pointstype);
		tPointsInfoCustom.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustom.setTaskpk(0);
		tPointsInfoCustom.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		map.put("ec", "0");
		return map;
	}
	/*
	 * 后台登录用户账号 -----代理
	 */
	@RequestMapping(value="/handworkLogin")
	public @ResponseBody ModelAndView handworkLogin(HttpSession session,String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom= userInfoService.findUserByuserpk(userpk);
		if(tUserInfoCustom!=null){
			session.removeAttribute("tUserInfoCustom");//
			session.setAttribute("tUserInfoCustom", tUserInfoCustom);
		}
		mv.setViewName("/user/responseuser");
		return mv;
	}
	/*
	 * 查询用户列表-----系统管理员
	 */
	@RequestMapping(value="/findUserByPageAndAdmin")
	public @ResponseBody ModelAndView findUserByPageAndAdmin(Integer page,Integer rows,String usernick,String userpk,String userphone) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("usernick", usernick);
		pagemap.put("userpk", userpk);
		pagemap.put("userphone", userphone);
		pagemap.put("userstate", 29);
		//系统管理员用户
		List<TUserInfoCustom> tUserInfoCustomlist = userInfoService.findUserByPage(pagemap);
		int total = userInfoService.findTotalUserByPage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum", page);
		mv.addObject("usernick", usernick);
		mv.addObject("userpk", userpk);
		mv.addObject("userphone", userphone);
		mv.addObject("tUserInfoCustomlist", tUserInfoCustomlist);
		mv.setViewName("/backstage/admin/useradmin.jsp");
		return mv;
	}

	
	
	
	/*
	 * 设为代理----系统管理员
	 */
	@RequestMapping(value="/setAgent/{userpk}")
	public @ResponseBody ModelAndView setAgent(@PathVariable(value="userpk") String userpk,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		//查询出系统管理员的web信息
		TWebInfoCustom tWebInfoCustomadmin = webInfoService.findWebByAgentid("0");
		TUserInfoCustom TUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		//修改角色为代理   useroleid=2   代理上级变为0 即系统管理员
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("agentid", "0");
		TIntroInfoCustom tIntroInfoCustomtemp = introInfoService.findIntroinfo(hashmap);
		hashmap.put("userpk", userpk);
		hashmap.put("oldroleid", "3");
		hashmap.put("newroleid", "2");
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustomsession.getUserid());
		userInfoService.updateroleAndagent(hashmap);
		//插入代理信息及对应的web信息    基本信息默认保持与系统管理员一致
		TAgentInfoCustom tAgentInfoCustom = new TAgentInfoCustom();
		tAgentInfoCustom.setAgentid(UUID.randomUUID().toString().replace("-", ""));
		tAgentInfoCustom.setAgentuserid(TUserInfoCustom.getUserid());
		tAgentInfoCustom.setAgentperson(TUserInfoCustom.getUsernick());
		tAgentInfoCustom.setAgentphone(TUserInfoCustom.getUserphone());
		tAgentInfoCustom.setAgentname(UUID.randomUUID().toString().replace("-", ""));//网站名称，请尽快修改...
		tAgentInfoCustom.setAgentstate("29");
		tAgentInfoCustom.setCreatetime(sdf.format(new Date()));
		tAgentInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		agentInfoService.saveAgentInfo(tAgentInfoCustom);
		TWebInfoCustom tWebInfoCustom = new TWebInfoCustom();
		tWebInfoCustom.setWebid(UUID.randomUUID().toString().replace("-", ""));
		tWebInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tWebInfoCustom.setLogo(tWebInfoCustomadmin.getLogo());
		tWebInfoCustom.setCarousel01(tWebInfoCustomadmin.getCarousel01());
		tWebInfoCustom.setCarousel02(tWebInfoCustomadmin.getCarousel02());
		tWebInfoCustom.setCarousel03(tWebInfoCustomadmin.getCarousel03());
		tWebInfoCustom.setQq(tWebInfoCustomadmin.getQq());
		tWebInfoCustom.setQqgroup(tWebInfoCustom.getQqgroup());
		tWebInfoCustom.setWechat(tWebInfoCustomadmin.getWechat());
		tWebInfoCustom.setRecord(tWebInfoCustomadmin.getRecord());
		tWebInfoCustom.setAlipay(tWebInfoCustomadmin.getAlipay());
		tWebInfoCustom.setBg01(tWebInfoCustomadmin.getBg01());
		tWebInfoCustom.setBg02(tWebInfoCustomadmin.getBg02());
		tWebInfoCustom.setIco(tWebInfoCustomadmin.getIco());
		tWebInfoCustom.setCreatetime(sdf.format(new Date()));
		tWebInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tWebInfoCustom.setUpdatetime(sdf.format(new Date()));
		tWebInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		webInfoService.saveWebInfo(tWebInfoCustom);
		//插入服务介绍信息
		TIntroInfoCustom tIntroInfoCustom = new TIntroInfoCustom();
		tIntroInfoCustom.setIntroid(UUID.randomUUID().toString().replace("-", ""));
		tIntroInfoCustom.setIntroname(tIntroInfoCustomtemp.getIntroname());
		tIntroInfoCustom.setIntrotext(tIntroInfoCustomtemp.getIntrotext());
		tIntroInfoCustom.setCreatetime(sdf.format(new Date()));
		tIntroInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tIntroInfoCustom.setUpdatetime(sdf.format(new Date()));
		tIntroInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		introInfoService.insertIntro(tIntroInfoCustom);
		//插入公告信息
		hashmap.clear();
		hashmap.put("agentid", "0");
		hashmap.put("notetype", "2");
		TNoteInfoCustom tNoteInfoCustom = noteInfoService.findNoteinfo(hashmap);
		tNoteInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tNoteInfoCustom.setCreatetime(sdf.format(new Date()));
		tNoteInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tNoteInfoCustom.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		noteInfoService.savenote(tNoteInfoCustom);
		mv.setViewName("/user/findUserByPageAndAdmin");
		return mv;
	}
	//===============================================================================以上为新
	
	/*
	 * 使用用户名密码登录
	 
	@RequestMapping(value="/Loginrest/{username}/{password}"
			,method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody TUserInfo Loginrest(HttpSession httpSession, String username,String password) throws Exception{
		TUserInfo tUserInfo=new TUserInfo();
		tUserInfo.setUserstate("1");
		List<TUserInfoCustom> list=userInfoService.findUserBynick(username);
		if (list.size()>0) {
			TUserInfoCustom tUserInfoCustom=list.get(0);
			if(tUserInfoCustom.getUserpwd().equals(MD5Util.string2MD5(password))){
				httpSession.setMaxInactiveInterval(900); //15分钟
				httpSession.setAttribute("tUserInfoCustom", tUserInfoCustom);
			}else{
				tUserInfo = null;
			}
		}else{
			tUserInfo = null;
		}
		return tUserInfo;
	}*/
	/*
	 * 查询用户列表
	 
	@RequestMapping(value="/findUserByPage")
	public @ResponseBody ModelMap findUserByPage(Integer page,Integer rows,HttpServletRequest request) throws Exception{
		ModelMap map=new ModelMap();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		pagemap.put("userstate", 29);
		List<TUserInfoCustom> tUserInfoCustomlist=userInfoService.findUserByPage(pagemap);
		int total=0;
		if(tUserInfoCustom.getUserroleid()==1){
			//系统管理员
			 
			tUserInfoCustomlist = userInfoService.findUserByPage(pagemap);
			total = userInfoService.findTotalUserByPage(pagemap);
		}else if(tUserInfoCustom.getUserroleid()==2){
			//代理用户
			 
			pagemap.put("userid", tUserInfoCustom.getUserid());
			tUserInfoCustomlist = userInfoService.findUserByPageandRole(pagemap);
			total = userInfoService.findTotalUserByPageandRole(pagemap);
		}
		map.put("total", total);
		map.put("rows", tUserInfoCustomlist);
		return map;
	}*/
	
	
	/*
	 * 基本信息页面数据显示
	 
	@RequestMapping(value="/findUserinfoByusernick")
	public ModelAndView findUserinfoByusernick(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TUserInfoCustom> list=userInfoService.findUserBynick(tUserInfoCustom.getUsernick());
		TUserInfoCustom tUserinfoCustom=null;
		if(list != null && list.size()>0){
			tUserinfoCustom = list.get(0);
		}
		mv.addObject("tUserinfoCustom",tUserinfoCustom);
		mv.setViewName("/page/personalcenter/personaldetails.jsp");
		return mv;
	}*/
	/*
	 * 重置密码页面数据显示
	
	@RequestMapping(value="/findUserinfoByusernicktopassword")
	public ModelAndView findUserinfoByusernicktopassword(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TUserInfoCustom> list=userInfoService.findUserBynick(tUserInfoCustom.getUsernick());
		TUserInfoCustom tUserinfoCustom=null;
		if(list != null && list.size()>0){
			tUserinfoCustom = list.get(0);
		}
		mv.addObject("tUserinfoCustom",tUserinfoCustom);
		mv.setViewName("/page/personalcenter/personalPassword.jsp");
		return mv;
	} */
	
	/*
	 * 使用邮件找回密码
	 
	@RequestMapping(value="/findPasswordByemail")
	public @ResponseBody ModelAndView findPasswordByemail(TUserinfoVo tUserinfoVo) throws Exception{
		ModelAndView mv =new ModelAndView();
		TUserInfoCustom TUserinfoCustomtemp=userInfoService.findPasswordByemail(tUserinfoVo);
		if(TUserinfoCustomtemp!=null){
			try{
				Mail.Send(TUserinfoCustomtemp.getUserpwd());
				mv.addObject("msg", "请查收邮件!");
			}catch(Exception e){
				mv.addObject("msg", "系统异常,请联系管理员!");
			}
		}else{
			mv.addObject("msg", "用户名或注册邮箱错误");
		}
		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}*/
	/*
	 * 用于用户修改基本信息
	 */
	@RequestMapping(value="/updateUserinfo")
	public @ResponseBody ModelAndView updateUserinfo(TUserinfoVo tUserinfoVo) throws Exception{
		ModelAndView mv =new ModelAndView();
		int i=userInfoService.updateUserinfo(tUserinfoVo);
		if(i>0){
			mv.setViewName("/user/findUserinfoByusernick");
		}
		return mv;
	}
	/*
	 * 删除用户信息
	
	@RequestMapping(value="/deleteUserinfoBypk/{userpk}")
	public @ResponseBody ModelMap deleteUserinfoBypk(@PathVariable(value="userpk")String userpk) throws Exception{
		ModelMap map= new ModelMap();
		int i= userInfoService.deleteUserinfoBypk(userpk);
		map.put("data", i);
		return map;
	}
	 */
	/*
	 * 根据用户信息查询余额
	 */
	@RequestMapping(value="/findpoints")
	public @ResponseBody ModelMap findpoints(HttpServletRequest request) throws Exception{
		ModelMap map= new ModelMap();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		map.put("points", points);
		return map;
	}
	/*
	 * 设置普通用户为代理用户
	 */
	@RequestMapping(value="/updaterole/{userpk}")
	public @ResponseBody ModelMap updaterole(@PathVariable(value="userpk")String userpk,HttpServletRequest request) throws Exception{
		ModelMap map= new ModelMap();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		int i = userInfoService.updaterole(userpk);//根据用户主键修改用户角色
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		/*
		 * 插入代理信息
		 */
		//查询系统管理员的代理信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid("0");
		tAgentInfoCustom.setAgentid(UUID.randomUUID().toString().replace("-", ""));
		tAgentInfoCustom.setAgentuserid(tUserInfoCustom.getUserid());
		tAgentInfoCustom.setAgentperson(tUserInfoCustom.getUsername());
		tAgentInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tAgentInfoCustom.setCreatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		agentInfoService.saveAgentInfo(tAgentInfoCustom);
		/*
		 * 插入代理的价格信息  默认与系统管理员一致
		 */
		//查询系统管理员的价格信息
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid("0");
		tPriceInfoCustom.setPriceid(UUID.randomUUID().toString().replace("-", ""));
		tPriceInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tPriceInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tPriceInfoCustom.setCreatetime(sdf.format(new Date()));
		tPriceInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPriceInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		priceInfoService.savePriceInfo(tPriceInfoCustom);
		/*
		 * 插入代理的web页面信息  默认与系统管理员一致
		 */
		//查询系统管理员的web信息
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid("0");
		tWebInfoCustom.setWebid(UUID.randomUUID().toString().replace("-", ""));
		tWebInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tWebInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tWebInfoCustom.setCreatetime(sdf.format(new Date()));
		tWebInfoCustom.setUpdatetime(sdf.format(new Date()));
		tWebInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		webInfoService.saveWebInfo(tWebInfoCustom);
		/*
		 * 插入代理套餐信息默认与系统管理员一致
		 */
		HashMap<String, Object> hashmap= new HashMap<String, Object>();
		hashmap.put("agentid", "0");
		hashmap.put("page", 0);
		hashmap.put("rows", 100);
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findComboByAgentid(hashmap);
		for (int j = 0; j < tComboInfoCustomlist.size(); j++) {
			TComboInfoCustom tComboInfoCustom = tComboInfoCustomlist.get(j);
			tComboInfoCustom.setComboid(UUID.randomUUID().toString().replace("-", ""));
			tComboInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
			tComboInfoCustom.setCombodesc("初始化套餐信息");
			tComboInfoCustom.setCreatetime(sdf.format(new Date()));
			tComboInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
			tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
			tComboInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
			comboInfoService.insertComboto(tComboInfoCustom);
		}
		
		map.put("data", i);
		return map;
	}
	
	/*
	 * 代理用户直接登录某一用户
	 */
	@RequestMapping(value="/login/{userpk}")
	public @ResponseBody ModelMap login(@PathVariable(value="userpk")String userpk,HttpServletRequest request) throws Exception{
		ModelMap map= new ModelMap();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		HttpSession session=request.getSession();
		session.removeAttribute("tUserInfoCustom");
		session.setAttribute("tUserInfoCustom", tUserInfoCustom);
		map.put("tUserInfoCustom", tUserInfoCustom);
		return map;
	}
	/*
	 * 代理根据用户主键给用户充值扣款
	 
	@RequestMapping(value="/findPointsByuserpk/{userpk}")
	public @ResponseBody ModelAndView findPointsByuserpk(@PathVariable(value="userpk")String userpk) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		mv.addObject("tUserInfoCustom",tUserInfoCustom);
		mv.setViewName("/page/user/updateUserpoints.jsp");
		return mv;
	}*/
	/*
	 * 代理根据用户主键给用户充值扣款
	 
	@RequestMapping(value="/updatepoints")
	public @ResponseBody ModelAndView updatepoints(HttpServletRequest request,String userpk,String caozo,String updatepoints,String desc) throws Exception{
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		Integer newpoints = 0;
		String Pointstype = "";
		if(caozo.equals("0")){
			newpoints=tUserInfoCustom.getPoints() + Integer.parseInt(updatepoints);
			Pointstype = "31";
		}else{
			newpoints=tUserInfoCustom.getPoints() - Integer.parseInt(updatepoints);
			Pointstype = "32";
		}
		//插入账户明细
		 
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason(desc);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(newpoints);
		tPointsInfoCustom.setPointstype(Pointstype);
		tPointsInfoCustom.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustom.setTaskpk(0);
		tPointsInfoCustom.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		//修改用户积分
		 
		tUserInfoCustom.setPoints(newpoints);
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		
		mv.setViewName("/page/user/userList.jsp");
		return mv;
	}*/
}
