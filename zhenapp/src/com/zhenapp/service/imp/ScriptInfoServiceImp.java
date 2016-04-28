package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TScriptInfoCustomMapper;
import com.zhenapp.po.Custom.TScriptInfoCustom;
import com.zhenapp.service.ScriptInfoService;

@Service
public class ScriptInfoServiceImp implements ScriptInfoService{
	@Autowired
	private TScriptInfoCustomMapper tScriptInfoCustomMapper;
	
	@Override
	public int insertScript(TScriptInfoCustom tScriptInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.insertScript(tScriptInfoCustom);
	}

	@Override
	public TScriptInfoCustom findScriptByid(String scriptid) throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.findScriptByid(scriptid);
	}

	@Override
	public int deletescriptByid(String scriptid) throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.deletescriptByid(scriptid);
	}

	@Override
	public List<TScriptInfoCustom> findAllScriptByPage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.findAllScriptByPage(pagemap);
	}

	@Override
	public List<TScriptInfoCustom> findScriptByPage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.findScriptByPage(pagemap);
	}

	@Override
	public int findTotalScriptByPage(HashMap<String, Object> pagemap)
			throws Exception {
		// TODO Auto-generated method stub
		return tScriptInfoCustomMapper.findTotalScriptByPage(pagemap);
	}
}
