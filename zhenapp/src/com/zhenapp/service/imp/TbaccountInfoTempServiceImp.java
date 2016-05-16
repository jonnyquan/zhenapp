package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhenapp.mapper.Custom.TTbaccountInfoTempCustomMapper;
import com.zhenapp.po.Custom.TTbaccountInfoTempCustom;
import com.zhenapp.service.TbaccountInfoTempService;

@Component
public class TbaccountInfoTempServiceImp implements TbaccountInfoTempService{

	@Autowired
	private TTbaccountInfoTempCustomMapper tTbaccountInfoTempCustomMapper;
	
	@Override
	public int deleteAll() throws Exception {
		return tTbaccountInfoTempCustomMapper.deleteAll();
	}

	@Override
	public int insertTbaccount(TTbaccountInfoTempCustom tTbaccountInfoTempCustom) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoTempCustomMapper.insertTbaccount(tTbaccountInfoTempCustom);
	}

	@Override
	public List<TTbaccountInfoTempCustom> findAllTTbaccountInfoTemp()
			throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoTempCustomMapper.findAllTTbaccountInfoTemp();
	}

}
