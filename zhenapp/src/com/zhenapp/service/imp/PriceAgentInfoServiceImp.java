package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TPriceAgentInfoCustomMapper;
import com.zhenapp.po.Custom.TPriceAgentInfoCustom;
import com.zhenapp.service.PriceAgentInfoService;

@Service
public class PriceAgentInfoServiceImp implements PriceAgentInfoService{
	@Autowired
	private TPriceAgentInfoCustomMapper tPriceAgentInfoCustomMapper;

	@Override
	public int insertPriceAgent(TPriceAgentInfoCustom tPriceagentInfoCustom) throws Exception {
		return tPriceAgentInfoCustomMapper.insertPriceAgent(tPriceagentInfoCustom);
	}

	@Override
	public TPriceAgentInfoCustom findPriceByAgentid(String agentid) throws Exception {
		return tPriceAgentInfoCustomMapper.findPriceByAgentid(agentid);
	}

	@Override
	public int updatePrice(TPriceAgentInfoCustom tPriceagentInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tPriceAgentInfoCustomMapper.updatePrice(tPriceagentInfoCustom);
	}
	
}
