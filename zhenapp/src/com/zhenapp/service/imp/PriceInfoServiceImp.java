package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TPriceInfoCustomMapper;
import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.service.PriceInfoService;

@Service
public class PriceInfoServiceImp implements PriceInfoService{
	@Autowired
	private TPriceInfoCustomMapper tPriceInfoCustomMapper;
	
	@Override
	public TPriceInfoCustom findPriceBycode(String pricecode) throws Exception {
		// TODO Auto-generated method stub
		return tPriceInfoCustomMapper.findPriceBycode(pricecode);
	}

	@Override
	public List<TPriceInfoCustom> findAllPrice() throws Exception {
		// TODO Auto-generated method stub
		return tPriceInfoCustomMapper.findAllPrice();
	}

	@Override
	public int updatePriceBycode(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tPriceInfoCustomMapper.updatePriceBycode(hashmap);
	}

}
