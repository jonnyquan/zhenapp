package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.TbaccountInfoService;

public class FeedbackAccount {
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
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
			map.put("return", "未查询到该账号信息或该账号信息不唯一");
		}
		return map;
	}
}
