package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TFilepathInfoCustomMapper;
import com.zhenapp.po.Custom.TFilepathInfoCustom;
import com.zhenapp.service.FilepathInfoService;

@Service
public class FilepathInfoServiceImp implements FilepathInfoService {
	
	@Autowired
	private TFilepathInfoCustomMapper tFilepathInfoCustomMapper;
	
	@Override
	public TFilepathInfoCustom findFilepathByid(String filepathid) throws Exception {
		// TODO Auto-generated method stub
		return tFilepathInfoCustomMapper.findFilepathByid(filepathid);
	}

}
