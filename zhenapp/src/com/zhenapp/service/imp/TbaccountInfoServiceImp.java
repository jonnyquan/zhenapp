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
		return tTbaccountInfoCustomMapper.insertTbaccount(tTbaccountInfoCustom);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountBypage(
			HashMap<String, Object> hashmap) throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccountBypage(hashmap);
	}

	@Override
	public List<TTbaccountInfoCustom> findAllTbaccountBypage(
			HashMap<String, Object> hashmap) throws Exception {
		return tTbaccountInfoCustomMapper.findAllTbaccountBypage(hashmap);
	}

	@Override
	public int deleteTbaccountByid(String tbaccountids) throws Exception {
		return tTbaccountInfoCustomMapper.deleteTbaccountByid(tbaccountids);
	}

	@Override
	public int findTotalTbaccountBypage(HashMap<String, Object> hashmap)
			throws Exception {
		return tTbaccountInfoCustomMapper.findTotalTbaccountBypage(hashmap);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByPhoneid(
			String tbaccountphoneid) throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccountByPhoneid(tbaccountphoneid);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByAccountname(String tbaccountphoneid)
			throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccountByAccountname(tbaccountphoneid);
	}

	@Override
	public int updateTbaccountByid(TTbaccountInfoCustom tTbaccountInfoCustom) throws Exception {
		return tTbaccountInfoCustomMapper.updateTbaccountByid(tTbaccountInfoCustom);
	}

	@Override
	public int deleteAccount(HashMap<String, Object> pagemap) throws Exception {
		return tTbaccountInfoCustomMapper.deleteAccount(pagemap);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByphoneidisnull()
			throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccountByphoneidisnull();
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccountByPhoneidandtag(
			HashMap<String, Object> hashmap) throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccountByPhoneidandtag(hashmap);
	}

	@Override
	public int updateTbaccountTag(HashMap<String, Object> hashmap)
			throws Exception {
		return tTbaccountInfoCustomMapper.updateTbaccountTag(hashmap);
	}

	@Override
	public int updateTbaccountstate() throws Exception {
		return tTbaccountInfoCustomMapper.updateTbaccountstate();
	}

	@Override
	public int updateTbaccount(HashMap<String, Object> hashmap)
			throws Exception {
		return tTbaccountInfoCustomMapper.updateTbaccount(hashmap);
	}

	@Override
	public List<TTbaccountInfoCustom> findTbaccount(
			HashMap<String, Object> pagemap) throws Exception {
		return tTbaccountInfoCustomMapper.findTbaccount(pagemap);
	}

}
