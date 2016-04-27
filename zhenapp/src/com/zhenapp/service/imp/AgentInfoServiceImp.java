package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TAgentInfoCustomMapper;
import com.zhenapp.po.Custom.TAgentInfoCustom;
import com.zhenapp.service.AgentInfoService;
@Service
public class AgentInfoServiceImp implements AgentInfoService{

	@Autowired
	private TAgentInfoCustomMapper tAgentInfoCustomMapper;
	
	@Override
	public List<TAgentInfoCustom> findAgentBypage(HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tAgentInfoCustomMapper.findAgentBypage(pagemap);
	}

	@Override
	public List<TAgentInfoCustom> findAllAgentBypage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tAgentInfoCustomMapper.findAllAgentBypage(pagemap);
	}

	@Override
	public int deleteAgentBypk(String pks) throws Exception {
		// TODO Auto-generated method stub
		return tAgentInfoCustomMapper.deleteAgentBypk(pks);
	}

}
