package com.zhenapp.controller.back.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/web")
public class SaveWebImageController {
	
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
