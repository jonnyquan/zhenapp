package com.zhenapp.controller.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/util")
public class upload {
	@Value("${config.imgurl}")
	private String imgurl;

	@RequestMapping(value = "/upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	ModelAndView upload(MultipartFile file) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 原始名称
		String originalFilename = file.getOriginalFilename();
		// 上传图片
		if (file != null && originalFilename != null
				&& originalFilename.length() > 0) {
			// 存储图片的物理路径
			String pic_path = imgurl;
			System.out
					.println("==================================================="
							+ pic_path);

			// 新的图片名称
			String newFileName = UUID.randomUUID()
					+ originalFilename.substring(originalFilename
							.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);

			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
		}
		mv.setViewName("/page/pagestates/info.jsp");
		return mv;
	}
}
