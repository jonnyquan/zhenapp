package com.zhenapp.service.imp;

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
	public int updatePriceByagentid(TPriceInfoCustom tPriceInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tPriceInfoCustomMapper.updatePriceByagentid(tPriceInfoCustom);
	}

	@Override
	public TPriceInfoCustom findPriceByAgentid(String agentid) throws Exception {
		// TODO Auto-generated method stub
		return tPriceInfoCustomMapper.findPriceByAgentid(agentid);
	}

}
