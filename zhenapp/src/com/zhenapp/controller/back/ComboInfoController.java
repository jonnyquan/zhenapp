package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.ComboInfoService;

@Controller
@RequestMapping(value = "/combo")
public class ComboInfoController {
	@Autowired
	private ComboInfoService comboInfoService;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");

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
		tComboInfoCustom.setComboid(UUID.randomUUID().toString());
		tComboInfoCustom.setCreatetime(sdf.format(new Date()));
		tComboInfoCustom.setUpdatetime(sdf.format(new Date()));
		tComboInfoCustom.setCreateuser(tUserInfoCustom.getUsernick());
		tComboInfoCustom.setUpdateuser(tUserInfoCustom.getUsernick());
		int i = comboInfoService.insertComboto(tComboInfoCustom);
		System.out.println(i);
		mv.setViewName("findAllCombotoEdit");
		return mv;
	}
}
