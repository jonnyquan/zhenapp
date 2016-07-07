package com.zhenapp.controller.back.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TIndexInfoCustom;
import com.zhenapp.po.Custom.TIntroInfoCustom;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.IndexInfoService;
import com.zhenapp.service.IntroInfoService;
import com.zhenapp.service.NoteInfoService;
import com.zhenapp.service.PriceAgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;
@Transactional
@Controller
@RequestMapping(value="/user")
public class SetAgentController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private IntroInfoService introInfoService;
	@Autowired
	private NoteInfoService noteInfoService;
	@Autowired
	private IndexInfoService indexInfoService;
	@Autowired
	private PriceAgentInfoService priceAgentInfoService;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/*
	 * 设为代理----系统管理员
	 */
	@RequestMapping(value="/setAgent/{userpk}")
	public @ResponseBody ModelAndView setAgent(@PathVariable(value="userpk") String userpk,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustomsession=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		//查询出系统管理员的web信息
		TWebInfoCustom tWebInfoCustomadmin = webInfoService.findWebByAgentid("0");
		TUserInfoCustom TUserInfoCustom = userInfoService.findUserByuserpk(userpk);
		//修改角色为代理   useroleid=2   代理上级变为0 即系统管理员
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("agentid", "0");
		TIntroInfoCustom tIntroInfoCustomtemp = introInfoService.findIntroinfo(hashmap);
		TIndexInfoCustom tIndexInfoCustomtemp = indexInfoService.findIndex(hashmap);
		hashmap.put("userpk", userpk);
		hashmap.put("oldroleid", "3");
		hashmap.put("newroleid", "2");
		hashmap.put("updatetime", sdf.format(new Date()));
		hashmap.put("updateuser", tUserInfoCustomsession.getUserid());
		userInfoService.updateroleAndagent(hashmap);
		//插入代理信息及对应的web信息    基本信息默认保持与系统管理员一致
		TAgentInfoCustom tAgentInfoCustom = new TAgentInfoCustom();
		tAgentInfoCustom.setAgentid(UUID.randomUUID().toString().replace("-", ""));
		tAgentInfoCustom.setAgentuserid(TUserInfoCustom.getUserid());
		tAgentInfoCustom.setAgentperson(TUserInfoCustom.getUsernick());
		tAgentInfoCustom.setAgentphone(TUserInfoCustom.getUserphone());
		tAgentInfoCustom.setAgentname("网站名称");//网站名称，请尽快修改...
		tAgentInfoCustom.setAgentstate("29");
		tAgentInfoCustom.setCreatetime(sdf.format(new Date()));
		tAgentInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		agentInfoService.saveAgentInfo(tAgentInfoCustom);
		TWebInfoCustom tWebInfoCustom = new TWebInfoCustom();
		tWebInfoCustom.setWebid(UUID.randomUUID().toString().replace("-", ""));
		tWebInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tWebInfoCustom.setLogo(tWebInfoCustomadmin.getLogo());
		tWebInfoCustom.setCarousel01(tWebInfoCustomadmin.getCarousel01());
		tWebInfoCustom.setCarousel02(tWebInfoCustomadmin.getCarousel02());
		tWebInfoCustom.setCarousel03(tWebInfoCustomadmin.getCarousel03());
		tWebInfoCustom.setQq(tWebInfoCustomadmin.getQq());
		tWebInfoCustom.setQq2(tWebInfoCustomadmin.getQq2());
		tWebInfoCustom.setQq3(tWebInfoCustomadmin.getQq3());
		tWebInfoCustom.setQqgroup(tWebInfoCustom.getQqgroup());
		tWebInfoCustom.setWechat(tWebInfoCustomadmin.getWechat());
		tWebInfoCustom.setRecord(tWebInfoCustomadmin.getRecord());
		tWebInfoCustom.setAlipay(tWebInfoCustomadmin.getAlipay());
		tWebInfoCustom.setBg01(tWebInfoCustomadmin.getBg01());
		tWebInfoCustom.setBg02(tWebInfoCustomadmin.getBg02());
		tWebInfoCustom.setIco(tWebInfoCustomadmin.getIco());
		tWebInfoCustom.setCreatetime(sdf.format(new Date()));
		tWebInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tWebInfoCustom.setUpdatetime(sdf.format(new Date()));
		tWebInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		webInfoService.saveWebInfo(tWebInfoCustom);
		//插入服务介绍信息
		TIntroInfoCustom tIntroInfoCustom = new TIntroInfoCustom();
		tIntroInfoCustom.setIntroid(UUID.randomUUID().toString().replace("-", ""));
		tIntroInfoCustom.setIntroname(tIntroInfoCustomtemp.getIntroname());
		tIntroInfoCustom.setIntrotext(tIntroInfoCustomtemp.getIntrotext());
		tIntroInfoCustom.setCreatetime(sdf.format(new Date()));
		tIntroInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tIntroInfoCustom.setUpdatetime(sdf.format(new Date()));
		tIntroInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		introInfoService.insertIntro(tIntroInfoCustom);
		TIndexInfoCustom tIndexInfoCustom = new TIndexInfoCustom();
		tIndexInfoCustom.setIndexid(UUID.randomUUID().toString().replace("-", ""));
		tIndexInfoCustom.setIndexname(tIndexInfoCustomtemp.getIndexname());
		tIndexInfoCustom.setIndextext(tIndexInfoCustomtemp.getIndextext());
		tIndexInfoCustom.setCreatetime(sdf.format(new Date()));
		tIndexInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tIndexInfoCustom.setUpdatetime(sdf.format(new Date()));
		tIndexInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		indexInfoService.insertIndex(tIndexInfoCustom);
		//插入公告信息
		hashmap.clear();
		hashmap.put("agentid", "0");
		hashmap.put("notetype", "2");
		TNoteInfoCustom tNoteInfoCustom2 = noteInfoService.findNoteinfo(hashmap);
		tNoteInfoCustom2.setNoteid(tIntroInfoCustom.getIntroid());
		tNoteInfoCustom2.setAgentid(tAgentInfoCustom.getAgentid());
		tNoteInfoCustom2.setCreatetime(sdf.format(new Date()));
		tNoteInfoCustom2.setCreateuser(tUserInfoCustomsession.getUserid());
		tNoteInfoCustom2.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom2.setUpdateuser(tUserInfoCustomsession.getUserid());
		noteInfoService.savenote(tNoteInfoCustom2);
		hashmap.put("agentid", "0");
		hashmap.put("notetype", "3");
		TNoteInfoCustom tNoteInfoCustom3 = noteInfoService.findNoteinfo(hashmap);
		tNoteInfoCustom3.setNoteid(tIndexInfoCustom.getIndexid());
		tNoteInfoCustom3.setAgentid(tAgentInfoCustom.getAgentid());
		tNoteInfoCustom3.setCreatetime(sdf.format(new Date()));
		tNoteInfoCustom3.setCreateuser(tUserInfoCustomsession.getUserid());
		tNoteInfoCustom3.setUpdatetime(sdf.format(new Date()));
		tNoteInfoCustom3.setUpdateuser(tUserInfoCustomsession.getUserid());
		noteInfoService.savenote(tNoteInfoCustom3);
		TPriceInfoCustom tPriceInfoCustom = priceInfoService.findPriceByAgentid("0");
		tPriceInfoCustom.setPriceid(UUID.randomUUID().toString().replace("-", ""));
		tPriceInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tPriceInfoCustom.setCreatetime(sdf.format(new Date()));
		tPriceInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tPriceInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPriceInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		priceInfoService.savePriceInfo(tPriceInfoCustom);
		TPriceAgentInfoCustom tPriceAgentInfoCustom = priceAgentInfoService.findPriceByAgentid("0");
		tPriceAgentInfoCustom.setPriceid(UUID.randomUUID().toString().replace("-", ""));
		tPriceAgentInfoCustom.setAgentid(tAgentInfoCustom.getAgentid());
		tPriceAgentInfoCustom.setCreatetime(sdf.format(new Date()));
		tPriceAgentInfoCustom.setCreateuser(tUserInfoCustomsession.getUserid());
		tPriceAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tPriceAgentInfoCustom.setUpdateuser(tUserInfoCustomsession.getUserid());
		priceAgentInfoService.insertPriceAgent(tPriceAgentInfoCustom);
		mv.setViewName("/user/findUserByPageAndAdmin");
		return mv;
	}
}
