package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TSysMenuCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.MenuInfoService;




@Controller
@RequestMapping(value="/menu")
public class MenuInfoController {

	@Autowired
	private MenuInfoService menuService;
	
	@RequestMapping(value="/findAllMenu")
	public @ResponseBody List<TSysMenuCustom> findAllMenu() throws Exception{
		List<TSysMenuCustom> list= menuService.findAllMenu();
		return list;
	}
	
	@RequestMapping(value="/findAllMenuById")
	public @ResponseBody List<TSysMenuCustom> findAllMenu(HttpServletRequest request,String id) throws Exception{
		HashMap<String,String> hashmap=new HashMap<String, String>();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom= (TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String userroleid=tUserInfoCustom.getUserroleid().toString();
		if(id==null){
			id="0";
		}
		hashmap.put("userroleid", userroleid);
		hashmap.put("tid", id);
		List<TSysMenuCustom> list= menuService.findMenuBytid(hashmap);
		return list;
	}
}
