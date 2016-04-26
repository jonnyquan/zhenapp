package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.TSysMenuMapper;
import com.zhenapp.mapper.Custom.TSysMenuCustomMapper;
import com.zhenapp.po.Custom.TSysMenuCustom;
import com.zhenapp.service.MenuInfoService;
@Service
public class MenuInfoServiceImp implements MenuInfoService {
	@Autowired
	private TSysMenuMapper tsysMenuMapper;
	@Autowired
	private TSysMenuCustomMapper tSysMenuCustomMapper;
	
	public List<TSysMenuCustom> findAllMenu() throws Exception{
		return tSysMenuCustomMapper.findAllMenu();
	}

	@Override
	public List<TSysMenuCustom> findMenuBytid(String tid) throws Exception {
		// TODO Auto-generated method stub
		return tSysMenuCustomMapper.findMenuBytid(tid);
	}
}
