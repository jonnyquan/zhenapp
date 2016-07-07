package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.UserInfoService;
@Transactional
@Controller
@RequestMapping(value="/user")
public class HandWorkRechargeAdminController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = Logger.getLogger(HandWorkRechargeAdminController.class);

	/*
	 * 对用户积分手工充值扣款-----系统管理员
	 */
	@RequestMapping(value="/handworkrechargeadmin")
	public @ResponseBody ModelMap handworkrechargeadmin(HttpSession session,String userpk,String updatepoints,String recharge,String memo) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		Integer newpoints = 0;
		String Pointstype = "";
		if(recharge.equals("recharge")){
			newpoints=tUserInfoCustom.getPoints() + Integer.parseInt(updatepoints);
			Pointstype = "31";//充值
		}else{
			newpoints=tUserInfoCustom.getPoints() - Integer.parseInt(updatepoints);
			if(newpoints<0){
				map.put("msg", "扣除积分超出用户最大积分数");
				logger.error("扣除积分超出用户最大积分数,代理：" + tUserInfoCustomsession.getUserid() + " 用户："+ tUserInfoCustom.getUserid());
				return map;
			}
			Pointstype = "32";//扣款
		}
		//修改用户积分
		tUserInfoCustom.setPoints(newpoints);
		tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
		tUserInfoCustom.setUpdateuser("手工充值/扣款");
		userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
		//插入账户明细
		TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
		tPointsInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPointsInfoCustom.setUpdateuser("sys");
		tPointsInfoCustom.setPointreason(memo);
		tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
		tPointsInfoCustom.setPoints(newpoints);
		tPointsInfoCustom.setPointstype(Pointstype);
		tPointsInfoCustom.setPointsupdate(Integer.parseInt(updatepoints));
		tPointsInfoCustom.setTaskpk(0);
		tPointsInfoCustom.setUserid(tUserInfoCustomsession.getUserid());
		pointsInfoService.savePoints(tPointsInfoCustom);
		map.put("ec", "0");
		return map;
	}
}
