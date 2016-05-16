package com.zhenapp.controller.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;

/*
 * 供手机端调用的api
 * 
 */
@Controller
public class phoneapi {
	@Autowired
	private PhoneInfoService phoneInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 手机端获取任务
	 * http://120.24.44.130/api/phone/request/task?pid=1
	 *param:pid-->手机号
	 */
	@RequestMapping(value="/api/phone/request/task/{pid}")
	public @ResponseBody String requesttask(@PathVariable(value="pid")String pid) throws Exception{
		StringBuffer sb=new StringBuffer();
		/*
		 * 查询当前手机是否有未完成的任务
		 */
		HashMap<String, Object> hashmap = new HashMap<String,Object>();
		hashmap.put("phoneid", pid);
		hashmap.put("taskstate", 20);
		TTaskDetailInfoCustom tTaskDetailInfoCustoming = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
		if(tTaskDetailInfoCustoming!=null){
			sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustoming);
		}else{
			TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.requesttaskByphoneid(pid);
			if(tTaskDetailInfoCustom!= null){
				hashmap.put("taskdetailid", tTaskDetailInfoCustom.getTaskdetailid());
				hashmap.put("updatetime", sdf.format(new Date()));
				hashmap.put("updateuser", "api手机端获取");
				int i =taskDetailInfoService.updateTaskDetailstate(hashmap);
				if(i > 0){
					sb = TTaskDetailInfoCustom.Mosaicstr(tTaskDetailInfoCustom);
					/*
					 * 将返回的字符串更新到数据表中
					 */
					hashmap.put("result", sb.toString());
					hashmap.put("updatetime", sdf.format(new Date()));
					hashmap.put("updateuser", "api手机端修改字符串");
					taskDetailInfoService.updateTaskDetailresultByid(hashmap);
				}else{
					sb.append("暂时没有任务");
				}
			}else{
				sb.append("暂时没有任务");
			}
		}
		String result=sb.toString();
		return result;
	}
	
	
	/*
	 * 手机端反馈任务
	 * http://120.24.44.130/api/phone/deleteTask/task?pid=2&visit=notfound&collect=no&trolley=no
	 *param:pid-->手机号
	 *visit=，后面带的是流量完成情况
	 *collect=,后面带的是收藏完成的情况
	 *trolley=，后面带的是购物车完成情况
	 *
	 *下面列举全部
	 *visit=yes（完成了这个流量）
	 *visit=notresult（搜索这个任务的时候没有搜索结果）
	 *visit=notfound（搜索这个任务的时候没有找到这个宝贝）
	 *visit=notload（搜索这个任务的时候没有加载到任何东西）
	 *
	 *collect= yes（收藏成功）
	 *collect=no（收藏失败）
	 *collect= havecollect （已经收藏过）
	 *
	 *trolley=yes（加入购物车成功）
	 *trolley=no（加入购物车失败）
	 *
	 */
	@RequestMapping(value="/api/phone/deleteTask/task")
	public @ResponseBody ModelMap requesttask(String pid,String visit,String collect,String trolley) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("phoneid", pid);
		hashmap.put("taskstate", "20");
		TTaskDetailInfoCustom tTaskDetailInfoCustom = taskDetailInfoService.findTaskDetailByPidAndState(hashmap);
		if(tTaskDetailInfoCustom!=null){
			if(visit.equals("yes")){
				hashmap.put("taskstatenew", 21);
			}else{
				hashmap.put("taskstatenew", 22);
			}
			hashmap.put("visit", visit);
			hashmap.put("collect", collect);
			hashmap.put("trolley", trolley);
			hashmap.put("updatetime", sdf.format(new Date()));
			hashmap.put("updateuser", "api手机端反馈");
			int i = taskDetailInfoService.updateTaskDetailByPidAndState(hashmap);
			if(i > 0){
				map.put("反馈情况", "已更新!");
			}else{
				map.put("反馈情况", "更新失败!");
			}
		}else{
			map.put("反馈情况", "暂时没有任务!");
		}
		return map;
	}
	
	
	/*
	 * 手机端获取淘宝账号信息
	 * http://120.24.44.130/api/phone/requestAccount/task?pid=1
	 */
	@RequestMapping(value="/api/phone/requestAccount/task")
	public @ResponseBody String requestAccounttask(String pid)throws Exception{
		StringBuffer sb=new StringBuffer();
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountByPhoneid(pid);
		if(tTbaccountInfoCustomlist!=null ){
			TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlist.get(0);
			//淘宝帐号|淘宝密码 |帐号序号|附加标记
			sb.append(tTbaccountInfoCustom.getTbaccountname()).append("|")
				.append(tTbaccountInfoCustom.getTbaccountpwd()).append("|")
				.append(tTbaccountInfoCustom.getTbaccountpk()).append("|")
				.append("-1");
		}
		return sb.toString();
	}
	/*
	 * 手机端反馈淘宝账号信息
	 * http://120.24.44.130/api/phone/postProblem/task?accountid=1&problem=unusable
	 */
	@RequestMapping(value="api/phone/postProblem/task")
	public @ResponseBody ModelMap postProblemtask(String accountid,String problem)throws Exception{
		ModelMap map = new ModelMap();
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountByAccountname(accountid);
		if(tTbaccountInfoCustomlist!=null && tTbaccountInfoCustomlist.size()==1){
			TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlist.get(0);
			if(problem.equals("avaliable")){
				tTbaccountInfoCustom.setTbaccountstate("61");
			}else if(problem.equals("unusable")){
				tTbaccountInfoCustom.setTbaccountstate("62");
			}
			tTbaccountInfoCustom.setTbaccounttime(tTbaccountInfoCustom.getTbaccounttime()+1);
			tTbaccountInfoCustom.setUpdatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setUpdateuser("api反馈淘宝账号信息");
			tbaccountInfoService.updateTbaccountByid(tTbaccountInfoCustom);
			map.put("return", "success");
		}else{
			map.put("return", "为查询到该账号信息或该账号信息不唯一");
		}
		return map;
	}
	
	
	/*
	 * 手机端下载脚本文件
	 * http://120.24.44.130/api/phone/down?name=hqfh2.lua
	 */
	@RequestMapping(value = "/api/phone/down")
	public void downloadFile(String name, HttpServletResponse response,HttpServletRequest request)  {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			TScriptInfoCustom tScriptInfoCustom = scriptInfoService.findScriptByname(name);
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
}
