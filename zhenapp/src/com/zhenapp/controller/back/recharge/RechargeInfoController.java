package com.zhenapp.controller.back.recharge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.ComboInfoService;
import com.zhenapp.service.PointsInfoService;
import com.zhenapp.service.RechargeInfoService;
import com.zhenapp.service.UserInfoService;

@Transactional
@Controller
@RequestMapping(value="/recharge")
public class RechargeInfoController {
	@Autowired
	private ComboInfoService comboInfoService;
	@Autowired
	private RechargeInfoService rechargeInfoService;
	@Autowired
	private PointsInfoService pointsInfoService;
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 *删除充值记录
	 */
	@RequestMapping(value="/deleteRechargeinfoByid")
	public @ResponseBody String deleteRechargeinfoByid(String rechargeids) throws Exception{
		rechargeInfoService.deleteRechargeinfoByid(rechargeids);
		return "removsuccess";
	}
	
	/*
	 * 确认充值
	 */
	@RequestMapping(value="/updateRechargestate/{verificationcode}")
	public @ResponseBody ModelMap updateRechargestate(HttpSession session,@PathVariable(value="verificationcode")String verificationcode) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustomsession = (TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		//修改充值记录状态为已确认
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("verificationcode", verificationcode);
		int i= rechargeInfoService.updateRechargestate(hashmap);
		if(i>0){
			TRechargeInfoCustom tRechargeInfoCustom=rechargeInfoService.findRechargeBycode(verificationcode);
			//插入账户明细
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tRechargeInfoCustom.getCreateuser());
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser(tRechargeInfoCustom.getCreateuser());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
			tPointsInfoCustom.setPointreason("充值到账"+tRechargeInfoCustom.getRechargepoints()+"赠送"+tRechargeInfoCustom.getRechargegivepoints());
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
			tUserInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
			userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			//扣除用户所属代理积分
		}
		map.put("data", "success");
		return map;
	}
}
