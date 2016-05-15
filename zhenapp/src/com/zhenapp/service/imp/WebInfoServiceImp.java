package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TWebInfoCustomMapper;
import com.zhenapp.po.Custom.TWebInfoCustom;
import com.zhenapp.service.WebInfoService;
@Service
public class WebInfoServiceImp implements WebInfoService {
	
	@Autowired
	private TWebInfoCustomMapper tWebInfoCustomMapper;
	
	@Override
	public int updateWebByAgentid(TWebInfoCustom tWebInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tWebInfoCustomMapper.updateWebByAgentid(tWebInfoCustom);
	}

	@Override
	public TWebInfoCustom findWebByAgentid(String agentid) throws Exception {
		// TODO Auto-generated method stub
		return tWebInfoCustomMapper.findWebByAgentid(agentid);
	}

	@Override
	public int saveWebInfo(TWebInfoCustom tWebInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tWebInfoCustomMapper.saveWebInfo(tWebInfoCustom);
	}
	
	
}
