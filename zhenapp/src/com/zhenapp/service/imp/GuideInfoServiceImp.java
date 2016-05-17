package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TGuideInfoCustomMapper;
import com.zhenapp.po.Custom.TGuideInfoCustom;
import com.zhenapp.service.GuideInfoService;
@Service
public class GuideInfoServiceImp implements GuideInfoService {
	
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
	public List<TGuideInfoCustom> findGuideBypage(HashMap<String,Object> pagemap)
			throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.findGuideBypage(pagemap);
	}

	@Override
	public int findTotalGuide() throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.findTotalGuide();
	}

	@Override
	public int updateGuideById(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.updateGuideById(hashmap);
	}

	@Override
	public int deleteById(HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tGuideInfoCustomMapper.deleteById(hashmap);
	}
	
}
