package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TPhoneInfoCustomMapper;
import com.zhenapp.po.Custom.TPhoneInfoCustom;
import com.zhenapp.service.PhoneInfoService;
@Service
public class PhoneInfoServiceImp implements PhoneInfoService{

	@Autowired
	private TPhoneInfoCustomMapper tPhoneInfoCustomMapper;
	
	@Override
	public TPhoneInfoCustom findTPhoneByTask(HashMap<String, Object> hashmap)throws Exception {
		return tPhoneInfoCustomMapper.findTPhoneByTask(hashmap);
	}

	@Override
	public List<TPhoneInfoCustom> findAllPhoneBykeynum(String keynum)throws Exception {
		return tPhoneInfoCustomMapper.findAllPhoneBykeynum(keynum);
	}

	@Override
	public int findPhonecountBykeynum(String keynum) throws Exception {
		return tPhoneInfoCustomMapper.findPhonecountBykeynum(keynum);
	}

	@Override
	public List<TPhoneInfoCustom> findAllPhoneBycount(int count) throws Exception {
		return tPhoneInfoCustomMapper.findAllPhoneBycount(count);
	}

	@Override
	public List<TPhoneInfoCustom> findPhoneAndTask(HashMap<String, Object> hashmap) throws Exception {
		return tPhoneInfoCustomMapper.findPhoneAndTask(hashmap);
	}

}
