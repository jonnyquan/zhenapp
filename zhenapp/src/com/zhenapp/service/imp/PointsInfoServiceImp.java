package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhenapp.mapper.Custom.TPointsInfoCustomMapper;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.service.PointsInfoService;

public class PointsInfoServiceImp implements PointsInfoService{

	@Autowired
	private TPointsInfoCustomMapper tPointsInfoCustomMapper;
	
	@Override
	public List<TPointsInfoCustom> findPointsInfoByPage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tPointsInfoCustomMapper.findPointsInfoByPage(pagemap);
	}

}
