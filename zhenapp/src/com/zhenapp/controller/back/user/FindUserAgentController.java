package com.zhenapp.controller.back.user;

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
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class FindUserAgentController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	/*
	 * 查询用户列表-----代理
	 */
	@RequestMapping(value="/findUserByPageandRole")
	public @ResponseBody ModelAndView findUserByPageandRole(HttpSession session,Integer page,String usernick,String userpk,String userphone,String handworklogin) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");//得到登陆用户信息
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("usernick", usernick);
		pagemap.put("userpk", userpk);
		
		pagemap.put("userphone", userphone);
		//代理用户
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
}
