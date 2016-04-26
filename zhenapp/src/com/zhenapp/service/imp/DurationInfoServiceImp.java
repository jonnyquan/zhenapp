package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TDurationInfoCustomMapper;
import com.zhenapp.po.Custom.TDurationInfoCustom;
import com.zhenapp.service.DurationInfoService;

@Service
public class DurationInfoServiceImp implements DurationInfoService {

	@Autowired
	private TDurationInfoCustomMapper tDurationInfoCustomMapper;
		
	@Override
	public List<TDurationInfoCustom> findAllDuration() throws Exception {
		// TODO Auto-generated method stub
		return tDurationInfoCustomMapper.findAllDuration();
	}
}
