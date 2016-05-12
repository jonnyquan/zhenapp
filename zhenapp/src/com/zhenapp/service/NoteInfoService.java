package com.zhenapp.service;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TNoteInfoCustom;

public interface NoteInfoService {
	/*
	 * 查询全部公告信息
	 */
	public List<TNoteInfoCustom> findAllNoteinfo() throws Exception;
	/*
	 * 根据id查询公告信息
	 */
	public TNoteInfoCustom findNoteinfoById(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 根据id更新公告信息
	 */
	public int updatenoteByid(TNoteInfoCustom tNoteInfoCustom) throws Exception;
}
