package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.TWebInfoMapper;
import com.zhenapp.mapper.Custom.TWebInfoCustomMapper;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.WebInfoService;
@Service
public class WebInfoServiceImp implements WebInfoService {
	
	@Autowired
	private TWebInfoMapper tWebInfoMapper;
	@Autowired
	private TWebInfoCustomMapper tWebInfoCustomMapper;

	@Override
	public TWebInfoCustom findWebBywebwww(String webwww) throws Exception {
		return tWebInfoCustomMapper.findWebBywebwww(webwww);
	}

	@Override
	public int updateWebBywebwww(TWebInfoCustom tWebInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tWebInfoCustomMapper.updateWebBywebwww(tWebInfoCustom);
	}
	
	
}
