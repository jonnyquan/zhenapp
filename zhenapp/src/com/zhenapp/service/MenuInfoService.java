package com.zhenapp.service;

import java.util.List;

import com.zhenapp.po.Custom.TSysMenuCustom;

public interface MenuInfoService {
	/*
	 * 查询所有菜单
	 */
	public List<TSysMenuCustom> findAllMenu() throws Exception;
	
	/*
	 * 根据tid查询菜单节点
	 */
	public List<TSysMenuCustom> findMenuBytid(String tid) throws Exception;
	
}
