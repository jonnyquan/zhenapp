package com.zhenapp.controller.back.points;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.service.RechargeInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseConsumeAdminController {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到充值记录界面-----系统管理员
	 */
	@RequestMapping(value="/responseconsumeadmin")
	public ModelAndView responseconsumeadmin(HttpSession session,Integer page,String datefrom,String dateto,String usernick,String rechargeid) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		if(datefrom !=null){
			pagemap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto !=null){
			pagemap.put("dateto", dateto.replace("-", ""));
		}
		pagemap.put("usernick", usernick);
		pagemap.put("rechargeid", rechargeid);
		//系统管理员
		int total = rechargeInfoService.findTotalRechargeinfoByUserAndpage(pagemap);
		List<TRechargeInfoCustom> tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("tRechargeInfoCustomlist",tRechargeInfoCustomlist);
		mv.setViewName("/backstage/admin/listrecharge.jsp");
		return mv;
	}	
}
