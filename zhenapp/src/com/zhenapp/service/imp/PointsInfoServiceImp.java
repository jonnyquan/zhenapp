package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TPointsInfoCustomMapper;
import com.zhenapp.po.Custom.TPointsInfoCustom;
import com.zhenapp.service.PointsInfoService;
@Service
public class PointsInfoServiceImp implements PointsInfoService{

	@Autowired
	private TPointsInfoCustomMapper tPointsInfoCustomMapper;
	
	@Override
	public List<TPointsInfoCustom> findPointsInfoByPage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tPointsInfoCustomMapper.findPointsInfoByPage(pagemap);
	}

	@Override
	public int findPointsCountsByPage(
			HashMap<String, Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tPointsInfoCustomMapper.findPointsCountsByPage(pagemap);
	}

}
