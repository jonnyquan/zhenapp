package com.zhenapp.controller.back;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.ScriptInfoService;

@Controller
@RequestMapping(value="/script")
public class ScriptInfoController {
	@Autowired
	private ScriptInfoService scriptInfoService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	@Value("${middleRows}")
	private Integer middleRows;
	@Value("${config.scriptfile}")
	private String scriptfilepath;
	
	/*
	 * 跳转到上传脚本界面 -----系统管理员
	 */
	@RequestMapping(value="/responsescriptmanage")
	public @ResponseBody ModelAndView responsescriptmanage(Integer page) throws Exception{
		ModelAndView mv=new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		}
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		List<TScriptInfoCustom> tScriptInfoCustomlist=scriptInfoService.findScriptByPage(pagemap);
		int total =scriptInfoService.findTotalScriptByPage(pagemap);
		mv.addObject("total", total);
		mv.addObject("pagenum",page);
		mv.addObject("tScriptInfoCustomlist", tScriptInfoCustomlist);
		mv.setViewName("/backstage/admin/scriptmanage.jsp");
		return mv;
	}

	/*
	 * 上传脚本信息
	 */
	@RequestMapping(value = "/uploadscript")
	public @ResponseBody ModelMap uploadscript(HttpServletRequest request, @RequestParam("file_name") MultipartFile file) throws Exception {
		ModelMap map = new ModelMap();
		TScriptInfoCustom tScriptInfoCustom = new TScriptInfoCustom();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String time = sdf.format(new Date());
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			String pic_path = scriptfilepath;
			// 新的脚本文件名称
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新文件
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			tScriptInfoCustom.setScriptpath(pic_path + newFileName);
			tScriptInfoCustom.setScriptname(originalFilename);
			tScriptInfoCustom.setCreatetime(time);
			tScriptInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tScriptInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tScriptInfoCustom.setUpdatetime(time);
			tScriptInfoCustom.setScriptid(UUID.randomUUID().toString().replace("-", ""));
			scriptInfoService.insertScript(tScriptInfoCustom);
		}
		map.put("ec", "0");
		return map;
	}
	
	@RequestMapping(value = "/downloadFile/{scriptid}")
	public void downloadFile(@PathVariable(value="scriptid") String scriptid, HttpServletResponse response,HttpServletRequest request)  {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			TScriptInfoCustom tScriptInfoCustom = scriptInfoService.findScriptByid(scriptid);
			request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	        //获取下载文件路径
	        String downLoadPath = tScriptInfoCustom.getScriptpath();
	        //获取文件的长度
	        long fileLength = new File(downLoadPath).length();
	        //设置文件输出类型
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String(tScriptInfoCustom.getScriptname().getBytes("utf-8"), "ISO8859-1")); 
	        //设置输出长度
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	        //获取输入流
	        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	        //输出流
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        //关闭流
	        bis.close();  
	        bos.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteScriptByid/{scriptid}")
	public @ResponseBody ModelAndView deleteScriptByid(@PathVariable(value="scriptid")String scriptid) throws Exception{
		ModelAndView mv= new ModelAndView();
		scriptInfoService.deletescriptByid(scriptid);
		mv.setViewName("/script/responsescriptmanage");
		return mv;
	}

}
