package com.zhenapp.controller.back.user;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class FindUserAdminController {
	@Autowired
	private UserInfoService userInfoService;
	@Value("${middleRows}")
	private Integer middleRows;

	/*
	 * 查询用户列表-----系统管理员
	 */
	@RequestMapping(value="/findUserByPageAndAdmin")
	public @ResponseBody ModelAndView findUserByPageAndAdmin(Integer page,String usernick,String userpk,String userphone) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
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
}
