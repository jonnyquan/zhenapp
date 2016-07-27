package com.zhenapp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TRankipInfoCustomMapper;
import com.zhenapp.po.Custom.TRankipInfoCustom;
import com.zhenapp.service.RankipInfoService;
@Service
public class RankipInfoServiceImp implements RankipInfoService{

	@Autowired
	private TRankipInfoCustomMapper tRankipInfoCustomMapper;
	
	@Override
	public TRankipInfoCustom findRankip() throws Exception {
		return tRankipInfoCustomMapper.findRankip();
	}
}
