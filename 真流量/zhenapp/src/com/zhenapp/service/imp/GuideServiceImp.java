package com.zhenapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhenapp.mapper.Custom.TGuideInfoCustomMapper;
import com.zhenapp.po.PageInfo;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.service.GuideService;

public class GuideServiceImp implements GuideService {
	
	@Autowired
	private TGuideInfoCustomMapper tGuideInfoCustomMapper;
	
	
	@Override
	public List<TGuideInfoCustom> findGuide_10() throws Exception {
		return tGuideInfoCustomMapper.findGuide_10();
	}

	@Override
	public List<TGuideInfoCustom> findAllGuide() throws Exception {
		return tGuideInfoCustomMapper.findAllGuide();
	}

	@Override
	public TGuideInfoCustom findElectrityBypk(String guidepk) throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.findElectrityBypk(guidepk);
	}

	@Override
	public List<TGuideInfoCustom> findGuideBypage(PageInfo pageinfo)
			throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.findGuideBypage(pageinfo);
	}
	
}
