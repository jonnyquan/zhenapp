package com.zhenapp.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TSysMenuCustom;
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
	public @ResponseBody List<TSysMenuCustom> findAllMenu(String id) throws Exception{
		if(id==null){
			id="0";
		}
		List<TSysMenuCustom> list= menuService.findMenuBytid(id);
		return list;
	}
}
