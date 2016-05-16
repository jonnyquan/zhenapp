package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TScriptInfoCustom;

public interface TScriptInfoCustomMapper {
	/*
	 * 插入上传的脚本信息
	 */
	public int insertScript(TScriptInfoCustom tScriptInfoCustom) throws Exception;
	/*
	 * 查询全部脚本信息
	 */
	public List<TScriptInfoCustom> findAllScriptByPage(HashMap<String,Object> pagemap) throws Exception;
	/*
	 * 查询全部脚本信息
	 */
	public int findTotalScriptByPage(HashMap<String,Object> pagemap) throws Exception;
	/*
	 * 查询全部脚本信息
	 */
	public List<TScriptInfoCustom> findScriptByPage(HashMap<String,Object> pagemap) throws Exception;
	/*
	 * 根据id查询脚本文件下载
	 */
	public TScriptInfoCustom findScriptByid(String scriptid) throws Exception; 
	/*
	 * 根据id删除脚本信息
	 */
	public int deletescriptByid(String scriptid) throws Exception;
	/*
	 * 根据脚本文件名查询脚本文件
	 */
	public TScriptInfoCustom findScriptByname(String scriptname) throws Exception;
}