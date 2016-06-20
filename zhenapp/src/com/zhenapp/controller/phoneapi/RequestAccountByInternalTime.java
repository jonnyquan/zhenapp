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
	 * 一键换号之后获取账号
	 */
	@RequestMapping(value="/api/phone/requestAccountByInternalTime/task")
	public @ResponseBody String phoneChange(String pid) throws Exception{
		StringBuffer sb=new StringBuffer();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("tbaccountstate", "nochange");
		hashmap.put("tbaccountphoneid", pid);
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
			List<TTbaccountInfoCustom> tTbaccountInfoCustomlistnull = tbaccountInfoService.findTbaccountByphoneidisnull();
			if(tTbaccountInfoCustomlistnull != null && tTbaccountInfoCustomlistnull.size()>0){
				TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlistnull.get(0);
				/*淘宝帐号|淘宝密码 |帐号序号|附加标记
				sb.append(tTbaccountInfoCustom.getTbaccountname()).append("|")
					.append(tTbaccountInfoCustom.getTbaccountpwd()).append("|")
					.append(tTbaccountInfoCustom.getTbaccountpk());*/
				hashmap.clear();
				hashmap.put("tbaccountphoneid", pid);
				hashmap.put("Tbaccountpk", tTbaccountInfoCustom.getTbaccountpk());
				tbaccountInfoService.updateTbaccount(hashmap);
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
				return "该手机的账号库没有账号";
			}
		}
	}
}
