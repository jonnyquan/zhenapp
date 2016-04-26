package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TComboInfoCustom;


public interface TComboInfoCustomMapper {
	/*
	 * 查询全部套餐信息
	 */
	public List<TComboInfoCustom> findAllCombo() throws Exception;
	
	/*
	 * 分页查询全部套餐信息
	 */
	public List<TComboInfoCustom> findComboBypage(HashMap<String, Object> hashmap) throws Exception;
	
	/*
	 * 根据套餐id查询详细套餐信息
	 */
	public TComboInfoCustom findComboByid(String id) throws Exception;
	/*
	 * 保存套餐信息
	 */
	public int insertComboto(TComboInfoCustom tComboInfoCustom) throws Exception;
	
}