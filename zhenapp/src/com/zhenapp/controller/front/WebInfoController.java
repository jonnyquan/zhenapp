package com.zhenapp.controller.front;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.AgentInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value="/web")
public class WebInfoController {

	@Autowired
	private WebInfoService webInfoService;
	
	@Autowired
	private AgentInfoService agentInfoService;
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	/*
	 * 根据访问域名查询web信息
	 *
	 */
	@RequestMapping(value="/findWebBywebwww")
	public @ResponseBody ModelAndView findWebBywebwww(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		String webwww=request.getServerName();
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebBywebwww(webwww);
		TAgentInfoCustom tAgentInfoCustom =agentInfoService.findAgentBywww(webwww);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.addObject("tAgentInfoCustom",tAgentInfoCustom);
		mv.setViewName("/page/upload/webEdit.jsp");
		return mv;
	}
	/*
	 * 根据代理id查询web信息
	 * 
	 */
	@RequestMapping(value="/findWebByAgentid/{agentid}")
	public @ResponseBody ModelAndView findWebByAgentid_rest(@PathVariable(value="agentid")String agentid, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		TWebInfoCustom tWebInfoCustom = webInfoService.findWebByAgentid(agentid);
		mv.addObject("tWebInfoCustom",tWebInfoCustom);
		mv.setViewName("/page/upload/webEdit.jsp");
		return mv;
	}
	
	
	/*
	 * 修改web页面图片信息
	 */
	@RequestMapping(value = "/updatewebinfo")
	public @ResponseBody ModelAndView uploadwebinfo(HttpServletRequest request,TAgentInfoCustom tAgentInfoCustom,TWebInfoCustom tWebInfoCustom, @RequestParam("files") MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		TWebInfoCustom tWebInfoCustomold = webInfoService.findWebBywebwww(tWebInfoCustom.getAgentid());
		
		TAgentInfoCustom tAgentInfoCustomold = agentInfoService.findAgentByAgentid(tAgentInfoCustom.getAgentid());
		tAgentInfoCustomold.setAgentname(tAgentInfoCustom.getAgentname());
		tAgentInfoCustomold.setAgentwww(tAgentInfoCustom.getAgentwww());
		tAgentInfoCustomold.setAgenthttp(tAgentInfoCustom.getAgenthttp());
		tAgentInfoCustomold.setUpdatetime(sdf.format(new Date()));
		tAgentInfoCustomold.setUpdateuser(tUserInfoCustom.getUserid());
		agentInfoService.updateAgentByid(tAgentInfoCustomold);
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
				// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];
					// 原始名称
					String originalFilename = file.getOriginalFilename();
					// 上传图片
					if (file != null && originalFilename != null
							&& originalFilename.length() > 0) {
						// 存储图片的物理路径
						String pic_path = request.getSession()
								.getServletContext().getRealPath("/")
								+ "bootstrap\\img\\index\\";
						// 新的图片名称
						String newFileName = UUID.randomUUID().toString().replace("-", "")
								+ originalFilename.substring(originalFilename
										.lastIndexOf("."));
						// 新图片
						File newFile = new File(pic_path + newFileName);
						// 将内存中的数据写入磁盘
						file.transferTo(newFile);

						if (i == 0) {
							tWebInfoCustomold.setLogo(newFileName);
						} else if (i == 1) {
							tWebInfoCustomold.setCarousel01(newFileName);
						} else if (i == 2) {
							tWebInfoCustomold.setCarousel02(newFileName);
						} else if (i == 3) {
							tWebInfoCustomold.setCarousel03(newFileName);
						} else if (i == 4) {
							tWebInfoCustomold.setBg01(newFileName);
						} else if (i == 5) {
							tWebInfoCustomold.setBg02(newFileName);
						}
					}
			}
			tWebInfoCustomold.setQq(tWebInfoCustom.getQq());
			tWebInfoCustomold.setQqgroup(tWebInfoCustom.getQqgroup());
			tWebInfoCustomold.setArchival(tWebInfoCustom.getArchival());
			tWebInfoCustomold.setAlipay(tWebInfoCustom.getAlipay());
			tWebInfoCustomold.setUpdateuser(tUserInfoCustom.getUserid());
			tWebInfoCustomold.setUpdatetime(sdf.format(new Date()));
			webInfoService.updateWebByAgentid(tWebInfoCustom);
		}
		mv.setViewName("/web/findWebBywebwww");
		return mv;
	}
}
