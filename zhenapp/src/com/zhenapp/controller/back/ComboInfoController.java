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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value = "/combo")
public class ComboInfoController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	/*
	 * 根据登录代理id查询套餐信息-----代理
	 */
	@RequestMapping(value = "/findComboByagent")
	public @ResponseBody
	ModelAndView findComboByagent(HttpSession session,Integer page,Integer rows) throws Exception {
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		/*
		 * 根据代理id查询套餐信息
		 */
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findComboByAgentid(pagemap);
		int total = comboInfoService.findTotalComboByAgentid(pagemap);
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("points", points);
		mv.addObject("tAgentInfoCustom", tAgentInfoCustom);
		mv.setViewName("/backstage/agent/combo.jsp");
		return mv;
	}
	/*
	 * 保存套餐信息 ---代理
	 */
	@RequestMapping(value="/savecombo")
	public @ResponseBody ModelMap savecombo(HttpSession session,TComboInfoCustom tComboInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
		tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		if(tComboInfoCustom.getCombopk()==null){
			tComboInfoCustom.setComboid(UUID.randomUUID().toString().replace("-", ""));
			tComboInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
			tComboInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tComboInfoCustom.setCreatetime(sdf.format(new Date()));
			comboInfoService.insertComboto(tComboInfoCustom);
		}else{
			tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
			tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			comboInfoService.updateCombotoByid(tComboInfoCustom);
		}
		map.put("ec", 0);
		return map;
	}
	/*
	 * 删除套餐信息 ---代理
	 */
	@RequestMapping(value="/deletecombo")
	public @ResponseBody ModelMap deletecombo(HttpSession session,String pk) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		pagemap.put("combopk", pk);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		comboInfoService.deleteCombo(pagemap);
		map.put("ec", 0);
		return map;
	}
	
	/*
	 * 根据登录代理id查询套餐信息-----系统管理员
	 */
	@RequestMapping(value = "/findComboByadmin")
	public @ResponseBody
	ModelAndView findComboByadmin(HttpSession session,Integer page,Integer rows) throws Exception {
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		/*
		 * 根据代理id查询套餐信息
		 */
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findAllComboByAdmin(pagemap);
		int total = comboInfoService.findAllTotalComboByAdmin(pagemap);
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/combo.jsp");
		return mv;
	}
//===========================================================================================以上为最新
	/*
	 * 查询全部的套餐信息 用于套餐展现
	 */
	@RequestMapping(value = "/findAllCombo")
	public @ResponseBody
	ModelAndView findAllCombo() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService
				.findAllCombo();
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.setViewName("/page/records/recordsdeposit.jsp");
		return mv;
	}
	
	/*
	 * 查询全部的套餐信息 用于套餐信息管理
	 */
	@RequestMapping(value = "/findAllCombotoEdit")
	public @ResponseBody
	ModelAndView findAllCombotoEdit() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService
				.findAllCombo();
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.setViewName("/page/combo/combomange.jsp");
		return mv;
	}
	
	
	/*
	 * 保存套餐信息
	 */
	@RequestMapping(value = "/insertComboto")
	public @ResponseBody
	ModelAndView insertComboto(HttpServletRequest request,TComboInfoCustom tComboInfoCustom) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tComboInfoCustom.setComboid(UUID.randomUUID().toString().replace("-", ""));
		tComboInfoCustom.setCreatetime(sdf.format(new Date()));
		tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
		tComboInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		int i = comboInfoService.insertComboto(tComboInfoCustom);
		System.out.println(i);
		mv.setViewName("findAllCombotoEdit");
		return mv;
	}
}
