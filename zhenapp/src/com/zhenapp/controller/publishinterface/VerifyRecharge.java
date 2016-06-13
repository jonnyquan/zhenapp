package com.zhenapp.controller.publishinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.DateInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.SysconfInfoService;
import com.zhenapp.service.TaskDetailInfoFlowService;
import com.zhenapp.service.TaskDetailInfoService;
import com.zhenapp.service.TaskInfoService;
import com.zhenapp.service.UserInfoService;
@Controller
public class VerifyRecharge {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static Logger logger = Logger.getLogger(VerifyRecharge.class);
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysconfInfoService sysconfInfoService;
	@Autowired
	private TaskInfoService taskInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private TaskDetailInfoService taskDetailInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private DateInfoService dateInfoService;
	@Autowired
	private TaskDetailInfoFlowService taskDetailInfoFlowService;
	@Autowired
	private PriceInfoService priceInfoService;
	
	/*
	 * 通过接口调用		确认充值
	 */
	@RequestMapping(value="/api/platform/updateRechargestate/{verificationcode}")
	public @ResponseBody ModelMap updateRechargestate(@PathVariable(value="verificationcode")String verificationcode) throws Exception{
		ModelMap map = new ModelMap();
		//修改充值记录状态为已确认
		int i= rechargeInfoService.updateRechargestate(verificationcode);
		if(i>0){
			TRechargeInfoCustom tRechargeInfoCustom=rechargeInfoService.findRechargeBycode(verificationcode);
			//插入账户明细
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tRechargeInfoCustom.getCreateuser());
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser("接口确认充值");
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
