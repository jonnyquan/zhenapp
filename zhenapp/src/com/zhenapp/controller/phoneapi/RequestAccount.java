package com.zhenapp.controller.phoneapi;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.TbaccountInfoService;
@Controller
public class RequestAccount {
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	/*
	 * 手机端获取淘宝账号信息
	 * http://120.24.44.130/api/phone/requestAccount/task?pid=1
	 */
	@RequestMapping(value="/api/phone/requestAccount/task")
	public @ResponseBody String requestAccounttask(String pid)throws Exception{
		StringBuffer sb=new StringBuffer();
		//查询指定手机编号下的淘宝账号
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountByPhoneid(pid);
		if(tTbaccountInfoCustomlist!=null && tTbaccountInfoCustomlist.size()>0){
			TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlist.get(0);
			//淘宝帐号|淘宝密码 |帐号序号|附加标记
			sb.append(tTbaccountInfoCustom.getTbaccountname()).append("|")
				.append(tTbaccountInfoCustom.getTbaccountpwd()).append("|")
				.append(tTbaccountInfoCustom.getTbaccountpk());
		}else{
			//当手机小号库没有符合要求的账号时，到大号库获取一个账号并修改手机编号属性
			List<TTbaccountInfoCustom> tTbaccountInfoCustomlistnull = tbaccountInfoService.findTbaccountByphoneidisnull();
			if(tTbaccountInfoCustomlistnull != null && tTbaccountInfoCustomlistnull.size()>0){
				TTbaccountInfoCustom tTbaccountInfoCustom = tTbaccountInfoCustomlistnull.get(0);
				//淘宝帐号|淘宝密码 |帐号序号|附加标记
				sb.append(tTbaccountInfoCustom.getTbaccountname()).append("|")
					.append(tTbaccountInfoCustom.getTbaccountpwd()).append("|")
					.append(tTbaccountInfoCustom.getTbaccountpk());
				HashMap<String, Object> hashmap = new HashMap<String, Object>();
				hashmap.put("tbaccountphoneid", pid);
				hashmap.put("Tbaccountpk", tTbaccountInfoCustom.getTbaccountpk());
				tbaccountInfoService.updateTbaccount(hashmap);
			}else{
				sb.append("未获取到淘宝账号信息");
			}
		}
		return sb.toString();
	}
	
}
