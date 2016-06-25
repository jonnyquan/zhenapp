package com.zhenapp.service.imp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TChangeInfoCustomMapper;
import com.zhenapp.po.Custom.TChangeInfoCustom;
import com.zhenapp.service.ChangeInfoService;

@Service
public class ChangeInfoServiceImp implements ChangeInfoService{

	@Autowired
	private TChangeInfoCustomMapper tChangeInfoCustomMapper;
	
	@Override
	public TChangeInfoCustom findChangeinfo(HashMap<String, Object> hashmap) throws Exception {
		return tChangeInfoCustomMapper.findChangeinfo(hashmap);
	}

	@Override
	public int updatestate(HashMap<String, Object> hashmap) throws Exception {
		return tChangeInfoCustomMapper.updatestate(hashmap);
	}
	
}
