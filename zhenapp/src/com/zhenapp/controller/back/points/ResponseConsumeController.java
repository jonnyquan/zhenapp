package com.zhenapp.controller.back.points;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.UserInfoService;

@Controller
@RequestMapping(value="/points")
public class ResponseConsumeController {
	
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到购买记录界面
	 */
	@RequestMapping(value="/responseconsume")
	public ModelAndView responseconsume(HttpSession session,Integer page,String datefrom,String dateto) throws Exception{
		ModelAndView mv=new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		datefrom=datefrom!=null?datefrom.replace("-", ""):"";
		dateto=dateto!=null?dateto.replace("-", ""):"";
		pagemap.put("datefrom", datefrom);
		pagemap.put("dateto", dateto);
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		//普通用户
		pagemap.put("createuser", tUserInfoCustom.getUserid());
		int total = rechargeInfoService.findTotalRechargeinfoByUserAndpage(pagemap);
		List<TRechargeInfoCustom> tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		mv.addObject("total",total);
		mv.addObject("pagenum", page);
		mv.addObject("tRechargeInfoCustomlist", tRechargeInfoCustomlist);
		mv.setViewName("/backstage/points/consumepoints.jsp");
		return mv;
	}
	
}
