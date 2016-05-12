package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTbaccountInfoCustomMapper;
import com.zhenapp.po.Custom.TTbaccountInfoCustom;
import com.zhenapp.service.TbaccountInfoService;
@Service
public class TbaccountInfoServiceImp implements TbaccountInfoService{

	@Autowired
	private TTbaccountInfoCustomMapper tTbaccountInfoCustomMapper;
	
	@Override
	public int insertTbaccount(TTbaccountInfoCustom tTbaccountInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.insertTbaccount(tTbaccountInfoCustom);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountBypage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.findTbaccountBypage(hashmap);
	}

	@Override
	public List<TTbaccountInfoCustom> findAllTbaccountBypage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.findAllTbaccountBypage(hashmap);
	}

	@Override
	public int deleteTbaccountByid(String tbaccountids) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.deleteTbaccountByid(tbaccountids);
	}

	@Override
	public int findTotalTbaccountBypage(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.findTotalTbaccountBypage(hashmap);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByPhoneid(
			String tbaccountphoneid) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.findTbaccountByPhoneid(tbaccountphoneid);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByAccountname(String tbaccountphoneid)
			throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.findTbaccountByAccountname(tbaccountphoneid);
	}

	@Override
	public int updateTbaccountByid(TTbaccountInfoCustom tTbaccountInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tTbaccountInfoCustomMapper.updateTbaccountByid(tTbaccountInfoCustom);
	}

}
