package com.zhenapp.controller.back.combo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;

@Controller
@RequestMapping(value = "/combo")
public class FindComboController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	
	//private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 根据登录代理id查询套餐信息-----系统管理员
	 */
	@RequestMapping(value = "/findComboByadmin")
	public @ResponseBody
	ModelAndView findComboByadmin(HttpSession session,Integer page) throws Exception {
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("agentid", tAgentInfoCustom.getAgentid());
		//根据代理id查询套餐信息
		List<TComboInfoCustom> tComboInfoCustomlist = comboInfoService.findAllComboByAdmin(pagemap);
		int total = comboInfoService.findAllTotalComboByAdmin(pagemap);
		mv.addObject("tComboInfoCustomlist", tComboInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.setViewName("/backstage/admin/combo.jsp");
		return mv;
	}

	/*
	 * 保存套餐信息
	 
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
	}*/
}
