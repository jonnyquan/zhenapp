package com.zhenapp.controller.back.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.UsertestInfoService;

@Controller
@RequestMapping(value="/user")
public class FindUsertestAdminController {
	@Autowired
	private UsertestInfoService usertestInfoService;
	@Value("${middleRows}")
	private Integer middleRows;

	/*
	 * 查询用户列表-----系统管理员
	 */
	@RequestMapping(value="/findUsertestAdmin")
	public @ResponseBody ModelAndView findUsertestAdmin(Integer page,String usertestnick) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("usertestnick", usertestnick);
		List<TUsertestInfoCustom> tUsertestInfoCustomlist = usertestInfoService.findUserTest(pagemap);
		int total = usertestInfoService.findTotalUsertest(pagemap);
		mv.addObject("total", total==0?1:total);
		mv.addObject("pagenum", page);
		mv.addObject("usertestnick", usertestnick);
		mv.addObject("tUsertestInfoCustomlist", tUsertestInfoCustomlist);
		mv.setViewName("/backstage/admin/usertest.jsp");
		return mv;
	}
}
