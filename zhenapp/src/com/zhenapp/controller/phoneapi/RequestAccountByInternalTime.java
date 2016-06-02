package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.TbaccountInfoService;

@Controller
public class RequestAccountByInternalTime {
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
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	private static Logger logger = Logger.getLogger(RequestAccountByInternalTime.class);
	/*
	 * 设置一键换号
	 */
	@RequestMapping(value="/api/phone/requestAccountByInternalTime/task")
	public @ResponseBody String phoneChange(String pid) throws Exception{
		StringBuffer sb=new StringBuffer();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("tbaccountstate", "nochange");
		//查询是否存在状态为nochange的淘宝账号
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlisttemp = tbaccountInfoService.findAllTbaccountBypage(hashmap);
		if(tTbaccountInfoCustomlisttemp!=null && tTbaccountInfoCustomlisttemp.size()>0){
			return "nochange";
		}
		hashmap.clear();
		hashmap.put("tbaccountphoneid", pid);
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountByPhoneidandtag(hashmap);
		if(tTbaccountInfoCustomlist!=null && tTbaccountInfoCustomlist.size()>0){
			TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlist.get(0);
			tTbaccountInfoCustom.setTbaccountstate("nochange");
			tTbaccountInfoCustom.setUpdatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setUpdateuser("sys");
			tbaccountInfoService.updateTbaccountByid(tTbaccountInfoCustom);
			sb.append(tTbaccountInfoCustom.getTbaccountname()).append("|")
			.append(tTbaccountInfoCustom.getTbaccountpwd()).append("|")
			.append(tTbaccountInfoCustom.getTbaccountpk()).append("|")
			.append(tTbaccountInfoCustom.getTbaccounttag());
			logger.info("一键换号成功!");
			return sb.toString();
		}else{
			return "nochange";
		}
	}
}
