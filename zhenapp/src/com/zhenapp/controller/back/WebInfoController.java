package com.zhenapp.controller.back;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.PriceInfoService;
import com.zhenapp.service.UserInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/web")
public class WebInfoController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private AgentInfoService agentInfoService;
	@Autowired
	private PriceInfoService priceInfoService;
	@Autowired
	private UserInfoService userInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	/*
	 * 根据代理id查询web信息--代理
	 */
	@RequestMapping(value="/findWebByAgentid")
	public @ResponseBody ModelAndView findWebByAgentid(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TAgentInfoCustom tAgentInfoCustom= agentInfoService.findAgentByuserid(tUserInfoCustom.getUserid());
		String points= userInfoService.findpointsByUsernickAndPwd(tUserInfoCustom);
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid(tAgentInfoCustom.getAgentid());
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.addObject("points", points);
		mv.setViewName("/backstage/agent/websetting.jsp");
		return mv;
	}
	/*
	 * 根据代理id查询web信息--系统管理员
	 */
	@RequestMapping(value="/findWebByAgentidadmin")
	public @ResponseBody ModelAndView findWebByAgentidadmin(String agentid) throws Exception{
		ModelAndView mv = new ModelAndView();
		TAgentInfoCustom tAgentInfoCustom = agentInfoService.findAgentByAgentid(agentid);
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid(agentid);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.setViewName("/backstage/admin/websetting.jsp");
		return mv;
	}
	
	@RequestMapping(value="/agentAndwebSave")
	public @ResponseBody ModelMap agentAndwebSave(HttpSession session,TWebInfoCustom tWebInfoCustom,TAgentInfoCustom tAgentInfoCustom) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		tWebInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		tWebInfoCustom.setUpdatetime(sdf.format(new Date()));
		webInfoService.updateWebByAgentid(tWebInfoCustom);
		tAgentInfoCustom.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
		agentInfoService.updateAgentByid(tAgentInfoCustom);
		map.put("ec", "0");
		return map;
	}
	
	@RequestMapping(value="/imagesave")
	public @ResponseBody ModelMap imagesave(HttpServletRequest request,@RequestParam("image_file")MultipartFile image_file) throws Exception{
		ModelMap map = new ModelMap();
		String originalFilename = image_file.getOriginalFilename();
		String imagefilepath="";
		// 上传图片
		if (image_file != null && originalFilename != null && originalFilename.length() > 0) {
			// 存储图片的物理路径
			String pic_path = request.getSession().getServletContext().getRealPath("/") + "webimg/";
			// 新的图片名称
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			image_file.transferTo(newFile);
			imagefilepath=newFileName;
		}
		map.put("rst", imagefilepath);
		map.put("ec", "0");
		return map;
	}
}
