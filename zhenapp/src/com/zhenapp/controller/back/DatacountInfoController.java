package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.DatacountInfoCustom;
import com.zhenapp.service.DatacountInfoService;

@Controller
@RequestMapping(value="/datacount")
public class DatacountInfoController {

	@Autowired
	private DatacountInfoService datacountInfoService;
	
	@RequestMapping(value="/findDataBydate")
	public @ResponseBody ModelMap findDataBydate(String datefrom,String dateto) throws Exception{
		ModelMap map= new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		hashmap.put("datefrom", datefrom.replace("-", ""));
		hashmap.put("dateto", dateto.replace("-", ""));
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		map.put("total", datacountInfoCustomlist.size());
		map.put("rows", datacountInfoCustomlist);
		return map;
	}
}
