package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TComboInfoCustomMapper;
import com.zhenapp.po.Custom.TComboInfoCustom;
import com.zhenapp.service.ComboInfoService;

@Service
public class ComboInfoServiceImp implements ComboInfoService{
	@Autowired
	private TComboInfoCustomMapper tComboInfoCustomMapper; 
	
	@Override
	public List<TComboInfoCustom> findAllCombo() throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.findAllCombo();
	}

	@Override
	public TComboInfoCustom findComboByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.findComboByid(id);
	}

	@Override
	public List<TComboInfoCustom> findComboBypage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.findComboBypage(hashmap);
	}

	@Override
	public int insertComboto(TComboInfoCustom tComboInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.insertComboto(tComboInfoCustom);
	}

	@Override
	public List<TComboInfoCustom> findComboByAgentid(HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.findComboByAgentid(pagemap);
	}
	@Override
	public int findTotalComboByAgentid(HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.findTotalComboByAgentid(pagemap);
	}

	@Override
	public int deleteCombo(HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.deleteCombo(pagemap);
	}

	@Override
	public int updateCombotoByid(TComboInfoCustom tComboInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tComboInfoCustomMapper.updateCombotoByid(tComboInfoCustom);
	}
	
}
