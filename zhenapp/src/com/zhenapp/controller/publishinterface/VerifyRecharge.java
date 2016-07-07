package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Controller
public class VerifyRecharge {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(VerifyRecharge.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	
	/*
	 * 通过接口调用		确认充值
	 */
	@RequestMapping(value="/api/platform/updateRechargestate")
	public @ResponseBody ModelMap updateRechargestate(String verificationcode,String rechargemoney,String keys) throws Exception{
		ModelMap map = new ModelMap();
		//修改充值记录状态为已确认
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("verificationcode", verificationcode);
		hashmap.put("rechargemoney", rechargemoney);
		hashmap.put("keys", "chongzhijiekou");
		int i= rechargeInfoService.updateRechargestate(hashmap);
		if(i>0){
			TRechargeInfoCustom tRechargeInfoCustom=rechargeInfoService.findRechargeBycode(verificationcode);
			//插入账户明细
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tRechargeInfoCustom.getCreateuser());
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("接口确认充值");
			tPointsInfoCustom.setPointreason("确认充值,到账"+tRechargeInfoCustom.getRechargepoints()+"赠送"+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointstype("26");
			tPointsInfoCustom.setPointsupdate(tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setTaskpk(0);
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			pointsInfoService.savePoints(tPointsInfoCustom);
			//修改用户当前积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser("接口确认充值");
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			logger.info("确认充值成功");
			map.put("data", "success");
			return map;
		}else{
			map.put("data", "error");
			return map;
		}
	}
}
