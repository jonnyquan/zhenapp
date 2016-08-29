package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.DatacountInfoCustomMapper;
import com.zhenapp.po.Custom.DatacountInfoCustom;
import com.zhenapp.po.Custom.TDatacountInfoCustom;
import com.zhenapp.service.DatacountInfoService;
@Service
public class DatacountInfoServiceImp implements DatacountInfoService{
	
	@Autowired
	private DatacountInfoCustomMapper datacountInfoCustomMapper;
	
	@Override
	public List<DatacountInfoCustom> findDataBydate(HashMap<String, Object> hashmap) throws Exception {
		return datacountInfoCustomMapper.findDataBydate(hashmap);
	}

	@Override
	public DatacountInfoCustom findSUMDataBydate(
			HashMap<String, Object> hashmap) throws Exception {
		return datacountInfoCustomMapper.findSUMDataBydate(hashmap);
	}

	@Override
	public int saveDatacount(HashMap<String, Object> hashmap) throws Exception {
		return datacountInfoCustomMapper.saveDatacount(hashmap);
	}

	@Override
	public List<TDatacountInfoCustom> findDatacountBydate(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return datacountInfoCustomMapper.findDatacountBydate(hashmap);
	}

	@Override
	public TDatacountInfoCustom findSUMDatacountBydate(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return datacountInfoCustomMapper.findSUMDatacountBydate(hashmap);
	}

}
