package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TNoteInfoCustomMapper;
import com.zhenapp.po.Custom.TNoteInfoCustom;
import com.zhenapp.service.NoteInfoService;
@Service
public class NoteInfoServiceImp implements NoteInfoService {
	@Autowired
	private TNoteInfoCustomMapper tNoteInfoCustomMapper;
	
	public int findTotalNoteinfoByPage(HashMap<String, Object> hashmap) throws Exception{
		
		return tNoteInfoCustomMapper.findTotalNoteinfoByPage(hashmap);
	}

	@Override
	public TNoteInfoCustom findNoteinfoByIdAndType(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.findNoteinfoByIdAndType(hashmap);
	}

	@Override
	public int updatenoteByid(TNoteInfoCustom tNoteInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.updatenoteByid(tNoteInfoCustom);
	}

	@Override
	public List<TNoteInfoCustom> findNoteinfoByPage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.findNoteinfoByPage(hashmap);
	}

	@Override
	public int deleteByIdAndType(HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.deleteByIdAndType(hashmap);
	}

	@Override
	public int savenote(TNoteInfoCustom tNoteInfoCustom) throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.savenote(tNoteInfoCustom);
	}

	@Override
	public int updatenotestateByidandtype(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tNoteInfoCustomMapper.updatenotestateByidandtype(hashmap);
	};
}
