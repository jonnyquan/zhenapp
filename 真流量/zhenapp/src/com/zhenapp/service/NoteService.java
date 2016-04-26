package com.zhenapp.service;

import java.util.List;

import com.zhenapp.po.TNoteInfo;

public interface NoteService {
	public List<TNoteInfo> findAllNoteinfo() throws Exception;
}
