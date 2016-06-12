package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TUsertestInfoCustomMapper;
import com.zhenapp.po.Custom.TUsertestInfoCustom;
import com.zhenapp.service.UsertestInfoService;

@Service
public class UsertestInfoServiceImp implements UsertestInfoService{

	@Autowired
	private TUsertestInfoCustomMapper tUsertestInfoCustomMapper;
	
	@Override
	public int insertUsertest(TUsertestInfoCustom tUsertestInfoCustom)
			throws Exception {
		return tUsertestInfoCustomMapper.insertUsertest(tUsertestInfoCustom);
	}

	@Override
	public int deleteUsertest(HashMap<String, Object> hashmap) throws Exception {
		return tUsertestInfoCustomMapper.deleteUsertest(hashmap);
	}

	@Override
	public List<TUsertestInfoCustom> findUserTest(HashMap<String, Object> hashmap)
			throws Exception {
		return tUsertestInfoCustomMapper.findUserTest(hashmap);
	}

	@Override
	public int findTotalUsertest(HashMap<String, Object> hashmap)
			throws Exception {
		return tUsertestInfoCustomMapper.findTotalUsertest(hashmap);
	}

}
