package com.zhenapp.controller.back.tbaccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.po.Custom.TTbaccountInfoTempCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.PhoneInfoService;
import com.zhenapp.service.TbaccountInfoService;
import com.zhenapp.service.TbaccountInfoTempService;

@Controller
@RequestMapping(value="/tbaoccount")
public class TbaccountInfoController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = Logger.getLogger(TbaccountInfoController.class);
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	@Autowired
	private TbaccountInfoTempService tbaccountInfoTempService;
	@Autowired
	private PhoneInfoService phoneInfoService;
	
	@Value("${config.tbidfile}")
	private String tbidfilepath;
	
	@Value("${middleRows}")
	private Integer middleRows;
	
	/*
	 * 跳转到上传淘宝账号界面
	 */
	@RequestMapping(value="responsetbaoccount")
	public @ResponseBody ModelAndView responsetbaoccount() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backstage/admin/uploadtaobaoid.jsp");
		return mv;
	}
	
	/*
	 * 跳转到查看淘宝账号界面
	 */
	@RequestMapping(value="/responsetaobaoid")
	public @ResponseBody ModelAndView responsetaobaoid(String tbaccountphoneid,String tbaccountstate,Integer page) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		pagemap.put("page", (page - 1) * middleRows);
		pagemap.put("rows", middleRows);
		pagemap.put("tbaccountphoneid", tbaccountphoneid);
		pagemap.put("tbaccountstate", tbaccountstate);
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountBypage(pagemap);
		int total = tbaccountInfoService.findTotalTbaccountBypage(pagemap);
		mv.addObject("tTbaccountInfoCustomlist",tTbaccountInfoCustomlist);
		mv.addObject("tbaccountphoneid",tbaccountphoneid);
		mv.addObject("tbaccountstate",tbaccountstate);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/admin/findtaobaoid.jsp");
		return mv;
	}
	/*
	 * 根据淘宝账号主键删除淘宝账号信息 
	 */
	@RequestMapping(value="/deletetaobaoidBypk")
	public @ResponseBody ModelAndView deletetaobaoidBypk(String tbaccountid) throws Exception{
		ModelAndView mv = new ModelAndView();
		tbaccountInfoService.deleteTbaccountByid(tbaccountid);
		mv.setViewName("responsetaobaoid");
		return mv;
	}
	/*
	 * 上传淘宝账号信息
	 */
	@RequestMapping(value = "/uploadTbaccount", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelMap uploadTbaccount(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
		ModelMap map = new ModelMap();
		String time = sdf.format(new Date());
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String[] jsonem=null;
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储账号文件的物理路径
			String pic_path = tbidfilepath;
			// 新的文件名称
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新文件
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			Reader reader = new InputStreamReader(new FileInputStream(newFile));
			String str = "";
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				if (((char) tempchar) != '\r') {
					str = str + (char) tempchar;
				}
			}
			reader.close();
			String[] strarr = str.split("\n");
			jsonem = strarr;
			tbaccountInfoTempService.deleteAll();
			for (int i = 0; i < strarr.length; i++) {
				String[] tbaccount = strarr[i].split("\\|");
				TTbaccountInfoTempCustom tTbaccountInfoTempCustom = new TTbaccountInfoTempCustom();
				tTbaccountInfoTempCustom.setTbaccountid(UUID.randomUUID().toString().replace("-", ""));
				tTbaccountInfoTempCustom.setTbaccountname(tbaccount[0]);
				tTbaccountInfoTempCustom.setTbaccountpwd(tbaccount[1]);
				if(tbaccount.length>2){
					tTbaccountInfoTempCustom.setTbaccountphoneid(tbaccount[2].trim());
				}
				tTbaccountInfoTempCustom.setCreatetime(time);
				tTbaccountInfoTempCustom.setCreateuser(tUserInfoCustom.getUserid());
				tTbaccountInfoTempCustom.setUpdatetime(time);
				tTbaccountInfoTempCustom.setUpdateuser(tUserInfoCustom.getUserid());
				tbaccountInfoTempService.insertTbaccount(tTbaccountInfoTempCustom);
			}
		}
		map.put("ec", "0");
		map.put("rst", jsonem);
		return map;
	}
	
	/*
	 * 放入大号库
	 * 或者按照手机分配
	 */
	@RequestMapping(value = "/saveAccount", method = { RequestMethod.POST,RequestMethod.GET })
	public @ResponseBody ModelMap saveAccount(HttpSession session) throws Exception {
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TTbaccountInfoTempCustom> tTbaccountInfoTempCustomlist = tbaccountInfoTempService.findAllTTbaccountInfoTemp();
		for (int i = 0; i < tTbaccountInfoTempCustomlist.size(); i++) {
			TTbaccountInfoTempCustom tTbaccountInfoTempCustom= tTbaccountInfoTempCustomlist.get(i);
			TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
			tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID().toString().replace("-", ""));
			tTbaccountInfoCustom.setTbaccountname(tTbaccountInfoTempCustom.getTbaccountname());
			tTbaccountInfoCustom.setTbaccountpwd(tTbaccountInfoTempCustom.getTbaccountpwd());
			if (tTbaccountInfoTempCustom.getTbaccountphoneid()!=null) {
				tTbaccountInfoCustom.setTbaccountphoneid(tTbaccountInfoTempCustom.getTbaccountphoneid());
			}
			tTbaccountInfoCustom.setTbaccountstate("60");
			tTbaccountInfoCustom.setCreatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tTbaccountInfoCustom.setUpdatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
		}
		logger.info("保存淘宝账号信息成功!");
		map.put("ec", "0");
		return map;
	}
	/*
	 * 按手机号分配
	 */
	@RequestMapping(value = "/saveAccountByphone", method = { RequestMethod.POST,RequestMethod.GET })
	public @ResponseBody ModelMap saveAccountByphone(HttpSession session, String phoneid) throws Exception {
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TTbaccountInfoTempCustom> tTbaccountInfoTempCustomlist = tbaccountInfoTempService.findAllTTbaccountInfoTemp();
		for (int i = 0; i < tTbaccountInfoTempCustomlist.size(); i++) {
			TTbaccountInfoTempCustom tTbaccountInfoTempCustom= tTbaccountInfoTempCustomlist.get(i);
			TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
			tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID().toString().replace("-", ""));
			tTbaccountInfoCustom.setTbaccountname(tTbaccountInfoTempCustom.getTbaccountname());
			tTbaccountInfoCustom.setTbaccountpwd(tTbaccountInfoTempCustom.getTbaccountpwd());
			tTbaccountInfoCustom.setTbaccountphoneid(phoneid);
			tTbaccountInfoCustom.setTbaccountstate("60");
			tTbaccountInfoCustom.setCreatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tTbaccountInfoCustom.setUpdatetime(sdf.format(new Date()));
			tTbaccountInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
		}
		logger.info("按手机号分配淘宝账号信息成功!");
		map.put("ec", "0");
		return map;
	}
	/*
	 * 平均分配账号
	 */
	@RequestMapping(value = "/avgAccount", method = { RequestMethod.POST,RequestMethod.GET })
	public @ResponseBody ModelMap avgAccount(HttpSession session, Integer phoneCount,Integer num) throws Exception {
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		List<TTbaccountInfoTempCustom> tTbaccountInfoTempCustomlist = tbaccountInfoTempService.findAllTTbaccountInfoTemp();
		List<TPhoneInfoCustom> TPhoneInfoCustomlist = phoneInfoService.findAllPhoneBycount(phoneCount);
		int a=0;
		for (int i = 0; i < TPhoneInfoCustomlist.size(); i++) {
			for (int j = 0; j < num; j++) {
				TTbaccountInfoTempCustom tTbaccountInfoTempCustom= tTbaccountInfoTempCustomlist.get(a);
				TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
				tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID().toString().replace("-", ""));
				tTbaccountInfoCustom.setTbaccountname(tTbaccountInfoTempCustom.getTbaccountname());
				tTbaccountInfoCustom.setTbaccountpwd(tTbaccountInfoTempCustom.getTbaccountpwd());
				tTbaccountInfoCustom.setTbaccountphoneid(TPhoneInfoCustomlist.get(i).getPhoneid());
				tTbaccountInfoCustom.setCreatetime(sdf.format(new Date()));
				tTbaccountInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tTbaccountInfoCustom.setUpdatetime(sdf.format(new Date()));
				tTbaccountInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
				a++;
			}	
		}
		logger.info("按平均分配淘宝账号信息"+a+"条成功!");
		map.put("ec", "0");
		return map;
	}
	/*
	 * 设置一键换号
	 */
	@RequestMapping(value="/phoneChange")
	public @ResponseBody ModelMap phoneChange(HttpSession session,String phoneTag) throws Exception{
		ModelMap map = new ModelMap();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("tbaccounttag", phoneTag);
		hashmap.put("updatetime",sdf.format(new Date()));
		hashmap.put("updateuser",tUserInfoCustom.getUserid());
		int i= tbaccountInfoService.updateTbaccountTag(hashmap);
		//将状为nochange的账号信息状态修改为未测试 60
		tbaccountInfoService.updateTbaccountstate();
		logger.info("修改淘宝账号手机标记信息"+i+"条成功!");
		map.put("ec", "0");
		return map;
	}
	/*
	 * 按条件删除淘宝账号
	 */
	@RequestMapping(value="/deleteAccount")
	public @ResponseBody ModelMap deleteAccount(String problem,String pid) throws Exception{
		ModelMap map = new ModelMap();
		HashMap<String, Object> pagemap = new HashMap<String, Object>();
		pagemap.put("tbaccountphoneid", pid);
		pagemap.put("tbaccountstate", problem);
		tbaccountInfoService.deleteAccount(pagemap);
		map.put("ec", "0");
		return map;
	}
}
