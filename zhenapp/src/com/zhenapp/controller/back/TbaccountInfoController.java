package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.TbaccountInfoService;

@Controller
@RequestMapping(value="/tbaccount")
public class TbaccountInfoController {
	
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	
	@RequestMapping(value="/findTbaccountBypage")
	public @ResponseBody ModelMap findTbaccountBypage(Integer page,Integer rows,String tbaccountphoneid,String tbaccountstate) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if(tbaccountstate==null || tbaccountstate.equals("0")){
			pagemap.put("tbaccountstate", null);
		}else{
			pagemap.put("tbaccountstate", tbaccountstate);
		}
		if(tbaccountstate==null ){
			pagemap.put("tbaccountphoneid", null);
		}else{
			pagemap.put("tbaccountphoneid", tbaccountphoneid);
		}
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TTbaccountInfoCustom>  tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountBypage(pagemap);
		//List<TTbaccountInfoCustom>  tTbaccountInfoCustomAlllist = tbaccountInfoService.findAllTbaccountBypage(pagemap);
		int total = tbaccountInfoService.findTotalTbaccountBypage(pagemap);
		
		map.put("total",total);
		map.put("rows", tTbaccountInfoCustomlist);
		
		return map;
	}
	@RequestMapping(value="/deleteTbaccountByid")
	public @ResponseBody ModelMap deleteTbaccountByid(String tbaccountids) throws Exception{
		ModelMap map=new ModelMap();
		int i= tbaccountInfoService.deleteTbaccountByid(tbaccountids);
		System.out.println(i);
		return map;
	}
}
