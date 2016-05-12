package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TComboInfoCustom;


public interface TComboInfoCustomMapper {
	/*
	 * 根据套餐id和代理id删除权限内的套餐信息
	 */
	public int deleteCombo(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据代理id查询套餐信息总数
	 */
	public int findTotalComboByAgentid(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 根据代理id查询套餐信息
	 */
	public List<TComboInfoCustom> findComboByAgentid(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 分页查询全部套餐信息
	 */
	public List<TComboInfoCustom> findAllComboByAdmin(HashMap<String, Object> pagemap) throws Exception;
	/*
	 * 查询全部套餐信息的总数
	 */
	public int findAllTotalComboByAdmin(HashMap<String, Object> pagemap) throws Exception;
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
	/*
	 * 根据套餐id更新信息
	 */
	public int updateCombotoByid(TComboInfoCustom tComboInfoCustom) throws Exception;
	
}