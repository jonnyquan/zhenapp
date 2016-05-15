package com.zhenapp.controller.back;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.po.Custom.TUserInfoCustom;
import com.zhenapp.service.TbaccountInfoService;

@Controller
@RequestMapping(value="/tbaoccount")
public class TbaccountInfoController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = Logger.getLogger(TbaccountInfoController.class);
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
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
	public @ResponseBody ModelAndView responsetaobaoid(String tbaccountphoneid,String tbaccountstate,Integer page,Integer rows) throws Exception{
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if (page == null || page==0) {
			page = 1;
		} 
		rows = 10;
		pagemap.put("page", (page - 1) * rows);
		pagemap.put("rows", rows);
		pagemap.put("tbaccountphoneid", tbaccountphoneid);
		pagemap.put("tbaccountstate", tbaccountstate);
		List<TTbaccountInfoCustom> tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountBypage(pagemap);
		int total = tbaccountInfoService.findTotalTbaccountBypage(pagemap);
		mv.addObject("tTbaccountInfoCustomlist",tTbaccountInfoCustomlist);
		mv.addObject("total",total);
		mv.addObject("pagenum",page);
		mv.setViewName("/backstage/admin/findtaobaoid.jsp");
		return mv;
	}
	
	/*
	 * 根据淘宝账号主键删除淘宝账号信息
	 * 
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
			// 存储图片的物理路径
			String pic_path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "page/other/tbaccount/";
			// 新的图片名称
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新图片
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
			for (int i = 0; i < strarr.length; i++) {
				String[] tbaccount = strarr[i].split("\\|");
				
				TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
				tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID()
						.toString().replace("-", ""));
				tTbaccountInfoCustom.setTbaccountname(tbaccount[0]);
				tTbaccountInfoCustom.setTbaccountpwd(tbaccount[1]);
				if (tbaccount.length > 2) {
					tTbaccountInfoCustom.setTbaccountphoneid(tbaccount[2].trim());
					try{
						Integer.parseInt(tbaccount[2].trim());
						
					}catch(Exception e){
						logger.error("上传的淘宝账号格式错误，第三列为非数值");
						return map;
					}
				}
				tTbaccountInfoCustom.setCreatetime(time);
				tTbaccountInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tTbaccountInfoCustom.setUpdatetime(time);
				tTbaccountInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
			}

		}
		map.put("ec", "0");
		map.put("rst", jsonem);
		return map;
	}

	
	@RequestMapping(value="/findTbaccountBypage")
	public @ResponseBody ModelMap findTbaccountBypage(Integer page,Integer rows,String tbaccountphoneid,String tbaccountstate) throws Exception{
		ModelMap map=new ModelMap();
		HashMap<String,Object> pagemap=new HashMap<String,Object>();
		if(tbaccountstate==null || tbaccountstate.equals("0")){
			pagemap.put("tbaccountstate", null);
		}else{
			pagemap.put("tbaccountstate", tbaccountstate);
		}
		if(tbaccountstate==null ){
			pagemap.put("tbaccountphoneid", null);
		}else{
			pagemap.put("tbaccountphoneid", tbaccountphoneid);
		}
		if (page == null || page == null) {
			pagemap.put("page", 0);
			pagemap.put("rows", 10);
		} else {
			pagemap.put("page", page-1);
			pagemap.put("rows", rows);
		}
		List<TTbaccountInfoCustom>  tTbaccountInfoCustomlist = tbaccountInfoService.findTbaccountBypage(pagemap);
		//List<TTbaccountInfoCustom>  tTbaccountInfoCustomAlllist = tbaccountInfoService.findAllTbaccountBypage(pagemap);
		int total = tbaccountInfoService.findTotalTbaccountBypage(pagemap);
		
		map.put("total",total);
		map.put("rows", tTbaccountInfoCustomlist);
		
		return map;
	}
	@RequestMapping(value="/deleteTbaccountByid")
	public @ResponseBody ModelMap deleteTbaccountByid(String tbaccountids) throws Exception{
		ModelMap map=new ModelMap();
		int i= tbaccountInfoService.deleteTbaccountByid(tbaccountids);
		System.out.println(i);
		return map;
	}
}
