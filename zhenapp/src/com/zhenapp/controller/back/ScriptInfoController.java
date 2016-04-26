package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.service.ScriptInfoService;

@Controller
@RequestMapping(value="/script")
public class ScriptInfoController {

	@Autowired
	private ScriptInfoService scriptInfoService;
	
	@RequestMapping(value="/findScriptByPage")
	public @ResponseBody ModelMap findAllScript(Integer page,Integer rows) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TScriptInfoCustom> tScriptInfoCustomlist=scriptInfoService.findScriptByPage(pagemap);
		List<TScriptInfoCustom> tScriptInfoCustomAlllist=scriptInfoService.findAllScriptByPage(pagemap);
		
		map.put("total", tScriptInfoCustomAlllist.size());
		map.put("rows", tScriptInfoCustomlist);
		return map;
	}
	
	@RequestMapping(value="/deletescriptByid")
	public @ResponseBody void deletescriptByid(String scriptid) throws Exception{
		scriptInfoService.deletescriptByid(scriptid);
	}
}
