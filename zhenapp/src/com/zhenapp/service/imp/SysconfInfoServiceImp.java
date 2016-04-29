package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TSysconfInfoCustomMapper;
import com.zhenapp.po.Custom.TSysconfInfoCustom;
import com.zhenapp.service.SysconfInfoService;
@Service
public class SysconfInfoServiceImp implements SysconfInfoService{

	@Autowired
	private TSysconfInfoCustomMapper tSysconfInfoCustomMapper;
	
	@Override
	public TSysconfInfoCustom findSysconf() throws Exception {
		// TODO Auto-generated method stub
		return tSysconfInfoCustomMapper.findSysconf();
	}

	@Override
	public int updateSysinfo(TSysconfInfoCustom tSysconfInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tSysconfInfoCustomMapper.updateSysinfo(tSysconfInfoCustom);
	}

	@Override
	public String findSysdesable() throws Exception {
		// TODO Auto-generated method stub
		return tSysconfInfoCustomMapper.findSysdesable();
	}
	
}
