package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhenapp.mapper.TNoteInfoMapper;
import com.zhenapp.po.TNoteInfo;
import com.zhenapp.service.NoteService;

public class NoteServiceImp implements NoteService {
	@Autowired
	private TNoteInfoMapper tNoteInfoMapper;
	
	public List<TNoteInfo> findAllNoteinfo() throws Exception{
		
		return tNoteInfoMapper.selectByExampleWithBLOBs(null);
	};
}
