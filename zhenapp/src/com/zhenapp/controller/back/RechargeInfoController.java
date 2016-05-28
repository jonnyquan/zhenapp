package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	/*
	 * 插入充值记录
	 
	@RequestMapping(value="/insertRechargeinfo/{id}")
	public ModelAndView insertRechargeinfo(@PathVariable(value="id")String id,TRechargeInfoVo tRechargeInfoVo,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String verificationcode = UUID.randomUUID().toString().replace("-", "");
		HttpSession session=request.getSession();
		TComboInfoCustom tComboInfoCustom= comboInfoService.findComboByid(id);
		TRechargeInfoCustom tRechargeInfoCustom=new TRechargeInfoCustom();
		tRechargeInfoCustom.setRechargeid(UUID.randomUUID().toString().replace("-", ""));
		tRechargeInfoCustom.setRechargemoney(tComboInfoCustom.getCombomoney());
		tRechargeInfoCustom.setRechargepoints(tComboInfoCustom.getCombointegral());
		tRechargeInfoCustom.setRechargegivemoney(tComboInfoCustom.getCombogivemoney());
		tRechargeInfoCustom.setRechargegivepoints(tComboInfoCustom.getCombogiveintegral());
		tRechargeInfoCustom.setRechargestate("24");//待确认状态
		tRechargeInfoCustom.setRechargeverification(verificationcode);
		tRechargeInfoCustom.setUpdatetime(sdf.format(new Date()));
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tRechargeInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tRechargeInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
		tRechargeInfoCustom.setCreatetime(sdf.format(new Date()));
		int i = rechargeInfoService.insertRechargeinfo(tRechargeInfoCustom);
		if(i>0){
			mv.addObject("tComboInfoCustom", tComboInfoCustom);
			mv.addObject("Verificationcode", verificationcode);
			mv.setViewName("/page/records/recordsdepositverification.jsp");
		}
		return mv;
	}*/
	
	/*
	 * 查询充值记录
	 
	@RequestMapping(value="/findRechargeinfoByUserAndpage")
	public @ResponseBody ModelMap findRechargeinfoByUserAndpage(String datefrom,String dateto,Integer page,Integer rows,HttpServletRequest request) throws Exception{
		ModelMap map=new ModelMap();
		HttpSession session=request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		datefrom=datefrom!=null?datefrom.replace("-", ""):"";
		dateto=dateto!=null?dateto.replace("-", ""):"";
		pagemap.put("datefrom", datefrom);
		pagemap.put("dateto", dateto);
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TRechargeInfoCustom> tRechargeInfoCustomlist = new ArrayList<TRechargeInfoCustom>();
		int total = 0;
		if(tUserInfoCustom.getUserroleid()==1){
			//系统管理员
			total = rechargeInfoService.findTotalRechargeinfoByUserAndpage(pagemap);
			tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		}else if(tUserInfoCustom.getUserroleid()==2){
			//代理用户
			pagemap.put("userid", tUserInfoCustom.getUserid());
			total = rechargeInfoService.findTotalRechargeinfoByRoleAndpage(pagemap);
			tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByRoleAndpage(pagemap);
		}else{
			//普通用户
			pagemap.put("createuser", tUserInfoCustom.getUserid());
			total = rechargeInfoService.findTotalRechargeinfoByUserAndpage(pagemap);
			tRechargeInfoCustomlist = rechargeInfoService.findRechargeinfoByUserAndpage(pagemap);
		}
		map.put("total",total);
		map.put("rows", tRechargeInfoCustomlist);
		return map;
	}*/
	
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
		int i= rechargeInfoService.updateRechargestate(verificationcode);
		if(i>0){
			TRechargeInfoCustom tRechargeInfoCustom=rechargeInfoService.findRechargeBycode(verificationcode);
			//插入账户明细
			TUserInfoCustom tUserInfoCustom = userInfoService.findUserByuserid(tRechargeInfoCustom.getCreateuser());
			TPointsInfoCustom tPointsInfoCustom =new TPointsInfoCustom();
			tPointsInfoCustom.setCreateuser(tRechargeInfoCustom.getCreateuser());
			tPointsInfoCustom.setCreatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdatetime(sdf.format(new Date()));
			tPointsInfoCustom.setUpdateuser("sys");
			tPointsInfoCustom.setPointreason("充值到账"+tRechargeInfoCustom.getRechargepoints()+"赠送"+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointsid(UUID.randomUUID().toString().replace("-", ""));
			tPointsInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setPointstype("26");
			tPointsInfoCustom.setPointsupdate(tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tPointsInfoCustom.setTaskpk(0);
			tPointsInfoCustom.setUserid(tUserInfoCustom.getUserid());
			int ii1 = pointsInfoService.savePoints(tPointsInfoCustom);
			//修改用户当前积分
			tUserInfoCustom.setPoints(tUserInfoCustom.getPoints()+tRechargeInfoCustom.getRechargepoints()+tRechargeInfoCustom.getRechargegivepoints());
			tUserInfoCustom.setUpdatetime(sdf.format(new Date()));
			tUserInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
			int ii2 = userInfoService.updateUserinfoPointByUserid(tUserInfoCustom);
			System.out.println(ii1+"============"+ii2);
		}
		map.put("data", "success");
		return map;
	}
}
