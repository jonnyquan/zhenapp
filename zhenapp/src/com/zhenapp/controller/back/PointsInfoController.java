package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.service.PointsInfoService;

@Controller
@RequestMapping(value="/points")
public class PointsInfoController {

	@Autowired
	private PointsInfoService pointsInfoService;
	
	@RequestMapping(value="/findPointsInfoByPage")
	public @ResponseBody ModelMap findPointsInfoByPage(Integer page,Integer rows) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String, Object> pagemap= new HashMap<String, Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TPointsInfoCustom> tPointsInfoCustomlist= pointsInfoService.findPointsInfoByPage(pagemap);
		int counts = pointsInfoService.findPointsCountsByPage(pagemap);
		
		map.put("total", counts);
		map.put("rows", tPointsInfoCustomlist);
		
		return map;
	}
}
