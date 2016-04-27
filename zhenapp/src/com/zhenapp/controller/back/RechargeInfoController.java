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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Vo.TRechargeInfoVo;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.RechargeInfoService;


@Controller
@RequestMapping(value="/recharge")
public class RechargeInfoController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	/*
	 * 插入充值记录
	 */
	@RequestMapping(value="/insertRechargeinfo/{id}")
	public ModelAndView insertRechargeinfo(@PathVariable(value="id")String id,TRechargeInfoVo tRechargeInfoVo,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String verificationcode = UUID.randomUUID().toString();
		HttpSession session=request.getSession();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		TComboInfoCustom tComboInfoCustom= comboInfoService.findComboByid(id);
		TRechargeInfoCustom tRechargeInfoCustom=new TRechargeInfoCustom();
		tRechargeInfoCustom.setRechargeid(UUID.randomUUID().toString());
		tRechargeInfoCustom.setRechargemoney(tComboInfoCustom.getCombomoney());
		tRechargeInfoCustom.setRechargestate("0");//待确认状态
		tRechargeInfoCustom.setRechargeverification(verificationcode);
		tRechargeInfoCustom.setUpdatetime(sdf.format(new Date()));
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tRechargeInfoCustom.setUpdateuser(tUserInfoCustom.getUsernick());
		tRechargeInfoCustom.setCreateuser(tUserInfoCustom.getUsernick());
		tRechargeInfoCustom.setCreatetime(sdf.format(new Date()));
		tRechargeInfoVo.settRechargeInfoCustom(tRechargeInfoCustom);
		int i = rechargeInfoService.insertRechargeinfo(tRechargeInfoVo);
		if(i>0){
			mv.addObject("tComboInfoCustom", tComboInfoCustom);
			mv.addObject("Verificationcode", verificationcode);
			mv.setViewName("/page/records/recordsdepositverification.jsp");
		}
		return mv;
	}
	
	/*
	 * 查询充值记录
	 */
	@RequestMapping(value="/findRechargeinfoByUserAndpage")
	public @ResponseBody ModelMap findRechargeinfoByUserAndpage(String datefrom,String dateto,Integer page,Integer rows,HttpServletRequest request) throws Exception{
		ModelMap map=new ModelMap();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		datefrom=datefrom!=null?datefrom.replace("-", ""):"";
		dateto=dateto!=null?dateto.replace("-", ""):"";
		pagemap.put("datefrom", datefrom);
		pagemap.put("dateto", dateto);
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		
		pagemap.put("createuser", tUserInfoCustom.getUsernick());
		List<TRechargeInfoCustom> tRechargeInfoCustomAlllist= rechargeInfoService.findRechargeinfoByUser(pagemap);
		List<TRechargeInfoCustom> tRechargeInfoCustomlist= rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		map.put("total",tRechargeInfoCustomAlllist.size());
		map.put("rows", tRechargeInfoCustomlist);
		return map;
	}
	
	/*
	 *删除充值记录
	 */
	@RequestMapping(value="/deleteRechargeinfoByid")
	public @ResponseBody String deleteRechargeinfoByid(String rechargeids) throws Exception{
		rechargeInfoService.deleteRechargeinfoByid(rechargeids);
		return "removsuccess";
	}
}
