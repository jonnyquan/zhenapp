package com.zhenapp.service.imp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TIntroInfoCustomMapper;
import com.zhenapp.po.Custom.TIntroInfoCustom;
import com.zhenapp.service.IntroInfoService;

@Service
public class IntroInfoServiceImp implements IntroInfoService{

	@Autowired
	private TIntroInfoCustomMapper tIntroInfoCustomMapper;
	
	@Override
	public TIntroInfoCustom findIntroinfo(HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tIntroInfoCustomMapper.findIntroinfo(pagemap);
	}

	@Override
	public int updateIntroById(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tIntroInfoCustomMapper.updateIntroById(hashmap);
	}

	@Override
	public int insertIntro(TIntroInfoCustom tIntroInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tIntroInfoCustomMapper.insertIntro(tIntroInfoCustom);
	}

}
