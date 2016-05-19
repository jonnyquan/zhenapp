package com.zhenapp.controller.back;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.DatacountInfoCustom;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TFilepathInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.DatacountInfoService;
import com.zhenapp.service.FilepathInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.util.ExportExcle;

@Controller
@RequestMapping(value="/datacount")
public class DatacountInfoController {
	private static Logger logger = Logger.getLogger(DatacountInfoController.class);
	
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	@Autowired
	private DatacountInfoService datacountInfoService;
	@Autowired
	private FilepathInfoService filepathInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	/*
	 * 根据日期和任务类型查询统计 -----代理
	 */
	@RequestMapping(value="/findDataByDateAndTasktype")
	public @ResponseBody ModelAndView findDataByDateAndTasktype(HttpSession session,String tasktype,String datefrom,String dateto) throws Exception{
		ModelAndView mv= new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(dateto!=null){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		hashmap.put("tasktype", tasktype);
		hashmap.put("agentid", "2");
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		DatacountInfoCustom datacountInfoCustom=datacountInfoService.findSUMDataBydate(hashmap);
		/*TFilepathInfoCustom tFilepathInfoCustom= filepathInfoService.findFilepathByid("1");
		File file =new File(tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
			logger.info("指定导出Excle目录不存在,创建目录"); 
		    file.mkdir();    
		} else   
		{  
			logger.info("指定导出Excle目录已存在"); 
		}  
		ExportExcle exportExcle = new ExportExcle();
		exportExcle.ExprotExcle(datacountInfoCustomlist,tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);
		mv.addObject("total", datacountInfoCustomlist.size());*/
		mv.addObject("datacountInfoCustomlist", datacountInfoCustomlist);
		mv.addObject("datacountInfoCustom", datacountInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.addObject("points", points);
		mv.setViewName("/backstage/agent/datasum.jsp");
		return mv;
	}
	
	/*
	 * 根据日期和任务类型查询统计 -----系统管理员
	 */
	@RequestMapping(value="/responsedatasumadmin")
	public @ResponseBody ModelAndView responsedatasumadmin(String tasktype,String datefrom,String dateto) throws Exception{
		ModelAndView mv= new ModelAndView();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(datefrom!=null){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		hashmap.put("tasktype", tasktype);
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		DatacountInfoCustom datacountInfoCustom=datacountInfoService.findSUMDataBydate(hashmap);
		/*TFilepathInfoCustom tFilepathInfoCustom= filepathInfoService.findFilepathByid("1");
		File file =new File(tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
			logger.info("指定导出Excle目录不存在,创建目录"); 
		    file.mkdir();    
		} else   
		{  
			logger.info("指定导出Excle目录已存在"); 
		}  
		ExportExcle exportExcle = new ExportExcle();
		exportExcle.ExprotExcle(datacountInfoCustomlist,tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);*/
		mv.addObject("total", datacountInfoCustomlist.size());
		mv.addObject("datacountInfoCustomlist", datacountInfoCustomlist);
		mv.addObject("datacountInfoCustom", datacountInfoCustom);
		mv.setViewName("/backstage/admin/datasum.jsp");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/findDataBydate")
	public @ResponseBody ModelMap findDataBydate(String datefrom,String dateto) throws Exception{
		ModelMap map= new ModelMap();
		HashMap<String, Object> hashmap=new HashMap<String, Object>();
		if(datefrom!=null){
			hashmap.put("datefrom", datefrom.replace("-", ""));
		}
		if(datefrom!=null){
			hashmap.put("dateto", dateto.replace("-", ""));
		}
		List<DatacountInfoCustom> datacountInfoCustomlist=datacountInfoService.findDataBydate(hashmap);
		TFilepathInfoCustom tFilepathInfoCustom= filepathInfoService.findFilepathByid("1");
		File file =new File(tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
			logger.info("指定导出Excle目录不存在,创建目录"); 
		    file.mkdir();    
		} else   
		{  
			logger.info("指定导出Excle目录已存在"); 
		}  
		ExportExcle exportExcle = new ExportExcle();
		exportExcle.ExprotExcle(datacountInfoCustomlist,tFilepathInfoCustom.getFilepath()+datefrom+""+dateto);
		map.put("total", datacountInfoCustomlist.size());
		map.put("rows", datacountInfoCustomlist);
		return map;
	}
	
	/*
	 * 导出数据为Excle文件
	 */
	@RequestMapping(value="/ExportFile/{datepath}")
	public void ExportFile(@PathVariable(value="datepath")String datepath,HttpServletResponse response,HttpServletRequest request) throws Exception{
		TFilepathInfoCustom tFilepathInfoCustom= filepathInfoService.findFilepathByid("1");
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	  
	        //获取下载文件路径
	        String downLoadPath = tFilepathInfoCustom.getFilepath()+datepath+"/datacountInfoCustom.xls";
	  
	        //获取文件的长度
	        long fileLength = new File(downLoadPath).length();  

	        //设置文件输出类型
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String("datacountInfoCustom.xls".getBytes("utf-8"), "ISO8859-1")); 
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
	
	/*
	 * 先查出数据生成根目录 再转发到数据统计页面
	 */
	@RequestMapping(value="/findFilepathTodatacount")
	public @ResponseBody ModelAndView findFilepathTodatacount() throws Exception{
		ModelAndView mv= new ModelAndView();
		TFilepathInfoCustom tFilepathInfoCustom= filepathInfoService.findFilepathByid("1");
		File file =new File(tFilepathInfoCustom.getFilepath());
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file .mkdir();    
		} else   
		{  
		    System.out.println("//目录存在");  
		}  
		mv.addObject("filepath",tFilepathInfoCustom.getFilepath());
		mv.setViewName("/page/main/datacount.jsp");
		return mv;
	}
}
