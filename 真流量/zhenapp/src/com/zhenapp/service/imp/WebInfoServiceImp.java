package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhenapp.mapper.Custom.TWebInfoCustomMapper;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.WebInfoService;

public class WebInfoServiceImp implements WebInfoService {

	@Autowired
	private TWebInfoCustomMapper tWebInfoCustomMapper;

	@Override
	public TWebInfoCustom findWebBywebwww(String webwww) throws Exception {
		return tWebInfoCustomMapper.findWebBywebwww(webwww);
	}
	
	
}
