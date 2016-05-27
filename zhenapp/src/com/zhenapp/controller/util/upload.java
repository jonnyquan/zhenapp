package com.zhenapp.controller.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhenapp.service.ScriptInfoService;
import com.zhenapp.service.TbaccountInfoService;
import com.zhenapp.service.WebInfoService;

@Controller
@RequestMapping(value = "/util")
public class upload {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private ScriptInfoService scriptInfoService;
	@Autowired
	private TbaccountInfoService tbaccountInfoService;
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/*
	 * 上传脚本信息
	 
	@RequestMapping(value = "/uploadscript")
	public @ResponseBody
	ModelAndView uploadscript(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws Exception {
		TScriptInfoCustom tScriptInfoCustom = new TScriptInfoCustom();
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		String time = sdf.format(new Date());
		ModelAndView mv = new ModelAndView();
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储图片的物理路径
			// String pic_path =
			// request.getSession().getServletContext().getRealPath("/") +
			// "page/other/scriptfile/";
			String pic_path = "C:/webfile/scriptfile/";
			// 新的图片名称
			String newFileName = UUID.randomUUID().toString().replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			tScriptInfoCustom.setScriptpath(pic_path + newFileName);
			tScriptInfoCustom.setScriptname(originalFilename);
			tScriptInfoCustom.setCreatetime(time);
			tScriptInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
			tScriptInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
			tScriptInfoCustom.setUpdatetime(time);
			tScriptInfoCustom.setScriptid(UUID.randomUUID().toString().replace("-", ""));
			scriptInfoService.insertScript(tScriptInfoCustom);
		}
		mv.setViewName("/page/other/uploadscript.jsp");
		return mv;
	}*/

	/*
	 * 上传淘宝账号信息
	 
	@RequestMapping(value = "/uploadTbaccount", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	ModelAndView uploadTbaccount(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		HttpSession session = request.getSession();
		TUserInfoCustom tUserInfoCustom=(TUserInfoCustom) session.getAttribute("tUserInfoCustom");
		
		ModelAndView mv = new ModelAndView();
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
			System.out.println(str);
			String[] strarr = str.split("\n");
			for (int i = 0; i < strarr.length; i++) {
				String[] tbaccount = strarr[i].split("\\|");

				TTbaccountInfoCustom tTbaccountInfoCustom = new TTbaccountInfoCustom();
				tTbaccountInfoCustom.setTbaccountid(UUID.randomUUID()
						.toString().replace("-", ""));
				tTbaccountInfoCustom.setTbaccountname(tbaccount[0]);
				tTbaccountInfoCustom.setTbaccountpwd(tbaccount[1]);
				if (tbaccount.length > 2) {
					tTbaccountInfoCustom.setTbaccountphoneid(tbaccount[2]);
				}
				tTbaccountInfoCustom.setCreatetime(time);
				tTbaccountInfoCustom.setCreateuser(tUserInfoCustom.getUserid());
				tTbaccountInfoCustom.setUpdatetime(time);
				tTbaccountInfoCustom.setUpdateuser(tUserInfoCustom.getUserid());
				tbaccountInfoService.insertTbaccount(tTbaccountInfoCustom);
			}

		}
		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}*/

	/*@RequestMapping(value = "/downloadFile/{scriptid}")
	public void downloadFile(@PathVariable(value="scriptid") String scriptid, HttpServletResponse response,HttpServletRequest request)  {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			TScriptInfoCustom tScriptInfoCustom = scriptInfoService.findScriptByid(scriptid);
			request.setCharacterEncoding("UTF-8");  
	        BufferedInputStream bis = null;  
	        BufferedOutputStream bos = null;  
	        //获取下载文件路径
	        String downLoadPath = tScriptInfoCustom.getScriptpath();
	        //获取文件的长度
	        long fileLength = new File(downLoadPath).length();
	        //设置文件输出类型
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-disposition", "attachment; filename="  
	                + new String(tScriptInfoCustom.getScriptname().getBytes("utf-8"), "ISO8859-1")); 
	        //设置输出长度
	        response.setHeader("Content-Length", String.valueOf(fileLength));  
	        //获取输入流
	        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	        //输出流
	        bos = new BufferedOutputStream(response.getOutputStream());  
	        byte[] buff = new byte[2048];  
	        int bytesRead;  
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	            bos.write(buff, 0, bytesRead);  
	        }  
	        //关闭流
	        bis.close();  
	        bos.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
