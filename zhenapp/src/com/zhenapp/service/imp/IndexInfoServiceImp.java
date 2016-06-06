package com.zhenapp.service.imp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TIndexInfoCustomMapper;
import com.zhenapp.po.Custom.TIndexInfoCustom;
import com.zhenapp.service.IndexInfoService;
@Service
public class IndexInfoServiceImp implements IndexInfoService {
	@Autowired
	private TIndexInfoCustomMapper tIndexInfoCustomMapper;
	
	@Override
	public TIndexInfoCustom findIndex(HashMap<String, Object> hashmap) throws Exception {
		return tIndexInfoCustomMapper.findIndex(hashmap);
	}
	@Override
	public int insertIndex(TIndexInfoCustom tIndexInfoCustom) throws Exception {
		return tIndexInfoCustomMapper.insertIndex(tIndexInfoCustom);
	}
	@Override
	public int updateIndex(HashMap<String, Object> hashmap) throws Exception {
		return tIndexInfoCustomMapper.updateIndex(hashmap);
	}
	
}
