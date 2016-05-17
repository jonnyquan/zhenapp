package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TNoteInfoCustom;

public interface TNoteInfoCustomMapper {
	/*
	 * 查询全部公告信息条数
	 */
	public int findTotalNoteinfoByPage() throws Exception;
	/*
	 * 根据id查询公告信息
	 */
	public TNoteInfoCustom findNoteinfoByIdAndType(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 根据id更新公告信息
	 */
	public int updatenoteByid(TNoteInfoCustom tNoteInfoCustom) throws Exception;
	/*
	 * 分页查询公告信息
	 */
	public List<TNoteInfoCustom> findNoteinfoByPage(HashMap<String, Object> hashmap) throws Exception;
	/*
	 * 根据id和类型删除公告信息
	 */
	public int deleteByIdAndType(HashMap<String, Object> hashmap) throws Exception;
}