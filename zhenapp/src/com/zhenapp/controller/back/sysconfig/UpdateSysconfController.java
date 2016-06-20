package com.zhenapp.controller.back.sysconfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.SysconfInfoService;

@Transactional
@Controller
@RequestMapping(value="/sysconf")
public class UpdateSysconfController {
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private PhoneInfoService phoneInfoService;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 * 修改系统配置信息
	 */
	@RequestMapping(value="/updatesyssetting")
	public @ResponseBody ModelMap updatesyssetting(HttpSession session,TSysconfInfoCustom tSysconfInfoCustom) throws Exception {
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tSysconfInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tSysconfInfoCustom.setUpdatetime(sdf.format(new Date()));
		sysconfInfoService.updateSysinfo(tSysconfInfoCustom);
		phoneInfoService.deletePhone(null);
		for (int i = 1; i <= Integer.parseInt(tSysconfInfoCustom.getSysconfvalue1()); i++) {
			TPhoneInfoCustom tPhoneInfoCustom = new TPhoneInfoCustom();
			tPhoneInfoCustom.setCreatetime(sdf.format(new Date()));
			tPhoneInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPhoneInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPhoneInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tPhoneInfoCustom.setPhoneid(i+"");
			tPhoneInfoCustom.setPhonestate("1");
			tPhoneInfoCustom.setPhonetype("1");
			phoneInfoService.insertPhone(tPhoneInfoCustom);
		}
		for (int i = 0; i < Integer.parseInt(tSysconfInfoCustom.getSysconfvalue2()); i++) {
			TPhoneInfoCustom tPhoneInfoCustom = new TPhoneInfoCustom();
			tPhoneInfoCustom.setCreatetime(sdf.format(new Date()));
			tPhoneInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPhoneInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPhoneInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tPhoneInfoCustom.setPhoneid((i+201)+"");
			tPhoneInfoCustom.setPhonestate("1");
			tPhoneInfoCustom.setPhonetype("2");
			phoneInfoService.insertPhone(tPhoneInfoCustom);
		}
		map.put("ec", "0");
		return map;
	}

}
