package com.zhenapp.service;

import java.util.List;

import com.zhenapp.po.TNoteInfo;

public interface NoteInfoService {
	public List<TNoteInfo> findAllNoteinfo() throws Exception;
}
