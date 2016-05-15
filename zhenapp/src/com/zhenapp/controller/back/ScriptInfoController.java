package com.zhenapp.controller.back;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.service.ScriptInfoService;

@Controller
@RequestMapping(value="/script")
public class ScriptInfoController {

	@Autowired
	private ScriptInfoService scriptInfoService;
	
	/*
	 * 跳转到上传脚本界面 -----系统管理员
	 */
	@RequestMapping(value="/responsescriptmanage")
	public @ResponseBody ModelAndView responsescriptmanage(Integer page,Integer rows) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		List<TScriptInfoCustom> tScriptInfoCustomlist=scriptInfoService.findScriptByPage(pagemap);
		int total =scriptInfoService.findTotalScriptByPage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum",page);
		mv.addObject("tScriptInfoCustomlist", tScriptInfoCustomlist);
		mv.setViewName("/backstage/admin/scriptmanage.jsp");
		return mv;
	}

	@RequestMapping(value="/deletescriptByid")
	public @ResponseBody void deletescriptByid(String scriptid) throws Exception{
		scriptInfoService.deletescriptByid(scriptid);
	}
}
